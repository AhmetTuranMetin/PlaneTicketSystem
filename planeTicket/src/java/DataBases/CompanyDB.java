/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBases;

import Entities.Company;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ahmet
 */
public class CompanyDB {
    DBProcesses dbp = new DBProcesses();
    public List<Company> AllList(){
        List<Company> companyList = new ArrayList<Company>();
        try {
            String query = "select * from firma";
            PreparedStatement ps = dbp.DBConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                Company company = new Company(rs.getInt("id"), rs.getString("isim"));
                companyList.add(company);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return companyList;
    }
    
    public void Add(String isim){
        try {
            String query = "insert into firma(isim) values (?)";
            PreparedStatement ps = dbp.DBConnection().prepareStatement(query);
            ps.setString(1, isim);
            ps.executeUpdate();
            ps.close();
            System.out.println("kayıt başarılı..");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("kayıt başarısız!!");
        }
    }
    
    public Company GetCompany(int id){
        Company company = null;
        try {
            String query = "select * from firma where id=?";
            PreparedStatement ps = dbp.DBConnection().prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                company = new Company(rs.getInt("id"), rs.getString("isim"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return company;
    }
    
    public void Update(int id, String isim){
        try {
            String query = "update firma set isim=? where id=?";
            PreparedStatement ps = dbp.DBConnection().prepareStatement(query);
            ps.setString(1, isim);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("güncelleme işlemi başarılı..");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("güncelleme işlemi başarısız!!");
        }
    }
    
    public void Delete(int id){
        try {
            String query = "delete from firma where id=?";
            PreparedStatement ps = dbp.DBConnection().prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("silme işlemi başarılı..");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("silme işlemi başarısız!!");
        }
    }
    
    public boolean Validation(String isim){
        Company company = null;
         try {
             String query = "select * from firma where isim=?";
             PreparedStatement ps = dbp.DBConnection().prepareStatement(query);
             ps.setString(1, isim);;
             ResultSet rs = ps.executeQuery();
             
             while (rs.next()) {                 
                company = new Company(rs.getInt("id"), rs.getString("isim"));
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
         if(company!=null)
             return true;
         else
             return false;
    }
}