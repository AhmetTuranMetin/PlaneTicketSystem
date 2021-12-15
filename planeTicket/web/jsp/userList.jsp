<%-- 
    Document   : userList
    Created on : 16.Kas.2021, 23:03:48
    Author     : ahmet
--%>

<%@page import="java.util.List"%>
<%@page import="Entities.User"%>
<%@page import="DataBases.UserDB"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-9"%>
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
    
    List<User> userList = new UserDB().AllList();
    request.setAttribute("userList", userList);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="../images/logo.ico"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <jsp:include page="menu.jsp"/>
        <jsp:include page="header.jsp"/>
        <jsp:include page="footer.jsp"/>
        <link href="../styles/general.css" rel="stylesheet" type="text/css"/>
        <script src="../js/login.js" type="text/javascript"></script>
    <title>Kullan�c� Listesi</title>
</head>
<body>
    <div id="content">
        <c:choose>
            <c:when test="${empty userList}">
                <button id="flight_btn" style="margin-left: 200%;margin-top: 70%" type="button" class="btn btn-outline-warning" data-toggle="modal" data-target="#addUserModal">Yeni Kullan�c� Ekle</button>
                <h2 style='position:absolute;left:48%;color:goldenrod;top:37%;font-size:330%'>Kullan�c� Yok</h2>
            </c:when>
            <c:otherwise>
                <button id="flight_btn" style="margin-left: 114%;margin-top: 6%" type="button" class="btn btn-outline-warning" data-toggle="modal" data-target="#addUserModal">Yeni Kullan�c� Ekle</button>
                <table id="bs-table" class="table table-striped table-dark">
                    <thead>
                        <tr class="bg-primary">
                        <th scope="col">#ID</th>
                        <th scope="col">ROL</th>
                        <th scope="col">TC K�ML�K NO</th>
                        <th scope="col">KULLANICI ADI</th>
                        <th scope="col">C�NS�YET</th>
                        <th scope="col">YA�</th>
                        <th scope="col">DO�UM TAR�H�</th>
                        <th scope="col">EMA�L</th>
                        <th scope="col">��FRE</th>
                        <th scope="col">��LEMLER</th>
                      </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${userList}" var="list">
                            <tr>
                        <th scope="row">${list.id}</th>
                        <td>${list.rol}</td>
                        <td>${list.tc}</td>
                        <td>${list.ad}</td>
                        <td>${list.cinsiyet}</td>
                        <td>${list.yas}</td>
                        <td>${list.DTarih}</td>
                        <td>${list.email}</td>
                        <td>${list.sifre}</td>
                        <td><a href="${pageContext.request.contextPath}/user?id=${list.id}&selector=delete"><button type="button" class="btn btn-outline-danger">Sil</button></a><a href="userUpdate.jsp?id=${list.id}"><button style="margin-left: 12%" type="button" class="btn btn-outline-success">G�ncelle</button></a></td>
                      </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:otherwise>
        </c:choose>
</div>
    
<!--Add User Modal -->
<div class="modal fade" id="addUserModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 id="m-title" class="modal-title" id="exampleModalLongTitle">Kullan�c� Ekle</h5>
        <button id="close-modal" type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
        <form action="${pageContext.request.contextPath}/user" method="POST">
            <div class="modal-body">
                <div class="row mb-4">
                    <div class="col">
                      <div class="form-outline">
                        <div id="alert"></div>
                        <input type="hidden" name="selector" value="add"></input>
                        <input type="hidden" name="redirect" value="admin"></input>
                        <label id="f-label" class="form-label" for="rol">Rol<i class="text-danger">*</i></label>
                         <select style="color: navy" id="f-control" name="rol" class="form-control" required oninvalid="this.setCustomValidity('L�tfen rol� giriniz !!')" oninput="this.setCustomValidity('')">
                            <option id="f-option" class="form-control"></option>
                            <option id="f-option" class="form-control">Admin</option>
                            <option id="f-option" class="form-control">�ye</option>
                        </select>
                        <label id="f-label" class="form-label" for="tc">TC Kimlik Numaras�<i class="text-danger">*</i></label>
                        <input id="f-control" type="text" id="tc" name="tc" pattern='\d{11}' class="form-control" required oninvalid="this.setCustomValidity('L�tfen 11 haneli TC kimlik numaran�z� giriniz !!')" oninput="this.setCustomValidity('')"/>
                        <label id="f-label" class="form-label" for="ad">Ad-Soyad<i class="text-danger">*</i></label>
                        <input id="f-control" type="text" id="ad" name="ad" class="form-control" required oninvalid="this.setCustomValidity('L�tfen kullan�c� ad�n�z� giriniz !!')" oninput="this.setCustomValidity('')"/>
                        <label id="f-label" class="form-label" for="cinsiyet">Cinsiyet<i class="text-danger">*</i></label>
                        <select style="color: navy" id="f-control" name="cinsiyet" class="form-control" required oninvalid="this.setCustomValidity('L�tfen cinsiyetinizi giriniz !!')" oninput="this.setCustomValidity('')">
                            <option id="f-option" class="form-control"></option>
                            <option id="f-option" class="form-control">Erkek</option>
                            <option id="f-option" class="form-control">Kad�n</option>
                        </select>
                        <label id="f-label" class="form-label" for="yas">Ya�<i class="text-danger">*</i></label>
                        <input id="f-control" type="number" min="18" id="yas" name="yas" class="form-control" required oninvalid="this.setCustomValidity('Bo� de�er kabul edilmez ve 18 ya��ndan k���kler �ye olamaz !!')" oninput="this.setCustomValidity('')"/>
                        <label id="f-label" class="form-label" for="d_tarih">Do�um Tarihi<i class="text-danger">*</i></label>
                        <input id="f-control" type="date" id="d-tarih" name="d_tarih" class="form-control" required oninvalid="this.setCustomValidity('L�tfen do�um tarihinizi giriniz !!')" oninput="this.setCustomValidity('')"/>
                        <label id="f-label" class="form-label" for="email">Email<i class="text-danger">*</i></label>
                        <input id="f-control" type="email" id="email" name="email" class="form-control" required oninvalid="this.setCustomValidity('L�tfen email adresinizi email format�na uyacak �ekilde giriniz !!')" oninput="this.setCustomValidity('')"/>
                        <label id="f-label" class="form-label" for="sifre">�ifre<i class="text-danger">*</i></label> <input id="checkbox" style="margin-left: 63%;margin-top: 2%" type="checkbox"><i style="margin-left: 2px;color: goldenrod">�ifreyi G�ster</i></input>
                        <input style="color: navy" type="password" id="sifre" name="sifre" class="form-control" required oninvalid="this.setCustomValidity('L�tfen �ifrenizi giriniz !!')" oninput="this.setCustomValidity('')"/>
                      </div> 
                </div>
            </div>
            <div class="modal-footer">
                <button style="color: navy" type="button" class="btn btn-info" data-dismiss="modal">Kapat</button>
                <button style="color: navy" id="flight_add_btn" type="submit" class="btn btn-warning" onclick="return validation();">Ekle</button>
            </div>
          </div>
      </form>  
  </div>
</div>
</div>
<!--end modal-->
</body>
</html>
