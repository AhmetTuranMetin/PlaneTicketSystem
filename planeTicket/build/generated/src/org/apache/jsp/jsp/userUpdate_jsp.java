package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import DataBases.UserDB;
import Entities.User;

public final class userUpdate_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");

    //if not login redirect to index.jsp
    if(session.getAttribute("login")!="OK"){
        response.sendRedirect("login.jsp");
        return;
    }
    
    int id = Integer.parseInt(request.getParameter("id")); 
    User user = new UserDB().GetUser(id);
    request.setAttribute("user", user);

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js\"></script>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "menu.jsp", out, false);
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\n");
      out.write("        <link href=\"../styles/general.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <script src=\"../js/login.js\" type=\"text/javascript\"></script>\n");
      out.write("    <title>Kullanıcı Güncelle</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div id=\"update-body\">\n");
      out.write("        <form id=\"form\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/user\" method=\"POST\">\n");
      out.write("            <div class=\"modal-body\">\n");
      out.write("                <div class=\"modal-header\">\n");
      out.write("                    <h5 style=\"color: navy\" class=\"modal-title\" id=\"exampleModalLongTitle\">Uçuş Güncelle</h5>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"row mb-4\">\n");
      out.write("                    <div class=\"col\">\n");
      out.write("                      <div class=\"form-outline\">\n");
      out.write("                          <div id=\"alert\"></div>\n");
      out.write("                        <input type=\"hidden\" name=\"selector\" value=\"update\"></input>\n");
      out.write("                        <input type=\"hidden\" name=\"id\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></input>\n");
      out.write("                        <label style=\"color: navy\" id=\"f-label\" class=\"form-label\" for=\"rol\">Rol<i class=\"text-danger\">*</i></label>\n");
      out.write("                         <select style=\"color: navy\" id=\"f-control\" name=\"rol\" class=\"form-control\" required oninvalid=\"this.setCustomValidity('Lütfen rolü giriniz !!')\" oninput=\"this.setCustomValidity('')\">\n");
      out.write("                            <option id=\"f-option\" class=\"form-control\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.rol}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</option>\n");
      out.write("                            <option id=\"f-option\" class=\"form-control\">Admin</option>\n");
      out.write("                            <option id=\"f-option\" class=\"form-control\">Üye</option>\n");
      out.write("                        </select>\n");
      out.write("                        <label style=\"color: navy\" id=\"f-label\" class=\"form-label\" for=\"tc\">TC Kimlik Numarası<i class=\"text-danger\">*</i></label>\n");
      out.write("                        <input style=\"color: navy\" id=\"f-control\" type=\"text\" pattern='\\d{11}' id=\"tc\" name=\"tc\" class=\"form-control\" required oninvalid=\"this.setCustomValidity('Lütfen 11 haneli TC kimlik numaranızı giriniz !!')\" oninput=\"this.setCustomValidity('')\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.tc}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/>\n");
      out.write("                        <label style=\"color: navy\" id=\"f-label\" class=\"form-label\" for=\"ad\">Ad-Soyad<i class=\"text-danger\">*</i></label>\n");
      out.write("                        <input style=\"color: navy\" id=\"f-control\" type=\"text\" id=\"ad\" name=\"ad\" class=\"form-control\" required oninvalid=\"this.setCustomValidity('Lütfen kullanıcı adınızı giriniz !!')\" oninput=\"this.setCustomValidity('')\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.ad}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/>\n");
      out.write("                        <label style=\"color: navy\" id=\"f-label\" class=\"form-label\" for=\"cinsiyet\">Cinsiyet<i class=\"text-danger\">*</i></label>\n");
      out.write("                        <select style=\"color: navy\" id=\"f-control\" name=\"cinsiyet\" class=\"form-control\" required oninvalid=\"this.setCustomValidity('Lütfen cinsiyetinizi giriniz !!')\" oninput=\"this.setCustomValidity('')\">\n");
      out.write("                            <option id=\"f-option\" class=\"form-control\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.cinsiyet}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</option>\n");
      out.write("                            <option id=\"f-option\" class=\"form-control\">Erkek</option>\n");
      out.write("                            <option id=\"f-option\" class=\"form-control\">Kadın</option>\n");
      out.write("                        </select>\n");
      out.write("                        <label style=\"color: navy\" id=\"f-label\" class=\"form-label\" for=\"yas\">Yaş<i class=\"text-danger\">*</i></label>\n");
      out.write("                        <input style=\"color: navy\" id=\"f-control\" min=\"18\" type=\"number\" id=\"yas\" name=\"yas\" class=\"form-control\" required oninvalid=\"this.setCustomValidity('Boş değer kabul edilmez ve 18 yaşından küçükler üye olamaz !!')\" oninput=\"this.setCustomValidity('')\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.yas}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/>\n");
      out.write("                        <label style=\"color: navy\" id=\"f-label\" class=\"form-label\" for=\"d_tarih\">Doğum Tarihi<i class=\"text-danger\">*</i></label>\n");
      out.write("                        <input style=\"color: navy\" id=\"f-control\" type=\"date\" id=\"d-tarih\" name=\"d_tarih\" class=\"form-control\" required oninvalid=\"this.setCustomValidity('Lütfen doğum tarihinizi giriniz !!')\" oninput=\"this.setCustomValidity('')\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.DTarih}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/>\n");
      out.write("                        <label style=\"color: navy\" id=\"f-label\" class=\"form-label\" for=\"email\">Email<i class=\"text-danger\">*</i></label>\n");
      out.write("                        <input style=\"color: navy\" id=\"f-control\" type=\"email\" id=\"email\" name=\"email\" class=\"form-control\" required oninvalid=\"this.setCustomValidity('Lütfen email adresinizi email formatına uyacak şekilde giriniz !!')\" oninput=\"this.setCustomValidity('')\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.email}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/>\n");
      out.write("                        <label style=\"color: navy\" id=\"f-label\" class=\"form-label\" for=\"sifre\">Şifre<i class=\"text-danger\">*</i></label> <input id=\"checkbox\" type=\"checkbox\"><i style=\"margin-left: 2px;color: navy\">Şifreyi Göster</i></input>\n");
      out.write("                        <input style=\"color: navy\" type=\"password\" id=\"sifre\" name=\"sifre\" class=\"form-control\" required oninvalid=\"this.setCustomValidity('Lütfen şifrenizi giriniz !!')\" oninput=\"this.setCustomValidity('')\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.sifre}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/>\n");
      out.write("                      </div> \n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal-footer\">\n");
      out.write("                <button style=\"color: navy\" id=\"flight_add_btn\" type=\"submit\" class=\"btn btn-success\" onclick=\"return validation();\">Güncelle</button>\n");
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
