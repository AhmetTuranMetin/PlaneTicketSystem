<%-- 
    Document   : tcFlightSearch
    Created on : 04.Ara.2021, 12:29:04
    Author     : ahmet
--%>

<%@page import="DataBases.TicketDB"%>
<%@page import="Entities.Ticket"%>
<%@page import="java.util.List"%>
<%@page import="DataBases.UserDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
    //get user id
    String kullanici_id=null;
    Cookie cookies[] = request.getCookies();
    for (int i = 0; i < cookies.length; i++) {
        if (cookies[i].getName().equals("userId")) {
            kullanici_id = cookies[i].getValue();
            break;
        }
    }
    
    String remember=null;
    for (int i = 0; i < cookies.length; i++) {
        if (cookies[i].getName().equals("remember")) {
            remember = cookies[i].getValue();
            break;
        }
    }
    
    //get user role
    String role = new UserDB().GetUser(Integer.parseInt(kullanici_id)).getRol();
    
    //if not login redirect to index.jsp
    check:
    if(session.getAttribute("login")!="OK" || !role.equals("Admin")){
        if(remember != null && !remember.equals("OK"))
            break check;
        response.sendRedirect("login.jsp");
    }
    
    String tc = request.getParameter("tc").trim();
    if(new UserDB().TcValidation(tc)!=0){
        int id = new UserDB().GetTcUserId(tc);
        List<Ticket> tcWithTickets = new TicketDB().GetUserTicket(id);
        request.setAttribute("tickets", tcWithTickets);
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="../images/logo.ico"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="../js/flight.js" type="text/javascript"></script>
        <jsp:include page="menu.jsp"/>
        <jsp:include page="header.jsp"/>
        <jsp:include page="footer.jsp"/>
        <link href="../styles/general.css" rel="stylesheet" type="text/css"/>
    <title>Bilet Ara</title>
</head>
<body>
<div id="content">
    <c:choose>
            <c:when test="${empty tickets}">
                <h2 style='position:absolute;left:41%;color:goldenrod;top:37%;font-size:330%'>Satın Alınan Bilet Bulunamadı</h2>
            </c:when>
            <c:otherwise>
                <table style="margin-top: 7%" id="bs-table" class="table table-striped table-dark">
                                <thead>
                                    <tr class="bg-primary">
                                    <th scope="col">#ID</th>
                                    <th scope="col">UÇUŞ ID</th>
                                    <th scope="col">ÜYE ID</th>
                                    <th scope="col">KOLTUK NUMARASI</th>
                                    <th scope="col">BİLET TİPİ</th>
                                    <th scope="col">BİLET PAKETİ</th>
                                    <th scope="col">İŞLEMLER</th>
                                  </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${tickets}" var="list">
                                        <tr>
                                    <th scope="row">${list.id}</th>
                                    <td>${list.ucusId}</td>
                                    <td>${list.uyeId}</td>
                                    <td>${list.koltukNo}</td>
                                    <td>${list.tip}</td>
                                    <td>${list.paket}</td>
                                    <td><a href="${pageContext.request.contextPath}/ticket?id=${list.id}&selector=delete&ucusId=${list.ucusId}&redirect=admin&uyeId=${list.uyeId}"><button type="button" class="btn btn-outline-danger">Sil</button></a><a href="ticketUpdate.jsp?id=${list.id}"><button style="margin-left: 12%" type="button" class="btn btn-outline-success">Güncelle</button></a></td>
                                  </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
            </c:otherwise>
    </c:choose>
</div>
</body>
</html>
