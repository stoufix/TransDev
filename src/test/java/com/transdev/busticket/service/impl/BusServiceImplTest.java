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
        Bus busBuilder = Bus.builder().numeroBus(25).trajet(trajetBuilder).build();

        this.trajetRepository.save(trajetBuilder);
        this.entityManager.persist(busBuilder);

        //act

        Bus buss = this.busRepository.findById(busBuilder.getIdBus()).get();
        //assert
        assertNotNull(buss);
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