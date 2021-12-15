/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBases;

import Entities.Seat;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ahmet
 */
public class SeatDB {
    DBProcesses dbp = new DBProcesses();
    public List<Seat> AllList(){
        List<Seat> seatList = new ArrayList<Seat>();
        try {
            String query = "select * from koltuk";
            PreparedStatement ps = dbp.DBConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Seat seat = new Seat(rs.getInt("id"), rs.getInt("ucusId"), rs.getInt("uyeId"), rs.getString("no"));
                seatList.add(seat);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return seatList;
    }
    
    public void Add(int ucusId, int uyeId, String no){
        try {
            String query = "insert into koltuk(ucusId,uyeId,no) values (?,?,?)";
            PreparedStatement ps = dbp.DBConnection().prepareStatement(query);
            ps.setInt(1, ucusId);
            ps.setInt(2, uyeId);
            ps.setString(3, no);
            ps.executeUpdate();
            ps.close();
            System.out.println("kayıt başarılı..");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("kayıt başarısız!!");
        }
    }
    
    public void Update(int id, int ucusId, int uyeId, String no){
        try {
            String query = "update koltuk set ucusId=?,uyeId=?,no=? where id=?";
            PreparedStatement ps = dbp.DBConnection().prepareStatement(query);
            ps.setInt(1, ucusId);
            ps.setInt(2, uyeId);
            ps.setString(3, no);
            ps.setInt(4, id);
            ps.executeUpdate();
            System.out.println("güncelleme işlemi başarılı..");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("güncelleme işlemi başarısız!!");
        }
    }
    
    public void Delete(int id){
        try {
            String query = "delete from koltuk where id=?";
            PreparedStatement ps = dbp.DBConnection().prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("silme işlemi başarılı..");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("silme işlemi başarısız!!");
        }
    }
    
    public Seat GetSeat(int id){
        Seat seat = null;
        try {
            String query = "select * from koltuk where id=?";
            PreparedStatement ps = dbp.DBConnection().prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                seat = new Seat(rs.getInt("id"), rs.getInt("ucusId"), rs.getInt("uyeId"), rs.getString("no"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return seat;
    }
    
    public List<Seat> GetList(int ucusId){
        List<Seat> seatList = new ArrayList<Seat>();
        try {
            String query = "select * from koltuk where ucusId=?";
            PreparedStatement ps = dbp.DBConnection().prepareStatement(query);
            ps.setInt(1, ucusId);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                Seat seat = new Seat(rs.getInt("id"), rs.getInt("ucusId"), rs.getInt("uyeId"), rs.getString("no"));
                seatList.add(seat);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return seatList;
    }
    
    public boolean Validation(int ucusId, String no){
        Seat seat = null;
         try {
             String query = "select * from koltuk where ucusId=? and no=?";
             PreparedStatement ps = dbp.DBConnection().prepareStatement(query);
             ps.setInt(1, ucusId);
             ps.setString(2, no);
             ResultSet rs = ps.executeQuery();
             
             while (rs.next()) {                 
                seat = new Seat(rs.getInt("id"), rs.getInt("ucusId"), rs.getInt("uyeId"), rs.getString("no"));
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
         if(seat!=null)
             return true;
         else
             return false;
    }
    
    public void Delete2(int ucusId, String koltukNo){
        try {
            String query = "delete from koltuk where ucusId=? and no=?";
            PreparedStatement ps = dbp.DBConnection().prepareStatement(query);
            ps.setInt(1, ucusId);
            ps.setString(2, koltukNo);
            ps.executeUpdate();
            System.out.println("silme işlemi başarılı..");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("silme işlemi başarısız!!");
        }
    }
}
