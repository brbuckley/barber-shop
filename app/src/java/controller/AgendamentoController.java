package controller;

import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Agendamento;
import model.Cliente;
import model.Fila;
import model.Funcionario;
import model.Pagamento;
import model.Servicos;
import service.AgendamentoService;
import service.FilaService;
import service.UsuarioService;

@WebServlet(name = "Agend", urlPatterns = {"/AgendamentoController"})
public class AgendamentoController extends HttpServlet {
    private UsuarioService barbeiroService;   
    private FilaService filaService;  
    private UsuarioService clienteService;
    private AgendamentoService agendamentoService;   

    public AgendamentoController() {        
        barbeiroService = new UsuarioService();
        filaService = new FilaService();
        clienteService = new UsuarioService();
        agendamentoService = new AgendamentoService();
    }    
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        String acao = request.getParameter("action"); 
        
        if (acao.equalsIgnoreCase("salvar")){    
             String filaId = request.getParameter("fila"); 
             String clienteId = request.getParameter("id"); 
             String[] arrayServicos = request.getParameter("servicos").split(","); 
             
            try {
                             
                Funcionario barbeiro = filaService.ObterFila(parseInt(filaId)).getBarbeiro();
                Pagamento pagamento = new Pagamento(1); // Por enquanto só está aceitando dinheiro; xD
                Cliente cliente = new Cliente(parseInt(clienteId));
                Fila fila = new Fila(parseInt(filaId));
                Servicos servico = new Servicos(parseInt(arrayServicos[0]));
               
                String data = Instant.now().atZone(ZoneOffset.UTC).format(DateTimeFormatter.ISO_LOCAL_DATE);
                
                Agendamento agendamento = new Agendamento(data, "Esperando", cliente, barbeiro, servico, pagamento, fila);
                agendamentoService.AdicionarAFila(agendamento);
              
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } 
        } 
        else {
             String barbeiroId = request.getParameter("barbeiro"); 
             agendamentoService.ChamarOProximo(parseInt(barbeiroId));
        }
        
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }
}
