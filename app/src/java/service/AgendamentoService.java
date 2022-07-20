package service;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import model.Agendamento;
import model.Fila;
import model.Funcionario;


public class AgendamentoService implements IAgendamentoService {
    
    public AgendamentoService() { 
    }
    
    @Override
    public void AdicionarAFila(Agendamento agendamento) 
    {          
        try {
            URL url = new URL("https://uff-barber-shop.herokuapp.com/appointment/new");
            HttpURLConnection http = (HttpURLConnection)url.openConnection();
            http.setRequestMethod("POST");
            http.setDoOutput(true);
            http.setRequestProperty("Content-Type", "application/json");

            Gson gson = new Gson();
            String data = gson.toJson(agendamento);

            byte[] out = data.getBytes(StandardCharsets.UTF_8);            

            OutputStream stream = http.getOutputStream();
            stream.write(out);  
            http.getResponseCode();                    
            http.disconnect();
            
        } catch (IOException e) {
        }             
    }
    
    public void ChamarOProximo(int id) 
    {          
        Fila fila = null;
        URL url = null;
        
        try {            
            url = new URL("https://uff-barber-shop.herokuapp.com/queue/barber/"+id);
            BufferedReader result = RequestService.CriarRequisicaoGet(url);
            Gson json = new Gson();
            fila  = json.fromJson(result, Fila.class);  
            Agendamento agendamento = fila.getAppointments().get(0);
            
            url = new URL(new StringBuilder("http://uff-barber-shop.herokuapp.com/appointment/").append(agendamento.getId()).append("/status/").append("Concluído").toString());
           
            HttpURLConnection http = (HttpURLConnection)url.openConnection();
            http.setRequestMethod("PUT");
            http.setDoOutput(true);
            http.setRequestProperty("Content-Type", "application/json");
            http.getResponseCode();
            http.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
}
