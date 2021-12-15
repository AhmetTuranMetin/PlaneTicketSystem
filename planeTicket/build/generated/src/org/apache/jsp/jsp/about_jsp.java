package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class about_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"icon\" href=\"../images/b_image.jpg\"/>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js\" integrity=\"sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js\" integrity=\"sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1\" crossorigin=\"anonymous\"></script>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "userMenu.jsp", out, false);
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
      out.write("        <link href=\"../styles/userfooter.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\"/>\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\n");
      out.write("    <title>Hakkımızda</title>\n");
      out.write("    \n");
      out.write("    <style>\n");
      out.write("        #about-area{\n");
      out.write("            background-color: goldenrod;\n");
      out.write("            position: relative;\n");
      out.write("            width: 50%;\n");
      out.write("            margin: auto\n");
      out.write("        }\n");
      out.write("        #about-logo{\n");
      out.write("            display: flex;\n");
      out.write("            margin-left: auto;\n");
      out.write("            margin-right: auto\n");
      out.write("        }\n");
      out.write("        #text{\n");
      out.write("            font-size: 180%;\n");
      out.write("            color: navy;\n");
      out.write("            border-bottom: 2px solid navy;\n");
      out.write("            text-align: center\n");
      out.write("        }\n");
      out.write("        #header-text{\n");
      out.write("            font-size: 180%;\n");
      out.write("            color: navy;\n");
      out.write("        }\n");
      out.write("        #info-modal{\n");
      out.write("            font-size: 180%;\n");
      out.write("            margin-top: 11%;\n");
      out.write("        }\n");
      out.write("        #about_modal_btn{\n");
      out.write("            font-size: 100%;\n");
      out.write("            background-color: goldenrod;\n");
      out.write("            color: navy;\n");
      out.write("            border: none;\n");
      out.write("            outline: none\n");
      out.write("        }\n");
      out.write("        #about_modal_btn:hover{\n");
      out.write("            opacity: 0.8;\n");
      out.write("            cursor: default\n");
      out.write("        }\n");
      out.write("        #info-btn{\n");
      out.write("            background-color: goldenrod;\n");
      out.write("            border: none;\n");
      out.write("            outline: none;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body style=\"background-color: navy\">\n");
      out.write("<div id=\"about-area\">\n");
      out.write("    <img id=\"about-logo\" src=\"../images/logo.ico\" alt=\"logo\" width=\"180px\" height=\"180px\"/>\n");
      out.write("    <p id=\"text\">Bu site <b>ATM Airlines</b> resmi web sitesidir. Uçak bileti rezervasyonu yapabilir veya satın alabilirsiniz. Dilerseniz sadece uçuşlara da göz atabilirsiniz.</p>\n");
      out.write("    <p id=\"header-text\"><b>Paketler hakkında bilgi için : </b><button id=\"info-btn\" data-toggle=\"modal\" data-target=\"#info-modal\" class=\"packet-btn\"><span style=\"margin-left: 2%;font-size: 18px\" class=\"fas fa-info-circle\"></span></button></p>\n");
      out.write("    <p style=\"border-bottom: 2px solid navy\" id=\"header-text\"><b>Bilet işlemleri hakkında bilgi için : </b><button id=\"info-btn\" data-toggle=\"modal\" data-target=\"#info-modal\" class=\"ticket_info-btn\"><span style=\"margin-left: 2%;font-size: 18px\" class=\"fas fa-info-circle\"></span></button></p>\n");
      out.write("    <p id=\"header-text\"><b><strong>Tüm Kullanıcıların Dikkatine;<br></strong></b><strong>Satın aldığınız tüm biletler için, uçuş saatinizden en az 2.5 saat önce havaalanında bulunmanız ve gerekli işlemleri yaptırmanız önemle rica olunur.</strong></p>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<!--package info modal -->\n");
      out.write("  <div class=\"modal\" id=\"info-modal\">\n");
      out.write("    <div class=\"modal-dialog\">\n");
      out.write("      <div style=\"background-color: navy\" class=\"modal-content\">\n");
      out.write("        <div class=\"modal-body\">\n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("        <div style=\"border-top: 2px solid goldenrod\" class=\"modal-footer\">\n");
      out.write("            <button id=\"about_modal_btn\" type=\"button\" data-dismiss=\"modal\">Kapat</button>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("<!--end modal-->\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("    var packetInfo = `<p style=\"color: goldenrod;text-align: center;border-bottom: 2px solid goldenrod\"><b>Standart</b> ve <b>Avantaj</b> olmak üzere 2 adet paket mevcuttur.</p>\n");
      out.write("    <p style=\"color: goldenrod\"><b>Standart: </b>Uçuşu seçip ödeme işlemini tamamladıktan sonra bilet satın alma işlemi sona erer. Koltuk numaranızı havaalanında öğrenirsiniz.</p>\n");
      out.write("    <p style=\"color: goldenrod\"><b>Avantaj: </b>Seçtiğiniz uçuş ücretine ilave olarak 30₺ ödeyerek koltuk seçme şansına sahip olduğunuz pakettir.</p>`;\n");
      out.write("    var ticketInfo = `<p style=\"color: goldenrod\"><b>Rezervasyon yapanların dikkatine;<br> </b>Uçuş saatinizden <strong>en az 6 saat</strong> önce ödeme işleminizi, web sitemiz üzerinden hesabınıza giriş yaparak gerçekleştirmeniz önemle rica olunur. (<strong>Biletlerim</strong> kısmından biletleri görebilir ve ödeme işlemi gerçekleştirebilirsiniz.)</p>\n");
      out.write("    <p style=\"color: goldenrod\"><b>Standart paketini seçip, bilet satın alanların dikkatine;<br></b>Uçuş saatinizden <strong>en az 2.5 saat</strong> önce ilgili havaalanına gelip işlemlerinizi(koltuk numarası öğrenme vs.) yaptırmanız önemle rica olunur.</p>`;\n");
      out.write("    \n");
      out.write("    $(\".packet-btn\").click(()=>{\n");
      out.write("       $(\".modal-body\").html(packetInfo);\n");
      out.write("    });\n");
      out.write("    \n");
      out.write("    $(\".ticket_info-btn\").click(()=>{\n");
      out.write("       $(\".modal-body\").html(ticketInfo);\n");
      out.write("    });\n");
      out.write("</script>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
