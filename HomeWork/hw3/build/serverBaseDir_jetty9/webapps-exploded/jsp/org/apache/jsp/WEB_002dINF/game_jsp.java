package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class game_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <!--<link rel=\"stylesheet\" type=\"text/css\" href=\"app.css\">-->\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css?family=Oswald|Roboto+Condensed\" rel=\"stylesheet\">\n");
      out.write("    <title>Resource Miner</title>\n");
      out.write("    <style media=\"screen\">\n");
      out.write("    header{\n");
      out.write("font-family: 'Oswald', sans-serif;\n");
      out.write("}\n");
      out.write("body{\n");
      out.write("font-family: 'Roboto Condensed', sans-serif;\n");
      out.write("}\n");
      out.write(".story-book{\n");
      out.write("height: 5.5em;\n");
      out.write("background-color: black;\n");
      out.write("color: white;\n");
      out.write("overflow: auto;\n");
      out.write("\n");
      out.write("}\n");
      out.write(".manual-generator{\n");
      out.write("display: flex;\n");
      out.write("justify-content: center;\n");
      out.write("}\n");
      out.write(".auto-generator-list{\n");
      out.write("display: flex;\n");
      out.write("width: auto;\n");
      out.write("justify-content: center;\n");
      out.write("}\n");
      out.write(".generator-container{\n");
      out.write("margin: 1em;\n");
      out.write("padding-left: 1em;\n");
      out.write("padding-right: 1em;\n");
      out.write("padding-bottom: 1em;\n");
      out.write("border-width: thin;\n");
      out.write("border-style: solid;\n");
      out.write("}\n");
      out.write(".gen-con-bottom-row-info{\n");
      out.write("padding-top: 5em;\n");
      out.write("display: flex;\n");
      out.write("}\n");
      out.write("#buy_button{\n");
      out.write("position: relative;\n");
      out.write("right: 0px;\n");
      out.write("}\n");
      out.write("footer{\n");
      out.write("font-family: 'Oswald', sans-serif;\n");
      out.write("position: absolute;\n");
      out.write("bottom: 0px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("    </style>\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("      generators = ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${genjson}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(";\n");
      out.write("      for(i = 0 ; i < generators.length ; i++){\n");
      out.write("        generators[i].type = 'autonomous';\n");
      out.write("        generators[i].unlockValue = generators[i].unlockAt;\n");
      out.write("        generators[i].quantity = 0;\n");
      out.write("        delete generators[i].unlockAt;\n");
      out.write("        delete generators[i].id;\n");
      out.write("      }\n");
      out.write("\n");
      out.write("      stories = ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${storyjson}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(";\n");
      out.write("      for(i = 0 ; i < stories.length ; i++){\n");
      out.write("        stories[i].triggeredAt = stories[i].triggerAt;\n");
      out.write("        stories[i].state = 'hidden';\n");
      out.write("        delete stories[i].triggerAt;\n");
      out.write("        delete stories[i].id;\n");
      out.write("      }\n");
      out.write("\n");
      out.write("      var backInfo = {}\n");
      out.write("      backInfo.example = 'Hello custom element';\n");
      out.write("  \t\tbackInfo.counter = 0;\n");
      out.write("      backInfo.generators = generators;\n");
      out.write("      backInfo.story = stories;\n");
      out.write("      console.log(backInfo);\n");
      out.write("\n");
      out.write("    </script>\n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("    <header>\n");
      out.write("      <h1>Resource Miner</h1>\n");
      out.write("    </header>\n");
      out.write("    <game-story-book></game-story-book>\n");
      out.write("    <div class=\"generators\">\n");
      out.write("      <div class=\"manual-generator\">\n");
      out.write("        <game-counter></game-counter>\n");
      out.write("        <game-button></game-button>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"auto-generator-list\">\n");
      out.write("        <game-generator data-id=\"0\"></game-generator>\n");
      out.write("        <game-generator data-id=\"1\"></game-generator>\n");
      out.write("        <game-generator data-id=\"2\"></game-generator>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("    <footer>\n");
      out.write("      <p>Created by: Carlos Larios-solis</p>\n");
      out.write("    </footer>\n");
      out.write("    <script type=\"text/javascript\" src=\"/app.bundle.js\"></script>\n");
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
