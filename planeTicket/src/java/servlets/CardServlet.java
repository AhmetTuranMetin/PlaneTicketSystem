/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import DataBases.CardDB;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ahmet
 */
public class CardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("ISO-8859-9");
        CardDB cdb = new CardDB();
        String selector = request.getParameter("selector");
        
        if(selector != null && selector.equals("add")){
            int uyeId = Integer.parseInt(request.getParameter("uyeId"));
            String kartNo = request.getParameter("kartNo").trim();
            int cvv = Integer.parseInt(request.getParameter("cvv"));
            
            if(!cdb.Validation(kartNo, cvv)){
                cdb.Add(uyeId, kartNo, cvv);
                response.sendRedirect(request.getContextPath()+"/jsp/cardSuccess.jsp");
            }else
                response.sendRedirect(request.getContextPath()+"/jsp/cardError.jsp");
        }
        else if(selector != null && selector.equals("delete")){
            int id = Integer.parseInt(request.getParameter("id"));
            int uyeId = Integer.parseInt(request.getParameter("uyeId"));
            
            cdb.Delete(id);
            response.sendRedirect(request.getContextPath()+"/jsp/cardList.jsp?uyeId="+uyeId);
        }else{
            response.sendRedirect(request.getContextPath()+"/jsp/errorPage.jsp");
        }
    }
}
