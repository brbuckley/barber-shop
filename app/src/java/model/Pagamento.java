package model;

public class Pagamento {
    private int id;
    private String description;
    
    public Pagamento(int id){
        this.id = id;
    }
    
    
    public int getId(){
        return this.id;
    }
    
    public String getDescription(){
        return this.description;
    }
    
    public void setDescription(String nome){
        this.description = nome;
    }    
}
