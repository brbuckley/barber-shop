package model;

public class Usuario {    
    public Usuario(int id, String name, String tipo, String email) {
         this.id = id;
        this.name = name;
        this.tipo = tipo;
        this.email = email;       
    }  
    
    public Usuario(int id, String name, String tipo, String email, int idFila) {
        this.id = id;
        this.name = name;
        this.tipo = tipo;
        this.email = email;
        this.idFila = idFila;
    } 
    
    private int id;
    private String name; 
    private String tipo;
    private String email; 
    private int idFila;
    
    public int getId(){
        return id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getTipo() {
        return this.tipo;
    }
    
    public void setTipo(String tipo) {
            this.tipo = tipo;
    } 
    
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }  
    
     public int getIdFila() {
        return this.idFila;
    }
    
    public void setIdFila(int idFila) {
        this.idFila = idFila;
    }  
}
