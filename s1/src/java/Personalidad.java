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
@WebServlet(urlPatterns = {"/Personalidad"})
public class Personalidad extends HttpServlet {

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
            out.println("<title>Servlet Personalidad</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Personalidad at " + request.getContextPath() + "</h1>");
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
        String nombre, opcion;
        String texto = null;
        
        response.setContentType(CONTENT_TYPE);
        ServletOutputStream out = response.getOutputStream();
        
        nombre = request.getParameter("nombre");
        opcion = request.getParameter("opcion");
        
        if("".equals(nombre)){
            
            out.println("<html>");
            out.println("<head>");
            out.println("<title>no_nombre");
            out.println("</title>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<big>No ha escrito su nombre</big>");
            out.println("<br/> <br/>");
            out.println("<a href=\"test.html\"> Volver al test </a>");
            out.println("</body>");
            
        }
        
        else if("".equals(opcion)){
            
            out.println("<html>");
            out.println("<head>");
            out.println("<title>no_foto");
            out.println("</title>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<big>No ha seleccionado ninguna fotografia</big>");
            out.println("<br/> <br/>");
            out.println("<a href=\"test.html\"> Volver al test </a>");
            out.println("</body>");
            
        }
        
        else{
            
            if("imagen1".equals(opcion))
                texto = "Te desentiendes de ti mismo y de tu entorno, en mayor medida que la mayoría de las personas. Detestas superficialidades, prefieres permanecer aislado que sufrir el impacto de un diálogo estéril. Pero las relaciones con amigos son intensas y profundas, lo que te proporciona tranquilidad y armonía espiritual indispensable para que te sientas bien. No te preocupas por el aislamiento, aunque sea durante largos periodos de tiempo. Es una circunstancia que no te desagrada.";
            if("imagen2".equals(opcion))
                texto = "Exiges libertad y vida sin compromiso. Determinas tu destino. Tienes talento artístico en el trabajo y en el ocio. Algunas veces, tu impulso por la libertad te lleva a proceder de manera opuesta a lo que se espera de ti. Tu estilo de vida es altamente individualista. Jamás imitas ciegamente lo que es convencional, al contrario, tratas de vivir de acuerdo con tus propias ideas y convicciones, aunque esto signifique nadar contra corriente.";
            if("imagen3".equals(opcion))
                texto = "Estás muy inclinada a correr ciertos riesgos y asumir importantes compromisos a cambio de tareas variadas e interesantes. En contraste, actividades rutinarias tienden a ejercer efecto paralizante sobre ti. Lo que más aprecias es desempeñar un papel activo en los acontecimientos. Procediendo así, tu capacidad de iniciativa se torna significativamente acentuada.";
            if("imagen4".equals(opcion))
                texto = "Valoras el amor y un estilo de vida simple y sin complicaciones. Los que te rodean te admiran porque tienes ambos pies firmemente plantados en el suelo y así se tornan dependientes de ti. Ofreces espacio y seguridad a los amigos íntimos. Tus dotes son consideradas humanas y cálidas. Rechazas lo trivial y extravagante. Tiendes a ser escéptico en relación a fantasías y modismos. Tu indumentaria tiene que ser práctica y discretamente elegante.";
            if("imagen5".equals(opcion))
                texto = "Tienes pleno dominio de la vida y depositas menos fe en la suerte que en tus actos. Solucionas problemas de modo simple y práctico. Tienes visión realista de los acontecimientos cotidianos y los manipulas sin dudas. Gran parte de la responsabilidad en el trabajo te es conferida porque todos saben que pueden depender de ti. Tu pronunciada fuerza de voluntad transmite auto-confianza a los otros. Jamás te sentirás totalmente satisfecho en cuanto no hayas realizado tus ideas.";
            if("imagen6".equals(opcion))
                texto = "Menosprecias formalidades sin causar dificultades a otros. Tus amistadas son hechas fácilmente, pero aprecias la privacidad y la independencia. Gustas distanciarte de todo y de todos, de tiempo en tiempo para contemplar el significado de la vida y alegrarte contigo mismo. Necesitas espacio, y por eso te refugias en lugares solitarios y bonitos. Pero, no eres una persona solitaria. Estás en paz contigo mismo y con el mundo, y gustas de la vida y de los que ella tiene para ofrecerte.";
            if("imagen7".equals(opcion))
                texto = "Amas una vida libre y espontánea, y tratas de disfrutarla en toda su plenitud, de acuerdo con el refrán: sólo se vive una vez. Te muestras interesado y abierto a todo lo que es nuevo; los cambios alimentan tu espíritu. Nada es peor que cuando te sientes privado de tu libertad. Vives tu ambiente como algo versátil y siempre en condiciones de brindarte con una sorpresa diaria.";
            if("imagen8".equals(opcion))
                texto = "Eres muy sensible. Rechazas analizar los acontecimientos solamente con un punto de vista frio y racional. Solo te importa lo que los sentimientos te dicen. Como efecto, avalas como significativo tener anhelos en la vida. Rechazas a quien desprecia el romanticismo y te dejas guiar solamente por la racionalidad. Rechazas cualquier limitación a la rica variedad de tus impulsos y emociones.";
            if("imagen9".equals(opcion))
                texto = "Tu sensibilidad representa lo que es duradero y de alta calidad. En consecuencia, gustas de rodearte de pequeñas preciosidades, que descubres donde quieres que sean ignoradas por otros. Siendo así, la cultura desempeña un papel especial en tu vida. Tienes un estilo personal elegante y exhaustivo, libre de las fantasías de los modismos. Lo ideal, sobre lo cual basas tu vida, es el placer asociado a la cultura. Valorizas un cierto nivel de cultura en las personas que quien te asocias.";
            
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Perfecto");
            out.println("</title>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<big>" + texto + "</big>");
            out.println("<br/> <br/>");
            out.println("<a href=\"test.html\"> Volver a realizar el test </a>");
            out.println("</body>");
            
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
