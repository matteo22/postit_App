/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.presentation;

import it.tss.business.boundary.Security;
import it.tss.business.boundary.UsersCache;
import it.tss.business.boundary.UtenteSrv;
import it.tss.business.entity.Utente;
import it.tss.presentation.util.JsfUtil;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import javax.inject.Named;

/**
 *
 * @author tss
 */
@Named(value = "login")
@SessionScoped
public class Login implements Serializable {

    private Utente user;

    @Inject
    Security security;

    @Inject
    SessionData sessiondata;

    @Inject
    UsersCache userscache;

    @Inject
    UtenteSrv utentesrv;

    public Utente getUser() {
        return user;
    }

    public void setUser(Utente user) {
        this.user = user;
    }

    public String onLogin() {

        boolean login = security.login(user.getUsername(), user.getPwd());

        if(login){
        
        sessiondata.setLoggedUser(user.toString());
            
            
            return "utente/List.jsf/faces-redirect=true";

        }
        
        JsfUtil.addErrorMessage("LOGIN ERRATA!!");
        return null;
    }
    
}
