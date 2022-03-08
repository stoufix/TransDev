package com.transdev.busticket.repository;

import com.transdev.busticket.domaine.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository extends JpaRepository<Bus,Long> {
}
