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
import model.Usuario;
import service.UsuarioService;

@WebServlet(name = "Clientes", urlPatterns = {"/ClienteController"})
public class ClienteController extends HttpServlet {        
    private static String LIST_CLIENTES = "/listclientes.jsp";
    private UsuarioService cliente;
    private String _tipo = "cliente";

    public ClienteController() {
        super();   
        cliente = new UsuarioService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        HttpSession session = request.getSession(true);   
        String sessaoValida = request.getParameter("session");        
        String deslogou = request.getParameter("deslogar");
        List<Usuario> listaUsuarios = null;
        
        if ("sim".equals(deslogou)){
            session.invalidate();
            request.getRequestDispatcher("login.jsp").forward(request, response);     
            
        } else if ("".equals(sessaoValida)){
            session.invalidate();
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        else {
            try {
              listaUsuarios =  cliente.Recuperar("cliente");
            } catch (Exception e) {
                System.out.println("Erro ao requisitar: " + e);
            }
            
            request.setAttribute("clientes", listaUsuarios);
            RequestDispatcher view = request.getRequestDispatcher(LIST_CLIENTES);       
            view.forward(request, response);
        }
    }
    
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        String acao = request.getParameter("action");           
        
        if (acao.equalsIgnoreCase("salvar")){            
            try {
                String clienteId = request.getParameter("idCliente");

                if(clienteId == null || clienteId.isEmpty()) {
                   cliente.Salvar(new Usuario(request.getParameter("name"), request.getParameter("email")), _tipo);
                }
                else {
                   cliente.Salvar(new Usuario(parseInt(clienteId), request.getParameter("name"), request.getParameter("email")), _tipo);
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } 
        }
        else if (acao.equalsIgnoreCase("delete")){
            int id = Integer.parseInt(request.getParameter("id_exclusao"));
            cliente.Deletar(id);                       
       }
        
        RequestDispatcher view = request.getRequestDispatcher(LIST_CLIENTES);
        request.setAttribute("clientes", cliente.Recuperar("cliente"));
        view.forward(request, response);
    }
}
