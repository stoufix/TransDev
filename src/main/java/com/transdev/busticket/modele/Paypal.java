package com.transdev.busticket.modele;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Paypal extends MoyenPaiement{

    private String mail ;

    @Override
    public boolean payerReservation(long idReservation) {
        return true;
    }
}
