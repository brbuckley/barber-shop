package model;

import java.util.Date;

public class Agendamento {    
   
    public Agendamento(int id, Date data, String status, Usuario cliente, Usuario barbeiro, Servicos servico, Pagamento pagamento) {
       this.id = id;
       this.status = status;
       this.date = data;       
       this.customer = cliente;
       this.barber = barbeiro;
       this.haircut = servico;  
       this.payment = pagamento;
    } 
    
    private int id;
    private Date date; 
    private String status;
    private Usuario customer;
    private Usuario barber;
    private Servicos haircut;
    private Pagamento payment;
    
    public int getId(){
        return id;
    }    
    
    public Pagamento getPagamento() {
        return this.payment;
    }
    
    public void setPagamento(Pagamento pagamento) {
        this.payment = pagamento;
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
