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
public class Flight {
    private int id;
    private String kalkis;
    private String varis;
    private Date tarih;
    private String saat;
    private String varisHavaalani;
    private String kalkisHavaalani;
    private double fiyat;
    private String firma;
    
    public Flight(){}

    public Flight(int id, String kalkis, String varis, Date tarih, String saat, String kalkisHavaalani, String varisHavaalani, double fiyat, String firma) {
        this.id = id;
        this.kalkis = kalkis;
        this.varis = varis;
        this.tarih = tarih;
        this.saat = saat;
        this.kalkisHavaalani = kalkisHavaalani;
        this.varisHavaalani = varisHavaalani;
        this.fiyat = fiyat;
        this.firma = firma;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setKalkis(String kalkis) {
        this.kalkis = kalkis;
    }

    public void setVaris(String varis) {
        this.varis = varis;
    }

    public void setTarih(Date tarih) {
        this.tarih = tarih;
    }

    public void setSaat(String saat) {
        this.saat = saat;
    }
    
    public void setKalkisHavaalani(String kalkisHavaalani) {
        this.kalkisHavaalani = kalkisHavaalani;
    }

    public void setVarisHavaalani(String varisHavaalani) {
        this.varisHavaalani = varisHavaalani;
    }

    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public int getId() {
        return id;
    }

    public String getKalkis() {
        return kalkis;
    }

    public String getVaris() {
        return varis;
    }

    public Date getTarih() {
        return tarih;
    }

    public String getSaat() {
        return saat;
    }
    
    public String getKalkisHavaalani() {
        return kalkisHavaalani;
    }

    public String getVarisHavaalani() {
        return varisHavaalani;
    }

    public double getFiyat() {
        return fiyat;
    }

    public String getFirma() {
        return firma;
    }
}
