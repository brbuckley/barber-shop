package model;

public class Servicos {  
    public Servicos(int id){
        this.id = id;
    }
    
    public Servicos(String descricao, Double preco) {
        this.description = descricao;       
        this.price = preco;
    }  
    
    public Servicos(int id, String nome, Double preco) {
        this.id = id;
        this.description = nome;      
        this.price = preco;
    } 
    
    private int id;
    private String description; 
    private double price;
  
    
    public int getId(){
        return id;
    }
    
    
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String descricao) {
        this.description = descricao;
    }    
    
    public Double getPrice() {
        return this.price;
    }
    
    public void setPrice(Double preco) {
        this.price = preco;
    }    
}
