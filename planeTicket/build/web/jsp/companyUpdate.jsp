<%-- 
    Document   : companyUpdate
    Created on : 16.Kas.2021, 12:30:03
    Author     : ahmet
--%>

<%@page import="DataBases.UserDB"%>
<%@page import="Entities.Company"%>
<%@page import="DataBases.CompanyDB"%>
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
    Company company = new CompanyDB().GetCompany(id);
    request.setAttribute("company", company);
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
    <title>Firma Güncelle</title>
</head>
<body>
    <div id="update-body">
    <form action="${pageContext.request.contextPath}/company" method="POST">
            <div class="modal-body">
                <div class="modal-header">
                    <h5 style="color: navy" class="modal-title" id="exampleModalLongTitle">Firma Güncelle</h5>
                </div>
                <div class="row mb-4">
                    <div class="col">
                      <div class="form-outline">
                        <input type="hidden" name="selector" value="update"></input>
                        <input type="hidden" name="id" value="${company.id}"></input>
                        <label style="color: navy" class="form-label" for="firmaIsim">Firma Adý<i class="text-danger">*</i></label>
                        <input style="color: navy" type="text" id="firmaIsim" name="firmaIsim" class="form-control" value="${company.isim}" required oninvalid="this.setCustomValidity('Lütfen firma ismi giriniz !!')" oninput="this.setCustomValidity('')"/>
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
