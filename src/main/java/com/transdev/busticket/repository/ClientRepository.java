package com.transdev.busticket.repository;

import com.transdev.busticket.domaine.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
