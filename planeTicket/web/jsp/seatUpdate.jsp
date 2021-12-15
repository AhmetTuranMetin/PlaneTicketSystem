<%-- 
    Document   : seatUpdate
    Created on : 21.Kas.2021, 23:45:10
    Author     : ahmet
--%>

<%@page import="DataBases.UserDB"%>
<%@page import="DataBases.SeatDB"%>
<%@page import="Entities.Seat"%>
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
    
    int id = Integer.parseInt(request.getParameter("id"));
    Seat ticket = new SeatDB().GetSeat(id);
    request.setAttribute("seat", ticket);
    
    String koltuk[] = ticket.getNo().split(" ");
    request.setAttribute("koltuk", koltuk);
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
    <title>Koltuk Güncelle</title>
</head>
<body>
    <div id="update-body">
    <form action="${pageContext.request.contextPath}/seat" method="POST">
            <div class="modal-body">
                <div class="modal-header">
                    <h5 style="color: navy" class="modal-title" id="exampleModalLongTitle">Koltuk Güncelle</h5>
                </div>
                <div class="row mb-4">
                    <div class="col">
                      <div class="form-outline">
                        <input style="color: navy" type="hidden" name="selector" value="update"></input>
                        <input style="color: navy" type="hidden" name="id" value="${seat.id}"></input>
                        <label style="color: navy" id="f-label" class="form-label" for="ucusId">Uçuş ID<i class="text-danger">*</i></label>
                        <input style="color: navy" id="t_ucus_id" type="number" name="ucusId" class="form-control" value="${seat.ucusId}" required oninvalid="this.setCustomValidity('Lütfen uçuş id giriniz !!')" oninput="this.setCustomValidity('')"/>
                        <label style="color: navy;position: absolute;left: 180px;top: 2px" id="f-label" class="form-label" for="uyeId">Üye ID<i class="text-danger">*</i></label>
                        <input style="color: navy" id="t_uye_id" type="number" name="uyeId" class="form-control" value="${seat.uyeId}" required oninvalid="this.setCustomValidity('Lütfen üye id giriniz !!')" oninput="this.setCustomValidity('')"/>
                        <label style="color: navy" id="f-label" class="form-label" for="koltukNo">Koltuk Numarası<i class="text-danger">*</i></label>
                        <input id="t_koltuk_no" type="number" name="koltukNo" class="form-control" value="${koltuk[0]}"/>
                        <label style="color: navy;position: absolute;left: 180px;top: 72px" id="f-label" class="form-label" for="koltukSira">Koltuk Sıra Numarası<i class="text-danger">*</i></label>
                        <select style="color: navy;width: 70px;position: absolute;left: 180px;top: 100px" id="f-control" name="koltukSira" class="form-control" required oninvalid="this.setCustomValidity('Lütfen bilet tipi giriniz !!')" oninput="this.setCustomValidity('')">
                            <option id="f-option" class="form-control">${koltuk[1]}</option>
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
                <button style="color: navy" id="flight_add_btn" type="submit" class="btn btn-success">Güncelle</button>
            </div>
          </div>
      </form>  
</div>
</body>
</html>
