<%-- 
    Document   : about
    Created on : 06.Ara.2021, 20:08:45
    Author     : ahmet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="../images/b_image.jpg"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
        <jsp:include page="userMenu.jsp"/>
        <jsp:include page="footer.jsp"/>
        <link href="../styles/userfooter.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <title>Hakkımızda</title>
    
    <style>
        #about-area{
            background-color: goldenrod;
            position: relative;
            width: 50%;
            margin: auto
        }
        #about-logo{
            display: flex;
            margin-left: auto;
            margin-right: auto
        }
        #text{
            font-size: 180%;
            color: navy;
            border-bottom: 2px solid navy;
            text-align: center
        }
        #header-text{
            font-size: 180%;
            color: navy;
        }
        #info-modal{
            font-size: 180%;
            margin-top: 11%;
        }
        #about_modal_btn{
            font-size: 100%;
            background-color: goldenrod;
            color: navy;
            border: none;
            outline: none
        }
        #about_modal_btn:hover{
            opacity: 0.8;
            cursor: default
        }
        #info-btn{
            background-color: goldenrod;
            border: none;
            outline: none;
        }
    </style>
</head>
<body style="background-color: navy">
<div id="about-area">
    <img id="about-logo" src="../images/logo.ico" alt="logo" width="180px" height="180px"/>
    <p id="text">Bu site <b>ATM Airlines</b> resmi web sitesidir. Uçak bileti rezervasyonu yapabilir veya satın alabilirsiniz. Dilerseniz sadece uçuşlara da göz atabilirsiniz.</p>
    <p id="header-text"><b>Paketler hakkında bilgi için : </b><button id="info-btn" data-toggle="modal" data-target="#info-modal" class="packet-btn"><span style="margin-left: 2%;font-size: 18px" class="fas fa-info-circle"></span></button></p>
    <p style="border-bottom: 2px solid navy" id="header-text"><b>Bilet işlemleri hakkında bilgi için : </b><button id="info-btn" data-toggle="modal" data-target="#info-modal" class="ticket_info-btn"><span style="margin-left: 2%;font-size: 18px" class="fas fa-info-circle"></span></button></p>
    <p style="border-bottom: 2px solid navy" id="header-text"><b><strong>Tüm Kullanıcıların Dikkatine;<br></strong></b><strong>Satın aldığınız tüm biletler için, uçuş saatinizden en az 2.5 saat önce havaalanında bulunmanız ve gerekli işlemleri yaptırmanız önemle rica olunur.</strong></p>
    <h2 style="color: navy">İLETİŞİM BİLGİLERİ</h2>
    <p id="header-text"><b>Email: </b>atmairline@gmail.com</p>
</div>

<!--package info modal -->
  <div class="modal" id="info-modal">
    <div class="modal-dialog">
      <div style="background-color: navy" class="modal-content">
        <div class="modal-body">
            
        </div>
        <div style="border-top: 2px solid goldenrod" class="modal-footer">
            <button id="about_modal_btn" type="button" data-dismiss="modal">Kapat</button>
        </div>
      </div>
    </div>
  </div>
<!--end modal-->
</body>
</html>

<script>
    var packetInfo = `<p style="color: goldenrod;text-align: center;border-bottom: 2px solid goldenrod"><b>Standart</b> ve <b>Avantaj</b> olmak üzere 2 adet paket mevcuttur.</p>
    <p style="color: goldenrod"><b>Standart: </b>Uçuşu seçip ödeme işlemini tamamladıktan sonra bilet satın alma işlemi sona erer. Koltuk numaranızı havaalanında öğrenirsiniz.</p>
    <p style="color: goldenrod"><b>Avantaj: </b>Seçtiğiniz uçuş ücretine ilave olarak 30₺ ödeyerek koltuk seçme şansına sahip olduğunuz pakettir.</p>`;
    var ticketInfo = `<p style="color: goldenrod"><b>Rezervasyon yapanların dikkatine;<br> </b>Uçuş saatinizden <strong>en az 6 saat</strong> önce ödeme işleminizi, web sitemiz üzerinden hesabınıza giriş yaparak gerçekleştirmeniz önemle rica olunur. (<strong>Biletlerim</strong> kısmından biletleri görebilir ve ödeme işlemi gerçekleştirebilirsiniz.)</p>
    <p style="color: goldenrod"><b>Standart paketini seçip, bilet satın alanların dikkatine;<br></b>Uçuş saatinizden <strong>en az 2.5 saat</strong> önce ilgili havaalanına gelip işlemlerinizi(koltuk numarası öğrenme vs.) yaptırmanız önemle rica olunur.</p>`;
    
    $(".packet-btn").click(()=>{
       $(".modal-body").html(packetInfo);
    });
    
    $(".ticket_info-btn").click(()=>{
       $(".modal-body").html(ticketInfo);
    });
</script>