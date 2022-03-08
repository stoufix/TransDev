package com.transdev.busticket.service.impl;

import com.transdev.busticket.domaine.Bus;
import com.transdev.busticket.domaine.Trajet;
import com.transdev.busticket.repository.BusRepository;
import com.transdev.busticket.repository.TrajetRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class BusServiceImplTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    BusRepository busRepository ;
    @Autowired
    TrajetRepository trajetRepository ;

    @Test
    void getAllBus() {
        Trajet trajetBuilder = Trajet.builder().heureDepart(new Date()).nbPlace(100).prix(35).build();
        Bus busBuilder = Bus.builder().numeroBus(25).trajet(trajetBuilder).build();

        this.trajetRepository.save(trajetBuilder);
        this.entityManager.persist(busBuilder);

        //act

        Iterable<Bus> buss = this.busRepository.findAll();
        //assert
        assertNotNull(buss);

        assertThat(buss).hasSize(1);
        assertThat(buss.iterator().next().getNumeroBus()).isEqualTo(busBuilder.getNumeroBus());
    }

    @Test
    void findBusById() {

        Trajet trajetBuilder = Trajet.builder().heureDepart(new Date()).nbPlace(100).prix(35).build();
        Bus busBuilder = Bus.builder().idBus(2).numeroBus(25).trajet(trajetBuilder).build();
        Bus busBuilder2 = Bus.builder().idBus(3).numeroBus(25).trajet(trajetBuilder).build();
        this.trajetRepository.save(trajetBuilder);
        this.entityManager.merge(busBuilder);
        this.entityManager.merge(busBuilder2);

        //act

        Bus bus = this.busRepository.findById(3L).get();
        //assert
        assertNotNull(bus);

        assertThat(bus.getNumeroBus()).isEqualTo(busBuilder.getNumeroBus());
        assertThat(bus.getTrajet().getPrix()).isEqualTo(busBuilder.getTrajet().getPrix());
    }

    @Test
    void creerBus() {
        Trajet trajetBuilder = Trajet.builder().heureDepart(new Date()).nbPlace(100).prix(35).build();
        Bus busBuilder = Bus.builder().numeroBus(25).trajet(trajetBuilder).build();

        this.trajetRepository.save(trajetBuilder);
        this.entityManager.persist(busBuilder);

        //act

        Bus buss = this.busRepository.save(busBuilder);
        //assert
        assertNotNull(buss);

    }

    @Test
    void supprimerBus() {

        Trajet trajetBuilder = Trajet.builder().heureDepart(new Date()).nbPlace(100).prix(35).build();
        Bus busBuilder = Bus.builder().numeroBus(25).trajet(trajetBuilder).build();

        this.trajetRepository.save(trajetBuilder);
        this.entityManager.persist(busBuilder);

        //act

        this.busRepository.deleteById(busBuilder.getIdBus());
        //assert
        assertThat(this.busRepository.findById((busBuilder.getIdBus())).isEmpty());
    }
}