package controller;


//import java.io.IOException;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Administrador;
import model.Usuario;


@WebServlet(name = "Autenticacao", urlPatterns = {"/AutenticacaoController"})
public class AutenticacaoController extends HttpServlet {        
   
//    private ClienteService serviceUsuario;
//    private AdministradorService serviceAdmin;
   

    public AutenticacaoController() {
        super();
//        serviceUsuario = new ClienteService();
//        serviceAdmin = new AdministradorService();
        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        HttpSession session = request.getSession(true);    
        String deslogou = request.getParameter("deslogar");
        
        if ("sim".equals(deslogou)){
            session.invalidate();
            request.getRequestDispatcher("login.jsp").forward(request, response);                    
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {   
           
     }    
}
