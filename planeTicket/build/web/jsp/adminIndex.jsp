<%-- 
    Document   : adminIndex
    Created on : 04.Ara.2021, 15:34:17
    Author     : ahmet
--%>

<%@page import="DataBases.UserDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
    
    for (int i = 0; i < cookies.length; i++) {
        if (cookies[i].getName().equals("userName")) {
            String kullanici_ad = cookies[i].getValue();
            request.setAttribute("kullanici_ad", kullanici_ad);
            break;
        }
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
    <title>Anasayfa</title>
</head>
<body>
    <img style="margin-left: 41%;margin-top: 3%" src="../images/logo.ico" width="500px" height="500px"></img>
    <div style="text-align: center;position: relative;margin: auto;margin-left: -25%;margin-top: 25%"><h2 style="color: goldenrod;font-size: 290%">Sayın ${kullanici_ad}</h2></div><br>
    <h2 style="position: absolute;left: 46%;top: 58%;color: goldenrod;font-size: 290%">HOŞ GELDİNİZ</h2><br>
</body>
</html>
