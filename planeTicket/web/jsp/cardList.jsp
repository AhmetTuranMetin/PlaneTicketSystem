<%-- 
    Document   : cardList
    Created on : 25.Kas.2021, 14:04:20
    Author     : ahmet
--%>

<%@page import="DataBases.CardDB"%>
<%@page import="Entities.Card"%>
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
    
    int uyeId = Integer.parseInt(request.getParameter("uyeId"));
    request.setAttribute("uyeId", uyeId);
    
    String name = request.getParameter("name");
    request.setAttribute("name", name);
    
    List<Card> cardList = new CardDB().GetCard(uyeId);
    request.setAttribute("cardList", cardList);
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
        <jsp:include page="footer.jsp"/>
        <link href="../styles/userfooter.css" rel="stylesheet" type="text/css"/>
        <link href="../styles/search.css" rel="stylesheet" type="text/css"/>
    <title>Kartlarım</title>
</head>
<body>
    <div id="content">
        <c:choose>
            <c:when test="${empty cardList}">
                <h2 style='position:absolute;left:43%;color:navy;top:30%;font-size:330%'>Kart Eklenmemiş</h2>
            </c:when>
            <c:otherwise>
                <table id="bs-table" class="table table-striped table-dark">
                    <thead>
                        <tr class="table-primary">
                        <th scope="col">KART SAHİBİ</th>
                        <th scope="col">KART NUMARASI</th>
                        <th scope="col">CVV</th>
                        <th scope="col">İŞLEMLER</th>
                      </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${cardList}" var="list">
                            <tr class="bg-info">
                                <td>${name}</td>
                                <td>${list.kartNo}</td>
                                <td>${list.cvv}</td> 
                                <td><a href="${pageContext.request.contextPath}/card?selector=delete&id=${list.id}&uyeId=${uyeId}"><button type="submit" class="btn btn-danger">Sil</button></a></td>
                            </tr>         
                        </c:forEach>
                    </tbody>
                </table>
            </c:otherwise>
        </c:choose>
</div>
</body>
</html>
