/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import DataBases.CompanyDB;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ahmet
 */
public class CompanyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("ISO-8859-9");
        CompanyDB cdb = new CompanyDB();
        
        String selector = request.getParameter("selector");
        
        if(selector != null && selector.equals("add")){
            String isim = request.getParameter("firmaIsim").trim();
            
            if(!(cdb.Validation(isim))){
                cdb.Add(isim);
                response.sendRedirect(request.getContextPath()+"/jsp/companySuccess.jsp");
            }
            else
                response.sendRedirect(request.getContextPath()+"/jsp/companyErr.jsp");
        }
        else if(selector != null && selector.equalsIgnoreCase("update")){
            int id = Integer.parseInt(request.getParameter("id"));
            String isim = request.getParameter("firmaIsim").trim();
            
            if(!(cdb.Validation(isim))){
                cdb.Update(id, isim);
                response.sendRedirect(request.getContextPath()+"/jsp/companySuccess.jsp");
            }
            else
                response.sendRedirect(request.getContextPath()+"/jsp/companyErr.jsp");
        }
        else if(selector != null && selector.equals("delete")){
            int id = Integer.parseInt(request.getParameter("id"));
            cdb.Delete(id);
            response.sendRedirect(request.getContextPath()+"/jsp/companyList.jsp");
        }else{
            response.sendRedirect(request.getContextPath()+"/jsp/errorPage.jsp");
        }
    }
}
