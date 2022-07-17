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
import model.Usuario;
import service.UsuarioService;

@WebServlet(name = "Clientes", urlPatterns = {"/ClienteController"})
public class ClienteController extends HttpServlet {        
    private static String LIST_CLIENTES = "/listclientes.jsp";
    private UsuarioService cliente;
    private String _tipo = "cliente";

    public ClienteController() {        
        cliente = new UsuarioService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        HttpSession session = request.getSession(true);   
        String sessaoValida = request.getParameter("session");        
        String deslogou = request.getParameter("deslogar");
        List<Cliente> listaClientes = null;
        
        if ("sim".equals(deslogou)){
            session.invalidate();
            request.getRequestDispatcher("login.jsp").forward(request, response);     
            
        } else if ("".equals(sessaoValida)){
            session.invalidate();
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        else {
            try {
              listaClientes =  cliente.RecuperarCliente();
            } catch (Exception e) {
                System.out.println("Erro ao requisitar: " + e);
            }
            
            request.setAttribute("clientes", listaClientes);
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
                   Usuario _usuario = new Usuario(request.getParameter("name"), request.getParameter("email"));
                   cliente.Salvar(_usuario, _tipo);
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
            cliente.Deletar(id, "cliente");                       
       }
        
        RequestDispatcher view = request.getRequestDispatcher(LIST_CLIENTES);
        request.setAttribute("clientes", cliente.RecuperarCliente());
        view.forward(request, response);
    }
}
