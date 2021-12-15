<%-- 
    Document   : ticketList
    Created on : 19.Kas.2021, 21:17:20
    Author     : ahmet
--%>

<%@page import="DataBases.UserDB"%>
<%@page import="Entities.Ticket"%>
<%@page import="java.util.List"%>
<%@page import="DataBases.TicketDB"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-9"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
    //get user id
    String kullanici_id=null;
    Cookie cookies[] = request.getCookies();
    for (int i = 0; i < cookies.length; i++) {
        if (cookies[i].getName().equals("userId")) {
            kullanici_id = cookies[i].getValue();
            request.setAttribute("kullanici_id", kullanici_id);
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
    
    List<Ticket> ticketList = new TicketDB().AllList();
    request.setAttribute("ticketList", ticketList);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf8">
        <link rel="icon" href="../images/logo.ico"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="../js/flight.js" type="text/javascript"></script>
        <jsp:include page="menu.jsp"/>
        <jsp:include page="header.jsp"/>
        <jsp:include page="footer.jsp"/>
        <link href="../styles/general.css" rel="stylesheet" type="text/css"/>
        <script src="../js/loading.js" type="text/javascript"></script>
        <link href="../styles/loading.css" rel="stylesheet" type="text/css"/>
    <title>Bilet Listesi</title>
</head>
<body>
    <div id="content">
    <c:choose>
            <c:when test="${empty ticketList}">
                <button id="flight_btn" style="margin-left: 200%;margin-top: 70%" type="button" class="btn btn-outline-warning" data-toggle="modal" data-target="#addTicketModal">Yeni Bilet Ekle</button>
                <h2 style='position:absolute;left:48%;color:goldenrod;top:37%;font-size:330%'>Bilet Yok</h2>
            </c:when>
            <c:otherwise>
                <button id="flight_btn" style="margin-left: 114%;margin-top: 6%" type="button" class="btn btn-outline-warning" data-toggle="modal" data-target="#addTicketModal">Yeni Bilet Ekle</button>
                <button style="position: absolute;margin-left: 20%;top: 84px" type="button" class="btn btn-outline-light" data-toggle="modal" data-target="#SearchTc">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                        <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"></path>
                    </svg>
                Ara
                </button>
                <table id="bs-table" class="table table-striped table-dark">
                    <thead>
                        <tr class="bg-primary">
                        <th scope="col">#ID</th>
                        <th scope="col">UÇUÞ ID</th>
                        <th scope="col">ÜYE ID</th>
                        <th scope="col">KOLTUK NUMARASI</th>
                        <th scope="col">BÝLET TÝPÝ</th>
                        <th scope="col">BÝLET PAKETÝ</th>
                        <th scope="col">ÝÞLEMLER</th>
                      </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${ticketList}" var="list">
                            <tr>
                        <th scope="row">${list.id}</th>
                        <td>${list.ucusId}</td>
                        <td>${list.uyeId}</td>
                        <td>${list.koltukNo}</td>
                        <td>${list.tip}</td>
                        <td>${list.paket}</td>
                        <td><a href="${pageContext.request.contextPath}/ticket?id=${list.id}&selector=delete&ucusId=${list.ucusId}&redirect=admin&uyeId=${list.uyeId}"><button type="button" class="btn btn-outline-danger" onclick="loading()">Sil</button></a><a href="ticketUpdate.jsp?id=${list.id}"><button style="margin-left: 12%" type="button" class="btn btn-outline-success">Güncelle</button></a></td>
                      </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:otherwise>
    </c:choose>
</div>
    
<!--Add Flight Modal -->
<div class="modal fade" id="addTicketModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 id="m-title" class="modal-title" id="exampleModalLongTitle">Bilet Ekle</h5>
        <button id="close-modal" type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
        <form action="${pageContext.request.contextPath}/ticket" method="POST">
            <div class="modal-body">
                <div class="row mb-4">
                    <div class="col">
                      <div class="form-outline">
                        <input type="hidden" name="selector" value="add"></input>
                        <input type="hidden" name="redirect" value="admin"></input>
                        <label id="f-label" class="form-label" for="ucusId">Uçuþ ID<i class="text-danger">*</i></label>
                        <input id="t_ucus_id" type="number" name="ucusId" class="form-control" required oninvalid="this.setCustomValidity('Lütfen uçuþ id giriniz !!')" oninput="this.setCustomValidity('')"/>
                        <label style="position: absolute;left: 180px;top: 2px" id="f-label" class="form-label" for="uyeId">Üye ID<i class="text-danger">*</i></label>
                        <input id="t_uye_id" type="number" name="uyeId" class="form-control" required oninvalid="this.setCustomValidity('Lütfen üye id giriniz !!')" oninput="this.setCustomValidity('')"/>
                        <label id="f-label" class="form-label" for="koltukNo">Koltuk Numarasý<i class="text-danger">*</i></label>
                        <input id="t_koltuk_no" type="number" name="koltukNo" class="form-control" required oninvalid="this.setCustomValidity('Lütfen koltuk bilgisini giriniz !!')" oninput="this.setCustomValidity('')"/>
                        <label style="position: absolute;left: 180px;top: 72px" id="f-label" class="form-label" for="koltukSira">Koltuk Sýra Numarasý<i class="text-danger">*</i></label>
                        <select style="color: navy;width: 70px;position: absolute;left: 180px;top: 100px" id="f-control" name="koltukSira" class="form-control" required oninvalid="this.setCustomValidity('Lütfen bilet tipi giriniz !!')" oninput="this.setCustomValidity('')">
                            <option id="f-option" class="form-control"></option>
                            <option id="f-option" class="form-control">A</option>
                            <option id="f-option" class="form-control">B</option>
                            <option id="f-option" class="form-control">C</option>
                            <option id="f-option" class="form-control">D</option>
                            <option id="f-option" class="form-control">E</option>
                            <option id="f-option" class="form-control">F</option>
                        </select>
                        <label id="f-label" class="form-label" for="tip">Bilet Tipi<i class="text-danger">*</i></label>
                        <select style="color: navy;width: 135px" id="f-control" name="tip" class="form-control" required oninvalid="this.setCustomValidity('Lütfen bilet tipi giriniz !!')" oninput="this.setCustomValidity('')">
                            <option id="f-option" class="form-control"></option>
                            <option id="f-option" class="form-control">Satýn Al</option>
                            <option id="f-option" class="form-control">Rezervasyon</option>
                        </select>
                        <label id="f-label" class="form-label" for="paket">Bilet Paketi<i class="text-danger">*</i></label>
                        <select style="color: navy;width: 118px" id="f-control" name="paket" class="form-control" required oninvalid="this.setCustomValidity('Lütfen paket tipi giriniz !!')" oninput="this.setCustomValidity('')">
                            <option id="f-option" class="form-control"></option>
                            <option id="f-option" class="form-control">Standart</option>
                            <option id="f-option" class="form-control">Avantaj (Fiyata +30 TL)</option>
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

<!--Search TC Flight Modal -->
<div class="modal fade" id="SearchTc" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 id="m-title" class="modal-title" id="exampleModalLongTitle">Bilet Ara</h5>
        <button id="close-modal" type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
        <form action="tcFlightSearch.jsp" method="POST">
            <div class="modal-body">
                <div class="row mb-4">
                    <div class="col">
                      <div class="form-outline">
                        <label id="f-label" class="form-label" for="tc">TC Kimlik Numarasý<i class="text-danger">*</i></label>
                        <input id="f-control" type="text" id="tc" name="tc" placeholder="11 haneli T.C. kimlik numarasýný giriniz" pattern='\d{11}' class="form-control" required oninvalid="this.setCustomValidity('Lütfen 11 haneli TC kimlik numaranýzý giriniz !!')" oninput="this.setCustomValidity('')"/>
                      </div> 
                </div>
            </div>
            <div class="modal-footer">
                <button style="color: navy" type="button" class="btn btn-info" data-dismiss="modal">Kapat</button>
                <button style="color: navy" id="flight_add_btn" type="submit" class="btn btn-light">Ara</button>
            </div>
          </div>
      </form>  
  </div>
</div>
</div>
<!--end modal-->
<div style="width:50%;position: relative;margin: auto;margin-top: 18%;margin-left: -41%" id="loading"></div>
</body>
</html>
