<%-- 
    Document   : flightSearch
    Created on : 17.Kas.2021, 21:05:00
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
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <script src="../js/login.js" type="text/javascript"></script>
        <jsp:include page="footer.jsp"/>
        <link href="../styles/userfooter.css" rel="stylesheet" type="text/css"/>
        <jsp:include page="userMenu.jsp"/>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
    <title>Uçuş Ara</title>
</head>
<body>
    <div id="account-body">
        <form action="flightSelect.jsp">
            <div class="modal-body">
                <div class="modal-header">
                    <h5 style="color: navy" class="modal-title" id="exampleModalLongTitle">Uçuş Ara</h5>
                </div>
                <div class="row mb-4">
                    <div class="col">
                      <div class="form-outline">
                        <label style="color: navy" class="form-label" for="kalkis">Nereden<i class="text-danger">*</i></label>
                        <input style="color: navy" type="text" id="kalkis" name="kalkis" class="form-control" required oninvalid="this.setCustomValidity('Lütfen bir şehir giriniz !!')" oninput="this.setCustomValidity('')"/>
                        <label style="color: navy" class="form-label" for="varis">Nereye<i class="text-danger">*</i></label>
                        <input style="color: navy" type="text" id="varis" name="varis" class="form-control" required oninvalid="this.setCustomValidity('Lütfen bir şehir giriniz !!')" oninput="this.setCustomValidity('')"/>
                        <label style="color: navy" id="f-label" class="form-label" for="tarih">Tarih<i class="text-danger">*</i></label>
                        <input style="color: navy" id="f-control" type="date" id="tarih" name="tarih" class="form-control" required oninvalid="this.setCustomValidity('Lütfen tarih giriniz !!')" oninput="this.setCustomValidity('')"/>
                      </div> 
                </div>
            </div>
            <div class="modal-footer">
                <button id="flight_add_btn" type="submit" class="btn btn-success">Uçuş Ara</button>
            </div>
          </div>
      </form>  
</div>
</body>
</html>
