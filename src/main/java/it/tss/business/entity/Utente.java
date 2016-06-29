/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.business.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author tss
 */
@NamedQueries({
    @NamedQuery(name = "Utente.findByUsrPwd",
            query = "select e from Utente e where e.username= :usr and e.pwd= :pwd"),
    @NamedQuery(name = "Utente.findByNick",
            query = "select e from Utente e where e.username like :usr")
}
)
@Entity
public class Utente implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    @Column(updatable = true)
    private String username;
    private String pwd;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

            
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return username;
    }
    
    
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Utente other = (Utente) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

//    @Override
//    public String toString() {
//        return "Utente{" + "id=" + id + ", username=" + username + ", pwd=" + pwd + '}';
//    }
    
    
    
}