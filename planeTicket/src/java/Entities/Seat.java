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
public class Seat {
    private int id;
    private int ucusId;
    private int uyeId;
    private String no;
    
    public Seat(){}

    public Seat(int id, int ucusId, int uyeId, String no) {
        this.id = id;
        this.ucusId = ucusId;
        this.uyeId = uyeId;
        this.no = no;
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

    public String getNo() {
        return no;
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

    public void setNo(String no) {
        this.no = no;
    }
}
