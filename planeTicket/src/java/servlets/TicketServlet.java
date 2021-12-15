/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import DataBases.CardDB;
import DataBases.DBProcesses;
import DataBases.FlightDB;
import DataBases.SeatDB;
import DataBases.TicketDB;
import DataBases.UserDB;
import Entities.Flight;
import Entities.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ahmet
 */
public class TicketServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("ISO-8859-9");
        double ADVANTAGE_PRİCE = 30.;
        TicketDB tdb = new TicketDB();
        SeatDB sdb = new SeatDB();
        CardDB cdb = new CardDB();
        DBProcesses dbp = new DBProcesses();
        String selector = request.getParameter("selector");
        
        if(selector != null && selector.equals("add")){
            String paket = "Standart";
            int ucusId = Integer.parseInt(request.getParameter("ucusId"));
            int uyeId = Integer.parseInt(request.getParameter("uyeId"));
            String koltukNo = request.getParameter("koltukNo");
            String koltukSira = request.getParameter("koltukSira");
            String tip = request.getParameter("tip").trim();
            paket = request.getParameter("paket").trim();
            String redirect = request.getParameter("redirect").trim();   
            
            if(redirect.equals("user")){
                //seat select return to page..
                if(!paket.equals("Standart")){
                    response.sendRedirect(request.getContextPath()+"/jsp/seatSelect.jsp?ucusId="+ucusId+"&uyeId="+uyeId+"&tip="+tip+"&paket="+paket);
                    return;
                }
                else if(tip.equals("Rezervasyon")){
                    if(!tdb.checkRezervation(ucusId,uyeId, tip)){
                        koltukNo="Koltuk";
                    koltukSira="Secilmedi";
                    tdb.Add(ucusId, uyeId, koltukNo, koltukSira, tip, paket);
                    User user = new UserDB().GetUser(uyeId);
                    Flight flight = new FlightDB().GetFlight(ucusId);
                    String BUY_TICKET_MAIL = "<head>\n" +
"    <style>\n" +
"        table,th,td{\n" +
"            border: 2px solid black;border-collapse: collapse;\n" +
"            border-color: goldenrod;\n" +
"            background-color: navy;\n" +
"            color: goldenrod;\n" +
"        }\n" +
"        td{\n" +
"            text-align: left\n" +
"        }\n" +
"        h2{\n" +
"            color: navy\n" +
"        }\n" +
"        p{\n" +
"            color: darkorange;\n" +
"        }\n" +
"    </style>\n" +
"</head>\n" +
"<body>\n" +
"    <h2>Rezervasyon işlemi gerçekleşmiştir. Bilgileriniz ATM Airlines tarafından güvence altındadır. Detaylı bilgi aşağıda tarafınıza iletilmiştir. Bizi tercih ettiğiniz için teşekkür ederiz ve iyi yolculuklar dileriz.</h2>\n" +
"    <p><strong>Uçuş saatinizden en az 6 saat önce ödeme işlemini gerçekleştirmeniz önemle rica olunur.</strong></p>\n" +
"    <table style=\"width: 100%\">\n" +
"        <tr>\n" +
"            <th>Bilet Sahibi</th>\n" +
"            <th>Kalkış Şehri</th>\n" +
"            <th>Varış Şehri</th>\n" +
"            <th>Kalkış Havaalanı</th>\n" +
"            <th>Varış Havaalanı</th>\n" +
"            <th>Tarih</th>\n" +
"            <th>Saat</th>\n" +
"            <th>Paket</th>\n" +
"            <th>Koltuk No</th>\n" +
"            <th>Bilet Tipi</th>\n" +
"            <th>Firma</th>\n" +
"            <th>Fiyat</th>\n" +
"        </tr>\n" +
"        <tr>\n" +
"            <td>"+user.getAd()+"</th>\n" +
"            <td>"+flight.getKalkis()+"</td>\n" +
"            <td>"+flight.getVaris()+"</td>\n" +
"            <td>"+flight.getKalkisHavaalani()+"</td>\n" +
"            <td>"+flight.getVarisHavaalani()+"</td>\n" +
"            <td>"+flight.getTarih()+"</td>\n" +
"            <td>"+flight.getSaat()+"</td>\n" +
"            <td>"+paket+"</td>\n" +
"            <td>"+koltukNo+" "+koltukSira+"</td>\n" +
"            <td>"+tip+"</td>\n" +
"            <td>"+flight.getFirma()+"</td>\n" +
"            <td>"+flight.getFiyat()+"</td>\n" +
"        </tr>\n" +
"    </table>\n" +
"</body>";
                    dbp.sendMail(user.getEmail(), BUY_TICKET_MAIL);
                    response.sendRedirect(request.getContextPath()+"/jsp/rezervationSuccess.jsp");
                    }else
                        response.sendRedirect(request.getContextPath()+"/jsp/rezervationErr.jsp");
                }
                else{
                    response.sendRedirect(request.getContextPath()+"/jsp/cardPage.jsp?ucusId="+ucusId+"&uyeId="+uyeId+"&tip="+tip+"&paket="+paket+"&koltukNo=Koltuk&koltukSira=Secilmedi&selector=addSeatSelect");
                }
            }
            else{
                if(!(tdb.Validation(ucusId, koltukNo, koltukSira))){
                    tdb.Add(ucusId, uyeId, koltukNo, koltukSira, tip, paket);
                    sdb.Add(ucusId, uyeId, koltukNo+" "+koltukSira);
                    User user = new UserDB().GetUser(uyeId);
                    Flight flight = new FlightDB().GetFlight(ucusId);
                    String BUY_TICKET_MAIL = "<head>\n" +
"    <style>\n" +
"        table,th,td{\n" +
"            border: 2px solid black;border-collapse: collapse;\n" +
"            border-color: goldenrod;\n" +
"            background-color: navy;\n" +
"            color: goldenrod;\n" +
"        }\n" +
"        td{\n" +
"            text-align: left\n" +
"        }\n" +
"        h2{\n" +
"            color: navy\n" +
"        }\n" +
"    </style>\n" +
"</head>\n" +
"<body>\n" +
"    <h2>Satın alma işlemi gerçekleşmiştir. Bilgileriniz ATM Airlines tarafından güvence altındadır. Detaylı bilgi aşağıda tarafınıza iletilmiştir. Bizi tercih ettiğiniz için teşekkür ederiz ve iyi yolculuklar dileriz.</h2>\n" +
"    <table style=\"width: 100%\">\n" +
"        <tr>\n" +
"            <th>Bilet Sahibi</th>\n" +
"            <th>Kalkış Şehri</th>\n" +
"            <th>Varış Şehri</th>\n" +
"            <th>Kalkış Havaalanı</th>\n" +
"            <th>Varış Havaalanı</th>\n" +
"            <th>Tarih</th>\n" +
"            <th>Saat</th>\n" +
"            <th>Paket</th>\n" +
"            <th>Koltuk No</th>\n" +
"            <th>Bilet Tipi</th>\n" +
"            <th>Firma</th>\n" +
"            <th>Fiyat</th>\n" +
"        </tr>\n" +
"        <tr>\n" +
"            <td>"+user.getAd()+"</th>\n" +
"            <td>"+flight.getKalkis()+"</td>\n" +
"            <td>"+flight.getVaris()+"</td>\n" +
"            <td>"+flight.getKalkisHavaalani()+"</td>\n" +
"            <td>"+flight.getVarisHavaalani()+"</td>\n" +
"            <td>"+flight.getTarih()+"</td>\n" +
"            <td>"+flight.getSaat()+"</td>\n" +
"            <td>"+paket+"</td>\n" +
"            <td>"+koltukNo+" "+koltukSira+"</td>\n" +
"            <td>"+tip+"</td>\n" +
"            <td>"+flight.getFirma()+"</td>\n" +
"            <td>"+flight.getFiyat()+"</td>\n" +
"        </tr>\n" +
"    </table>\n" +
"</body>";
                    dbp.sendMail(user.getEmail(), BUY_TICKET_MAIL);
                    response.sendRedirect(request.getContextPath()+"/jsp/ticketSuccess.jsp");
                }
                else
                    response.sendRedirect(request.getContextPath()+"/jsp/ticketError.jsp");
            }
        }
        else if(selector != null && selector.equals("addSeatSelect")){
            int ucusId = Integer.parseInt(request.getParameter("ucusId"));
            int uyeId = Integer.parseInt(request.getParameter("uyeId"));
            String koltukNo = request.getParameter("koltukNo").trim();
            String koltukSira = request.getParameter("koltukSira").trim();
            String tip = request.getParameter("tip").trim();
            String paket = request.getParameter("paket").trim();
            String kartNo = request.getParameter("kartNo").trim();
            int cvv = Integer.parseInt(request.getParameter("cvv").trim());
            
            if(!paket.equals("Standart")){
                if(!(tdb.Validation(ucusId, koltukNo, koltukSira)) && !(sdb.Validation(ucusId, koltukNo+" "+koltukSira)) && cdb.Check(kartNo, cvv, uyeId)){
                tdb.Add(ucusId, uyeId, koltukNo, koltukSira, tip, paket);
                sdb.Add(ucusId, uyeId, koltukNo+" "+koltukSira);
                User user = new UserDB().GetUser(uyeId);
                Flight flight = new FlightDB().GetFlight(ucusId);
                double yeniFiyat = flight.getFiyat() + ADVANTAGE_PRİCE;
                String BUY_TICKET_MAIL = "<head>\n" +
"    <style>\n" +
"        table,th,td{\n" +
"            border: 2px solid black;border-collapse: collapse;\n" +
"            border-color: goldenrod;\n" +
"            background-color: navy;\n" +
"            color: goldenrod;\n" +
"        }\n" +
"        td{\n" +
"            text-align: left\n" +
"        }\n" +
"        h2{\n" +
"            color: navy\n" +
"        }\n" +
"    </style>\n" +
"</head>\n" +
"<body>\n" +
"    <h2>Satın alma işlemi gerçekleşmiştir. Bilgileriniz ATM Airlines tarafından güvence altındadır. Detaylı bilgi aşağıda tarafınıza iletilmiştir. Bizi tercih ettiğiniz için teşekkür ederiz ve iyi yolculuklar dileriz.</h2>\n" +
"    <table style=\"width: 100%\">\n" +
"        <tr>\n" +
"            <th>Bilet Sahibi</th>\n" +
"            <th>Kalkış Şehri</th>\n" +
"            <th>Varış Şehri</th>\n" +
"            <th>Kalkış Havaalanı</th>\n" +
"            <th>Varış Havaalanı</th>\n" +
"            <th>Tarih</th>\n" +
"            <th>Saat</th>\n" +
"            <th>Paket</th>\n" +
"            <th>Koltuk No</th>\n" +
"            <th>Bilet Tipi</th>\n" +
"            <th>Firma</th>\n" +
"            <th>Fiyat</th>\n" +
"        </tr>\n" +
"        <tr>\n" +
"            <td>"+user.getAd()+"</th>\n" +
"            <td>"+flight.getKalkis()+"</td>\n" +
"            <td>"+flight.getVaris()+"</td>\n" +
"            <td>"+flight.getKalkisHavaalani()+"</td>\n" +
"            <td>"+flight.getVarisHavaalani()+"</td>\n" +
"            <td>"+flight.getTarih()+"</td>\n" +
"            <td>"+flight.getSaat()+"</td>\n" +
"            <td>"+paket+"</td>\n" +
"            <td>"+koltukNo+" "+koltukSira+"</td>\n" +
"            <td>"+tip+"</td>\n" +
"            <td>"+flight.getFirma()+"</td>\n" +
"            <td>"+yeniFiyat+"</td>\n" +
"        </tr>\n" +
"    </table>\n" +
"</body>";
                dbp.sendMail(user.getEmail(), BUY_TICKET_MAIL);
                response.sendRedirect(request.getContextPath()+"/jsp/buyTicketSuccess.jsp");
                }
                else
                    response.sendRedirect(request.getContextPath()+"/jsp/buyTicketErr.jsp");
            }else{
                if(cdb.Check(kartNo, cvv, uyeId)){
                    tdb.Add(ucusId, uyeId, koltukNo, koltukSira, tip, paket);
                    User user = new UserDB().GetUser(uyeId);
                    Flight flight = new FlightDB().GetFlight(ucusId);
                    String BUY_TICKET_MAIL = "<head>\n" +
"    <style>\n" +
"        table,th,td{\n" +
"            border: 2px solid black;border-collapse: collapse;\n" +
"            border-color: goldenrod;\n" +
"            background-color: navy;\n" +
"            color: goldenrod;\n" +
"        }\n" +
"        td{\n" +
"            text-align: left\n" +
"        }\n" +
"        h2{\n" +
"            color: navy\n" +
"        }\n" +
"    </style>\n" +
"</head>\n" +
"<body>\n" +
"    <h2>Satın alma işlemi gerçekleşmiştir. Bilgileriniz ATM Airlines tarafından güvence altındadır. Detaylı bilgi aşağıda tarafınıza iletilmiştir. Bizi tercih ettiğiniz için teşekkür ederiz ve iyi yolculuklar dileriz.</h2>\n" +
"    <table style=\"width: 100%\">\n" +
"        <tr>\n" +
"            <th>Bilet Sahibi</th>\n" +
"            <th>Kalkış Şehri</th>\n" +
"            <th>Varış Şehri</th>\n" +
"            <th>Kalkış Havaalanı</th>\n" +
"            <th>Varış Havaalanı</th>\n" +
"            <th>Tarih</th>\n" +
"            <th>Saat</th>\n" +
"            <th>Paket</th>\n" +
"            <th>Koltuk No</th>\n" +
"            <th>Bilet Tipi</th>\n" +
"            <th>Firma</th>\n" +
"            <th>Fiyat</th>\n" +
"        </tr>\n" +
"        <tr>\n" +
"            <td>"+user.getAd()+"</th>\n" +
"            <td>"+flight.getKalkis()+"</td>\n" +
"            <td>"+flight.getVaris()+"</td>\n" +
"            <td>"+flight.getKalkisHavaalani()+"</td>\n" +
"            <td>"+flight.getVarisHavaalani()+"</td>\n" +
"            <td>"+flight.getTarih()+"</td>\n" +
"            <td>"+flight.getSaat()+"</td>\n" +
"            <td>"+paket+"</td>\n" +
"            <td>"+koltukNo+" "+koltukSira+"</td>\n" +
"            <td>"+tip+"</td>\n" +
"            <td>"+flight.getFirma()+"</td>\n" +
"            <td>"+flight.getFiyat()+"</td>\n" +
"        </tr>\n" +
"    </table>\n" +
"</body>";
                    dbp.sendMail(user.getEmail(), BUY_TICKET_MAIL);
                    response.sendRedirect(request.getContextPath()+"/jsp/buyTicketSuccess.jsp");
                }  
                else
                    response.sendRedirect(request.getContextPath()+"/jsp/buyTicketErr.jsp");
            } 
        }
        else if(selector != null && selector.equals("update")){
            int id = Integer.parseInt(request.getParameter("id"));
            int ucusId = Integer.parseInt(request.getParameter("ucusId"));
            int uyeId = Integer.parseInt(request.getParameter("uyeId"));
            String koltukNo = request.getParameter("koltukNo").trim();
            String koltukSira = request.getParameter("koltukSira").trim();
            String koltuk = koltukNo+" "+koltukSira;
            String tip = request.getParameter("tip").trim();
            String paket = request.getParameter("paket").trim();
            
            if(!(tdb.Validation(ucusId, koltukNo, koltukSira)) && !(sdb.Validation(ucusId, koltukNo+" "+koltukSira))){
                tdb.Update(id, ucusId, uyeId, koltuk, tip, paket);
                sdb.Add(ucusId, uyeId, koltukNo+" "+koltukSira);
                response.sendRedirect(request.getContextPath()+"/jsp/ticketSuccess.jsp");
            }
            else{
                response.sendRedirect(request.getContextPath()+"/jsp/ticketError.jsp");
            }
        }
        else if(selector != null && selector.equals("delete")){
            String redirect = request.getParameter("redirect").trim();
            String kullanici_ad=null;
            if(redirect.equals("user")){
                //get user name path
                Cookie cookies[] = request.getCookies();
                for (int i = 0; i < cookies.length; i++) {
                    if (cookies[i].getName().equals("userName")) {
                        kullanici_ad = cookies[i].getValue();
                        break;
                    }
                }
                
                int id = Integer.parseInt(request.getParameter("id"));
                String koltukNo = tdb.GetSeat(id);
                int uyeId = Integer.parseInt(request.getParameter("uyeId"));
                int ucusId = Integer.parseInt(request.getParameter("ucusId"));
                
                tdb.Delete(id);
                sdb.Delete2(ucusId, koltukNo);
                User user = new UserDB().GetUser(uyeId);
                Flight flight = new FlightDB().GetFlight(ucusId);
                String CANCEL_TICKET_MAIL = "<h2 style=\"color: navy\">"+flight.getKalkis()+"-"+flight.getVaris()+" arası, "+flight.getTarih()+" tarihli ve "+flight.getSaat()+" saatli uçuşunuzun iptal işlemi gerçekleşmiştir. ATM Airlines olarak, bizi tercih ettiğiniz için teşekkür eder, iyi günler dileriz.</h2>";
                dbp.sendMail(user.getEmail(), CANCEL_TICKET_MAIL);
                response.sendRedirect(request.getContextPath()+"/jsp/userTicketList.jsp?uyeId="+uyeId+"&name="+kullanici_ad);
            }else{
                int id = Integer.parseInt(request.getParameter("id"));
                String koltukNo = tdb.GetSeat(id);
                int ucusId = Integer.parseInt(request.getParameter("ucusId"));
                int uyeId = Integer.parseInt(request.getParameter("uyeId"));
            
                tdb.Delete(id);
                sdb.Delete2(ucusId, koltukNo);
                User user = new UserDB().GetUser(uyeId);
                Flight flight = new FlightDB().GetFlight(ucusId);
                String CANCEL_TICKET_MAIL = "<h2 style=\"color: navy\">"+flight.getKalkis()+"-"+flight.getVaris()+" arası, "+flight.getTarih()+" tarihli ve "+flight.getSaat()+" saatli uçuşunuzun iptal işlemi gerçekleşmiştir. ATM Airlines olarak, bizi tercih ettiğiniz için teşekkür eder, iyi günler dileriz.</h2>";
                dbp.sendMail(user.getEmail(), CANCEL_TICKET_MAIL);
                response.sendRedirect(request.getContextPath()+"/jsp/ticketList.jsp");
            }
        }
        else if(selector != null && selector.equals("payRezervation")){
            int id = Integer.parseInt(request.getParameter("id"));
            int uyeId = Integer.parseInt(request.getParameter("uyeId"));
            int ucusId = Integer.parseInt(request.getParameter("ucusId"));
            String kartNo = request.getParameter("kartNo");
            int cvv = Integer.parseInt(request.getParameter("cvv"));
            
            if(cdb.Check(kartNo, cvv, uyeId)){
                tdb.payRezervation(id);
                User user = new UserDB().GetUser(uyeId);
                Flight flight = new FlightDB().GetFlight(ucusId);
                String PAY_REZERVATION_TICKET_MAİL = "<h2 style=\"color: navy\">Rezervasyon yapmış olduğunuz; "+flight.getKalkis()+"-"+flight.getVaris()+" arası, "+flight.getTarih()+" tarihli ve "+flight.getSaat()+" saatli uçuşunuzun ödemesi tamamlanmıştır. Rezervasyon yaptığınızda gelen maildeki bilgiler aynı şekilde geçerlidir, farklı olarak satın alma işlemi yapmış oldunuz. ATM Airlines olarak, bizi tercih ettiğiniz için teşekkür eder, iyi yolculuklar dileriz.</h2>";
                dbp.sendMail(user.getEmail(), PAY_REZERVATION_TICKET_MAİL);
                response.sendRedirect(request.getContextPath()+"/jsp/buyTicketSuccess.jsp");
            }else
                response.sendRedirect(request.getContextPath()+"/jsp/buyTicketErr.jsp");            
        }else{
            response.sendRedirect(request.getContextPath()+"/jsp/errorPage.jsp");
        }
    }
}