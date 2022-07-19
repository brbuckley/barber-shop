package model;

import java.util.List;

public class Fila {    
    public Fila(List<Agendamento> agendamentos, Usuario usuario) {
        this.appointments = agendamentos;       
        this.barber = usuario;        
    }  
    
    private int id;
    private List<Agendamento> appointments; 
    private Usuario barber;
    private String status;
    private int resultCount;
    
    public int getId(){
        return id;
    }    
    
    public List<Agendamento> getAppointments() {
        return this.appointments;
    }
    
    public void setAppointments(List<Agendamento> agendamentos) {
        this.appointments = agendamentos;
    }    
    
      public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }    
    
     public Usuario getBarbeiro() {
        return this.barber;
    }
    
    public void setBarbeiro(Usuario barbeiro) {
        this.barber = barbeiro;
    }    
    
     public int getResultCount() {
        return this.resultCount;
    }
    
    public void setResultCount(int resultCount) {
        this.resultCount = resultCount;
    }    
   
}
