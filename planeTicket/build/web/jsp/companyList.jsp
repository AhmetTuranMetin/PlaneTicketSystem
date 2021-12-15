<%-- 
    Document   : companyList
    Created on : 15.Kas.2021, 19:14:55
    Author     : ahmet
--%>

<%@page import="DataBases.UserDB"%>
<%@page import="DataBases.CompanyDB"%>
<%@page import="Entities.Company"%>
<%@page import="java.util.List"%>
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
    
    List<Company> companyList = new CompanyDB().AllList();
    request.setAttribute("companyList", companyList);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf8">
        <link rel="icon" href="../images/logo.ico"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <jsp:include page="menu.jsp"/>
        <jsp:include page="header.jsp"/>
        <jsp:include page="footer.jsp"/>
        <link href="../styles/general.css" rel="stylesheet" type="text/css"/>
    <title>Firma Listesi</title>
</head>
<body>
    <div id="content">
        <c:choose>
            <c:when test="${empty companyList}">
                <button id="flight_btn" style="margin-left: 200%;margin-top: 70%" type="button" class="btn btn-outline-warning" data-toggle="modal" data-target="#addCompanyModal">Yeni Firma Ekle</button>
                <h2 style='position:absolute;left:48%;color:goldenrod;top:37%;font-size:330%'>Firma Yok</h2>
            </c:when>
            <c:otherwise>
                <button id="flight_btn" style="margin-left: 114%;margin-top: 6%" type="button" class="btn btn-outline-warning" data-toggle="modal" data-target="#addCompanyModal">Yeni Firma Ekle</button>
                <table id="bs-table" class="table table-striped table-dark">
                    <thead>
                        <tr class="bg-primary">
                        <th scope="col">#ID</th>
                        <th scope="col">FÝRMA ADI</th>
                        <th scope="col">ÝÞLEMLER</th>
                      </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${companyList}" var="list">
                            <tr>
                        <th scope="row">${list.id}</th>
                        <td>${list.isim}</td>
                        <td><a href="${pageContext.request.contextPath}/company?id=${list.id}&selector=delete"><button type="button" class="btn btn-outline-danger">Sil</button></a><a href="companyUpdate.jsp?id=${list.id}"><button style="margin-left: 12%" type="button" class="btn btn-outline-success">Güncelle</button></a></td>
                      </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:otherwise>
        </c:choose>
</div>
    
<!--Add Company Modal -->
<div class="modal fade" id="addCompanyModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 id="m-title" class="modal-title" id="exampleModalLongTitle">Uçuþ Ekle</h5>
        <button id="close-modal" type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
        <form action="${pageContext.request.contextPath}/company" method="POST">
            <div class="modal-body">
                <div class="row mb-4">
                    <div class="col">
                      <div class="form-outline">
                        <input type="hidden" name="selector" value="add"></input>
                        <label id="f-label" class="form-label" for="firmaIsim">Firma Adý<i class="text-danger">*</i></label>
                        <input id="f-control" type="text" id="firmaIsim" name="firmaIsim" class="form-control" required oninvalid="this.setCustomValidity('Lütfen firma ismi giriniz !!')" oninput="this.setCustomValidity('')"/>
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
