package model;

import java.util.Date;

public class Agendamento {    
   
    public Agendamento(int id, Date data, String status, Usuario cliente, Usuario barbeiro, Servicos servico) {
       this.id = id;
       this.date = data;
       this.status = status;
       this.customer = cliente;
       this.barber = barbeiro;
       this.haircut = servico;       
    } 
    
    private int id;
    private Date date; 
    private String status;
    private Usuario customer;
    private Usuario barber;
    private Servicos haircut;
    
    public int getId(){
        return id;
    }    
    
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date data) {
        this.date = data;
    }    
    
     public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }    
    
     public Usuario getCustomer() {
        return this.customer;
    }
    
    public void setCustomer(Usuario cliente) {
        this.customer = cliente;
    }    
    
    public Usuario getBarber() {
        return this.barber;
    }
    
    public void setBarber(Usuario barbeiro) {
        this.barber = barbeiro;
    }    
    
    public Servicos getHairCut() {
        return this.haircut;
    }
    
    public void setHairCut(Servicos haircut) {
        this.haircut = haircut;
    }       
}
