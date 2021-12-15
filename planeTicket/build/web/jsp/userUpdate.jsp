<%-- 
    Document   : userUpdate
    Created on : 17.Kas.2021, 10:17:55
    Author     : ahmet
--%>

<%@page import="DataBases.UserDB"%>
<%@page import="Entities.User"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-9"%>

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
    
    int id = Integer.parseInt(request.getParameter("id")); 
    User user = new UserDB().GetUser(id);
    request.setAttribute("user", user);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="../images/logo.ico"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <jsp:include page="menu.jsp"/>
        <jsp:include page="header.jsp"/>
        <link href="../styles/general.css" rel="stylesheet" type="text/css"/>
        <script src="../js/login.js" type="text/javascript"></script>
    <title>Kullan�c� G�ncelle</title>
</head>
<body>
    <div id="update-body">
        <form id="form" action="${pageContext.request.contextPath}/user" method="POST">
            <div class="modal-body">
                <div class="modal-header">
                    <h5 style="color: navy" class="modal-title" id="exampleModalLongTitle">U�u� G�ncelle</h5>
                </div>
                <div class="row mb-4">
                    <div class="col">
                      <div class="form-outline">
                          <div id="alert"></div>
                        <input type="hidden" name="selector" value="update"></input>
                        <input type="hidden" name="id" value="${user.id}"></input>
                        <label style="color: navy" id="f-label" class="form-label" for="rol">Rol<i class="text-danger">*</i></label>
                         <select style="color: navy" id="f-control" name="rol" class="form-control" required oninvalid="this.setCustomValidity('L�tfen rol� giriniz !!')" oninput="this.setCustomValidity('')">
                            <option id="f-option" class="form-control">${user.rol}</option>
                            <option id="f-option" class="form-control">Admin</option>
                            <option id="f-option" class="form-control">�ye</option>
                        </select>
                        <label style="color: navy" id="f-label" class="form-label" for="tc">TC Kimlik Numaras�<i class="text-danger">*</i></label>
                        <input style="color: navy" id="f-control" type="text" pattern='\d{11}' id="tc" name="tc" class="form-control" required oninvalid="this.setCustomValidity('L�tfen 11 haneli TC kimlik numaran�z� giriniz !!')" oninput="this.setCustomValidity('')" value="${user.tc}"/>
                        <label style="color: navy" id="f-label" class="form-label" for="ad">Ad-Soyad<i class="text-danger">*</i></label>
                        <input style="color: navy" id="f-control" type="text" id="ad" name="ad" class="form-control" required oninvalid="this.setCustomValidity('L�tfen kullan�c� ad�n�z� giriniz !!')" oninput="this.setCustomValidity('')" value="${user.ad}"/>
                        <label style="color: navy" id="f-label" class="form-label" for="cinsiyet">Cinsiyet<i class="text-danger">*</i></label>
                        <select style="color: navy" id="f-control" name="cinsiyet" class="form-control" required oninvalid="this.setCustomValidity('L�tfen cinsiyetinizi giriniz !!')" oninput="this.setCustomValidity('')">
                            <option id="f-option" class="form-control">${user.cinsiyet}</option>
                            <option id="f-option" class="form-control">Erkek</option>
                            <option id="f-option" class="form-control">Kad�n</option>
                        </select>
                        <label style="color: navy" id="f-label" class="form-label" for="yas">Ya�<i class="text-danger">*</i></label>
                        <input style="color: navy" id="f-control" min="18" type="number" id="yas" name="yas" class="form-control" required oninvalid="this.setCustomValidity('Bo� de�er kabul edilmez ve 18 ya��ndan k���kler �ye olamaz !!')" oninput="this.setCustomValidity('')" value="${user.yas}"/>
                        <label style="color: navy" id="f-label" class="form-label" for="d_tarih">Do�um Tarihi<i class="text-danger">*</i></label>
                        <input style="color: navy" id="f-control" type="date" id="d-tarih" name="d_tarih" class="form-control" required oninvalid="this.setCustomValidity('L�tfen do�um tarihinizi giriniz !!')" oninput="this.setCustomValidity('')" value="${user.DTarih}"/>
                        <label style="color: navy" id="f-label" class="form-label" for="email">Email<i class="text-danger">*</i></label>
                        <input style="color: navy" id="f-control" type="email" id="email" name="email" class="form-control" required oninvalid="this.setCustomValidity('L�tfen email adresinizi email format�na uyacak �ekilde giriniz !!')" oninput="this.setCustomValidity('')" value="${user.email}"/>
                        <label style="color: navy" id="f-label" class="form-label" for="sifre">�ifre<i class="text-danger">*</i></label> <input id="checkbox" type="checkbox"><i style="margin-left: 2px;color: navy">�ifreyi G�ster</i></input>
                        <input style="color: navy" type="password" id="sifre" name="sifre" class="form-control" required oninvalid="this.setCustomValidity('L�tfen �ifrenizi giriniz !!')" oninput="this.setCustomValidity('')" value="${user.sifre}"/>
                      </div> 
                </div>
            </div>
            <div class="modal-footer">
                <button style="color: navy" id="flight_add_btn" type="submit" class="btn btn-success" onclick="return validation();">G�ncelle</button>
            </div>
          </div>
      </form>  
</div>
</body>
</html>
