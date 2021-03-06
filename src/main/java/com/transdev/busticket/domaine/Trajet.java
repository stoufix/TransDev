package com.transdev.busticket.domaine;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    private long idTrajet;

    @Column(name = "nbPlace")
    private int nbPlace;

    @Column(name = "heureDepart")
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private Date heureDepart;

    @Column(name = "prix")
    private float prix;

    /*@OneToOne
    @JoinColumn(name="numeroBus",referencedColumnName="numeroBus", nullable = false)
    private Bus numeroBus ;*/
}
