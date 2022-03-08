package com.transdev.busticket.service;

import com.transdev.busticket.domaine.Bus;
import com.transdev.busticket.exception.RessourceNotFound;

import java.util.List;

public interface BusService {

    List<Bus> getAllBus();
    Bus findBusById(long idBus) throws RessourceNotFound;
    Bus creerBus(Bus bus);
    void supprimerBus(long idBus) throws RessourceNotFound;
}
