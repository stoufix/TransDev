package com.transdev.busticket.modele;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreditCard extends MoyenPaiement{

    private String numeroCard ;
    private String dateExpiration;

    @Override
    public boolean payerReservation(long idReservation) {
        return true;
    }
}
