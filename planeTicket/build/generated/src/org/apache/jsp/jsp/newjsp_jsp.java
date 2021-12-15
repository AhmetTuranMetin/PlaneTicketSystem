package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class newjsp_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<head>\n");
      out.write("    <style>\n");
      out.write("        table,th,td{\n");
      out.write("            border: 2px solid black;border-collapse: collapse;\n");
      out.write("            border-color: goldenrod;\n");
      out.write("            background-color: navy;\n");
      out.write("            color: goldenrod;\n");
      out.write("        }\n");
      out.write("        td{\n");
      out.write("            text-align: left\n");
      out.write("        }\n");
      out.write("        h2{\n");
      out.write("            color: navy\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <h2>Rezervasyon işlemi gerçekleşmiştir. Bilgileriniz ATM Airlines tarafından güvence altındadır. Detaylı bilgi aşağıda tarafınıza iletilmiştir. Bizi tercih ettiğiniz için teşekkür ederiz ve iyi yolculuklar dileriz.</h2>\n");
      out.write("    <h2><strong>Uçuş saatinizden en az 6 saat önce ödeme işlemini gerçekleştirmeniz önemle rica olunur.</strong></h2>\n");
      out.write("    <table style=\"width: 100%\">\n");
      out.write("        <tr>\n");
      out.write("            <th>Bilet Sahibi</th>\n");
      out.write("            <th>Kalkış Şehri</th>\n");
      out.write("            <th>Varış Şehri</th>\n");
      out.write("            <th>Kalkış Havaalanı</th>\n");
      out.write("            <th>Varış Havaalanı</th>\n");
      out.write("            <th>Tarih</th>\n");
      out.write("            <th>Saat</th>\n");
      out.write("            <th>Paket</th>\n");
      out.write("            <th>Koltuk No</th>\n");
      out.write("            <th>Bilet Tipi</th>\n");
      out.write("            <th>Firma</th>\n");
      out.write("            <th>Fiyat</th>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("            <td>test1</th>\n");
      out.write("            <td>test2ghhgjhkhkjh</td>\n");
      out.write("            <td>fgfgfgfgfgfgfgf</td>\n");
      out.write("            <td>fgfgfdgfgfdgf</td>\n");
      out.write("            <td>fgfgfdgfgfdgf</td>\n");
      out.write("            <td>fgfgfdgfgfdgf</td>\n");
      out.write("            <td>fgfgfdgfgfdgf</td>\n");
      out.write("            <td>fgfgfdgfgfdgf</td>\n");
      out.write("            <td>fgfgfdgfgfdgf</td>\n");
      out.write("            <td>fgfgfdgfgfdgf</td>\n");
      out.write("            <td>fgfgfdgfgfdgf</td>\n");
      out.write("            <td>fgfgfdgfgfdgf</td>\n");
      out.write("        </tr>\n");
      out.write("    </table>\n");
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
