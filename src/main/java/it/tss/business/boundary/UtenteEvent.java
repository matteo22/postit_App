/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.webapp.business.boundary;

import it.tss.business.entity.Utente;



/**
 *
 * @author tss
 */

public class UtenteEvent {
    
    private Utente utente;

    public UtenteEvent(Utente utente) {
        this.utente = utente;
    }

    public Utente getUtente() {
        return utente;
    }
    
    
}
