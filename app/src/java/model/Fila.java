package model;

import java.util.List;

public class Fila {    
    public Fila(List<Agendamento> agendamentos, Funcionario usuario) {
        this.appointments = agendamentos;       
        this.barber = usuario;        
    }  
    
    public Fila(int id) {
       this.id = id;
    }
    
    private int id;
    private List<Agendamento> appointments; 
    private Funcionario barber;
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
    
     public void setAppointment(Agendamento agendamento) {
        this.appointments.add(agendamento);
    }   
    
      public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }    
    
     public Funcionario getBarbeiro() {
        return this.barber;
    }
    
    public void setBarbeiro(Funcionario barbeiro) {
        this.barber = barbeiro;
    }    
    
     public int getResultCount() {
        return this.resultCount;
    }
    
    public void setResultCount(int resultCount) {
        this.resultCount = resultCount;
    }    
   
}
