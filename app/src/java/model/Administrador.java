package model;

public class Administrador extends Usuario  { 
    
    public Administrador(int id, String name, String email) {
        super(id, name, email);
    }
    
    public Administrador(String name, String email) {
        super(name, email);
    }
}