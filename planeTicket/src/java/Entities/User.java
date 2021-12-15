/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Date;

/**
 *
 * @author ahmet
 */
public class User {
    private int id;
    private String rol;
    private String tc;
    private String ad;
    private String cinsiyet;
    private int yas;
    private Date dTarih;
    private String email;
    private String sifre;
    
    public User(){}

    public User(int id, String rol, String tc, String ad, String cinsiyet, int yas, Date dTarih, String email, String sifre) {
        this.id = id;
        this.rol = rol;
        this.tc = tc;
        this.ad = ad;
        this.cinsiyet = cinsiyet;
        this.yas = yas;
        this.dTarih = dTarih;
        this.email = email;
        this.sifre = sifre;
    }

    public User(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }

    public void setDTarih(Date dTarih) {
        this.dTarih = dTarih;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public int getId() {
        return id;
    }

    public String getRol() {
        return rol;
    }

    public String getTc() {
        return tc;
    }

    public String getAd() {
        return ad;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public int getYas() {
        return yas;
    }

    public Date getDTarih() {
        return dTarih;
    }

    public String getEmail() {
        return email;
    }

    public String getSifre() {
        return sifre;
    }
}
