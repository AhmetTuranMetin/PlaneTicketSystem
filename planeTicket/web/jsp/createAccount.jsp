<%-- 
    Document   : createAccount
    Created on : 14.Kas.2021, 21:43:35
    Author     : ahmet
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-9"%>
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
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
    <title>Üye Ol</title>
</head>
<body>
    <div style="top: 12%" id="account-body">
    <form action="${pageContext.request.contextPath}/user" method="POST">
            <div class="modal-body">
                <div class="modal-header">
                    <h5 style="color: navy" class="modal-title" id="exampleModalLongTitle">Hesap Oluþtur</h5>
                </div>
                <div class="row mb-4">
                    <div class="col">
                      <div class="form-outline">
                        <div id="alert"></div>
                        <input type="hidden" name="selector" value="add"></input>
                        <input type="hidden" name="rol" value="Üye"></input>
                        <input type="hidden" name="redirect" value="user"></input>
                        <label style="color: navy" class="form-label" for="tc">TC Kimlik Numarasý<i class="text-danger">*</i></label>
                        <input style="color: navy" type="text" id="tc" pattern='\d{11}' name="tc" class="form-control" required oninvalid="this.setCustomValidity('Lütfen 11 haneli TC kimlik numaranýzý giriniz !!')" oninput="this.setCustomValidity('')"/>
                        <label style="color: navy" class="form-label" for="ad">Ad-Soyad<i class="text-danger">*</i></label>
                        <input style="color: navy" type="text" id="ad" name="ad" class="form-control" required oninvalid="this.setCustomValidity('Lütfen kullanýcý adýnýzý giriniz !!')" oninput="this.setCustomValidity('')"/>
                        <label style="color: navy" class="form-label" for="cinsiyet">Cinsiyet<i class="text-danger">*</i></label>
                        <select style="color: navy" id="f-control" name="cinsiyet" class="form-control" required oninvalid="this.setCustomValidity('Lütfen cinsiyetinizi giriniz !!')" oninput="this.setCustomValidity('')">
                            <option id="f-option" class="form-control"></option>
                            <option id="f-option" class="form-control">Erkek</option>
                            <option id="f-option" class="form-control">Kadýn</option>
                        </select>
                        <label style="color: navy" class="form-label" for="yas">Yaþ<i class="text-danger">*</i></label>
                        <input style="color: navy" type="number" min='18' id="yas" name="yas" class="form-control" required oninvalid="this.setCustomValidity('Boþ deðer kabul edilmez ve 18 yaþýndan küçükler üye olamaz !!')" oninput="this.setCustomValidity('')"/>
                        <label style="color: navy" class="form-label" for="d_tarih">Doðum Tarihi<i class="text-danger">*</i></label>
                        <input style="color: navy" type="date" id="d-tarih" name="d_tarih" class="form-control" required oninvalid="this.setCustomValidity('Lütfen doðum tarihinizi giriniz !!')" oninput="this.setCustomValidity('')"/>
                        <label style="color: navy" class="form-label" for="email">Email<i class="text-danger">*</i></label>
                        <input style="color: navy" type="email" id="email" name="email" class="form-control" required oninvalid="this.setCustomValidity('Lütfen email adresinizi email formatýna uyacak þekilde giriniz !!')" oninput="this.setCustomValidity('')"/>
                        <label style="color: navy" class="form-label" for="sifre">Þifre<i class="text-danger">*</i></label> <input id="checkbox" type="checkbox"><i style="margin-left: 2px;color: navy">Þifreyi Göster</i></input>
                        <input style="color: navy" type="password" id="sifre" name="sifre" class="form-control" required oninvalid="this.setCustomValidity('Lütfen þifrenizi giriniz !!')" oninput="this.setCustomValidity('')"/>
                      </div> 
                </div>
            </div>
            <div class="modal-footer">
                <button id="flight_add_btn" type="submit" class="btn btn-success" onclick="return validation();">Oluþtur</button>
            </div>
          </div>
      </form>  
</div>
</body>
</html>
