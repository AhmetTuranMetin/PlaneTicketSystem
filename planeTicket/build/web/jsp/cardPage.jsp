<%-- 
    Document   : cardPage
    Created on : 24.Kas.2021, 13:16:12
    Author     : ahmet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
    
    String selector = request.getParameter("selector").trim();
    request.setAttribute("selector", selector);
    if(selector.equals("addSeatSelect")){
        String ucusId = request.getParameter("ucusId").trim();
        String uyeId = request.getParameter("uyeId").trim();
        String tip = request.getParameter("tip").trim();
        String paket = request.getParameter("paket").trim();
        String koltukNo = request.getParameter("koltukNo").trim();
        String koltukSira = request.getParameter("koltukSira").trim();
        request.setAttribute("ucusId", ucusId);
        request.setAttribute("uyeId", uyeId);
        request.setAttribute("tip", tip);
        request.setAttribute("paket", paket);
        request.setAttribute("koltukNo", koltukNo);
        request.setAttribute("koltukSira", koltukSira);
    }else{
        int id = Integer.parseInt(request.getParameter("id"));
        String uyeId = request.getParameter("uyeId").trim();
        String ucusId = request.getParameter("ucusId").trim();
        request.setAttribute("id", id);
        request.setAttribute("uyeId", uyeId);
        request.setAttribute("ucusId", ucusId);
    }
%>
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
        <script src="../js/loading.js" type="text/javascript"></script>
        <jsp:include page="footer.jsp"/>
        <link href="../styles/userfooter.css" rel="stylesheet" type="text/css"/>
        <link href="../styles/loading.css" rel="stylesheet" type="text/css"/>
        <jsp:include page="userMenu.jsp"/>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
    <title>Ödeme Bilgileri</title>
</head>
<body>
    <div id="account-body">
        <form action="${pageContext.request.contextPath}/ticket" method="POST">
            <input type="hidden" name="ucusId" value="${ucusId}"></input>
            <input type="hidden" name="uyeId" value="${uyeId}"></input>
            <input type="hidden" name="tip" value="${tip}"></input>
            <input type="hidden" name="koltukSira" value="${koltukSira}"></input>
            <input type="hidden" name="koltukNo" value="${koltukNo}"></input>
            <input type="hidden" name="paket" value="${paket}"></input>
            <input type="hidden" name="selector" value="${selector}"></input>
            <input type="hidden" name="id" value="${id}"></input>
            <div class="modal-body">
                <div class="modal-header">
                    <h5 style="color: navy" class="modal-title" id="exampleModalLongTitle">Ödeme Bilgileri</h5>
                </div>
                <div class="row mb-4">
                    <div class="col">
                      <div class="form-outline">
                        <label style="color: navy" class="form-label" for="kartNo">Kart Numarası<i class="text-danger">*</i></label>
                        <input style="color: navy;width: 50%" type="text" pattern='\d{16}' id="kartNo" name="kartNo" class="form-control" required oninvalid="this.setCustomValidity('Lütfen 16 haneli kart numarası giriniz !!')" oninput="this.setCustomValidity('')"/>
                        <label style="color: navy" class="form-label" for="cvv">CVV<i class="text-danger">*</i></label>
                        <input style="color: navy;width: 10%" type="number" id="cvv" name="cvv" class="form-control" required oninvalid="this.setCustomValidity('Lütfen 3 haneli cvv giriniz !!')" oninput="this.setCustomValidity('')"/>
                      </div> 
                </div>
            </div>
            <div class="modal-footer">
                <button id="pay_completed" type="submit" class="btn btn-success" onclick="loading()">Ödemeyi Tamamla</button>
            </div>
          </div>
      </form>
</div>
<div style="width:50%;position: relative;margin: auto;margin-top: 11%" id="loading"></div>
</body>
</html>
