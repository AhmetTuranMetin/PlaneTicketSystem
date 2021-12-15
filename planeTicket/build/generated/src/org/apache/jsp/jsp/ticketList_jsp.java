package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import DataBases.UserDB;
import Entities.Ticket;
import java.util.List;
import DataBases.TicketDB;

public final class ticketList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_choose;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_otherwise;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_when_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_choose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_otherwise = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_when_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_choose.release();
    _jspx_tagPool_c_otherwise.release();
    _jspx_tagPool_c_when_test.release();
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

    //get user id
    String kullanici_id=null;
    Cookie cookies[] = request.getCookies();
    for (int i = 0; i < cookies.length; i++) {
        if (cookies[i].getName().equals("userId")) {
            kullanici_id = cookies[i].getValue();
            break;
        }
    }
    
    //get user role
    String role = new UserDB().GetUser(Integer.parseInt(kullanici_id)).getRol();
    
    //if not login redirect to index.jsp
    if(session.getAttribute("login")!="OK" || !role.equals("Admin"))
        response.sendRedirect("login.jsp");
    
    List<Ticket> ticketList = new TicketDB().AllList();
    request.setAttribute("ticketList", ticketList);

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf8\">\n");
      out.write("        <link rel=\"icon\" href=\"../images/logo.ico\"/>\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js\"></script>\n");
      out.write("        <script src=\"../js/flight.js\" type=\"text/javascript\"></script>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "menu.jsp", out, false);
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
      out.write("        <link href=\"../styles/general.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    <title>Bilet Listesi</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div id=\"content\">\n");
      out.write("    ");
      if (_jspx_meth_c_choose_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("</div>\n");
      out.write("    \n");
      out.write("<!--Add Flight Modal -->\n");
      out.write("<div class=\"modal fade\" id=\"addTicketModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalCenterTitle\" aria-hidden=\"true\">\n");
      out.write("  <div class=\"modal-dialog modal-dialog-centered\" role=\"document\">\n");
      out.write("    <div class=\"modal-content\">\n");
      out.write("      <div class=\"modal-header\">\n");
      out.write("        <h5 id=\"m-title\" class=\"modal-title\" id=\"exampleModalLongTitle\">Bilet Ekle</h5>\n");
      out.write("        <button id=\"close-modal\" type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("          <span aria-hidden=\"true\">&times;</span>\n");
      out.write("        </button>\n");
      out.write("      </div>\n");
      out.write("        <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/ticket\" method=\"POST\">\n");
      out.write("            <div class=\"modal-body\">\n");
      out.write("                <div class=\"row mb-4\">\n");
      out.write("                    <div class=\"col\">\n");
      out.write("                      <div class=\"form-outline\">\n");
      out.write("                        <input type=\"hidden\" name=\"selector\" value=\"add\"></input>\n");
      out.write("                        <input type=\"hidden\" name=\"redirect\" value=\"admin\"></input>\n");
      out.write("                        <label id=\"f-label\" class=\"form-label\" for=\"ucusId\">Uçuş ID<i class=\"text-danger\">*</i></label>\n");
      out.write("                        <input id=\"t_ucus_id\" type=\"number\" name=\"ucusId\" class=\"form-control\" required oninvalid=\"this.setCustomValidity('Lütfen uçuş id giriniz !!')\" oninput=\"this.setCustomValidity('')\"/>\n");
      out.write("                        <label style=\"position: absolute;left: 180px;top: 2px\" id=\"f-label\" class=\"form-label\" for=\"uyeId\">Üye ID<i class=\"text-danger\">*</i></label>\n");
      out.write("                        <input id=\"t_uye_id\" type=\"number\" name=\"uyeId\" class=\"form-control\" required oninvalid=\"this.setCustomValidity('Lütfen üye id giriniz !!')\" oninput=\"this.setCustomValidity('')\"/>\n");
      out.write("                        <label id=\"f-label\" class=\"form-label\" for=\"koltukNo\">Koltuk Numarası<i class=\"text-danger\">*</i></label>\n");
      out.write("                        <input id=\"t_koltuk_no\" type=\"number\" name=\"koltukNo\" class=\"form-control\" required oninvalid=\"this.setCustomValidity('Lütfen koltuk bilgisini giriniz !!')\" oninput=\"this.setCustomValidity('')\"/>\n");
      out.write("                        <label style=\"position: absolute;left: 180px;top: 72px\" id=\"f-label\" class=\"form-label\" for=\"koltukSira\">Koltuk Sıra Numarası<i class=\"text-danger\">*</i></label>\n");
      out.write("                        <select style=\"color: navy;width: 70px;position: absolute;left: 180px;top: 100px\" id=\"f-control\" name=\"koltukSira\" class=\"form-control\" required oninvalid=\"this.setCustomValidity('Lütfen bilet tipi giriniz !!')\" oninput=\"this.setCustomValidity('')\">\n");
      out.write("                            <option id=\"f-option\" class=\"form-control\"></option>\n");
      out.write("                            <option id=\"f-option\" class=\"form-control\">A</option>\n");
      out.write("                            <option id=\"f-option\" class=\"form-control\">B</option>\n");
      out.write("                            <option id=\"f-option\" class=\"form-control\">C</option>\n");
      out.write("                            <option id=\"f-option\" class=\"form-control\">D</option>\n");
      out.write("                            <option id=\"f-option\" class=\"form-control\">E</option>\n");
      out.write("                            <option id=\"f-option\" class=\"form-control\">F</option>\n");
      out.write("                        </select>\n");
      out.write("                        <label id=\"f-label\" class=\"form-label\" for=\"tip\">Bilet Tipi<i class=\"text-danger\">*</i></label>\n");
      out.write("                        <select style=\"color: navy;width: 135px\" id=\"f-control\" name=\"tip\" class=\"form-control\" required oninvalid=\"this.setCustomValidity('Lütfen bilet tipi giriniz !!')\" oninput=\"this.setCustomValidity('')\">\n");
      out.write("                            <option id=\"f-option\" class=\"form-control\"></option>\n");
      out.write("                            <option id=\"f-option\" class=\"form-control\">Satın Al</option>\n");
      out.write("                            <option id=\"f-option\" class=\"form-control\">Rezervasyon</option>\n");
      out.write("                        </select>\n");
      out.write("                        <label id=\"f-label\" class=\"form-label\" for=\"paket\">Bilet Paketi<i class=\"text-danger\">*</i></label>\n");
      out.write("                        <select style=\"color: navy;width: 118px\" id=\"f-control\" name=\"paket\" class=\"form-control\" required oninvalid=\"this.setCustomValidity('Lütfen paket tipi giriniz !!')\" oninput=\"this.setCustomValidity('')\">\n");
      out.write("                            <option id=\"f-option\" class=\"form-control\"></option>\n");
      out.write("                            <option id=\"f-option\" class=\"form-control\">Standart</option>\n");
      out.write("                            <option id=\"f-option\" class=\"form-control\">Avantaj (Fiyata +30₺)</option>\n");
      out.write("                        </select>\n");
      out.write("                      </div> \n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal-footer\">\n");
      out.write("                <button style=\"color: navy\" type=\"button\" class=\"btn btn-info\" data-dismiss=\"modal\">Kapat</button>\n");
      out.write("                <button style=\"color: navy\" id=\"flight_add_btn\" type=\"submit\" class=\"btn btn-warning\">Ekle</button>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("      </form>  \n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("</div>\n");
      out.write("<!--end modal-->\n");
      out.write("\n");
      out.write("<!--Search TC Flight Modal -->\n");
      out.write("<div class=\"modal fade\" id=\"SearchTc\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalCenterTitle\" aria-hidden=\"true\">\n");
      out.write("  <div class=\"modal-dialog modal-dialog-centered\" role=\"document\">\n");
      out.write("    <div class=\"modal-content\">\n");
      out.write("      <div class=\"modal-header\">\n");
      out.write("        <h5 id=\"m-title\" class=\"modal-title\" id=\"exampleModalLongTitle\">Bilet Ara</h5>\n");
      out.write("        <button id=\"close-modal\" type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("          <span aria-hidden=\"true\">&times;</span>\n");
      out.write("        </button>\n");
      out.write("      </div>\n");
      out.write("        <form action=\"tcFlightSearch.jsp\" method=\"POST\">\n");
      out.write("            <div class=\"modal-body\">\n");
      out.write("                <div class=\"row mb-4\">\n");
      out.write("                    <div class=\"col\">\n");
      out.write("                      <div class=\"form-outline\">\n");
      out.write("                        <label id=\"f-label\" class=\"form-label\" for=\"tc\">TC Kimlik Numarası<i class=\"text-danger\">*</i></label>\n");
      out.write("                        <input id=\"f-control\" type=\"text\" id=\"tc\" name=\"tc\" placeholder=\"11 haneli T.C. kimlik numarasını giriniz\" pattern='\\d{11}' class=\"form-control\" required oninvalid=\"this.setCustomValidity('Lütfen 11 haneli TC kimlik numaranızı giriniz !!')\" oninput=\"this.setCustomValidity('')\"/>\n");
      out.write("                      </div> \n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal-footer\">\n");
      out.write("                <button style=\"color: navy\" type=\"button\" class=\"btn btn-info\" data-dismiss=\"modal\">Kapat</button>\n");
      out.write("                <button style=\"color: navy\" id=\"flight_add_btn\" type=\"submit\" class=\"btn btn-light\">Ara</button>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("      </form>  \n");
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

  private boolean _jspx_meth_c_choose_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_choose_0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _jspx_tagPool_c_choose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_choose_0.setPageContext(_jspx_page_context);
    _jspx_th_c_choose_0.setParent(null);
    int _jspx_eval_c_choose_0 = _jspx_th_c_choose_0.doStartTag();
    if (_jspx_eval_c_choose_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("            ");
        if (_jspx_meth_c_when_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("            ");
        if (_jspx_meth_c_otherwise_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("    ");
        int evalDoAfterBody = _jspx_th_c_choose_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_choose_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
      return true;
    }
    _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
    return false;
  }

  private boolean _jspx_meth_c_when_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_when_0 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _jspx_tagPool_c_when_test.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_when_0.setPageContext(_jspx_page_context);
    _jspx_th_c_when_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
    _jspx_th_c_when_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${empty ticketList}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_when_0 = _jspx_th_c_when_0.doStartTag();
    if (_jspx_eval_c_when_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                <button id=\"flight_btn\" style=\"margin-left: 200%;margin-top: 70%\" type=\"button\" class=\"btn btn-outline-warning\" data-toggle=\"modal\" data-target=\"#addTicketModal\">Yeni Bilet Ekle</button>\n");
        out.write("                <h2 style='position:absolute;left:48%;color:goldenrod;top:37%;font-size:330%'>Bilet Yok</h2>\n");
        out.write("            ");
        int evalDoAfterBody = _jspx_th_c_when_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_when_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
      return true;
    }
    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
    return false;
  }

  private boolean _jspx_meth_c_otherwise_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:otherwise
    org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_c_otherwise_0 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _jspx_tagPool_c_otherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
    _jspx_th_c_otherwise_0.setPageContext(_jspx_page_context);
    _jspx_th_c_otherwise_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
    int _jspx_eval_c_otherwise_0 = _jspx_th_c_otherwise_0.doStartTag();
    if (_jspx_eval_c_otherwise_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                <button id=\"flight_btn\" style=\"margin-left: 114%;margin-top: 6%\" type=\"button\" class=\"btn btn-outline-warning\" data-toggle=\"modal\" data-target=\"#addTicketModal\">Yeni Bilet Ekle</button>\n");
        out.write("                <button style=\"position: absolute;margin-left: 20%;top: 84px\" type=\"button\" class=\"btn btn-outline-light\" data-toggle=\"modal\" data-target=\"#SearchTc\">\n");
        out.write("                    <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" fill=\"currentColor\" class=\"bi bi-search\" viewBox=\"0 0 16 16\">\n");
        out.write("                        <path d=\"M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z\"></path>\n");
        out.write("                    </svg>\n");
        out.write("                Ara\n");
        out.write("                </button>\n");
        out.write("                <table id=\"bs-table\" class=\"table table-striped table-dark\">\n");
        out.write("                    <thead>\n");
        out.write("                        <tr class=\"bg-primary\">\n");
        out.write("                        <th scope=\"col\">#ID</th>\n");
        out.write("                        <th scope=\"col\">UÇUŞ ID</th>\n");
        out.write("                        <th scope=\"col\">ÜYE ID</th>\n");
        out.write("                        <th scope=\"col\">KOLTUK NUMARASI</th>\n");
        out.write("                        <th scope=\"col\">BİLET TİPİ</th>\n");
        out.write("                        <th scope=\"col\">BİLET PAKETİ</th>\n");
        out.write("                        <th scope=\"col\">İŞLEMLER</th>\n");
        out.write("                      </tr>\n");
        out.write("                    </thead>\n");
        out.write("                    <tbody>\n");
        out.write("                        ");
        if (_jspx_meth_c_forEach_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_otherwise_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("                    </tbody>\n");
        out.write("                </table>\n");
        out.write("            ");
        int evalDoAfterBody = _jspx_th_c_otherwise_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_otherwise_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_0);
      return true;
    }
    _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_0);
    return false;
  }

  private boolean _jspx_meth_c_forEach_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_otherwise_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_otherwise_0);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ticketList}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("list");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                            <tr>\n");
          out.write("                        <th scope=\"row\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</th>\n");
          out.write("                        <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.ucusId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                        <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.uyeId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                        <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.koltukNo}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                        <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.tip}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                        <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.paket}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                        <td><a href=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("/ticket?id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("&selector=delete&ucusId=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.ucusId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("&redirect=admin\"><button type=\"button\" class=\"btn btn-outline-danger\">Sil</button></a><a href=\"ticketUpdate.jsp?id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"><button style=\"margin-left: 12%\" type=\"button\" class=\"btn btn-outline-success\">Güncelle</button></a></td>\n");
          out.write("                      </tr>\n");
          out.write("                        ");
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
