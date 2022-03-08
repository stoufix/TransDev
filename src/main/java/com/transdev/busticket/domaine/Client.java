package com.transdev.busticket.domaine;

import javax.persistence.*;

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

    public long getIdClient() {
        return idClient;
    }

    public void setIdClient(long id) {
        this.idClient = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
