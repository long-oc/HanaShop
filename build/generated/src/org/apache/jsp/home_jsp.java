package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Dieu Dao Page</title\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header>\n");
      out.write("            <div class=\"drop-down\">\n");
      out.write("                <span>\n");
      out.write("                <i class=\"nav-menu\">\n");
      out.write("\n");
      out.write("                </i>\n");
      out.write("                DANH MỤC SẢN PHẨM\n");
      out.write("                </span>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </header>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("<style>\n");
      out.write("    * {\n");
      out.write("        margin: 0;\n");
      out.write("        padding: 0;\n");
      out.write("\n");
      out.write("    }\n");
      out.write("    body{ background-color: #e9edf0;}\n");
      out.write("\n");
      out.write("    header{\n");
      out.write("        position: fixed;\n");
      out.write("        background-color: #008848;\n");
      out.write("        min-width: 1200px;\n");
      out.write("        height: 50px;\n");
      out.write("        display: block;\n");
      out.write("        padding-left: calc((100% - 1200px)/2);\n");
      out.write("        padding-right: calc((100% - 1200px)/2);\n");
      out.write("\n");
      out.write("    }\n");
      out.write("    .nav-menu{\n");
      out.write("        background-image:  url(\"https://cdn.tgdd.vn/bachhoaxanh/www/Content/images/desktop/bhxdesk@2x.v202101041331.png\");\n");
      out.write("        background-repeat: no-repeat;\n");
      out.write("        background-size: 500px auto;\n");
      out.write("        display: inline-block;\n");
      out.write("        height: 30px;\n");
      out.write("        width: 30px;\n");
      out.write("        line-height: 30px;\n");
      out.write("        vertical-align: middle;\n");
      out.write("    }\n");
      out.write("    .drop-down{\n");
      out.write("        overflow: scroll;\n");
      out.write("        position: relative;\n");
      out.write("        padding-top: 20px;\n");
      out.write("        background-color: white;\n");
      out.write("        width:207.15px;\n");
      out.write("        height: 1200px;;\n");
      out.write("        display: block;\n");
      out.write("        padding: 10px 10px 10px 35px;\n");
      out.write("        border-bottom: 1px solid #e5e5e5;\n");
      out.write("        margin-bottom: 10px;\n");
      out.write("        color: #656565;\n");
      out.write("        position: relative;\n");
      out.write("        text-align: center;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("</style>");
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
