package controller;

import service.ServicoService;
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
import model.Servicos;

@WebServlet(name = "Servicos", urlPatterns = {"/ServicoController"})
public class ServicoController extends HttpServlet {        
    private static String LIST_SERVICOS = "/listservicos.jsp";
    private ServicoService service;

    public ServicoController() {
        super();   
        service = new ServicoService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        HttpSession session = request.getSession(true);   
        String sessaoValida = request.getParameter("session");        
        String deslogou = request.getParameter("deslogar");
        List<Servicos> listaServicos = null;
        
        if ("sim".equals(deslogou)){
            session.invalidate();
            request.getRequestDispatcher("login.jsp").forward(request, response);     
            
        } else if ("".equals(sessaoValida)){
            session.invalidate();
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        else {
            try {
              listaServicos =  service.Recuperar();
            } catch (Exception e) {
                System.out.println("Erro ao requisitar: " + e);
            }
            
            request.setAttribute("servicos", listaServicos);
            RequestDispatcher view = request.getRequestDispatcher(LIST_SERVICOS);       
            view.forward(request, response);
        }
    }
    
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        String acao = request.getParameter("action");           
        
        if (acao.equalsIgnoreCase("salvar")){            
            try {
                String servicoId = request.getParameter("idServico");

                if(servicoId == null || servicoId.isEmpty()) {
                    service.Salvar(new Servicos(request.getParameter("description"), Double.parseDouble(request.getParameter("price"))));
                }
                else {
                    service.Salvar(new Servicos(parseInt(servicoId), request.getParameter("description"), Double.parseDouble(request.getParameter("price"))));
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } 
        }
        else if (acao.equalsIgnoreCase("delete")){
            int id = Integer.parseInt(request.getParameter("id_exclusao"));
            service.Deletar(id);                       
       }
        
        RequestDispatcher view = request.getRequestDispatcher(LIST_SERVICOS);
        request.setAttribute("servicos", service.Recuperar());
        view.forward(request, response);
    }
}
