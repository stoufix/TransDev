package com.transdev.busticket.domaine;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "trajet")
public class Trajet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long trajetId;

    @Column(name = "nbPlace")
    private int nbPlace;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "heureDepart")
    private Date heureDepart;

    @Column(name = "prix")
    private float prix;
}
