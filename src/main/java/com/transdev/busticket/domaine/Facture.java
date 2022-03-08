package com.transdev.busticket.domaine;


import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "facture")
public class Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idFacture;

    @OneToOne
    @JoinColumn(name="idReservation",referencedColumnName="idReservation", nullable = false)
    private Reservation reservation ;
}
