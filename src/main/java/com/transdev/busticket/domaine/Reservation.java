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
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    @JoinColumn(name = "heureDepart", nullable = false)
    private Trajet dateDepart ;

    @OneToOne
    @JoinColumn(name = "id", nullable = false)
    private Client idClient;

    @OneToOne
    @JoinColumn(name = "numero", nullable = false)
    private Bus numeroBus ;
}
