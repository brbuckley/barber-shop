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

@WebServlet(name = "Filas", urlPatterns = {"/FilasController"})
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
              listaFilas =  fila.ObterFilas();
            } catch (Exception e) {
                System.out.println("Erro ao requisitar: " + e);
            }
            
            request.setAttribute("filas", listaFilas);
            RequestDispatcher view = request.getRequestDispatcher(LIST_FILAS);       
            view.forward(request, response);
        }
    }    
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        String acao = request.getParameter("action");           
        List<Fila> lstFilas = null;
        
        if (acao.equalsIgnoreCase("salvar")){            
            try {
                String funcionarioId = request.getParameter("idUsuarioLogado");
                
                  try {
                    lstFilas =  fila.ObterFilas();
                    
                    lstFilas.forEach((x) -> {
                        if (x.getBarbeiro().getId() == parseInt(funcionarioId) /*&& x.getStatus() == "aberto" */ ) {
                            
                            request.setAttribute("filaIniciada", "");
                            //Enviar request para parar a fila
                            return;                         

                        }
                        else if (x.getBarbeiro().getId() == parseInt(funcionarioId) /*&& x.getStatus() == "fechado" */ ) {
                            request.setAttribute("filaIniciada", "checked");
                            //Enviar request para iniciarlizar a fila
                            return;  
                        }  
                    });
                    
                  } catch (Exception e) {
                      System.out.println("Erro ao requisitar: " + e);
                  }
//          

//                if(filaId == null || filaId.isEmpty()) {
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
        request.setAttribute("filas", fila.ObterFilas());
        view.forward(request, response);
    }
}
