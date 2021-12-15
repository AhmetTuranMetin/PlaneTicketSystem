/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBases;

import Entities.Ticket;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ahmet
 */
public class TicketDB {
    DBProcesses dbp = new DBProcesses();
    public List<Ticket> AllList(){
        List<Ticket> ticketList = new ArrayList<Ticket>();
        try {
            String query = "select * from bilet";
            PreparedStatement ps = dbp.DBConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Ticket ticket = new Ticket(rs.getInt("id"), rs.getInt("ucusId"), rs.getInt("uyeId"), rs.getString("koltukNo"), rs.getString("tip"), rs.getString("paket"));
                ticketList.add(ticket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ticketList;
    }
    
    public void Add(int ucusId, int uyeId, String koltukNo, String koltukSira, String tip, String paket){
        try {
            String query = "insert into bilet(ucusId,uyeId,koltukNo,tip,paket) values (?,?,?,?,?)";
            PreparedStatement ps = dbp.DBConnection().prepareStatement(query);
            ps.setInt(1, ucusId);
            ps.setInt(2, uyeId);
            ps.setString(3, koltukNo+" "+koltukSira);
            ps.setString(4, tip);
            ps.setString(5, paket);
            ps.executeUpdate();
            ps.close();
            System.out.println("kayıt başarılı..");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("kayıt başarısız!!");
        }
    }
    
    public Ticket GetTicket(int id){
        Ticket ticket = null;
        try {
            String query = "select * from bilet where id=?";
            PreparedStatement ps = dbp.DBConnection().prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                ticket = new Ticket(rs.getInt("id"), rs.getInt("ucusId"), rs.getInt("uyeId"), rs.getString("koltukNo"), rs.getString("tip"), rs.getString("paket"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ticket;
    }
    
    public void Update(int id, int ucusId, int uyeId, String koltukNo, String tip, String paket){
        try {
            String query = "update bilet set ucusId=?,uyeId=?,koltukNo=?,tip=?,paket=? where id=?";
            PreparedStatement ps = dbp.DBConnection().prepareStatement(query);
            ps.setInt(1, ucusId);
            ps.setInt(2, uyeId);
            ps.setString(3, koltukNo);
            ps.setString(4, tip);
            ps.setString(5, paket);
            ps.setInt(6, id);
            ps.executeUpdate();
            System.out.println("güncelleme işlemi başarılı..");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("güncelleme işlemi başarısız!!");
        }
    }
    
    public void Delete(int id){
        try {
            String query = "delete from bilet where id=?";
            PreparedStatement ps = dbp.DBConnection().prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("silme işlemi başarılı..");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("silme işlemi başarısız!!");
        }
    }
    
    public boolean Validation(int ucusId, String koltukNo, String koltukSira){
        Ticket ticket = null;
         try {
             String query = "select * from bilet where ucusId=? and koltukNo=?";
             PreparedStatement ps = dbp.DBConnection().prepareStatement(query);
             ps.setInt(1, ucusId);
             ps.setString(2, koltukNo+" "+koltukSira);
             ResultSet rs = ps.executeQuery();
             
             while (rs.next()) {                 
                ticket = new Ticket(rs.getInt("id"), rs.getInt("ucusId"), rs.getInt("uyeId"), rs.getString("koltukNo"), rs.getString("tip"), rs.getString("paket"));
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
         if(ticket!=null)
             return true;
         else
             return false;
    }
    
    public List<Ticket> GetUserTicket(int uyeId){
        List<Ticket> ticketList = new ArrayList<Ticket>();
        try {
            String query = "select * from bilet where uyeId=?";
            PreparedStatement ps = dbp.DBConnection().prepareStatement(query);
            ps.setInt(1, uyeId);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                Ticket ticket = new Ticket(rs.getInt("id"), rs.getInt("ucusId"), rs.getInt("uyeId"), rs.getString("koltukNo"), rs.getString("tip"), rs.getString("paket"));
                ticketList.add(ticket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ticketList;
    }
    
    public String GetSeat(int id){
        Ticket ticket=null;
        try {
            String query = "select * from bilet where id=?";
            PreparedStatement ps = dbp.DBConnection().prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                ticket = new Ticket(rs.getInt("id"), rs.getInt("ucusId"), rs.getInt("uyeId"), rs.getString("koltukNo"), rs.getString("tip"), rs.getString("paket"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ticket.getKoltukNo();
    }
    
    public void payRezervation(int id){
        try {
            String query = "update bilet set tip=? where id=?";
            PreparedStatement ps = dbp.DBConnection().prepareStatement(query);
            ps.setString(1, "Satın Al");
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("rezervasyon ödeme işlemi başarılı..");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("rezervasyon ödeme işlemi başarısız!!");
        }
    }
    
    public boolean checkRezervation(int ucusId,int uyeId, String tip){
        Ticket ticket=null;
        try {
            String query = "select * from bilet where ucusId=? and uyeId=? and tip=?";
            PreparedStatement ps = dbp.DBConnection().prepareStatement(query);
            ps.setInt(1, ucusId);
            ps.setInt(2, uyeId);
            ps.setString(3, tip);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                ticket = new Ticket(rs.getInt("id"), rs.getInt("ucusId"), rs.getInt("uyeId"), rs.getString("koltukNo"), rs.getString("tip"), rs.getString("paket"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        if(ticket==null)
            return false;
        else
            return true;
    }
}
