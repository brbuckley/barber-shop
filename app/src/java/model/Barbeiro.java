package model;

public class Usuario { 
    
    public Usuario(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    
    public Usuario(String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    
    private int id;
    private String name; 
    private String tipo;
    private String email; 
    private String passwordHash;
    private int idFila;
    private String username;
    
    
    public int getId(){
        return id;
    }
    
     public String getUserName() {
        return this.username;
    }
    
    public void setserName(String username) {
        this.username = username;
    }
    
     public String getPasswordHash() {
        return this.passwordHash;
    }
    
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
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
