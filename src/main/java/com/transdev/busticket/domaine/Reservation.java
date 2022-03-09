package com.transdev.busticket.domaine;

import lombok.*;

import javax.persistence.*;
import java.util.List;

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
    private long idReservation;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "idTrajet")
    private List<Trajet> trajet ;

    @OneToOne
    @JoinColumn(name="idClient",referencedColumnName="idClient", nullable = false)
    private Client idClient;

}
