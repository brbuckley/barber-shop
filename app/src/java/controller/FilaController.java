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
import model.Cliente;
import model.Fila;
import service.FilaService;

@WebServlet(name = "Filas", urlPatterns = {"/FilasController"})
public class FilaController extends HttpServlet {        
    private static String LIST_FILAS = "/listfilass.jsp";
    private FilaService fila;
    

    public FilaController() {        
        fila = new FilaService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        HttpSession session = request.getSession(true);   
        String sessaoValida = request.getParameter("session");        
        String deslogou = request.getParameter("deslogar");
        List<Fila> listaClientes = null;
        
        if ("sim".equals(deslogou)){
            session.invalidate();
            request.getRequestDispatcher("login.jsp").forward(request, response);     
            
        } else if ("".equals(sessaoValida)){
            session.invalidate();
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        else {
            try {
              listaClientes =  fila.ObterFilas();
            } catch (Exception e) {
                System.out.println("Erro ao requisitar: " + e);
            }
            
            request.setAttribute("clientes", listaClientes);
            RequestDispatcher view = request.getRequestDispatcher(LIST_FILAS);       
            view.forward(request, response);
        }
    }    
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        String acao = request.getParameter("action");           
        
        if (acao.equalsIgnoreCase("salvar")){            
            try {
                String clienteId = request.getParameter("idCliente");

//                if(clienteId == null || clienteId.isEmpty()) {
//                   fila.Salvar(new Cliente(request.getParameter("name"), request.getParameter("email"), request.getParameter("endereco"), parseInt(request.getParameter("idade")), request.getParameter("aniversario")), _tipo);
//                }
//                else {
//                   fila.Salvar(new Cliente(parseInt(clienteId), request.getParameter("name"), request.getParameter("email"), request.getParameter("endereco"), parseInt(request.getParameter("idade")), request.getParameter("aniversario")), _tipo);
//                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } 
        }
        else if (acao.equalsIgnoreCase("delete")){
            int id = Integer.parseInt(request.getParameter("id_exclusao"));
          //  fila.Deletar(id, "cliente");                       
       }
        
        RequestDispatcher view = request.getRequestDispatcher(LIST_FILAS);
        request.setAttribute("clientes", fila.ObterFilas());
        view.forward(request, response);
    }
}
