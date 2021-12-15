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
public class Card {
    private int id;
    private int uyeId;
    private String kartNo;
    private int cvv;
    
    public Card(){}

    public Card(int id, int uyeId, String kartNo, int cvv) {
        this.id = id;
        this.uyeId = uyeId;
        this.kartNo = kartNo;
        this.cvv = cvv;
    }

    public int getId() {
        return id;
    }

    public int getUyeId() {
        return uyeId;
    }

    public String getKartNo() {
        return kartNo;
    }

    public int getCvv() {
        return cvv;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUyeId(int uyeId) {
        this.uyeId = uyeId;
    }

    public void setKartNo(String kartNo) {
        this.kartNo = kartNo;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }
    
    
}
