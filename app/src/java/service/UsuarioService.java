package service;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import model.Usuario;

public class UsuarioService implements IUsuarioService {
    public UsuarioService() {       
    }            
     
    @Override
    public List<Usuario> Recuperar(String tipo) {         
        List<Usuario> listaUsuarios = null;
        URL url = null;
        try {
             switch (tipo) {
                case "cliente":
                    url = new URL("https://uff-barber-shop.herokuapp.com/customer/all");
                    break;
                case "administrador":
                    url = new URL("https://uff-barber-shop.herokuapp.com/admin/all");                     
                    break;
                default:
                    url = new URL("https://uff-barber-shop.herokuapp.com/barber/all");
                    break;
            }
            
            HttpURLConnection requisicao = (HttpURLConnection) url.openConnection();
            requisicao.setRequestMethod("GET");
            requisicao.setRequestProperty("Accept", "application/json");
            if (requisicao.getResponseCode() != 200) {
                throw new RuntimeException("Falha na requisição com código: "
                        + requisicao.getResponseCode());
            }
            InputStreamReader in = new InputStreamReader(requisicao.getInputStream());
            BufferedReader br = new BufferedReader(in);
            
            Gson json = new Gson();
            listaUsuarios  = Arrays.asList(json.fromJson(br, Usuario[].class));               
            requisicao.disconnect();
           
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaUsuarios;
    }   
    
    @Override
    public void Salvar(Usuario usuario, String tipo) {
        URL url = null;
        try {            
            if (usuario.getId() == 0) {
                try {
                    url = new URL("https://uff-barber-shop.herokuapp.com/customer/new");
                    HttpURLConnection http = (HttpURLConnection)url.openConnection();
                    http.setRequestMethod("POST");
                    http.setDoOutput(true);
                    http.setRequestProperty("Content-Type", "application/json");
                    
                    Gson gson = new Gson();
                    String data = gson.toJson(usuario);

                    byte[] out = data.getBytes(StandardCharsets.UTF_8);

                    OutputStream stream = http.getOutputStream();
                    stream.write(out);

                    System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
                    http.disconnect();

                } catch (Exception e) {
                    e.printStackTrace();
                }            
            }
            else {
                 try {
                     
                     switch (tipo) {
                         case "cliente":
                             url = new URL("https://uff-barber-shop.herokuapp.com/customer/update");
                             break;
                         case "administrador":
                             url = new URL("https://uff-barber-shop.herokuapp.com/admin/update");                     
                             break;
                         default:
                             url = new URL("https://uff-barber-shop.herokuapp.com/barber/update");
                             break;
                     }
                    
                    HttpURLConnection http = (HttpURLConnection)url.openConnection();
                    http.setRequestMethod("PUT");
                    http.setDoOutput(true);
                    http.setRequestProperty("Content-Type", "application/json");
                    
                    Gson json = new Gson();
                    String data = json.toJson(usuario);

                    byte[] out = data.getBytes(StandardCharsets.UTF_8);

                    OutputStream stream = http.getOutputStream();
                    stream.write(out);

                    System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
                    http.disconnect();
                } catch (IOException e) {
                }            
          }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Deletar(int id) {
        try {
            URL url = new URL("https://uff-barber-shop.herokuapp.com/customer/delete/"+id);
            HttpURLConnection requisicao = (HttpURLConnection) url.openConnection();
            requisicao.setRequestMethod("DELETE");
            requisicao.setRequestProperty("Accept", "application/json");
            if (requisicao.getResponseCode() != 200) {
                throw new RuntimeException("Falha na requisição com código: "
                        + requisicao.getResponseCode());
            }                  
            requisicao.disconnect();
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
}
