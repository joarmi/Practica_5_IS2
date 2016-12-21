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
@WebServlet(urlPatterns = {"/Votacion"})
public class Votacion extends HttpServlet {

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
            out.println("<title>Servlet Votacion</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Votacion at " + request.getContextPath() + "</h1>");
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
        String eleccion;

        response.setContentType(CONTENT_TYPE);
        ServletOutputStream out = response.getOutputStream();

        eleccion = request.getParameter("eleccion");

        if (eleccion == null) {

            out.println("<html>");
            out.println("<head>");
            out.println("<title>fiesta");
            out.println("</title>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<big>No ha seleccionado ninguna opcion</big>");
            out.println("<br/> <br/>");
            out.println("<a href=\"Viajes.html\"> Volver al test </a>");
            out.println("</body>");
            out.println("</html>");

            try {
                conexionBD.close();
            } catch (SQLException ex) {
                Logger.getLogger(Votacion.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {

            ResultSet resultados3 = null;
            try {
                String con;
                Statement s = conexionBD.createStatement();
                con = "UPDATE `votaciones` SET cantidad = cantidad + 1 WHERE viaje='" + eleccion + "'";

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
            out.println("<big>Has votado</big>");
            out.println("<br/> <br/>");
            out.println("<a href=\"inicio.html\"> Volver al test </a>");
            out.println("</body>");
            out.println("</html>");
            
            try {
                conexionBD.close();
            } catch (SQLException ex) {
                Logger.getLogger(Votacion.class.getName()).log(Level.SEVERE, null, ex);
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
