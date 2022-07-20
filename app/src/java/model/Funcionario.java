package model;

public class Funcionario extends Usuario  { 
    
    public Funcionario(int id) {
        super(id);
    }
    
    public Funcionario(int id, String name, String email) {
        super(id, name, email);
    }
    
    public Funcionario(String name, String email, String password) {
        super(name, email);
    }
    
     public Funcionario(String name, String email) {
        super(name, email);
    }
    
    private int age;     
    private Fila fila; 
    
    public int getAge() {
        return this.age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public Fila getFila() {
        return this.fila;
    }
    
    public void setFila(Fila fila) {
        this.fila = fila;
    }
}