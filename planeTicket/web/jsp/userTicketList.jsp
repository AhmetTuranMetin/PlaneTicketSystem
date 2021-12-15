<%-- 
    Document   : userTicketList
    Created on : 25.Kas.2021, 17:33:37
    Author     : ahmet
--%>

<%@page import="DataBases.FlightDB"%>
<%@page import="Entities.Flight"%>
<%@page import="DataBases.TicketDB"%>
<%@page import="Entities.Ticket"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
    String remember=null;
    Cookie cookies[] = request.getCookies();
    for (int i = 0; i < cookies.length; i++) {
        if (cookies[i].getName().equals("remember")) {
            remember = cookies[i].getValue();
            break;
        }
    }
    //if not login redirect to index.jsp
    check:
    if(session.getAttribute("login")!="OK"){
        if(remember!=null)
            break check;
        response.sendRedirect("login.jsp");
    }
    
    int uyeId = Integer.parseInt(request.getParameter("uyeId"));
    String name = request.getParameter("name").trim();
    
    List<Ticket> ticketList = new TicketDB().GetUserTicket(uyeId);
    request.setAttribute("ticketList", ticketList);
    
    for (int i = 0; i < cookies.length; i++) {
        if (cookies[i].getName().equals("userId")) {
            String kullanici_id = cookies[i].getValue();
            break;
        }
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="../images/b_image.jpg"/>
        <link href="../styles/index.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
        <jsp:include page="userMenu.jsp"/>
        <jsp:include page="footer.jsp"/>
        <link href="../styles/userfooter.css" rel="stylesheet" type="text/css"/>
        <link href="../styles/search.css" rel="stylesheet" type="text/css"/>
        <script src="../js/userTicketList.js" type="text/javascript"></script>
        
        <!--set swal size-->
        <style>
            .swal2-popup {
                font-size: 180%
            }
        </style>
    <title>Biletlerim</title>
</head>
<body>
    <div id="content">
        <c:choose>
            <c:when test="${empty ticketList}">
                <h2 style='position:absolute;left:43%;color:navy;top:30%;font-size:330%'>Bilet Bulunamadı</h2>
            </c:when>
            <c:otherwise>
                <table style="width: 95%;left: 2%" id="bs-table" class="table table-striped table-dark">
                    <thead>
                        <tr class="table-primary">
                        <th scope="col">BİLET SAHİBİ</th>
                        <th scope="col">KOLTUK NUMARASI</th>
                        <th scope="col">BİLET TİPİ</th>
                        <th scope="col">PAKET</th>
                        <th scope="col">KALKIŞ ŞEHRİ</th>
                        <th scope="col">VARIŞ ŞEHRİ</th>
                        <th scope="col">TARİH</th>
                        <th scope="col">SAAT</th>
                        <th scope="col">KALKIŞ HAVAALANI</th>
                        <th scope="col">VARIŞ HAVAALANI</th>
                        <th scope="col">FİRMA</th>
                        <th scope="col">ÖDENEN FİYAT</th>
                        <th scope="col">İPTAL</th>
                      </tr>
                    </thead>
                    <tbody>
                        <%
                            double ADVANTAGE_PACKAGE_PRİCE = 30.;
                            for (int i = 0; i < ticketList.size(); i++) {
                                Flight flight = new FlightDB().GetFlight(ticketList.get(i).getUcusId());
                                out.println("<tr class='bg-info'>");
                                out.println("<td>"+name+"</td>");
                                out.println("<td>"+ticketList.get(i).getKoltukNo()+"</td>");
                                out.println("<td>"+ticketList.get(i).getTip()+"</td>");
                                out.println("<td>"+ticketList.get(i).getPaket()+"</td>");
                                out.println("<td>"+flight.getKalkis()+"</td>");
                                out.println("<td>"+flight.getVaris()+"</td>");
                                out.println("<td>"+flight.getTarih()+"</td>");
                                out.println("<td>"+flight.getSaat()+"</td>");
                                out.println("<td>"+flight.getKalkisHavaalani()+"</td>");
                                out.println("<td>"+flight.getVarisHavaalani()+"</td>");
                                out.println("<td>"+flight.getFirma()+"</td>");
                                if(!ticketList.get(i).getPaket().equals("Standart")){
                                    double fiyat = flight.getFiyat();
                                    fiyat += ADVANTAGE_PACKAGE_PRİCE;
                                    out.println("<td>"+fiyat+"</td>");
                                }else
                                    out.println("<td>"+flight.getFiyat()+"</td>");
                                //rezervation pay process query
                                if(ticketList.get(i).getTip().equals("Rezervasyon")){
                                    out.println("<td><a href='cardPage.jsp?uyeId="+uyeId+"&selector=payRezervation&id="+ticketList.get(i).getId()+"&ucusId="+flight.getId()+"'><button style='position:absolute;margin-left:-75px' type='submit' class='btn btn-warning'>Satın Al</button></a><button type='submit' class='btn btn-danger' onclick='cancel("+ticketList.get(i).getId()+","+uyeId+","+ticketList.get(i).getUcusId()+")'>İptal Et</button></td>");
                                }else
                                    out.println("<td><button type='submit' class='btn btn-danger' onclick='cancel("+ticketList.get(i).getId()+","+uyeId+","+ticketList.get(i).getUcusId()+")'>İptal Et</button></td>");
                                out.println("</tr>");
                           }
                        %>
                    </tbody>
                </table>
            </c:otherwise>
        </c:choose>
</div>
</body>
</html>
