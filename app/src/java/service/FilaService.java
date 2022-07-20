package service;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import model.Fila;


public class FilaService implements IFilaService {
    
    public FilaService() { 
    }            
    
    public List<Fila> ObterFilas() {         
       List<Fila> listaFilas = null;
        try {
            URL url = new URL("https://uff-barber-shop.herokuapp.com/queue/all");
            BufferedReader result = RequestService.CriarRequisicaoGet(url);
            Gson json = new Gson();
            listaFilas  = Arrays.asList(json.fromJson(result, Fila[].class));  
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaFilas;
    }

    @Override
    public void AlteraStatusFila(int id, String status) {
        try {
            String _url = new StringBuilder("http://uff-barber-shop.herokuapp.com/queue/").append(id).append("/status/").append(status).toString();
            URL url = new URL(_url);
            HttpURLConnection requisicao = (HttpURLConnection) url.openConnection();
            requisicao.setRequestMethod("PUT");
            requisicao.setRequestProperty("Accept", "application/json");
            if (requisicao.getResponseCode() != 200) {                
                throw new RuntimeException("Falha na requisição com código: "
                        + requisicao.getResponseCode());
            }
            requisicao.disconnect();
            
        } catch (IOException | RuntimeException e) { }       
    }
    
    @Override
    public int ObterFilaDoBarbeiro(int id) {
        int filaId = 0;
        try {
            URL url = new URL(new StringBuilder("http://uff-barber-shop.herokuapp.com/barber/").append(id).toString());
            BufferedReader result = RequestService.CriarRequisicaoGet(url);
            Gson json = new Gson();
            filaId = json.fromJson(result, Fila.class).getId(); 
            
        } catch (IOException | RuntimeException e){}  
        return filaId;
    }

    @Override
    public Fila ObterFila(int id) {
         Fila fila = null;
        try {
            URL url = new URL("https://uff-barber-shop.herokuapp.com/queue/"+id);
            BufferedReader result = RequestService.CriarRequisicaoGet(url);
            Gson json = new Gson();
            fila  = json.fromJson(result, Fila.class);  
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fila;
    }
}
