<%-- 
    Document   : flightSelect
    Created on : 18.Kas.2021, 11:19:49
    Author     : ahmet
--%>

<%@page import="Entities.Flight"%>
<%@page import="java.util.List"%>
<%@page import="DataBases.FlightDB"%>
<%@page import="java.sql.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
    String kalkis = request.getParameter("kalkis").trim();
    String varis = request.getParameter("varis").trim();
    Date tarih = Date.valueOf(request.getParameter("tarih"));
    
    List<Flight> searchList = new FlightDB().Search(kalkis, varis, tarih);
    request.setAttribute("searchList", searchList);
    
    Cookie cookies[] = request.getCookies();
    for (int i = 0; i < cookies.length; i++) {
        if (cookies[i].getName().equals("userId")) {
            String kullanici_id = cookies[i].getValue();
            request.setAttribute("kullanici_id", kullanici_id);
            break;
        }
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="../images/b_image.jpg"/>
        <link href="../styles/index.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
        <jsp:include page="userMenu.jsp"/>
        <link href="../styles/search.css" rel="stylesheet" type="text/css"/>
        <jsp:include page="footer.jsp"/>
        <link href="../styles/userfooter.css" rel="stylesheet" type="text/css"/>
        <link href="../styles/loading.css" rel="stylesheet" type="text/css"/>
        <script src="../js/loading.js" type="text/javascript"></script>
    <title>Uçuşlar</title>
</head>
<body>
    <div id="content">
        <c:choose>
            <c:when test="${empty searchList}">
                <h2 style='position:absolute;left:43%;color:navy;top:30%;font-size:330%'>Uçuş Bulunamadı</h2>
            </c:when>
            <c:when test="${empty kullanici_id}">
                <table id="bs-table" class="table table-striped table-dark">
                    <thead>
                        <tr class="table-primary">
                        <th scope="col">KALKIŞ</th>
                        <th scope="col">VARIŞ</th>
                        <th scope="col">TARİH</th>
                        <th scope="col">SAAT</th>
                        <th scope="col">KALKIŞ HAVAALANI</th>
                        <th scope="col">VARIŞ HAVAALANI</th>
                        <th scope="col">FİYAT</th>
                        <th scope="col">FİRMA</th>
                      </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${searchList}" var="list">
                            <tr class="bg-info">
                        <td>${list.kalkis}</td>
                        <td>${list.varis}</td>
                        <td>${list.tarih}</td>
                        <td>${list.saat}</td>
                        <td>${list.kalkisHavaalani}</td>
                        <td>${list.varisHavaalani}</td>
                        <td>${list.fiyat}</td>
                        <td>${list.firma}</td> 
                        </tr>         
                        </c:forEach>
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                <table id="bs-table" class="table table-striped table-dark">
                    <thead>
                        <tr class="table-primary">
                        <th scope="col">KALKIŞ</th>
                        <th scope="col">VARIŞ</th>
                        <th scope="col">TARİH</th>
                        <th scope="col">SAAT</th>
                        <th scope="col">KALKIŞ HAVAALANI</th>
                        <th scope="col">VARIŞ HAVAALANI</th>
                        <th scope="col">FİYAT</th>
                        <th scope="col">FİRMA</th>
                        <th scope="col">PAKET SEÇİMİ</th>
                        <th scope="col">SATIN AL</th>
                        <th scope="col">REZERVASYON</th>
                      </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${searchList}" var="list">
                            <tr class="bg-info">
                        <td>${list.kalkis}</td>
                        <td>${list.varis}</td>
                        <td>${list.tarih}</td>
                        <td>${list.saat}</td>
                        <td>${list.kalkisHavaalani}</td>
                        <td>${list.varisHavaalani}</td>
                        <td>${list.fiyat}</td>
                        <td>${list.firma}</td> 
                        <form action="${pageContext.request.contextPath}/ticket?ucusId=${list.id}&selector=add&uyeId=${kullanici_id}&tip=Satın Al" method="POST">
                            <td>
                                <select style="color: navy;width: 118px;float: left;margin-right: 2%;font-size: 16px;padding: 0" id="f-control" name="paket" class="form-control" required oninvalid="this.setCustomValidity('Lütfen paket tipi giriniz !!')" oninput="this.setCustomValidity('')">
                                    <option style="color: navy;font-size: 17px;padding: 0" id="f-option" class="form-control"></option>
                                    <option style="color: navy;font-size: 17px;padding: 0" id="f-option" class="form-control">Standart</option>
                                    <option style="color: navy;font-size: 17px;padding: 0" id="f-option" class="form-control">Avantaj (Fiyata +30 TL)</option>
                                </select>
                            </td>
                            <td>
                                <input type="hidden" name="redirect" value="user"></input>
                                    <button type="submit" class="btn btn-warning">Satın Al</button>
                                </form>
                            </td>
                        <td>
                        <form action="${pageContext.request.contextPath}/ticket?ucusId=${list.id}&selector=add&uyeId=${kullanici_id}&tip=Rezervasyon&paket=Standart" method="POST">
                            <input type="hidden" name="redirect" value="user"></input>
                            <button type="submit" class="btn btn-light" onclick="loading()">Rezervasyon</button>
                        </td>
                        </form>
                        </tr>         
                        </c:forEach>
                    </tbody>
                </table>
            </c:otherwise>
        </c:choose>
</div>
</body>
<div style="width:50%;position: relative;margin: auto;margin-top: 11%" id="loading"></div>
</html>