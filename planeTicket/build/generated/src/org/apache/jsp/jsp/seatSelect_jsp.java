package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import DataBases.SeatDB;
import Entities.Seat;
import java.util.List;

public final class seatSelect_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");

    //if not login redirect to index.jsp
    if(session.getAttribute("login")!="OK"){
        response.sendRedirect("login.jsp");
        return;
    }
    
    String ucusId = request.getParameter("ucusId");
    String uyeId = request.getParameter("uyeId");
    String tip = request.getParameter("tip");
    String paket = request.getParameter("paket");
    request.setAttribute("ucusId", ucusId);
    request.setAttribute("uyeId", uyeId);
    request.setAttribute("tip", tip);
    request.setAttribute("paket", paket);
    
    List<Seat> seats = new SeatDB().GetList(Integer.parseInt(ucusId));
    request.setAttribute("seats", seats);

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"../js/seat.js\" type=\"text/javascript\"></script>\n");
      out.write("        <link href=\"../styles/seat.css\" rel=\"stylesheet\" type=\"text/css\"/>  \n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
      out.write("        <link href=\"../styles/userfooter.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "userMenu.jsp", out, false);
      out.write("\n");
      out.write("    <title>Bilet Seç</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div id=\"account-body\">\n");
      out.write("        <div hidden id=\"seats\">");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("</div>\n");
      out.write("\n");
      out.write("        <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/jsp/cardPage.jsp\">\n");
      out.write("            <input type=\"hidden\" name=\"ucusId\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ucusId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></input>\n");
      out.write("            <input type=\"hidden\" name=\"uyeId\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uyeId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></input>\n");
      out.write("            <input type=\"hidden\" name=\"tip\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tip}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></input>\n");
      out.write("            <input type=\"hidden\" name=\"paket\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${paket}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></input>\n");
      out.write("            <input type=\"hidden\" name=\"selector\" value=\"addSeatSelect\"></input>\n");
      out.write("            <div class=\"modal-body\">\n");
      out.write("                <div class=\"modal-header\">\n");
      out.write("                    <h5 style=\"color: navy\" class=\"modal-title\" id=\"exampleModalLongTitle\">Koltuk Seç</h5>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"row mb-4\">\n");
      out.write("                    <div class=\"col\">\n");
      out.write("                      <div class=\"form-outline\">\n");
      out.write("                        <label id=\"f-label\" class=\"form-label\" for=\"koltukNo\">Koltuk Numarası<i class=\"text-danger\">*</i></label>\n");
      out.write("                        <input id=\"t_koltuk_no\" type=\"number\" name=\"koltukNo\" class=\"form-control\" required oninvalid=\"this.setCustomValidity('Lütfen koltuk bilgisini giriniz !!')\" oninput=\"this.setCustomValidity('')\"/>\n");
      out.write("                        <label style=\"position: absolute;left: 180px;top: 0px\" id=\"f-label\" class=\"form-label\" for=\"koltukSira\">Koltuk Sıra Numarası<i class=\"text-danger\">*</i></label>\n");
      out.write("                        <select style=\"color: navy;width: 70px;position: absolute;left: 180px;top: 32px\" id=\"f-control\" name=\"koltukSira\" class=\"form-control\" required oninvalid=\"this.setCustomValidity('Lütfen koltuk sırası giriniz !!')\" oninput=\"this.setCustomValidity('')\">\n");
      out.write("                            <option id=\"f-option\" class=\"form-control\"></option>\n");
      out.write("                            <option id=\"f-option\" class=\"form-control\">A</option>\n");
      out.write("                            <option id=\"f-option\" class=\"form-control\">B</option>\n");
      out.write("                            <option id=\"f-option\" class=\"form-control\">C</option>\n");
      out.write("                            <option id=\"f-option\" class=\"form-control\">D</option>\n");
      out.write("                            <option id=\"f-option\" class=\"form-control\">E</option>\n");
      out.write("                            <option id=\"f-option\" class=\"form-control\">F</option>\n");
      out.write("                        </select><br>\n");
      out.write("                        <div id=\"alert\"></div>\n");
      out.write("                      </div> \n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal-footer\">\n");
      out.write("                <button style=\"position: absolute;left: 2%\" id=\"flight_add_btn\" type=\"button\" class=\"btn btn-success\" data-toggle=\"modal\" data-target=\"#seatsModal\">Koltuk Durumu</button>\n");
      out.write("                <button id=\"flight_add_btn\" type=\"submit\" class=\"btn btn-success\" onclick=\"return validation();\">Tamam</button>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("      </form>  \n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<!--begin::modal-->\n");
      out.write("<div class=\"modal fade\" id=\"seatsModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalCenterTitle\" aria-hidden=\"true\">\n");
      out.write("  <div class=\"modal-dialog modal-dialog-centered\" role=\"document\">\n");
      out.write("    <div class=\"modal-content\">\n");
      out.write("      <div class=\"modal-header\">\n");
      out.write("          <h5 style=\"color: gold\" id=\"m-title\" class=\"modal-title\" id=\"exampleModalLongTitle\">Koltuklar</h5>\n");
      out.write("        <button style=\"color: gold\" id=\"close-modal\" type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("          <span aria-hidden=\"true\">&times;</span>\n");
      out.write("        </button>\n");
      out.write("      </div>\n");
      out.write("            <div class=\"modal-body\">\n");
      out.write("                <div class=\"row mb-4\">\n");
      out.write("                    <div class=\"col\">\n");
      out.write("                      <div class=\"form-outline\">\n");
      out.write("                        <div class=\"seat-area\"></div>\n");
      out.write("                      </div> \n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("</div>\n");
      out.write("<!--end modal-->\n");
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
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${seats}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("seats");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${seats.no}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(';');
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
