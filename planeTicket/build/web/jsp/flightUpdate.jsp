<%-- 
    Document   : flightUpdate
    Created on : 12.Kas.2021, 16:13:48
    Author     : ahmet
--%>

<%@page import="DataBases.UserDB"%>
<%@page contentType="text/html;charset=ISO-8859-9" pageEncoding="ISO-8859-9" %>
<%@page import="Entities.Company"%>
<%@page import="DataBases.CompanyDB"%>
<%@page import="java.util.List"%>
<%@page import="DataBases.FlightDB"%>
<%@page import="Entities.Flight"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!--get update information-->
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
    Flight flight = new FlightDB().GetFlight(id);
    request.setAttribute("flight", flight);
%>

<%
    List<Company> companyList = new CompanyDB().AllList();
    request.setAttribute("companyList", companyList);
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-9" />
        <link rel="icon" href="../images/logo.ico"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <jsp:include page="menu.jsp"/>
        <jsp:include page="header.jsp"/>
        <script src="../js/flight.js" type="text/javascript"></script>
        <link href="../styles/general.css" rel="stylesheet" type="text/css"/>
    <title>Uçuþ Güncelle</title>
</head>
<body>
<div id="update-body">
    <form action="${pageContext.request.contextPath}/flight" method="POST">
            <div class="modal-body">
                <div class="modal-header">
                    <h5 style="color: navy" class="modal-title" id="exampleModalLongTitle">Uçuþ Güncelle</h5>
                </div>
                <div class="row mb-4">
                    <div class="col">
                      <div class="form-outline">
                        <div id="alert"></div>
                        <input type="hidden" name="selector" value="update"></input>
                        <input type="hidden" name="id" value="${flight.id}"></input>
                        <label style="color: navy" class="form-label" for="kalkis">Kalkýþ Yeri<i class="text-danger">*</i></label>
                        <input style="color: navy" type="text" id="kalkis" name="kalkis" class="form-control" value="${flight.kalkis}" required oninvalid="this.setCustomValidity('Lütfen kalkýþ yeri giriniz !!')" oninput="this.setCustomValidity('')"/>
                        <label style="color: navy" class="form-label" for="varis">Varýþ Yeri<i class="text-danger">*</i></label>
                        <input style="color: navy" type="text" id="varis" name="varis" class="form-control" value="${flight.varis}" required oninvalid="this.setCustomValidity('Lütfen varýþ yeri giriniz !!')" oninput="this.setCustomValidity('')"/>
                        <label style="color: navy" class="form-label" for="tarih">Tarih<i class="text-danger">*</i></label>
                        <input style="color: navy" type="date" id="tarih" name="tarih" class="form-control" value="${flight.tarih}" required oninvalid="this.setCustomValidity('Lütfen tarih giriniz !!')" oninput="this.setCustomValidity('')"/>
                        <label style="color: navy" class="form-label" for="saat">Saat<i class="text-danger">*</i></label>
                        <input style="color: navy" type="time" id="saat" name="saat" class="form-control" value="${flight.saat}" required oninvalid="this.setCustomValidity('Lütfen saat giriniz !!')" oninput="this.setCustomValidity('')"/>
                        <label style="color: navy" class="form-label" for="kalkisHavaalani">Kalkýþ Havaalaný<i class="text-danger">*</i></label>
                        <input style="color: navy" type="text" id="kalkisHavaalani" name="kalkisHavaalani" class="form-control" value="${flight.kalkisHavaalani}" required oninvalid="this.setCustomValidity('Lütfen kalkýþ havaalaný giriniz !!')" oninput="this.setCustomValidity('')"/>
                        <label style="color: navy" class="form-label" for="varisHavaalani">Varýþ Havaalaný<i class="text-danger">*</i></label>
                        <input style="color: navy" type="text" id="varisHavaalani" name="varisHavaalani" class="form-control" value="${flight.varisHavaalani}" required oninvalid="this.setCustomValidity('Lütfen varýþ havaalaný giriniz !!')" oninput="this.setCustomValidity('')"/>
                        <label style="color: navy" class="form-label" for="fiyat">Fiyat<i class="text-danger">*</i></label>
                        <input style="color: navy" type="text" id="fiyat" pattern='\d.*' name="fiyat" class="form-control" value="${flight.fiyat}" required oninvalid="this.setCustomValidity('Lütfen fiyat giriniz !!')" oninput="this.setCustomValidity('')"/>
                        <label style="color: navy" class="form-label" for="firma">Firma<i class="text-danger">*</i></label>
                        <select style="color: navy" id="f-control" id="firma" name="firma" class="form-control" required oninvalid="this.setCustomValidity('Lütfen firma giriniz !!')" oninput="this.setCustomValidity('')">
                            <option id="f-option" class="form-control">${flight.firma}</option>
                            <c:forEach items="${companyList}" var="list">
                                <option id="f-option" class="form-control">${list.isim}</option>
                            </c:forEach>
                        </select>
                      </div> 
                </div>
            </div>
            <div class="modal-footer">
                <button style="color: navy" id="flight_add_btn" type="submit" class="btn btn-success" onclick="return validation();">Güncelle</button>
            </div>
          </div>
      </form>  
</div>
</body>
</html>
