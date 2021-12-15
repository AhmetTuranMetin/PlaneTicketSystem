/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBases;



import Entities.Flight;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ahmet
 */
public class FlightDB {
    DBProcesses dbp = new DBProcesses();
    public List<Flight> AllList(){
        List<Flight> flightList = new ArrayList<Flight>();
        try {
            String query = "select * from ucus";
            PreparedStatement ps = dbp.DBConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Flight flight = new Flight(rs.getInt("iducus"),rs.getString("kalkis"), rs.getString("varis"), 
                rs.getDate("tarih"), rs.getString("saat"), rs.getString("kalkisHavaalani"), rs.getString("varisHavaalani"), rs.getDouble("fiyat"), rs.getString("firma"));
                flightList.add(flight);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flightList;
    }
    
    public void Add(String kalkis, String varis, Date tarih, String saat, String kalkisHavaalani, String varisHavaalani, double fiyat, String firma){
        try {
            String query = "insert into ucus(kalkis,varis,tarih,saat,kalkisHavaalani,varisHavaalani,fiyat,firma) values (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = dbp.DBConnection().prepareStatement(query);
            ps.setString(1, kalkis);
            ps.setString(2, varis);
            ps.setDate(3, tarih);
            ps.setString(4, saat);
            ps.setString(5, kalkisHavaalani);
            ps.setString(6, varisHavaalani);
            ps.setDouble(7, fiyat);
            ps.setString(8, firma);
            ps.executeUpdate();
            ps.close();
            System.out.println("kayıt başarılı..");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("kayıt başarısız!!");
        }
    }
    
    public Flight GetFlight(int id){
        Flight flight = null;
        try {
            String query = "select * from ucus where iducus=?";
            PreparedStatement ps = dbp.DBConnection().prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                flight = new Flight(rs.getInt("iducus"),rs.getString("kalkis"), rs.getString("varis"), 
                rs.getDate("tarih"), rs.getString("saat"), rs.getString("kalkisHavaalani"), rs.getString("varisHavaalani"), rs.getDouble("fiyat"), rs.getString("firma"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flight;
    }
    
    public void Update(int id, String kalkis, String varis, Date tarih, String saat, String kalkisHavaalani, String varisHavaalani, double fiyat, String firma){
        try {
            String query = "update ucus set kalkis=?,varis=?,tarih=?,saat=?,kalkisHavaalani=?,varisHavaalani=?,fiyat=?,firma=? where iducus=?";
            PreparedStatement ps = dbp.DBConnection().prepareStatement(query);
            ps.setString(1, kalkis);
            ps.setString(2, varis);
            ps.setDate(3, tarih);
            ps.setString(4, saat);
            ps.setString(5, kalkisHavaalani);
            ps.setString(6, varisHavaalani);
            ps.setDouble(7, fiyat);
            ps.setString(8, firma);
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
            String query = "delete from ucus where iducus=?";
            PreparedStatement ps = dbp.DBConnection().prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("silme işlemi başarılı..");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("silme işlemi başarısız!!");
        }
    }
    
    public List<Flight> Search(String kalkis, String varis, Date tarih){
        List<Flight> searchList = new ArrayList<Flight>();
        try {
            String query = "select * from ucus where kalkis=? and varis=? and tarih=?";
            PreparedStatement ps = dbp.DBConnection().prepareStatement(query);
            ps.setString(1, kalkis);
            ps.setString(2, varis);
            ps.setDate(3, tarih);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                Flight flight = new Flight(rs.getInt("iducus"),rs.getString("kalkis"), rs.getString("varis"), 
                rs.getDate("tarih"), rs.getString("saat"), rs.getString("kalkisHavaalani"), rs.getString("varisHavaalani"), rs.getDouble("fiyat"), rs.getString("firma"));
                searchList.add(flight);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return searchList;
    }
}

