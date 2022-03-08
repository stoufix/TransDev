package com.transdev.busticket.service.impl;

import com.transdev.busticket.domaine.Bus;
import com.transdev.busticket.repository.BusRepository;
import com.transdev.busticket.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BusServiceImpl implements BusService {

    @Autowired
    BusRepository busRepository;
    @Override
    public List<Bus> getAllBus() {
        return null;
    }

    @Override
    public Bus findBusById(long idBus) {
        return null;
    }

    @Override
    public Bus creerBus(Bus bus) {
        return null;
    }

    @Override
    public void supprimerBus(long idBus) {

    }
}
