package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Usuario;
import service.AutenticacaoService;


@WebServlet(name = "Autenticacao", urlPatterns = {"/AutenticacaoController"})
public class AutenticacaoController extends HttpServlet {        
   
    private AutenticacaoService autenticacao;   
    static String tipo = "";

    public AutenticacaoController() {
        autenticacao = new AutenticacaoService();
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
            String email = request.getParameter("email");           
            String senha = request.getParameter("senha");   
            HttpSession session = request.getSession(true);    
            
            Usuario dto = autenticacao.Logar(email, senha);
            
            if (dto == null)
            {
                request.getRequestDispatcher("login.jsp").forward(request, response);                 
                return;
            }
            
            if (AutenticacaoService._tipo.equals("Admin"))
            {
                session.setAttribute("adm", "display: normal");
                session.setAttribute("usu", "display: none");
            }
            else {
                session.setAttribute("adm", "display: none");
                session.setAttribute("usu", "display: normal");
            }            
            
            session.setAttribute("usuarioLogado", dto.getName()); 
            session.setAttribute("idUsuarioLogado", dto.getId());
            request.getRequestDispatcher("home.jsp").forward(request, response);
     }     
}