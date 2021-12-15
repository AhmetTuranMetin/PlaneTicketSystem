package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class createAccount_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\" integrity=\"sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <link href=\"../styles/login.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <script src=\"../js/login.js\" type=\"text/javascript\"></script>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
      out.write("        <link href=\"../styles/userfooter.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "userMenu.jsp", out, false);
      out.write("\n");
      out.write("    <title>Üye Ol</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div id=\"account-body\">\n");
      out.write("    <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/user\" method=\"POST\">\n");
      out.write("            <div class=\"modal-body\">\n");
      out.write("                <div class=\"modal-header\">\n");
      out.write("                    <h5 style=\"color: navy\" class=\"modal-title\" id=\"exampleModalLongTitle\">Hesap Oluştur</h5>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"row mb-4\">\n");
      out.write("                    <div class=\"col\">\n");
      out.write("                      <div class=\"form-outline\">\n");
      out.write("                        <input type=\"hidden\" name=\"selector\" value=\"add\"></input>\n");
      out.write("                        <input type=\"hidden\" name=\"rol\" value=\"Üye\"></input>\n");
      out.write("                        <input type=\"hidden\" name=\"redirect\" value=\"user\"></input>\n");
      out.write("                        <label style=\"color: navy\" class=\"form-label\" for=\"tc\">TC Kimlik Numarası<i class=\"text-danger\">*</i></label>\n");
      out.write("                        <input style=\"color: navy\" type=\"text\" id=\"tc\" pattern='\\d{11}' name=\"tc\" class=\"form-control\" required oninvalid=\"this.setCustomValidity('Lütfen 11 haneli TC kimlik numaranızı giriniz !!')\" oninput=\"this.setCustomValidity('')\"/>\n");
      out.write("                        <label style=\"color: navy\" class=\"form-label\" for=\"ad\">Ad-Soyad<i class=\"text-danger\">*</i></label>\n");
      out.write("                        <input style=\"color: navy\" type=\"text\" id=\"ad\" name=\"ad\" class=\"form-control\" required oninvalid=\"this.setCustomValidity('Lütfen kullanıcı adınızı giriniz !!')\" oninput=\"this.setCustomValidity('')\"/>\n");
      out.write("                        <label style=\"color: navy\" class=\"form-label\" for=\"cinsiyet\">Cinsiyet<i class=\"text-danger\">*</i></label>\n");
      out.write("                        <select style=\"color: navy\" id=\"f-control\" name=\"cinsiyet\" class=\"form-control\" required oninvalid=\"this.setCustomValidity('Lütfen cinsiyetinizi giriniz !!')\" oninput=\"this.setCustomValidity('')\">\n");
      out.write("                            <option id=\"f-option\" class=\"form-control\"></option>\n");
      out.write("                            <option id=\"f-option\" class=\"form-control\">Erkek</option>\n");
      out.write("                            <option id=\"f-option\" class=\"form-control\">Kadın</option>\n");
      out.write("                        </select>\n");
      out.write("                        <label style=\"color: navy\" class=\"form-label\" for=\"yas\">Yaş<i class=\"text-danger\">*</i></label>\n");
      out.write("                        <input style=\"color: navy\" type=\"number\" min='18' id=\"yas\" name=\"yas\" class=\"form-control\" required oninvalid=\"this.setCustomValidity('Boş değer kabul edilmez ve 18 yaşından küçükler üye olamaz !!')\" oninput=\"this.setCustomValidity('')\"/>\n");
      out.write("                        <label style=\"color: navy\" class=\"form-label\" for=\"d_tarih\">Doğum Tarihi<i class=\"text-danger\">*</i></label>\n");
      out.write("                        <input style=\"color: navy\" type=\"date\" id=\"d-tarih\" name=\"d_tarih\" class=\"form-control\" required oninvalid=\"this.setCustomValidity('Lütfen doğum tarihinizi giriniz !!')\" oninput=\"this.setCustomValidity('')\"/>\n");
      out.write("                        <label style=\"color: navy\" class=\"form-label\" for=\"email\">Email<i class=\"text-danger\">*</i></label>\n");
      out.write("                        <input style=\"color: navy\" type=\"email\" id=\"email\" name=\"email\" class=\"form-control\" required oninvalid=\"this.setCustomValidity('Lütfen email adresinizi email formatına uyacak şekilde giriniz !!')\" oninput=\"this.setCustomValidity('')\"/>\n");
      out.write("                        <label style=\"color: navy\" class=\"form-label\" for=\"sifre\">Şifre<i class=\"text-danger\">*</i></label> <input id=\"checkbox\" type=\"checkbox\"><i style=\"margin-left: 2px;color: navy\">Şifreyi Göster</i></input>\n");
      out.write("                        <input style=\"color: navy\" type=\"password\" id=\"sifre\" name=\"sifre\" class=\"form-control\" required oninvalid=\"this.setCustomValidity('Lütfen şifrenizi giriniz !!')\" oninput=\"this.setCustomValidity('')\"/>\n");
      out.write("                      </div> \n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal-footer\">\n");
      out.write("                <button id=\"flight_add_btn\" type=\"submit\" class=\"btn btn-success\">Oluştur</button>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("      </form>  \n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
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
