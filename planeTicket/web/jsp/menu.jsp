<%-- 
    Document   : menu
    Created on : 09.Kas.2021, 22:23:50
    Author     : ahmet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../styles/menu.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
<body>
    <div class="area">
        <a href="adminIndex.jsp"><img style="position: absolute;left: 9%" src="../images/logo.ico" width="180px" height="180px"></img></a>
        <ui class="mainMenu">
             <li class="item">
                <a href="adminIndex.jsp"><span style="margin-left: -7%;margin-right: 2%" class="fas fa-home"></span>Anasayfa</a>
            </li>
            <li class="item">
                <a href="companyList.jsp"><span style="margin-left: -10%;margin-right: 2%" class="fas fa-briefcase"></span>Şirketler</a>
            </li>
            <li class="item">
                <a href="flightList.jsp"><span style="margin-left: -18%;margin-right: 2%" class="fas fa-plane-departure"></span>Uçuşlar</a>
            </li>
            <li class="item" id="subMenuItem">
                <i class="first_menu_item"><span style="margin-left: -41%;margin-right: 2%" class="fas fa-chevron-down"></span>Bilet</i>
                <div class="subMenu">
                    <a href="ticketList.jsp"><span style="margin-left: -16%;margin-right: 2%" class="fas fa-ticket-alt"></span>Biletler</a>
                    <a href="seatList.jsp"><span style="margin-left: -5%" class="fas fa-chair"></span>Koltuklar</a>
                </div>
            </li>
            <li class="item">
                <a href="userList.jsp"><span style="margin-left: -25%;margin-right: 2%" class="fas fa-user-alt"></span>Üyeler</a>
            </li>
        </ui>
    </div>
</body>
</html>
