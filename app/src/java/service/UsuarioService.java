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
import model.Administrador;
import model.Funcionario;
import model.Cliente;
import model.Usuario;

public class UsuarioService implements IUsuarioService {
    public UsuarioService() {       
    }   
    
    @Override
    public void Salvar(Usuario usuario, String tipo) {
        URL url = null;
        try {            
            if (usuario.getId() == 0) {
                try {
                    
                     switch (tipo) {
                         case "cliente":
                             url = new URL("https://uff-barber-shop.herokuapp.com/customer/new");
                             break;
                         case "admin":
                             url = new URL("https://uff-barber-shop.herokuapp.com/admin/new");                     
                             break;
                         default:
                             url = new URL("https://uff-barber-shop.herokuapp.com/barber/new");
                             break;
                     }
                    
                    HttpURLConnection http = (HttpURLConnection)url.openConnection();
                    http.setRequestMethod("POST");
                    http.setDoOutput(true);
                    http.setRequestProperty("Content-Type", "application/json");
                    
                    Gson gson = new Gson();
                    String data = gson.toJson(usuario);

                    byte[] out = data.getBytes(StandardCharsets.UTF_8);

                    OutputStream stream = http.getOutputStream();
                    stream.write(out);  
                    http.getResponseCode();                    
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
                         case "admin":
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
    public void Deletar(int id, String tipo) {
        URL url = null;
        
        try {            
            switch (tipo) {
                case "cliente":
                    url = new URL("https://uff-barber-shop.herokuapp.com/customer/delete/"+id);
                    break;
                case "admin":
                    url = new URL("https://uff-barber-shop.herokuapp.com/admin/delete/"+id);                     
                    break;
                default:
                    url = new URL("https://uff-barber-shop.herokuapp.com/barber/delete/"+id);
                    break;
            }
            
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

    @Override
    public List<Cliente> RecuperarCliente() {
       List<Cliente> listaClientes = null;
       
        try {
            URL url = new URL("https://uff-barber-shop.herokuapp.com/customer/all");
            BufferedReader result = RequestService.CriarRequisicaoGet(url);
            Gson json = new Gson();
            listaClientes  = Arrays.asList(json.fromJson(result, Cliente[].class));  
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaClientes;
    }

    @Override
    public List<Administrador> RecuperarAdmin() {
       List<Administrador> listaAdmins = null;
       
        try {
            URL url = new URL("https://uff-barber-shop.herokuapp.com/admin/all");
            BufferedReader result = RequestService.CriarRequisicaoGet(url);
            Gson json = new Gson();
            listaAdmins  = Arrays.asList(json.fromJson(result, Administrador[].class));  
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaAdmins;
    }

    @Override
    public List<Funcionario> RecuperarFuncionario() {
        List<Funcionario> listaBarbeiro = null;
       
        try {
            URL url = new URL("https://uff-barber-shop.herokuapp.com/barber/all");
            BufferedReader result = RequestService.CriarRequisicaoGet(url);
            Gson json = new Gson();
            listaBarbeiro = Arrays.asList(json.fromJson(result, Funcionario[].class));  
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaBarbeiro;
    }
}
