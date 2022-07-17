package service;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
}
