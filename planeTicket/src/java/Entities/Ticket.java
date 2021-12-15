/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author ahmet
 */
public class Ticket {
    private int id;
    private int ucusId;
    private int uyeId;
    private String koltukNo;
    private String tip;
    private String paket;
    
    public Ticket(){}

    public Ticket(int id, int ucusId, int uyeId, String koltukNo, String tip, String paket) {
        this.id = id;
        this.ucusId = ucusId;
        this.uyeId = uyeId;
        this.koltukNo = koltukNo;
        this.tip = tip;
        this.paket = paket;
    }

    public int getId() {
        return id;
    }

    public int getUcusId() {
        return ucusId;
    }

    public int getUyeId() {
        return uyeId;
    }

    public String getKoltukNo() {
        return koltukNo;
    }

    public String getTip() {
        return tip;
    }

    public String getPaket() {
        return paket;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUcusId(int ucusId) {
        this.ucusId = ucusId;
    }

    public void setUyeId(int uyeId) {
        this.uyeId = uyeId;
    }

    public void setKoltukNo(String koltukNo) {
        this.koltukNo = koltukNo;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public void setPaket(String paket) {
        this.paket = paket;
    }
}