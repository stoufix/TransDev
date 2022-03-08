package com.transdev.busticket.domaine;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "billet")
public class Billet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    @JoinColumn(name = "id", nullable = false)
    private Reservation idReservation;

    @Column(name = "moyenPaiment")
    private String moyenPaiment;

}
