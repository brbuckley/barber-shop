package controller;

import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Fila;
import service.FilaService;

@WebServlet(name = "Filas", urlPatterns = {"/FilaController"})
public class FilaController extends HttpServlet {        
    private static String LIST_FILAS = "/listfilas.jsp";
    private FilaService fila;
    

    public FilaController() {        
        fila = new FilaService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        HttpSession session = request.getSession(true);   
        String sessaoValida = request.getParameter("session");        
        String deslogou = request.getParameter("deslogar");
        String ativaDesativaFila = request.getParameter("ativo");
        String barbeiroId = request.getParameter("id");
        List<Fila> listaFilas = null;
        
        if ("sim".equals(deslogou)){
            session.invalidate();
            request.getRequestDispatcher("login.jsp").forward(request, response);     
            
        } else if ("".equals(sessaoValida)){
            session.invalidate();
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        else {
            try {
                if (ativaDesativaFila != null && !ativaDesativaFila.isEmpty()){
                   int filaId = fila.ObterFilaDoBarbeiro(parseInt(barbeiroId));
                   if (ativaDesativaFila.equals("false")) 
                       fila.AlteraStatusFila(filaId, "fechado");
                   else
                       fila.AlteraStatusFila(filaId, "aberto");
            }
              listaFilas =  fila.ObterFilas();
              
              listaFilas.forEach((x) -> {
                        if (x.getBarbeiro().getId() == parseInt(barbeiroId) && x.getStatus().equals("aberto")) {
                            session.setAttribute("filaIniciada", "checked");
                        }
                });
              session.setAttribute("filaIniciada", "");
            } catch (Exception e) {
                System.out.println("Erro ao requisitar: " + e);
            }
            
            request.setAttribute("filas", listaFilas);
            request.getRequestDispatcher("home.jsp").forward(request, response);            
        }
    }    
}
