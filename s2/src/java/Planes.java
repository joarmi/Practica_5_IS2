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
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Javier Argente Micó
 */
@WebServlet(urlPatterns = {"/Planes"})
public class Planes extends HttpServlet {

    private Connection conexionBD;

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

        String bd = "jdbc:mysql://localhost/practica_5";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexionBD = DriverManager.getConnection(bd, "root", "ruzizeli");
        } catch (Exception e) {
            System.out.println("Error de conexión");
        }

        String CONTENT_TYPE = "text/html";
        String password, dni;

        Integer resultadoInt = null;
        Integer resultadoInt2 = null;

        response.setContentType(CONTENT_TYPE);
        ServletOutputStream out = response.getOutputStream();

        dni = request.getParameter("dni");
        password = request.getParameter("password");

        if (!"".equals(dni)) {          //dnis validos: 1,2,3,4

            ResultSet resultados = null;
            try {
                String con;
                Statement s = conexionBD.createStatement();
                con = "SELECT COUNT(*) FROM `usuarios` WHERE   dni='" + dni + "'";
                resultados = s.executeQuery(con);

                while (resultados.next()) {
                    resultadoInt = resultados.getInt(1);
                }

            } catch (Exception e) {
                System.out.println("Error en la petición a la BD");
            }

            //------------------------------------------------------------------
            ResultSet resultados2 = null;
            try {
                String con;
                Statement s = conexionBD.createStatement();
                con = "SELECT COUNT(*) FROM `han_votado` WHERE   dni='" + dni + "'";
                resultados2 = s.executeQuery(con);

                while (resultados2.next()) {
                    resultadoInt2 = resultados2.getInt(1);
                }

            } catch (Exception e) {
                System.out.println("Error en la petición a la BD");
            }

            //------------------------------------------------------------------
            if (password.equals("ffin2016") && resultadoInt == 1 && resultadoInt2 == 0) {

                ResultSet resultados3 = null;
                try {
                    String con;
                    Statement s = conexionBD.createStatement();
                    con = "INSERT INTO `han_votado` (dni) values ('" + dni + "')";

                    PreparedStatement preparedStmt = conexionBD.prepareStatement(con);
                    preparedStmt.executeUpdate();

                } catch (Exception e) {
                    System.out.println("Error en la petición a la BD");
                }

                out.println("<html>");
                out.println("<head>");
                out.println("<title>fiesta");
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

                try {
                    conexionBD.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Planes.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {

                out.println("<html>");
                out.println("<head>");
                out.println("<title>fiesta");
                out.println("</title>");
                out.println("<meta charset=\"UTF-8\">");
                out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
                out.println("</head>");
                out.println("<body>");
                out.println("<big>Clave incorrecta, no esta registrado o ya ha votado</big>");
                out.println("<br/> <br/>");
                out.println("<a href=\"inicio.html\"> Volver al test </a>");
                out.println("</body>");
                out.println("</html>");

                try {
                    conexionBD.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Planes.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        } else {

            out.println("<html>");
            out.println("<head>");
            out.println("<title>fiesta");
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

            try {
                conexionBD.close();
            } catch (SQLException ex) {
                Logger.getLogger(Planes.class.getName()).log(Level.SEVERE, null, ex);
            }

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
