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
import model.Administrador;
import model.Usuario;
import service.UsuarioService;

@WebServlet(name = "Admins", urlPatterns = {"/AdminController"})
public class AdminController extends HttpServlet {        
    private static String LIST_ADMINS = "/listadmins.jsp";
    private UsuarioService admin;
    private String _tipo = "admin";

    public AdminController() {        
        admin = new UsuarioService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        HttpSession session = request.getSession(true);   
        String sessaoValida = request.getParameter("session");        
        String deslogou = request.getParameter("deslogar");
        List<Administrador> listaAdmins = null;
        
        if ("sim".equals(deslogou)){
            session.invalidate();
            request.getRequestDispatcher("login.jsp").forward(request, response);     
            
        } else if ("".equals(sessaoValida)){
            session.invalidate();
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        else {
            try {
              listaAdmins =  admin.RecuperarAdmin();
            } catch (Exception e) {
                System.out.println("Erro ao requisitar: " + e);
            }
            
            request.setAttribute("admins", listaAdmins);
            RequestDispatcher view = request.getRequestDispatcher(LIST_ADMINS);       
            view.forward(request, response);
        }
    }
    
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        String acao = request.getParameter("action");           
        
        if (acao.equalsIgnoreCase("salvar")){            
            try {
                String clienteId = request.getParameter("idAdmin");

                if(clienteId == null || clienteId.isEmpty()) {
                   Usuario _usuario = new Administrador(request.getParameter("name"), request.getParameter("email"));
                   admin.Salvar(_usuario, _tipo);
                }
                else {
                   admin.Salvar(new Administrador(parseInt(clienteId), request.getParameter("name"), request.getParameter("email")), _tipo);
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } 
        }
        else if (acao.equalsIgnoreCase("delete")){
            int id = Integer.parseInt(request.getParameter("id_exclusao"));
            admin.Deletar(id, "admin");                       
       }
        
        RequestDispatcher view = request.getRequestDispatcher(LIST_ADMINS);
        request.setAttribute("admins", admin.RecuperarAdmin());
        view.forward(request, response);
    }
}
