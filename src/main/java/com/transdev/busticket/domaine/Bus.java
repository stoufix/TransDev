package com.transdev.busticket.domaine;


import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "bus")
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idBus;

    @Column(unique=true,name = "numeroBus",nullable = false)
    private int numeroBus ;

    @JoinColumn(name="idTrajet",referencedColumnName="idTrajet")
    @OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    private Trajet trajet ;
}
