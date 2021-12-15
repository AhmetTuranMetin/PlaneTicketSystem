/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBases;

import Entities.User;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ahmet
 */
public class UserDB {
    DBProcesses dbp = new DBProcesses();
    public List<User> AllList(){
        List<User> userList = new ArrayList<User>();
        try {
            String query = "select * from uye";
            PreparedStatement ps = dbp.DBConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                User user = new User(rs.getInt("id"), rs.getString("rol"), rs.getString("tc"), rs.getString("ad"), 
                        rs.getString("cinsiyet"), rs.getInt("yas"), rs.getDate("dTarih"), rs.getString("email"), rs.getString("sifre"));
                userList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }
    
    public void Add(String rol, String tc, String ad, String cinsiyet, int yas, Date dTarih, String email, String sifre){
        try {
            String query = "insert into uye(rol,tc,ad,cinsiyet,yas,dTarih,email,sifre) values (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = dbp.DBConnection().prepareStatement(query);
            ps.setString(1, rol);
            ps.setString(2, tc);
            ps.setString(3, ad);
            ps.setString(4, cinsiyet);
            ps.setInt(5, yas);
            ps.setDate(6, dTarih);
            ps.setString(7, email);
            ps.setString(8, sifre);
            ps.executeUpdate();
            ps.close();
            System.out.println("kayıt başarılı..");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("kayıt başarısız!!");
        }
    }
    
    public User GetUser(int id){
        User user = null;
        try {
            String query = "select * from uye where id=?";
            PreparedStatement ps = dbp.DBConnection().prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                user = new User(rs.getInt("id"), rs.getString("rol"), rs.getString("tc"), rs.getString("ad"), rs.getString("cinsiyet"), 
                        rs.getInt("yas"), rs.getDate("dTarih"), rs.getString("email"), rs.getString("sifre"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
    
    public void Update(int id, String rol, String tc, String ad, String cinsiyet, int yas, Date dTarih, String email, String sifre){
        try {
            String query = "update uye set rol=?,tc=?,ad=?,cinsiyet=?,yas=?,dTarih=?,email=?,sifre=? where id=?";
            PreparedStatement ps = dbp.DBConnection().prepareStatement(query);
            ps.setString(1, rol);
            ps.setString(2, tc);
            ps.setString(3, ad);
            ps.setString(4, cinsiyet);
            ps.setInt(5, yas);
            ps.setDate(6, dTarih);
            ps.setString(7, email);
            ps.setString(8, sifre);
            ps.setInt(9, id);
            ps.executeUpdate();
            System.out.println("güncelleme işlemi başarılı..");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("güncelleme işlemi başarısız!!");
        }
    }
    
     public void Delete(int id){
        try {
            String query = "delete from uye where id=?";
            PreparedStatement ps = dbp.DBConnection().prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("silme işlemi başarılı..");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("silme işlemi başarısız!!");
        }
    }
     
     public User Login(String tc, String ad, String sifre){
         User user = null;
         try {
             String query = "select * from uye where tc=? and ad=? and sifre=?";
             PreparedStatement ps = dbp.DBConnection().prepareStatement(query);
             ps.setString(1, tc);
             ps.setString(2, ad);
             ps.setString(3, sifre);
             ResultSet rs = ps.executeQuery();
              while (rs.next()) {                 
                 user = new User(rs.getInt("id"), rs.getString("rol"), rs.getString("tc"), rs.getString("ad"), rs.getString("cinsiyet"), 
                        rs.getInt("yas"), rs.getDate("dTarih"), rs.getString("email"), rs.getString("sifre"));
             }
              System.out.println("giriş yapıldı..");
         } catch (Exception e) {
             e.printStackTrace();
             System.out.println("giriş başarısız!!");
         }
         return user;
     }
     
     public User Validation(String tc, String email, String sifre){
         User user = null;
         try {
             String query = "select * from uye where tc=? or email=? or sifre=?";
             PreparedStatement ps = dbp.DBConnection().prepareStatement(query);
             ps.setString(1, tc);
             ps.setString(2, email);
             ps.setString(3, sifre);
             ResultSet rs = ps.executeQuery();
             
             while (rs.next()) {                 
                user = new User(rs.getInt("id"), rs.getString("rol"), rs.getString("tc"), rs.getString("ad"), rs.getString("cinsiyet"), 
                        rs.getInt("yas"), rs.getDate("dTarih"), rs.getString("email"), rs.getString("sifre"));
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
         return user;
     }
     
     public int TcValidation(String tc){
         User user = null;
         try {
             String query = "select * from uye where tc=?";
             PreparedStatement ps = dbp.DBConnection().prepareStatement(query);
             ps.setString(1, tc);
             ResultSet rs = ps.executeQuery();
             
             while (rs.next()) {                 
                user = new User(rs.getInt("id"), rs.getString("rol"), rs.getString("tc"), rs.getString("ad"), rs.getString("cinsiyet"), 
                        rs.getInt("yas"), rs.getDate("dTarih"), rs.getString("email"), rs.getString("sifre"));
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
         
         if(user==null){
             return 0;
         }else
             return user.getId();
     }
     
     public int MailValidation(String email){
         User user = null;
         try {
             String query = "select * from uye where email=?";
             PreparedStatement ps = dbp.DBConnection().prepareStatement(query);
             ps.setString(1, email);
             ResultSet rs = ps.executeQuery();
             
             while (rs.next()) {                 
                user = new User(rs.getInt("id"), rs.getString("rol"), rs.getString("tc"), rs.getString("ad"), rs.getString("cinsiyet"), 
                        rs.getInt("yas"), rs.getDate("dTarih"), rs.getString("email"), rs.getString("sifre"));
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
         
         if(user==null){
             return 0;
         }else
             return user.getId();
     }
     
     public int SifreValidation(String sifre){
         User user = null;
         try {
             String query = "select * from uye where sifre=?";
             PreparedStatement ps = dbp.DBConnection().prepareStatement(query);
             ps.setString(1, sifre);
             ResultSet rs = ps.executeQuery();
             
             while (rs.next()) {                 
                user = new User(rs.getInt("id"), rs.getString("rol"), rs.getString("tc"), rs.getString("ad"), rs.getString("cinsiyet"), 
                        rs.getInt("yas"), rs.getDate("dTarih"), rs.getString("email"), rs.getString("sifre"));
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
         
         if(user==null){
             return 0;
         }else
             return user.getId();
     }
     
     public void ChangePass(String tc, String sifre){
         try {
            String query = "update uye set sifre=? where tc=?";
            PreparedStatement ps = dbp.DBConnection().prepareStatement(query);
            ps.setString(1, sifre);
            ps.setString(2, tc);
            ps.executeUpdate();
            System.out.println("şifre güncelleme işlemi başarılı..");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("şifre güncelleme işlemi başarısız!!");
        }
     }
     
     public int GetTcUserId(String tc){
         User user = null;
         try {
             String query = "select * from uye where tc=?";
             PreparedStatement ps = dbp.DBConnection().prepareStatement(query);
             ps.setString(1, tc);
             ResultSet rs = ps.executeQuery();
             
             while (rs.next()) {                 
                user = new User(rs.getInt("id"), rs.getString("rol"), rs.getString("tc"), rs.getString("ad"), rs.getString("cinsiyet"), 
                        rs.getInt("yas"), rs.getDate("dTarih"), rs.getString("email"), rs.getString("sifre"));
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
         
         return user.getId();
     }
}
