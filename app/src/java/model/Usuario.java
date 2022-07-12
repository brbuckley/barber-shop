package model;

public class Usuario {    
    public Usuario(String nome, String cpf, String senha, String suspenso) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;      
        this.suspenso = suspenso;
    }  
    
    public Usuario(int id, String nome, String cpf, String senha, String suspenso) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;  
        this.suspenso = suspenso;
    } 
    
    private int id;
    private String nome; 
    private String cpf;
    private String senha; 
    private String suspenso; 
    
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
    
      public String getSuspenso() {        
        return (this.suspenso == null ? "N" : this.suspenso.equals("N") ? "N" : "S");
    }
    
    public void setSuspenso(String suspenso) {
        this.suspenso = suspenso;
    }  
}
