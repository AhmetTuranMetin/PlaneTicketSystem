/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import DataBases.FlightDB;
import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ahmet
 */
public class FlightServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("ISO-8859-9");
        FlightDB fdb = new FlightDB();
        String selector = request.getParameter("selector");
        
        if(selector != null && selector.equals("add")){
            String kalkis = request.getParameter("kalkis").trim();
            String varis = request.getParameter("varis").trim();
            Date tarih = Date.valueOf(request.getParameter("tarih"));
            String saat = request.getParameter("saat").trim();
            String kalkisHavaalani = request.getParameter("kalkisHavaalani").trim();
            String varisHavaalani = request.getParameter("varisHavaalani").trim();
            double fiyat = Double.parseDouble(request.getParameter("fiyat"));
            String firma = request.getParameter("firma").trim();
            
            fdb.Add(kalkis, varis, tarih, saat, kalkisHavaalani, varisHavaalani, fiyat, firma);
            response.sendRedirect(request.getContextPath()+"/jsp/flightSuccess.jsp");
        }
        else if(selector != null && selector.equals("update")){
            int id = Integer.parseInt(request.getParameter("id"));
            String kalkis = request.getParameter("kalkis").trim();
            String varis = request.getParameter("varis").trim();
            Date tarih = Date.valueOf(request.getParameter("tarih"));
            String saat = request.getParameter("saat").trim();
            String kalkisHavaalani = request.getParameter("kalkisHavaalani").trim();
            String varisHavaalani = request.getParameter("varisHavaalani").trim();
            double fiyat = Double.parseDouble(request.getParameter("fiyat"));
            String firma = request.getParameter("firma").trim();
            
            fdb.Update(id, kalkis, varis, tarih, saat, kalkisHavaalani, varisHavaalani, fiyat, firma);
            response.sendRedirect(request.getContextPath()+"/jsp/flightSuccess.jsp");
        }
        else if(selector != null && selector.equals("delete")){
            int id = Integer.parseInt(request.getParameter("id"));
            fdb.Delete(id);
            response.sendRedirect(request.getContextPath()+"/jsp/flightList.jsp");
        }else{
            response.sendRedirect(request.getContextPath()+"/jsp/errorPage.jsp");
        }
    }
}
