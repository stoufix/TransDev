package com.transdev.busticket.domaine;

import lombok.*;

import javax.persistence.*;

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

    @ManyToOne
    @JoinColumn(name = "heureDepart",referencedColumnName="heureDepart", nullable = false)
    private Trajet heureDepart ;

    @OneToOne
    @JoinColumn(name="idClient",referencedColumnName="idClient", nullable = false)
    private Client idClient;

}
