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
public class Company {
    private int id;
    private String isim;
    
    public Company(){}
    
    public Company(int id, String isim){
        this.id=id;
        this.isim=isim;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public int getId() {
        return id;
    }

    public String getIsim() {
        return isim;
    }
}
