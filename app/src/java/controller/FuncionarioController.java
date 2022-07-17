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
import model.Funcionario;
import model.Usuario;
import service.UsuarioService;

@WebServlet(name = "Funcionarios", urlPatterns = {"/FuncionarioController"})
public class FuncionarioController extends HttpServlet {        
    private static String LIST_FUNCS = "/listfuncionarios.jsp";
    private UsuarioService func;
    private String _tipo = "func";

    public FuncionarioController() {        
        func = new UsuarioService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        HttpSession session = request.getSession(true);   
        String sessaoValida = request.getParameter("session");        
        String deslogou = request.getParameter("deslogar");
        List<Funcionario> listaFuncionarios = null;
        
        if ("sim".equals(deslogou)){
            session.invalidate();
            request.getRequestDispatcher("login.jsp").forward(request, response);     
            
        } else if ("".equals(sessaoValida)){
            session.invalidate();
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        else {
            try {
              listaFuncionarios =  func.RecuperarFuncionario();
            } catch (Exception e) {
                System.out.println("Erro ao requisitar: " + e);
            }
            
            request.setAttribute("funcionarios", listaFuncionarios);
            RequestDispatcher view = request.getRequestDispatcher(LIST_FUNCS);       
            view.forward(request, response);
        }
    }
    
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        String acao = request.getParameter("action");           
        
        if (acao.equalsIgnoreCase("salvar")){            
            try {
                String funcionarioId = request.getParameter("idFunc");

                if(funcionarioId == null || funcionarioId.isEmpty()) {
                   Usuario _usuario = new Administrador(request.getParameter("name"), request.getParameter("email"));
                   func.Salvar(_usuario, _tipo);
                }
                else {
                   func.Salvar(new Administrador(parseInt(funcionarioId), request.getParameter("name"), request.getParameter("email")), _tipo);
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } 
        }
        else if (acao.equalsIgnoreCase("delete")){
            int id = Integer.parseInt(request.getParameter("id_exclusao"));
            func.Deletar(id, "func");                       
       }
        
        RequestDispatcher view = request.getRequestDispatcher(LIST_FUNCS);
        request.setAttribute("admins", func.RecuperarFuncionario());
        view.forward(request, response);
    }
}
