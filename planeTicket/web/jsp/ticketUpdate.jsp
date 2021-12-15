<%-- 
    Document   : ticketUpdate
    Created on : 19.Kas.2021, 21:52:29
    Author     : ahmet
--%>

<%@page import="DataBases.UserDB"%>
<%@page import="Entities.Ticket"%>
<%@page import="DataBases.TicketDB"%>
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
    Ticket ticket = new TicketDB().GetTicket(id);
    request.setAttribute("ticket", ticket);
    
    String koltuk[] = ticket.getKoltukNo().split(" ");
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
    <title>Bilet Güncelle</title>
</head>
<body>
    <div id="update-body">
    <form action="${pageContext.request.contextPath}/ticket" method="POST">
            <div class="modal-body">
                <div class="modal-header">
                    <h5 style="color: navy" class="modal-title" id="exampleModalLongTitle">Uçuþ Güncelle</h5>
                </div>
                <div class="row mb-4">
                    <div class="col">
                      <div class="form-outline">
                        <input style="color: navy" type="hidden" name="selector" value="update"></input>
                        <input style="color: navy" type="hidden" name="id" value="${ticket.id}"></input>
                        <label style="color: navy" id="f-label" class="form-label" for="ucusId">Uçuþ ID<i class="text-danger">*</i></label>
                        <input style="color: navy" id="t_ucus_id" type="number" name="ucusId" class="form-control" value="${ticket.ucusId}" required oninvalid="this.setCustomValidity('Lütfen uçuþ id giriniz !!')" oninput="this.setCustomValidity('')"/>
                        <label style="color: navy;position: absolute;left: 180px;top: 2px" id="f-label" class="form-label" for="uyeId">Üye ID<i class="text-danger">*</i></label>
                        <input style="color: navy" id="t_uye_id" type="number" name="uyeId" class="form-control" value="${ticket.uyeId}" required oninvalid="this.setCustomValidity('Lütfen üye id giriniz !!')" oninput="this.setCustomValidity('')"/>
                        <label style="color: navy" id="f-label" class="form-label" for="koltukNo">Koltuk Numarasý<i class="text-danger">*</i></label>
                        <input id="t_koltuk_no" type="number" name="koltukNo" class="form-control" value="${koltuk[0]}"/>
                        <label style="color: navy;position: absolute;left: 180px;top: 72px" id="f-label" class="form-label" for="koltukSira">Koltuk Sýra Numarasý<i class="text-danger">*</i></label>
                        <select style="color: navy;width: 70px;position: absolute;left: 180px;top: 100px" id="f-control" name="koltukSira" class="form-control" required oninvalid="this.setCustomValidity('Lütfen bilet tipi giriniz !!')" oninput="this.setCustomValidity('')">
                            <option id="f-option" class="form-control">${koltuk[1]}</option>
                            <option id="f-option" class="form-control">A</option>
                            <option id="f-option" class="form-control">B</option>
                            <option id="f-option" class="form-control">C</option>
                            <option id="f-option" class="form-control">D</option>
                            <option id="f-option" class="form-control">E</option>
                            <option id="f-option" class="form-control">F</option>
                        </select>
                        <label style="color: navy" id="f-label" class="form-label" for="tip">Bilet Tipi<i class="text-danger">*</i></label>
                        <select style="color: navy;width: 135px" id="f-control" name="tip" class="form-control" required oninvalid="this.setCustomValidity('Lütfen bilet tipi giriniz !!')" oninput="this.setCustomValidity('')">
                            <option id="f-option" class="form-control">${ticket.tip}</option>
                            <option id="f-option" class="form-control">Satýn Al</option>
                            <option id="f-option" class="form-control">Rezervasyon</option>
                        </select>
                        <label style="color: navy" id="f-label" class="form-label" for="paket">Bilet Paketi<i class="text-danger">*</i></label>
                        <select style="color: navy;width: 118px" id="f-control" name="paket" class="form-control" required oninvalid="this.setCustomValidity('Lütfen paket tipi giriniz !!')" oninput="this.setCustomValidity('')">
                            <option id="f-option" class="form-control">${ticket.paket}</option>
                            <option id="f-option" class="form-control">Standart</option>
                            <option id="f-option" class="form-control">Avantaj (Fiyata +30 TL)</option>
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
