<%-- 
    Document   : header
    Created on : 10.Kas.2021, 12:03:26
    Author     : ahmet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
    Cookie cookies[] = request.getCookies();
    for (int i = 0; i < cookies.length; i++) {
        if (cookies[i].getName().equals("userName")) {
            String kullsnici_ad = cookies[i].getValue();
            request.setAttribute("kullsnici_ad", kullsnici_ad);
            break;
        }
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
    <link href="../styles/header.css" rel="stylesheet" type="text/css"/>
    <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
</head>
<body>
<div id="header">
<div id="dropdown-area" class="btn-group">
    <c:choose>
        <c:when test="${kullsnici_ad!=null}">
            <button id="drp-btn" type="button" class="btn btn-outline-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                ${kullsnici_ad}
            </button>
            <div id="drp-menu" class="dropdown-menu">
                <a class="dropdown-item" href="${pageContext.request.contextPath}/jsp/index.jsp"><span style="margin-left: -7%;margin-right: 2%" class="fas fa-door-open"></span>Kullanıcı Sayfası</a>
                <div style="border-top: 2px solid navy" class="dropdown-divider"></div>
                <a class="dropdown-item" href="../user?selector=logout"><span style="margin-left: -7%;margin-right: 2%" class="fas fa-sign-out-alt"></span>Çıkış Yap</a>
            </div>
        </c:when>
    </c:choose>
</div>
</div>
</body>
</html>
