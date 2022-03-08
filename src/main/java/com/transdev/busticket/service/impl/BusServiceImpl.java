package com.transdev.busticket.service.impl;

import com.transdev.busticket.domaine.Bus;
import com.transdev.busticket.exception.RessourceNotFound;
import com.transdev.busticket.repository.BusRepository;
import com.transdev.busticket.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BusServiceImpl implements BusService {

    @Autowired
    BusRepository busRepository;
    @Override
    public List<Bus> getAllBus() {
        return this.busRepository.findAll();
    }

    @Override
    public Bus findBusById(long idBus) throws RessourceNotFound {
        Optional<Bus> busBD = this.busRepository.findById(idBus);
        if(busBD.isPresent()){
            return busBD.get();
        }
        else {
            throw new RessourceNotFound("pas de bus dans la BD" + idBus);
        }
    }

    @Override
    public Bus creerBus(Bus bus) {
        return this.busRepository.save(bus);
    }

    @Override
    public void supprimerBus(long idBus) throws RessourceNotFound {
        Optional<Bus> busBD = this.busRepository.findById(idBus);
        if(busBD.isPresent()){
            this.busRepository.deleteById(idBus);
        }
        else {
            throw new RessourceNotFound("pas de bus dans la BD" + idBus);
        }

    }
}
