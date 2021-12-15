<%-- 
    Document   : changePass
    Created on : 02.Ara.2021, 21:52:09
    Author     : ahmet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="../images/b_image.jpg"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <link href="../styles/login.css" rel="stylesheet" type="text/css"/>
        <script src="../js/login.js" type="text/javascript"></script>
        <jsp:include page="footer.jsp"/>
        <link href="../styles/userfooter.css" rel="stylesheet" type="text/css"/>
        <jsp:include page="userMenu.jsp"/>
    <title>Şifre Değiştir</title>
</head>
<body>
    <div id="account-body">
    <form action="${pageContext.request.contextPath}/user" method="POST">
            <div class="modal-body">
                <div class="modal-header">
                    <h5 style="color: navy" class="modal-title" id="exampleModalLongTitle">Şifre Değiştir</h5>
                </div>
                <div class="row mb-4">
                    <div class="col">
                      <div class="form-outline">
                        <input type="hidden" value="change" name="selector"></input>
                        <label style="color: navy" class="form-label" for="tc">TC Kimlik Numarası<i class="text-danger">*</i></label>
                        <input style="color: navy;width: 25%" type="text" id="tc" pattern='\d{11}' name="tc" class="form-control" required oninvalid="this.setCustomValidity('Lütfen TC kimlik numaranızı giriniz !!')" oninput="this.setCustomValidity('')"/>
                        <label style="color: navy" class="form-label" for="sifre">Yeni Şifre<i class="text-danger">*</i></label> <input style="margin-left: 7%" id="checkbox" type="checkbox"><i style="margin-left: 2px;color: navy">Şifreyi Göster</i></input>
                        <input style="color: navy;width: 27%" type="password" id="sifre" name="sifre" class="form-control" required oninvalid="this.setCustomValidity('Lütfen şifrenizi giriniz !!')" oninput="this.setCustomValidity('')"/>
                      </div> 
                </div>
            </div>
            <div class="modal-footer">
                <button id="flight_add_btn" type="submit" class="btn btn-success">Değiştir</button>
            </div>
          </div>
      </form>  
</div>
</body>
</html>
