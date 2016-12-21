/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Javier Argente Micó
 */
@WebServlet(urlPatterns = {"/Planes"})
public class Planes extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Planes</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Planes at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String CONTENT_TYPE = "text/html";
        String password, dni;

        response.setContentType(CONTENT_TYPE);
        ServletOutputStream out = response.getOutputStream();

        dni = request.getParameter("dni");
        password = request.getParameter("password");

        if (!"".equals(dni)) {

            if (password.equals("ffin2016")) {

                out.println("<html>");
                out.println("<head>");
                out.println("<title>no_nombre");
                out.println("</title>");
                out.println("<meta charset=\"UTF-8\">");
                out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
                out.println("</head>");
                out.println("<body>");
                out.println("<form id=\"form2\" name=\"form2\" method=\"post\" action=\"Votacion\">");
                
                out.println("<img src=\"esqui.png\" alt=\"esqui\">");
                out.println("<input type=" + "radio" + " name=" + "eleccion" + " value=" + "esqui" + "> Esqui");
                out.println("<br/> <br/>");
                out.println("<big>Nos vamos a esquiar. Saldremos en coches particulares y pasaremos 2 dias en las pistas de Astun (Huesca). Tendremos un forfait para un dia y pension completa para dos dias en un alojamiento rural. El precio total es de 160 euros.</big>");
                out.println("<br/> <br/>");
                out.println("<br/> <br/>");
                
                out.println("<img src=\"casa_rural.png\" alt=\"esqui\">");
                out.println("<input type=" + "radio" + " name=" + "eleccion" + " value=" + "casa_rural" + "> casa rural");
                out.println("<br/> <br/>");
                out.println("<big>Una bonita casa rural a las afueras de Valencia con todo lujo de detalles durante 3 dias. Todos estos lujos por 150 euros.</big>");
                out.println("<br/> <br/>");
                out.println("<br/> <br/>");
                
                out.println("<img src=\"amsterdam.png\" alt=\"esqui\">");
                out.println("<input type=" + "radio" + " name=" + "eleccion" + " value=" + "amsterdam" + "> amsterdam");
                out.println("<br/> <br/>");
                out.println("<big>Un gran e inolvidabe viaje a amsterdam donde estaremos probando sus deliciosos brownies durante 5 dias por 250.</big>");
                out.println("<br/> <br/>");
                out.println("<br/> <br/>");
                
                out.println("<img src=\"ETSE.png\" alt=\"esqui\">");
                out.println("<input type=" + "radio" + " name=" + "eleccion" + " value=" + "ETSE" + "> ETSE");
                out.println("<br/> <br/>");
                out.println("<big>Un gran dia en la ETSE haciendo trabajos, super divertido y todo esto GRATIS.</big>");
                out.println("<br/> <br/>");
                
                out.println("<input type=\"submit\" name=\"Submit\" value=\"Votar\" />");
                out.println("</form>");
                out.println("</body>");
                out.println("</html>");

            } else {

                out.println("<html>");
                out.println("<head>");
                out.println("<title>no_nombre");
                out.println("</title>");
                out.println("<meta charset=\"UTF-8\">");
                out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
                out.println("</head>");
                out.println("<body>");
                out.println("<big>Clave incorrecta</big>");
                out.println("<br/> <br/>");
                out.println("<a href=\"inicio.html\"> Volver al test </a>");
                out.println("</body>");
                out.println("</html>");

            }

        } else {

            out.println("<html>");
            out.println("<head>");
            out.println("<title>no_nombre");
            out.println("</title>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<big>No ha escrito ningun DNI</big>");
            out.println("<br/> <br/>");
            out.println("<a href=\"inicio.html\"> Volver al test </a>");
            out.println("</body>");
            out.println("</html>");

        }

        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
