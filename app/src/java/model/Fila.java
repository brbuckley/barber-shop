package model;

import java.util.List;

public class Fila {    
    public Fila(List<Agendamento> agendamentos, Usuario usuario) {
        this.agendamentos = agendamentos;       
        this.barbeiro = usuario;
    }  
    
    private int id;
    private List<Agendamento> agendamentos; 
    private Usuario barbeiro;
  
    
    public int getId(){
        return id;
    }    
    
    public List<Agendamento> getAgendamentos() {
        return this.agendamentos;
    }
    
    public void setAgendamentos(List<Agendamento> agendamentos) {
        this.agendamentos = agendamentos;
    }    
    
     public Usuario getBarbeiro() {
        return this.barbeiro;
    }
    
    public void setBarbeiro(Usuario agendamentos) {
        this.barbeiro = barbeiro;
    }    
   
}
