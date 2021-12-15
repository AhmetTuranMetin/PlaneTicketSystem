package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class menu_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <link href=\"../styles/menu.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\" integrity=\"sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"//cdn.jsdelivr.net/npm/sweetalert2@11\"></script>\n");
      out.write("        <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>\n");
      out.write("<body>\n");
      out.write("    <div class=\"area\">\n");
      out.write("        <a href=\"adminIndex.jsp\"><img style=\"position: absolute;left: 9%\" src=\"../images/logo.ico\" width=\"180px\" height=\"180px\"></img></a>\n");
      out.write("        <ui class=\"mainMenu\">\n");
      out.write("             <li class=\"item\">\n");
      out.write("                <a href=\"adminIndex.jsp\"><span style=\"margin-left: -7%;margin-right: 2%\" class=\"fas fa-home\"></span>Anasayfa</a>\n");
      out.write("            </li>\n");
      out.write("            <li class=\"item\">\n");
      out.write("                <a href=\"companyList.jsp\"><span style=\"margin-left: -10%;margin-right: 2%\" class=\"fas fa-briefcase\"></span>Şirketler</a>\n");
      out.write("            </li>\n");
      out.write("            <li class=\"item\">\n");
      out.write("                <a href=\"flightList.jsp\"><span style=\"margin-left: -18%;margin-right: 2%\" class=\"fas fa-plane-departure\"></span>Uçuşlar</a>\n");
      out.write("            </li>\n");
      out.write("            <li class=\"item\" id=\"subMenuItem\">\n");
      out.write("                <i class=\"first_menu_item\"><span style=\"margin-left: -41%;margin-right: 2%\" class=\"fas fa-chevron-down\"></span>Bilet</i>\n");
      out.write("                <div class=\"subMenu\">\n");
      out.write("                    <a href=\"ticketList.jsp\"><span style=\"margin-left: -16%;margin-right: 2%\" class=\"fas fa-ticket-alt\"></span>Biletler</a>\n");
      out.write("                    <a href=\"seatList.jsp\"><span style=\"margin-left: -5%\" class=\"fas fa-chair\"></span>Koltuklar</a>\n");
      out.write("                </div>\n");
      out.write("            </li>\n");
      out.write("            <li class=\"item\">\n");
      out.write("                <a href=\"userList.jsp\"><span style=\"margin-left: -25%;margin-right: 2%\" class=\"fas fa-user-alt\"></span>Üyeler</a>\n");
      out.write("            </li>\n");
      out.write("        </ui>\n");
      out.write("    </div>\n");
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
