package hello;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author viter
 */
public class MessageBean implements Serializable {
     
    private String msg;
        
    public MessageBean() {
    }
    
    public String getMsg() {
        return msg;
    }
    
    public void setMsg(String value) {
        switch (value){
            case "":
            case "pt":
                msg = "Alô";
                break;
            case "en":
                msg = "Hello";
                break;
            case "de":
                msg = "Hallo";
                break;
            case "fr":
                msg = "Bonjour";
                break;
        }
    }
}
