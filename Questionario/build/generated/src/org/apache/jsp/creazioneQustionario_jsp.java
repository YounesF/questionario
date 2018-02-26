package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.PreparedStatement;
import java.sql.Connection;

public final class creazioneQustionario_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<!--\n");
      out.write("To change this license header, choose License Headers in Project Properties.\n");
      out.write("To change this template file, choose Tools | Templates\n");
      out.write("and open the template in the editor.\n");
      out.write("-->\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Questionario</title>\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"creaQuestionario\" >\n");
      out.write("            <form action=\"QuestionarioServlet\"> \n");
      out.write("                <span> Domanda numero <span id=\"numeroDomanda\">1</span>:</span><input type=\"button\" id=\"creaDomandaAperta\" value=\"crea una domanda aperta\"><br>\n");
      out.write("                <input type=\"text\" name=\"domanda\" id=\"testoDomanda\" placeholder=\"Testo Domanda\"><br>\n");
      out.write("                <div id=\"risposta1\"><input type=\"text\" name=\"r1\"></div>\n");
      out.write("                <div id=\"risposta2\"><input type=\"text\" name=\"r2\"></div>\n");
      out.write("                <div id=\"risposta3\"><input type=\"text\" name=\"r3\"></div>\n");
      out.write("                <div id=\"risposta4\"><input type=\"text\" name=\"r4\"></div>\n");
      out.write("                <input type=\"submit\" value=\"submit\" class=\"submit\">\n");
      out.write("                <div id=\"limiteRisposte\"></div>\n");
      out.write("            </form>\n");
      out.write("         <input type=\"button\" id=\"aggiungiRisposta\" value=\"aggiungi risposta\"><br>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <script>\n");
      out.write("            /*\n");
      out.write("            //non permette l'inserimento nell'input number numDomande dei caratteri e,+,-\n");
      out.write("            document.querySelector(\"#numDomande\").addEventListener(\"keypress\", function (evt) {\n");
      out.write("                if (evt.which != 8 && evt.which != 0 && evt.which < 48 || evt.which > 57)\n");
      out.write("                {\n");
      out.write("                    evt.preventDefault();\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("            */\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            //aggiunge una casella di risposta al aclick di #aggiungiRisposta\n");
      out.write("            var num = 4;\n");
      out.write("            $('#aggiungiRisposta').on('click', function() {\n");
      out.write("                if(num+1 <= 10){\n");
      out.write("                    $('#risposta' + num).after('<div id=\"risposta' + (num+1) + '\"><input type=\"text\" id=\"r'+(num+1)+'\" name=\"r'+(num+1)+'\"><input type=\"button\" id=\"' + (num+1) + '\" class=\"elimina\" value=\"X\"></div>');\n");
      out.write("                    $('#' + num).remove();\n");
      out.write("                    num++;\n");
      out.write("                }\n");
      out.write("                else {\n");
      out.write("                    $('#limiteRisposte').html('limite massimo di risposte raggiunto');\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("            \n");
      out.write("            //al click di .elimina elimina l'ultima casella di risposta\n");
      out.write("            $('form').on('click', '.elimina' ,function() {\n");
      out.write("                $('#risposta' + this.id).remove();\n");
      out.write("                num--;\n");
      out.write("                $('#r' + num).after('<input type=\"button\" id=\"' + num + '\" class=\"elimina\" value=\"X\">');\n");
      out.write("            });\n");
      out.write("            \n");
      out.write("            //cambia da domanda chiusa a domanda aperta\n");
      out.write("            $('form').on('click', '#creaDomandaAperta' ,function() {\n");
      out.write("                $('form').html('<span> Domanda numero <span id=\"numeroDomanda\">1</span>:</span><input type=\"button\" id=\"creaDomandaChiusa\" value=\"crea una domanda chiusa\"><br><input type=\"text\" id=\"testoDomanda\" placeholder=\"Testo Domanda\"><br>\\n\\\n");
      out.write("                <input type=\"button\" id=\"aggiungiRisposta\" value=\"aggiungi risposta\"><br>\\n\\\n");
      out.write("                <input type=\"submit\" class=\"submit\">');\n");
      out.write("            });\n");
      out.write("            \n");
      out.write("            //cambia da domanda aperta a domanda a risposta multipla\n");
      out.write("            $('form').on('click', '#creaDomandaChiusa' ,function() {\n");
      out.write("                $('form').html('<span> Domanda numero <span id=\"numeroDomanda\">1</span>:</span><input type=\"button\" id=\"creaDomandaAperta\" value=\"crea una domanda aperta\"><br>\\n\\\n");
      out.write("                <input type=\"text\" id=\"testoDomanda\" placeholder=\"Testo Domanda\"><br>\\n\\\n");
      out.write("                <div id=\"risposta1\"><input type=\"text\"></div>\\n\\\n");
      out.write("                <div id=\"risposta2\"><input type=\"text\"></div>\\n\\\n");
      out.write("                <div id=\"risposta3\"><input type=\"text\"></div>\\n\\\n");
      out.write("                <div id=\"risposta4\"><input type=\"text\"></div>\\n\\\n");
      out.write("                <input type=\"button\" id=\"aggiungiRisposta\" value=\"aggiungi risposta\"><br>\\n\\\n");
      out.write("                <input type=\"submit\" class=\"submit\">\\n\\\n");
      out.write("                <div id=\"limiteRisposte\"></div>');\n");
      out.write("            });\n");
      out.write("           \n");
      out.write("            \n");
      out.write("            \n");
      out.write("        </script>\n");
      out.write("    </body>\n");
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
