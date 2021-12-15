<%-- 
    Document   : userMenu
    Created on : 13.Kas.2021, 18:43:24
    Author     : ahmet
--%>

<%@page import="DataBases.CardDB"%>
<%@page import="DataBases.TicketDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
    String kullanici_id = null;
    Cookie cookies[] = request.getCookies();
    for (int i = 0; i < cookies.length; i++) {
        if (cookies[i].getName().equals("userName")) {
            String kullanici_ad = cookies[i].getValue();
            request.setAttribute("kullanici_ad", kullanici_ad);
            break;
        }
    }
    
    for (int i = 0; i < cookies.length; i++) {
        if (cookies[i].getName().equals("userId")) {
            kullanici_id = cookies[i].getValue();
            request.setAttribute("kullanici_id", kullanici_id);
            break;
        }
    }
    if(kullanici_id != null){
        int ticketSize = new TicketDB().GetUserTicket(Integer.parseInt(kullanici_id)).size();
        request.setAttribute("ticketSize", ticketSize);
        
        int cardSize = new CardDB().GetCard(Integer.parseInt(kullanici_id)).size();
        request.setAttribute("cardSize", cardSize);
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <link href="../styles/userMenu.css" rel="stylesheet" type="text/css"/>
        <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
</head>
<body>
<div class="menu-area">
    <a href="index.jsp" id="logo"><img style="position: absolute;top: -5px" src="../images/logo.ico" width="118px" height="118px"></img></a>
    <ul class="main-menu">
        <li id="first-item"><a href="index.jsp"><span style="margin-left: -5%;margin-right: 2%" class="fas fa-door-open"></span>Anasayfa</a></li>
        <li><a href="flightSearch.jsp"><span style="margin-left: -2%;margin-right: 2%" class="fas fa-plane"></span>Uçuşlara Göz At</a></li>
        <li><a href="flightSearch.jsp"><span style="margin-left: -2%;margin-right: 2%" class="fas fa-ticket-alt"></span>Bilet Satın Al</a></li>
        <li><a href="about.jsp"><span style="margin-left: -2%;margin-right: 2%" class="fas fa-info"></span>Hakkımızda</a></li>
    </ul>
    
    <div id="dropdown-area" class="btn-group">
        <c:choose>
            <c:when test="${kullanici_ad==null}">
                <button id="drp-btn" type="button" class="btn btn-outline-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Hesap İşlemleri
                </button>
                <div id="drp-menu" class="dropdown-menu">
                    <a class="dropdown-item" href="login.jsp"><span style="margin-left: -2%;margin-right: 2%" class="fas fa-sign-in-alt"></span>Giriş Yap</a>
                    <a class="dropdown-item" href="createAccount.jsp"><span style="margin-left: -2%;margin-right: 2%" class="fas fa-user-plus"></span>Üye Ol</a>
                </div>
            </c:when>
            <c:otherwise>
                <button id="drp-btn" type="button" class="btn btn-outline-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    ${kullanici_ad}
                </button>
                <div id="drp-menu" class="dropdown-menu">
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/jsp/userTicketList.jsp?uyeId=${kullanici_id}&name=${kullanici_ad}"><span style="margin-left: -2%;margin-right: 2%" class="fa fa-ticket"></span>Biletlerim <i style="color: red">${ticketSize}</i></a>
                    <div style="border-top: 2px solid navy" class="dropdown-divider"></div>
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/jsp/addCard.jsp"><span style="margin-left: -2%;margin-right: 2%" class="fas fa-credit-card"></span>Kart Ekle</a>
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/jsp/cardList.jsp?uyeId=${kullanici_id}&name=${kullanici_ad}"><span style="margin-left: -2%;margin-right: 2%" class="fas fa-id-card"></span>Kartlarım <i style="color: red">${cardSize}</i></a>
                    <div style="border-top: 2px solid navy" class="dropdown-divider"></div>
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/jsp/adminIndex.jsp"><span style="margin-left: -2%;margin-right: 2%" class="fas fa-home"></span>Admin Sayfası</a>
                    <div style="border-top: 2px solid navy" class="dropdown-divider"></div>
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/user?selector=logout"><span style="margin-left: -2%;margin-right: 2%" class="fas fa-sign-out-alt"></span>Çıkış Yap</a>
                </div>
            </c:otherwise>
        </c:choose>
</div>
</div>
</body>
</html>
