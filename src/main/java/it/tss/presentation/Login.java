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

    private String user;
    private String pwd;

    @Inject
    Security security;

    @Inject
    SessionData sessiondata;

    @Inject
    UsersCache userscache;

    @Inject
    UtenteSrv utentesrv;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String onLogin() {

        boolean login = security.login(user, pwd);

        if (login) {

            sessiondata.setLoggedUser(user);

            JsfUtil.addSuccessMessage("Login effettuata!!");
            return "utente/List.jsf/faces-redirect=true";

        } else {
            FacesContext.getCurrentInstance().
                    addMessage("", new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Login non effettuato.",
                            ""));
        }

        return "";

    }

}
