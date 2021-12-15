package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entities.Company;
import DataBases.CompanyDB;
import java.util.List;
import DataBases.FlightDB;
import Entities.Flight;

public final class flightUpdate_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
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
      response.setContentType("text/html;charset=utf8");
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!--get update information-->\n");

    //if not login redirect to index.jsp
    if(session.getAttribute("login")!="OK"){
        response.sendRedirect("login.jsp");
        return;
    }
    
    int id = Integer.parseInt(request.getParameter("id"));
    Flight flight = new FlightDB().GetFlight(id);
    request.setAttribute("flight", flight);

      out.write('\n');
      out.write('\n');

    List<Company> companyList = new CompanyDB().AllList();
    request.setAttribute("companyList", companyList);

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf8\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js\"></script>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "menu.jsp", out, false);
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\n");
      out.write("        <script src=\"../js/flight.js\" type=\"text/javascript\"></script>\n");
      out.write("        <link href=\"../styles/general.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    <title>Uçuş Güncelle</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div id=\"update-body\">\n");
      out.write("    <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/flight\" method=\"POST\">\n");
      out.write("            <div class=\"modal-body\">\n");
      out.write("                <div class=\"modal-header\">\n");
      out.write("                    <h5 style=\"color: navy\" class=\"modal-title\" id=\"exampleModalLongTitle\">Uçuş Güncelle</h5>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"row mb-4\">\n");
      out.write("                    <div class=\"col\">\n");
      out.write("                      <div class=\"form-outline\">\n");
      out.write("                        <div id=\"alert\"></div>\n");
      out.write("                        <input type=\"hidden\" name=\"selector\" value=\"update\"></input>\n");
      out.write("                        <input type=\"hidden\" name=\"id\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${flight.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></input>\n");
      out.write("                        <label style=\"color: navy\" class=\"form-label\" for=\"kalkis\">Kalkış Yeri<i class=\"text-danger\">*</i></label>\n");
      out.write("                        <input style=\"color: navy\" type=\"text\" id=\"kalkis\" name=\"kalkis\" class=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${flight.kalkis}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required oninvalid=\"this.setCustomValidity('Lütfen kalkış yeri giriniz !!')\" oninput=\"this.setCustomValidity('')\"/>\n");
      out.write("                        <label style=\"color: navy\" class=\"form-label\" for=\"varis\">Varış Yeri<i class=\"text-danger\">*</i></label>\n");
      out.write("                        <input style=\"color: navy\" type=\"text\" id=\"varis\" name=\"varis\" class=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${flight.varis}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required oninvalid=\"this.setCustomValidity('Lütfen varış yeri giriniz !!')\" oninput=\"this.setCustomValidity('')\"/>\n");
      out.write("                        <label style=\"color: navy\" class=\"form-label\" for=\"tarih\">Tarih<i class=\"text-danger\">*</i></label>\n");
      out.write("                        <input style=\"color: navy\" type=\"date\" id=\"tarih\" name=\"tarih\" class=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${flight.tarih}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required oninvalid=\"this.setCustomValidity('Lütfen tarih giriniz !!')\" oninput=\"this.setCustomValidity('')\"/>\n");
      out.write("                        <label style=\"color: navy\" class=\"form-label\" for=\"saat\">Saat<i class=\"text-danger\">*</i></label>\n");
      out.write("                        <input style=\"color: navy\" type=\"time\" id=\"saat\" name=\"saat\" class=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${flight.saat}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required oninvalid=\"this.setCustomValidity('Lütfen saat giriniz !!')\" oninput=\"this.setCustomValidity('')\"/>\n");
      out.write("                        <label style=\"color: navy\" class=\"form-label\" for=\"kalkisHavaalani\">Kalkış Havaalanı<i class=\"text-danger\">*</i></label>\n");
      out.write("                        <input style=\"color: navy\" type=\"text\" id=\"kalkisHavaalani\" name=\"kalkisHavaalani\" class=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${flight.kalkisHavaalani}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required oninvalid=\"this.setCustomValidity('Lütfen kalkış havaalanı giriniz !!')\" oninput=\"this.setCustomValidity('')\"/>\n");
      out.write("                        <label style=\"color: navy\" class=\"form-label\" for=\"varisHavaalani\">Varış Havaalanı<i class=\"text-danger\">*</i></label>\n");
      out.write("                        <input style=\"color: navy\" type=\"text\" id=\"varisHavaalani\" name=\"varisHavaalani\" class=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${flight.varisHavaalani}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required oninvalid=\"this.setCustomValidity('Lütfen varış havaalanı giriniz !!')\" oninput=\"this.setCustomValidity('')\"/>\n");
      out.write("                        <label style=\"color: navy\" class=\"form-label\" for=\"fiyat\">Fiyat<i class=\"text-danger\">*</i></label>\n");
      out.write("                        <input style=\"color: navy\" type=\"text\" id=\"fiyat\" pattern='\\d.*' name=\"fiyat\" class=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${flight.fiyat}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required oninvalid=\"this.setCustomValidity('Lütfen fiyat giriniz !!')\" oninput=\"this.setCustomValidity('')\"/>\n");
      out.write("                        <label style=\"color: navy\" class=\"form-label\" for=\"firma\">Firma<i class=\"text-danger\">*</i></label>\n");
      out.write("                        <select style=\"color: navy\" id=\"f-control\" id=\"firma\" name=\"firma\" class=\"form-control\" required oninvalid=\"this.setCustomValidity('Lütfen firma giriniz !!')\" oninput=\"this.setCustomValidity('')\">\n");
      out.write("                            <option id=\"f-option\" class=\"form-control\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${flight.firma}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</option>\n");
      out.write("                            ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                        </select>\n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${companyList}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("list");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                <option id=\"f-option\" class=\"form-control\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.isim}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</option>\n");
          out.write("                            ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
