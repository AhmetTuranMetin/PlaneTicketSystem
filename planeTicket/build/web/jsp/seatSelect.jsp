<%-- 
    Document   : seatSelect
    Created on : 21.Kas.2021, 13:16:56
    Author     : ahmet
--%>

<%@page import="DataBases.SeatDB"%>
<%@page import="Entities.Seat"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
    String remember=null;
    Cookie cookies[] = request.getCookies();
    for (int i = 0; i < cookies.length; i++) {
        if (cookies[i].getName().equals("remember")) {
            remember = cookies[i].getValue();
            break;
        }
    }
    //if not login redirect to index.jsp
    check:
    if(session.getAttribute("login")!="OK"){
        if(remember!=null)
            break check;
        response.sendRedirect("login.jsp");
    }
    
    String ucusId = request.getParameter("ucusId");
    String uyeId = request.getParameter("uyeId");
    String tip = request.getParameter("tip");
    String paket = request.getParameter("paket");
    request.setAttribute("ucusId", ucusId);
    request.setAttribute("uyeId", uyeId);
    request.setAttribute("tip", tip);
    request.setAttribute("paket", paket);
    
    List<Seat> seats = new SeatDB().GetList(Integer.parseInt(ucusId));
    request.setAttribute("seats", seats);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="../images/b_image.jpg"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="../js/seat.js" type="text/javascript"></script>
        <link href="../styles/seat.css" rel="stylesheet" type="text/css"/>  
        <jsp:include page="footer.jsp"/>
        <link href="../styles/userfooter.css" rel="stylesheet" type="text/css"/>
        <jsp:include page="userMenu.jsp"/>
    <title>Bilet Seç</title>
</head>
<body>
    <div id="account-body">
        <div hidden id="seats"><c:forEach items="${seats}" var="seats">${seats.no};</c:forEach></div>

        <form action="${pageContext.request.contextPath}/jsp/cardPage.jsp">
            <input type="hidden" name="ucusId" value="${ucusId}"></input>
            <input type="hidden" name="uyeId" value="${uyeId}"></input>
            <input type="hidden" name="tip" value="${tip}"></input>
            <input type="hidden" name="paket" value="${paket}"></input>
            <input type="hidden" name="selector" value="addSeatSelect"></input>
            <div class="modal-body">
                <div class="modal-header">
                    <h5 style="color: navy" class="modal-title" id="exampleModalLongTitle">Koltuk Seç</h5>
                </div>
                <div class="row mb-4">
                    <div class="col">
                      <div class="form-outline">
                        <label id="f-label" class="form-label" for="koltukNo">Koltuk Numarası<i class="text-danger">*</i></label>
                        <input id="t_koltuk_no" type="number" name="koltukNo" class="form-control" required oninvalid="this.setCustomValidity('Lütfen koltuk bilgisini giriniz !!')" oninput="this.setCustomValidity('')"/>
                        <label style="position: absolute;left: 180px;top: 0px" id="f-label" class="form-label" for="koltukSira">Koltuk Sıra Numarası<i class="text-danger">*</i></label>
                        <select style="color: navy;width: 70px;position: absolute;left: 180px;top: 32px" id="f-control" name="koltukSira" class="form-control" required oninvalid="this.setCustomValidity('Lütfen koltuk sırası giriniz !!')" oninput="this.setCustomValidity('')">
                            <option id="f-option" class="form-control"></option>
                            <option id="f-option" class="form-control">A</option>
                            <option id="f-option" class="form-control">B</option>
                            <option id="f-option" class="form-control">C</option>
                            <option id="f-option" class="form-control">D</option>
                            <option id="f-option" class="form-control">E</option>
                            <option id="f-option" class="form-control">F</option>
                        </select><br>
                        <div id="alert"></div>
                      </div> 
                </div>
            </div>
            <div class="modal-footer">
                <button style="position: absolute;left: 2%" id="flight_add_btn" type="button" class="btn btn-success" data-toggle="modal" data-target="#seatsModal">Koltuk Durumu</button>
                <button id="flight_add_btn" type="submit" class="btn btn-success" onclick="return validation();">Tamam</button>
            </div>
          </div>
      </form>  
</div>

<!--begin::modal-->
<div class="modal fade" id="seatsModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content" id="modal_content">
      <div class="modal-header">
          <h5 style="color: gold" id="m-title" class="modal-title" id="exampleModalLongTitle">Koltuklar</h5>
        <button style="color: gold" id="close-modal" type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
            <div class="modal-body">
                <div class="row mb-4">
                    <div class="col">
                      <div class="form-outline">
                        <div class="seat-area"></div>
                      </div> 
                </div>
            </div>
          </div>
  </div>
</div>
</div>
<!--end modal-->
</body>
</html>
