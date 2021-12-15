<%-- 
    Document   : seatList
    Created on : 21.Kas.2021, 23:31:59
    Author     : ahmet
--%>

<%@page import="DataBases.UserDB"%>
<%@page import="DataBases.SeatDB"%>
<%@page import="Entities.Seat"%>
<%@page import="java.util.List"%>
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
    
    List<Seat> seatList = new SeatDB().AllList();
    request.setAttribute("seatList", seatList);
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
    <title>Koltuk Listesi</title>
</head>
<body>
    <div id="content">
        <c:choose>
            <c:when test="${empty seatList}">
                <button id="flight_btn" style="margin-left: 200%;margin-top: 70%" type="button" class="btn btn-outline-warning" data-toggle="modal" data-target="#addSeatModal">Yeni Koltuk Ekle</button>
                <h2 style='position:absolute;left:48%;color:goldenrod;top:37%;font-size:330%'>Koltuk Yok</h2>
            </c:when>
            <c:otherwise>
                <button id="flight_btn" style="margin-left: 114%;margin-top: 6%" type="button" class="btn btn-outline-warning" data-toggle="modal" data-target="#addSeatModal">Yeni Koltuk Ekle</button>
                <table id="bs-table" class="table table-striped table-dark">
                    <thead>
                        <tr class="bg-primary">
                        <th scope="col">#ID</th>
                        <th scope="col">UÇUŞ ID</th>
                        <th scope="col">ÜYE ID</th>
                        <th scope="col">KOLTUK NUMARASI</th>
                        <th scope="col">İŞLEMLER</th>
                      </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${seatList}" var="list">
                            <tr>
                        <th scope="row">${list.id}</th>
                        <td>${list.ucusId}</td>
                        <td>${list.uyeId}</td>
                        <td>${list.no}</td>
                        <td><a href="${pageContext.request.contextPath}/seat?id=${list.id}&selector=delete"><button type="button" class="btn btn-outline-danger">Sil</button></a><a href="seatUpdate.jsp?id=${list.id}"><button style="margin-left: 12%" type="button" class="btn btn-outline-success">Güncelle</button></a></td>
                      </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:otherwise>
        </c:choose>
</div>
    
<!--Add Flight Modal -->
<div class="modal fade" id="addSeatModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 id="m-title" class="modal-title" id="exampleModalLongTitle">Koltuk Ekle</h5>
        <button id="close-modal" type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
        <form action="${pageContext.request.contextPath}/seat" method="POST">
            <div class="modal-body">
                <div class="row mb-4">
                    <div class="col">
                      <div class="form-outline">
                        <input type="hidden" name="selector" value="add"></input>
                        <label id="f-label" class="form-label" for="ucusId">Uçuş ID<i class="text-danger">*</i></label>
                        <input id="t_ucus_id" type="number" name="ucusId" class="form-control" required oninvalid="this.setCustomValidity('Lütfen uçuş id giriniz !!')" oninput="this.setCustomValidity('')"/>
                        <label style="position: absolute;left: 180px;top: 2px" id="f-label" class="form-label" for="uyeId">Üye ID<i class="text-danger">*</i></label>
                        <input id="t_uye_id" type="number" name="uyeId" class="form-control" required oninvalid="this.setCustomValidity('Lütfen üye id giriniz !!')" oninput="this.setCustomValidity('')"/>
                        <label id="f-label" class="form-label" for="koltukNo">Koltuk Numarası<i class="text-danger">*</i></label>
                        <input id="t_koltuk_no" type="number" name="koltukNo" class="form-control" required oninvalid="this.setCustomValidity('Lütfen koltuk bilgisini giriniz !!')" oninput="this.setCustomValidity('')"/>
                        <label style="position: absolute;left: 180px;top: 72px" id="f-label" class="form-label" for="koltukSira">Koltuk Sıra Numarası<i class="text-danger">*</i></label>
                        <select style="color: navy;width: 70px;position: absolute;left: 180px;top: 100px" id="f-control" name="koltukSira" class="form-control" required oninvalid="this.setCustomValidity('Lütfen bilet tipi giriniz !!')" oninput="this.setCustomValidity('')">
                            <option id="f-option" class="form-control"></option>
                            <option id="f-option" class="form-control">A</option>
                            <option id="f-option" class="form-control">B</option>
                            <option id="f-option" class="form-control">C</option>
                            <option id="f-option" class="form-control">D</option>
                            <option id="f-option" class="form-control">E</option>
                            <option id="f-option" class="form-control">F</option>
                        </select>
                      </div> 
                </div>
            </div>
            <div class="modal-footer">
                <button style="color: navy" type="button" class="btn btn-info" data-dismiss="modal">Kapat</button>
                <button style="color: navy" id="flight_add_btn" type="submit" class="btn btn-warning">Ekle</button>
            </div>
          </div>
      </form>  
  </div>
</div>
</div>
<!--end modal-->
</body>
</html>
