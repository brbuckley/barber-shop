package model;

public class Barbeiro extends Usuario  { 
    
    public Barbeiro(int id, String name, String email) {
        super(id, name, email);
    }
    
    public Barbeiro(String name, String email) {
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