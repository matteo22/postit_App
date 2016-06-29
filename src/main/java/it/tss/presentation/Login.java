/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.presentation;

import it.tss.business.boundary.Security;
import it.tss.business.boundary.UsersCache;
import it.tss.business.boundary.UtenteSrv;
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

    private String nick;
    private String pwd;

    @Inject
    Security security;

    @Inject
    SessionData sessiondata;

    @Inject
    UsersCache userscache;
            
    @Inject
    UtenteSrv utentesrv;

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String onLogin() {

        boolean login = security.login(nick, pwd);

        if (login) {

            sessiondata.setLoggedUser(nick);

            FacesContext.getCurrentInstance().
                    addMessage("", new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Login effettuato.",
                            ""));
           return "/utente/List.jsf/faces-redirect=true";

        } else {

            FacesContext.getCurrentInstance().
                    addMessage("", new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Login non effettuato.",
                            ""));

        }

        return null;

    }
}
