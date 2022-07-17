
package service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class RequestService {
    public static BufferedReader CriarRequisicaoGet(URL url){
        InputStreamReader in = null;
        
        try{
            HttpURLConnection requisicao = (HttpURLConnection) url.openConnection();
            requisicao.setRequestMethod("GET");
            requisicao.setRequestProperty("Accept", "application/json");
            if (requisicao.getResponseCode() != 200) {
                throw new RuntimeException("Falha na requisição com código: "
                        + requisicao.getResponseCode());
            }
            in = new InputStreamReader(requisicao.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  new BufferedReader(in);
    }
}
