/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBases;

import Entities.Card;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ahmet
 */
public class CardDB {
    DBProcesses dbp = new DBProcesses();
    public void Add(int uyeId, String kartNo, int cvv){
        try {
            String query = "insert into kart(uyeId,kartNo,cvv) values (?,?,?)";
            PreparedStatement ps = dbp.DBConnection().prepareStatement(query);
            ps.setInt(1, uyeId);
            ps.setString(2, kartNo);
            ps.setInt(3, cvv);
            ps.executeUpdate();
            ps.close();
            System.out.println("kayıt başarılı..");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("kayıt başarısız!!");
        }
    }
    
    public void Delete(int id){
        try {
            String query = "delete from kart where id=?";
            PreparedStatement ps = dbp.DBConnection().prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("silme işlemi başarılı..");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("silme işlemi başarısız!!");
        }
    }
    
    public List<Card> GetCard(int uyeId){
        List<Card> cardList = new ArrayList<Card>();
        try {
            String query = "select * from kart where uyeId=?";
            PreparedStatement ps = dbp.DBConnection().prepareStatement(query);
            ps.setInt(1, uyeId);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                Card card = new Card(rs.getInt("id"), rs.getInt("uyeId"), rs.getString("kartNo"), rs.getInt("cvv"));
                cardList.add(card);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cardList;
    }
    
    public boolean Check(String kartNo, int cvv, int uyeId){
        Card card = null;
        try {
            String query = "select * from kart where kartNo=? and cvv=? and uyeId=?";
            PreparedStatement ps = dbp.DBConnection().prepareStatement(query);
            ps.setString(1, kartNo);
            ps.setInt(2, cvv);
            ps.setInt(3, uyeId);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                card = new Card(rs.getInt("id"), rs.getInt("uyeId"), rs.getString("kartNo"), rs.getInt("cvv"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        if(card==null)
            return false;
        else
            return true;
    }
    
    public boolean Validation(String kartNo, int cvv){
        Card card = null;
        try {
            String query = "select * from kart where kartNo=? or cvv=?";
            PreparedStatement ps = dbp.DBConnection().prepareStatement(query);
            ps.setString(1, kartNo);
            ps.setInt(2, cvv);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                card = new Card(rs.getInt("id"), rs.getInt("uyeId"), rs.getString("kartNo"), rs.getInt("cvv"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        if(card==null)
            return false;
        else
            return true;
    }
}
