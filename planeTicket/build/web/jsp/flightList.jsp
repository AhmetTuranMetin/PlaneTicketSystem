<%-- 
    Document   : flightList
    Created on : 07.Kas.2021, 23:03:26
    Author     : ahmet
--%>

<%@page import="DataBases.UserDB"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-9"%>
<%@page import="Entities.Company"%>
<%@page import="DataBases.CompanyDB"%>
<%@page import="java.util.List"%>
<%@page import="Entities.Flight"%>
<%@page import="DataBases.FlightDB"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!--get all flight list-->
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
    
    List<Flight> flightList = new FlightDB().AllList();
    request.setAttribute("flightList", flightList);
%>

<!--get all company list-->
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
        <script src="../js/flight.js" type="text/javascript"></script>
        <jsp:include page="menu.jsp"/>
        <jsp:include page="header.jsp"/>
        <jsp:include page="footer.jsp"/>
        <link href="../styles/general.css" rel="stylesheet" type="text/css"/>
        <title>Uçuþ Listesi</title>
</head>
<body>
<div id="content">
    <c:choose>
            <c:when test="${empty flightList}">
                <button id="flight_btn" style="margin-left: 200%;margin-top: 70%" type="button" class="btn btn-outline-warning" data-toggle="modal" data-target="#addFlightModal">Yeni Uçuþ Ekle</button>
                <h2 style='position:absolute;left:48%;color:goldenrod;top:37%;font-size:330%'>Uçuþ Yok</h2>
            </c:when>
            <c:otherwise>
                <button id="flight_btn" style="margin-left: 114%;margin-top: 6%" type="button" class="btn btn-outline-warning" data-toggle="modal" data-target="#addFlightModal">Yeni Uçuþ Ekle</button>
                <table id="bs-table" class="table table-striped table-dark">
                    <thead>
                        <tr class="bg-primary">
                        <th scope="col">#ID</th>
                        <th scope="col">KALKIÞ</th>
                        <th scope="col">VARIÞ</th>
                        <th scope="col">TARÝH</th>
                        <th scope="col">SAAT</th>
                        <th scope="col">KALKIÞ HAVAALANI</th>
                        <th scope="col">VARIÞ HAVAALANI</th>
                        <th scope="col">FÝYAT</th>
                        <th scope="col">FÝRMA</th>
                        <th scope="col">ÝÞLEMLER</th>
                      </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${flightList}" var="list">
                            <tr>
                        <th scope="row">${list.id}</th>
                        <td>${list.kalkis}</td>
                        <td>${list.varis}</td>
                        <td>${list.tarih}</td>
                        <td>${list.saat}</td>
                        <td>${list.kalkisHavaalani}</td>
                        <td>${list.varisHavaalani}</td>
                        <td>${list.fiyat}</td>
                        <td>${list.firma}</td>
                        <td><a href="${pageContext.request.contextPath}/flight?id=${list.id}&selector=delete"><button type="button" class="btn btn-outline-danger">Sil</button></a><a href="flightUpdate.jsp?id=${list.id}"><button style="margin-left: 12%" type="button" class="btn btn-outline-success">Güncelle</button></a></td>
                      </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:otherwise>
    </c:choose>
</div>
    
<!--Add Flight Modal -->
<div class="modal fade" id="addFlightModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 id="m-title" class="modal-title" id="exampleModalLongTitle">Uçuþ Ekle</h5>
        <button id="close-modal" type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
        <form action="${pageContext.request.contextPath}/flight" method="POST">
            <div class="modal-body">
                <div class="row mb-4">
                    <div class="col">
                      <div class="form-outline">
                        <div id="alert"></div>
                        <input type="hidden" name="selector" value="add"></input>
                        <label id="f-label" class="form-label" for="kalkis">Kalkýþ Yeri<i class="text-danger">*</i></label>
                        <input id="f-control" type="text" id="kalkis" name="kalkis" class="form-control" required oninvalid="this.setCustomValidity('Lütfen kalkýþ yeri giriniz !!')" oninput="this.setCustomValidity('')"/>
                        <label id="f-label" class="form-label" for="varis">Varýþ Yeri<i class="text-danger">*</i></label>
                        <input id="f-control" type="text" id="varis" name="varis" class="form-control" required oninvalid="this.setCustomValidity('Lütfen varýþ yeri giriniz !!')" oninput="this.setCustomValidity('')"/>
                        <label id="f-label" class="form-label" for="tarih">Tarih<i class="text-danger">*</i></label>
                        <input id="f-control" type="date" id="tarih" name="tarih" class="form-control" required oninvalid="this.setCustomValidity('Lütfen tarih giriniz !!')" oninput="this.setCustomValidity('')"/>
                        <label id="f-label" class="form-label" for="saat">Saat<i class="text-danger">*</i></label>
                        <input id="f-control" type="time" id="saat" name="saat" class="form-control" required oninvalid="this.setCustomValidity('Lütfen saat giriniz !!')" oninput="this.setCustomValidity('')"/>
                        <label id="f-label" class="form-label" for="kalkisHavaalani">Kalkýþ Havaalaný<i class="text-danger">*</i></label>
                        <input id="f-control" type="text" id="kalkisHavaalani" name="kalkisHavaalani" class="form-control" required oninvalid="this.setCustomValidity('Lütfen kalkýþ havaalaný giriniz !!')" oninput="this.setCustomValidity('')"/>
                        <label id="f-label" class="form-label" for="varisHavaalani">Varýþ Havaalaný<i class="text-danger">*</i></label>
                        <input id="f-control" type="text" id="varisHavaalani" name="varisHavaalani" class="form-control" required oninvalid="this.setCustomValidity('Lütfen varýþ havaalaný giriniz !!')" oninput="this.setCustomValidity('')"/>
                        <label id="f-label" class="form-label" for="fiyat">Fiyat<i class="text-danger">*</i></label>
                        <input id="f-control" type="text" id="fiyat" pattern='\d.*' name="fiyat" class="form-control" placeholder="Örn. 118.50" required oninvalid="this.setCustomValidity('Lütfen fiyat giriniz !!')" oninput="this.setCustomValidity('')"/>
                        <label id="f-label" class="form-label" for="firma">Firma<i class="text-danger">*</i></label>
                        <select style="color: navy" id="f-control" name="firma" class="form-control" required oninvalid="this.setCustomValidity('Lütfen firma giriniz !!')" oninput="this.setCustomValidity('')">
                            <option id="f-option" class="form-control"></option>
                            <c:forEach items="${companyList}" var="list">
                                <option id="f-option" class="form-control">${list.isim}</option>
                            </c:forEach>
                        </select>
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