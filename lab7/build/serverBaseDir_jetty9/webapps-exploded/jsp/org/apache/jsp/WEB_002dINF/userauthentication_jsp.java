package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class userauthentication_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("  <head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <title>Incremental Game</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"../app.css\">\n");
      out.write("      <style media=\"screen\">\n");
      out.write("      body{\n");
      out.write("        background-color: #7FFF00;\n");
      out.write("      }\n");
      out.write("\n");
      out.write("      #wrap{\n");
      out.write("        float: left;\n");
      out.write("      }\n");
      out.write("      .add-event{\n");
      out.write("        float: left;\n");
      out.write("      }\n");
      out.write("      .event-table{\n");
      out.write("        float: right;\n");
      out.write("        text-align: left;\n");
      out.write("        padding-left: 100px;\n");
      out.write("      }\n");
      out.write("\n");
      out.write("      th, td{\n");
      out.write("        border: 1px solid #00FFFF;\n");
      out.write("        padding: 10px;\n");
      out.write("      }\n");
      out.write("      </style>\n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("    <div id=\"wrap\">\n");
      out.write("      <div class=\"add-event\">\n");
      out.write("        <form method=\"POST\">\n");
      out.write("          <label for=\"username\">User Name</label>\n");
      out.write("          <input type=\"text\" name=\"username\" placeholder=\"admin\">\n");
      out.write("          <label for=\"password\">password</label>\n");
      out.write("          <input type=\"text\" name=\"password\" placeholder=\"cs3220password\">\n");
      out.write("          <button>Log-in</button>\n");
      out.write("        </form>\n");
      out.write("      </dizv>\n");
      out.write("      <div class=\"event-table\">\n");
      out.write("\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </body>\n");
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
