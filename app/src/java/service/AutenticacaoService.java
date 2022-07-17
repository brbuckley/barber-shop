package service;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import model.Usuario;

public class AutenticacaoService implements IAutenticacaoService {
    public static String _tipo;
    
    public AutenticacaoService() { 
        this._tipo = "cliente";
    }            
  
    public Usuario Logar(String email, String senha) {         
        
        Usuario usuario = null;
        try {
            String _url = new StringBuilder("http://uff-barber-shop.herokuapp.com/login/?email=").append(email).append("&password-hash=").append(senha).toString();
            URL url = new URL(_url);
            HttpURLConnection requisicao = (HttpURLConnection) url.openConnection();
            requisicao.setRequestMethod("GET");
            requisicao.setRequestProperty("Accept", "application/json");
            if (requisicao.getResponseCode() != 200) {
                throw new RuntimeException("Falha na requisição com código: "
                        + requisicao.getResponseCode());
            }
            InputStreamReader in = new InputStreamReader(requisicao.getInputStream());
            BufferedReader br = new BufferedReader(in);
            
            Gson g = new Gson();
            usuario = g.fromJson(br, Usuario.class);   
            AutenticacaoService._tipo = requisicao.getHeaderField("Object-Class");            
           
            requisicao.disconnect();
            
        } catch (IOException | RuntimeException e) {
        }

        return usuario;
    }
    
    public static String ObterTipoUsuarioLogado() {
        return AutenticacaoService._tipo;
    }    
}
