package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Fila;
import model.Usuario;
import service.AutenticacaoService;
import service.FilaService;


@WebServlet(name = "Autenticacao", urlPatterns = {"/AutenticacaoController"})
public class AutenticacaoController extends HttpServlet {        
   
    private AutenticacaoService autenticacao;   
    static String tipo = "";
    private static String LIST_FILAS = "/listfilas.jsp";
    private FilaService service;
    private List<Fila> lstFilas = null;    

    public AutenticacaoController() {
        autenticacao = new AutenticacaoService();
        service = new FilaService();
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
            
            try {
              this.lstFilas =  service.ObterFilas();
            } catch (Exception e) {
                System.out.println("Erro ao requisitar: " + e);
            }
            
            if (dto == null)
            {
                request.getRequestDispatcher("login.jsp").forward(request, response);                 
                return;
            }
            
            // Bloco que trata de visualização dos menus
            switch (AutenticacaoService._tipo) {
                case "Admin":
                    session.setAttribute("adm", "display: normal");
                    session.setAttribute("cli", "display: none");
                    session.setAttribute("func", "display: none");
                    break;
                case "Barber": {
                    session.setAttribute("adm", "display: none");
                    session.setAttribute("cli", "display: none");
                    session.setAttribute("func", "display: normal");
                    lstFilas.forEach((x) -> {
                        if (x.getBarbeiro().getId() == dto.getId() && x.getStatus().equals("aberto")) {
                            session.setAttribute("filaIniciada", "checked");
                        }
                    });
                    break;
                }                    
                default:
                    session.setAttribute("adm", "display: none");
                    session.setAttribute("cli", "display: normal");
                    session.setAttribute("func", "display: none");//               
                    break;  
            }

            session.setAttribute("usuarioLogado", dto.getName()); 
            session.setAttribute("idUsuarioLogado", dto.getId());
            session.setAttribute("filas", this.lstFilas);
            request.getRequestDispatcher("home.jsp").forward(request, response);
     }     
}