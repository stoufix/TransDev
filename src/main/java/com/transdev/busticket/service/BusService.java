package com.transdev.busticket.service;

import com.transdev.busticket.domaine.Bus;

import java.util.List;

public interface BusService {

    List<Bus> getAllBus();
    Bus findBusById(long idBus);
    Bus creerBus(Bus bus);
    void supprimerBus(long idBus);
}
