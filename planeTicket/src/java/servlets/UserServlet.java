/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import DataBases.DBProcesses;
import DataBases.UserDB;
import Entities.User;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ahmet
 */
public class UserServlet extends HttpServlet {
    private static int AGE_LIMIT=18;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("ISO-8859-9");
        UserDB udb = new UserDB();
        DBProcesses dbp = new DBProcesses();
        String selector = request.getParameter("selector");
        
        if(selector != null && selector.equals("add")){
            String rol = request.getParameter("rol").trim();
            String tc = request.getParameter("tc").trim();
            String ad = request.getParameter("ad").trim();
            String cinsiyet = request.getParameter("cinsiyet").trim();
            int yas = Integer.parseInt(request.getParameter("yas"));
            Date dTarih = Date.valueOf(request.getParameter("d_tarih"));
            String email = request.getParameter("email").trim();
            String sifre = request.getParameter("sifre").trim();
            String redirect = request.getParameter("redirect").trim();
            //send create account mail message..
            String NEW_ACCOUNT_MAIL = "<head>\n" +
            "    <style>\n" +
            "        #btn_web:hover{\n" +
            "            opacity: 0.8;\n" +
            "            cursor: pointer\n" +
            "        }\n" +
            "    </style>\n" +
            "</head>\n" +
            "<body>\n" +
            "    <div style=\"width: 100%;position: relative;margin: auto;background-color: navy\">\n" +
            "        <h2 style=\"background-color: goldenrod;color: navy;text-align: center;font-size: 180%\">Sayın "+ad+", Hoşgeldiniz</h2>\n" +
            "        <p style=\"color: goldenrod\">ATM Airlines olarak aramıza katıldığınızı görmekten mutluluk duyduğumuzu ifade etmek isteriz. Resmi web sitemiz üzerinden, gitmek istediğiniz yeri ve tarihi arayarak uçuşlara göz atabilir, bilet rezervasyonu yapabilir veya bilet satın alabilirsiniz. Satın alma işleminde ilave bir ücret ödeyerek \"Avantaj\" paketini seçip koltuk seçme şansına sahip olabilirsiniz. İyi seyahatler..</p>\n" +
            "        <a style=\"text-decoration: none\" target=\"_blank\" href=\"http://localhost:8018/UcakBiletiSistemi/jsp/index.jsp\"><button id=\"btn_web\" style=\"display: block;margin: auto;text-align: center;height: 29px;background-color: goldenrod;color: navy\">Web Sitesini Ziyaret Et</button></a>\n" +
            "    </div>\n" +
            "</body>";
            
            if(yas >= AGE_LIMIT){
                if(udb.Validation(tc, email, sifre)==null){
                    udb.Add(rol, tc, ad, cinsiyet, yas, dTarih, email, sifre);
                    dbp.sendMail(email, NEW_ACCOUNT_MAIL);
                    if(redirect.equals("user"))
                        response.sendRedirect(request.getContextPath()+"/jsp/createAccountSuccess.jsp");
                    else
                        response.sendRedirect(request.getContextPath()+"/jsp/userSuccess.jsp");
                }
                else{
                    if(redirect.equals("user"))
                        response.sendRedirect(request.getContextPath()+"/jsp/createAccountError.jsp");
                    else
                        response.sendRedirect(request.getContextPath()+"/jsp/userError.jsp");
                }
            }
            else{
                if(redirect.equals("user"))
                    response.sendRedirect(request.getContextPath()+"/jsp/createAccount.jsp");
                else
                    response.sendRedirect(request.getContextPath()+"/jsp/userList.jsp");
            }
        }
        else if(selector != null && selector.equals("update")){
            int id = Integer.parseInt(request.getParameter("id"));
            String rol = request.getParameter("rol").trim();
            String tc = request.getParameter("tc").trim();
            String ad = request.getParameter("ad").trim();
            String cinsiyet = request.getParameter("cinsiyet").trim();
            int yas = Integer.parseInt(request.getParameter("yas"));
            Date dTarih = Date.valueOf(request.getParameter("d_tarih"));
            String email = request.getParameter("email").trim();
            String sifre = request.getParameter("sifre").trim();
            
            if(yas >= AGE_LIMIT){
                if(udb.TcValidation(tc)==0 || udb.MailValidation(email)==0 || udb.SifreValidation(sifre)==0){
                    udb.Update(id, rol, tc, ad, cinsiyet, yas, dTarih, email, sifre);
                    response.sendRedirect(request.getContextPath()+"/jsp/userSuccess.jsp");
                }
                else if(udb.TcValidation(tc)==id && udb.MailValidation(email)==id && udb.SifreValidation(sifre)==id){
                        udb.Update(id, rol, tc, ad, cinsiyet, yas, dTarih, email, sifre);
                        response.sendRedirect(request.getContextPath()+"/jsp/userSuccess.jsp");
                }
                else
                    response.sendRedirect(request.getContextPath()+"/jsp/userError.jsp");              
            }
            else
                response.sendRedirect(request.getContextPath()+"/jsp/userUpdate.jsp?id="+id);
        }
        else if(selector != null && selector.equals("delete")){
            int id = Integer.parseInt(request.getParameter("id"));
            
            udb.Delete(id);
            response.sendRedirect(request.getContextPath()+"/jsp/userList.jsp");
        }
        else if(selector != null && selector.equals("login")){
            String remember_box_value = request.getParameter("remember");
            String tc = request.getParameter("tc").trim();
            String ad = request.getParameter("ad").trim();
            String sifre = request.getParameter("sifre").trim();
            User user = udb.Login(tc, ad, sifre);
            if(user == null){
                response.sendRedirect(request.getContextPath()+"/jsp/loginErr.jsp");
            }
            else{
                HttpSession login = request.getSession(true);
                login.setMaxInactiveInterval(60*60*24);
                login.setAttribute("login", "OK");
                
                if(user.getRol().equals("Admin")){
                    if(remember_box_value != null && remember_box_value.equals("on")){
                        Cookie user_name = new Cookie("userName", ad.replace(" ", ""));
                        user_name.setMaxAge(60*60*24);
                        response.addCookie(user_name);

                        Cookie user_id = new Cookie("userId", String.valueOf(user.getId()));
                        user_id.setMaxAge(60*60*24);
                        response.addCookie(user_id);
                        
                        Cookie remember = new Cookie("remember", "adminOK");
                        remember.setMaxAge(60*60*24);
                        response.addCookie(remember);
                    }else{
                        Cookie user_name = new Cookie("userName", ad.replace(" ", ""));
                        response.addCookie(user_name);

                        Cookie user_id = new Cookie("userId", String.valueOf(user.getId()));
                        response.addCookie(user_id);
                    }
                    response.sendRedirect(request.getContextPath()+"/jsp/adminIndex.jsp");
                }
                else{
                    if(remember_box_value != null && remember_box_value.equals("on")){
                        Cookie user_name = new Cookie("userName", ad.replace(" ", ""));
                        user_name.setMaxAge(60*60*24);
                        response.addCookie(user_name);

                        Cookie user_id = new Cookie("userId", String.valueOf(user.getId()));
                        user_id.setMaxAge(60*60*24);
                        response.addCookie(user_id);
                        
                        Cookie remember = new Cookie("remember", "OK");
                        remember.setMaxAge(60*60*24);
                        response.addCookie(remember);
                    }else{
                        Cookie user_name = new Cookie("userName", ad.replace(" ", ""));
                        response.addCookie(user_name);

                        Cookie user_id = new Cookie("userId", String.valueOf(user.getId()));
                        response.addCookie(user_id);
                    }
                    response.sendRedirect(request.getContextPath()+"/jsp/index.jsp");
                }  
            }
        }
        else if(selector != null && selector.equals("logout")){
            HttpSession logout = request.getSession(true);
            logout.invalidate();
            
            Cookie user_name = new Cookie("userName", null);
            user_name.setMaxAge(0);
            response.addCookie(user_name);
            
            Cookie user_id = new Cookie("userId", null);
            user_id.setMaxAge(0);
            response.addCookie(user_id);
            
            Cookie remember = new Cookie("remember", null);
            remember.setMaxAge(0);
            response.addCookie(remember);
            
            response.sendRedirect(request.getContextPath()+"/jsp/index.jsp");
        }
        else if(selector != null && selector.equals("change")){
            String tc = request.getParameter("tc");
            String sifre = request.getParameter("sifre");
            
            udb.ChangePass(tc, sifre);
            response.sendRedirect(request.getContextPath()+"/jsp/changeSuccess.jsp");
        }else{
            response.sendRedirect(request.getContextPath()+"/jsp/errorPage.jsp");
        }
    }
}