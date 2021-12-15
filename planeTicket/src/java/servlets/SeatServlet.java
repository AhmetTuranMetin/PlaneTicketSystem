/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import DataBases.SeatDB;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ahmet
 */
public class SeatServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("ISO-8859-9");
        SeatDB sdb = new SeatDB();
        String selector = request.getParameter("selector");
        
        if(selector != null && selector.equals("add")){
            int ucusId = Integer.parseInt(request.getParameter("ucusId"));
            int uyeId = Integer.parseInt(request.getParameter("uyeId"));
            String koltukNo = request.getParameter("koltukNo").trim();
            String koltukSira = request.getParameter("koltukSira").trim();
            String no = koltukNo+" "+koltukSira;
            
            if(!(sdb.Validation(ucusId, no))){
                sdb.Add(ucusId, uyeId, no);
                response.sendRedirect(request.getContextPath()+"/jsp/seatSuccess.jsp");
            }
            else
               response.sendRedirect(request.getContextPath()+"/jsp/seatError.jsp"); 
        }
        else if(selector != null && selector.equals("update")){
            int id = Integer.parseInt(request.getParameter("id"));
            int ucusId = Integer.parseInt(request.getParameter("ucusId"));
            int uyeId = Integer.parseInt(request.getParameter("uyeId"));
            String koltukNo = request.getParameter("koltukNo").trim();
            String koltukSira = request.getParameter("koltukSira").trim();
            String no = koltukNo+" "+koltukSira;
            
            if(!(sdb.Validation(ucusId, no))){
                sdb.Update(id, ucusId, uyeId, no);
                response.sendRedirect(request.getContextPath()+"/jsp/seatSuccess.jsp");
            }
            else
                response.sendRedirect(request.getContextPath()+"/jsp/seatError.jsp");
        }
        else if(selector != null && selector.equals("delete")){
            int id = Integer.parseInt(request.getParameter("id"));
            
            sdb.Delete(id);
            response.sendRedirect(request.getContextPath()+"/jsp/seatList.jsp");
        }else{
            response.sendRedirect(request.getContextPath()+"/jsp/errorPage.jsp");
        }
    }
}
