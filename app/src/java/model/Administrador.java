package model;

public class Administrador {    
    public Administrador(String nome, String cpf, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;         
    }  
    
    public Administrador(int id, String nome, String cpf, String senha) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;         
    } 
    
    private int id;
    private String nome; 
    private String cpf;
    private String senha; 
    
    public int getId(){
        return id;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getCPF() {
        return this.cpf;
    }
    
    public void setCPF(String cpf) {
        if (String.valueOf(cpf).length() == 14)
            this.cpf = cpf;
    } 
    
    public String getSenha() {
        return this.senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }  
}
