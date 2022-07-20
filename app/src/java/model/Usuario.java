package model;

public class Usuario { 
    
    public Usuario(int id){
        this.id = id;
    }
    
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
    private String email; 
    private String passwordHash;    
    
    public int getId(){
        return id;
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
    
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }  
}