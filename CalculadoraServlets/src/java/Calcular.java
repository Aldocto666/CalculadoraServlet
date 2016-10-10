import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Calcular extends HttpServlet {
    float numero1, numero2, resultado;
    String combo;
    
    protected void doPost(HttpServletRequest peticion, HttpServletResponse respuesta) throws ServletException, IOException {
        numero1 = Float.parseFloat(peticion.getParameter("n1"));
        numero2 = Float.parseFloat(peticion.getParameter("n2"));
        combo= peticion.getParameter("tipo");
        if(combo.equals("suma"))
            resultado=numero1+numero2;
        else if(combo.equals("resta"))
            resultado=numero1-numero2;
        else if(combo.equals("multiplicacion"))
            resultado=numero1*numero2;
        else if(combo.equals("division"))
            resultado=numero1/numero2;
        PrintWriter out = new PrintWriter(respuesta.getOutputStream());
        out.println("<html>");
        out.println("<head><title>Resultado</title></head>");
        out.println("<body>");
        out.println("<p><h1>El resultado es "+ resultado+"</h1></p>");
        out.println("</body></html>");
        out.close();
    }
      
}