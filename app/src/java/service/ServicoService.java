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
import model.Servicos;

public class ServicoService implements IServicoService {
    
    public ServicoService() {       
    }            
     
    @Override
    public List<Servicos> Recuperar() {         
        List<Servicos> listaServicos = null;
        try {
            URL url = new URL("https://uff-barber-shop.herokuapp.com/haircut/all");
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
            listaServicos  = Arrays.asList(g.fromJson(br, Servicos[].class));       
            requisicao.disconnect();
           
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaServicos;
    }   
    
    @Override
    public void Salvar(Servicos servico) {
        try {            
            if (servico.getId() == 0) {
                try {
                    URL url = new URL("https://uff-barber-shop.herokuapp.com/haircut/new");
                    HttpURLConnection http = (HttpURLConnection)url.openConnection();
                    http.setRequestMethod("POST");
                    http.setDoOutput(true);
                    http.setRequestProperty("Content-Type", "application/json");
                    
                    Gson gson = new Gson();
                    String data = gson.toJson(servico);

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
                    URL url = new URL("https://uff-barber-shop.herokuapp.com/haircut/update");
                    HttpURLConnection http = (HttpURLConnection)url.openConnection();
                    http.setRequestMethod("PUT");
                    http.setDoOutput(true);
                    http.setRequestProperty("Content-Type", "application/json");
                    
                    Gson gson = new Gson();
                    String data = gson.toJson(servico);

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
            URL url = new URL("https://uff-barber-shop.herokuapp.com/haircut/delete/"+id);
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
