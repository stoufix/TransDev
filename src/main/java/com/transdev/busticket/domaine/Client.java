package com.transdev.busticket.domaine;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idClient;

    @Column(name = "nom")
    private String nom;

    @Column(name = "email")
    private String email;
}
