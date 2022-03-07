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
    private long busId;

    @Column(unique=true,name = "numero",nullable = false)
    private int numero ;

    @ManyToOne(optional=false)
    @JoinColumn(name="trajetId",referencedColumnName="trajetId")
    private Trajet trajet ;
}
