package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entities.Company;
import DataBases.CompanyDB;

public final class companyUpdate_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    Company company = new CompanyDB().GetCompany(id);
    request.setAttribute("company", company);

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("         <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js\"></script>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "menu.jsp", out, false);
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\n");
      out.write("        <link href=\"../styles/general.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    <title>Firma Güncelle</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div id=\"update-body\">\n");
      out.write("    <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/company\" method=\"POST\">\n");
      out.write("            <div class=\"modal-body\">\n");
      out.write("                <div class=\"modal-header\">\n");
      out.write("                    <h5 style=\"color: navy\" class=\"modal-title\" id=\"exampleModalLongTitle\">Firma Güncelle</h5>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"row mb-4\">\n");
      out.write("                    <div class=\"col\">\n");
      out.write("                      <div class=\"form-outline\">\n");
      out.write("                        <input type=\"hidden\" name=\"selector\" value=\"update\"></input>\n");
      out.write("                        <input type=\"hidden\" name=\"id\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${company.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></input>\n");
      out.write("                        <label style=\"color: navy\" class=\"form-label\" for=\"firmaIsim\">Firma Adı<i class=\"text-danger\">*</i></label>\n");
      out.write("                        <input style=\"color: navy\" type=\"text\" id=\"firmaIsim\" name=\"firmaIsim\" class=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${company.isim}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required oninvalid=\"this.setCustomValidity('Lütfen firma ismi giriniz !!')\" oninput=\"this.setCustomValidity('')\"/>\n");
      out.write("                      </div> \n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal-footer\">\n");
      out.write("                <button style=\"color: navy\" id=\"flight_add_btn\" type=\"submit\" class=\"btn btn-success\">Güncelle</button>\n");
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
