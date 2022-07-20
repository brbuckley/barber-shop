package model;

import java.util.Date;

public class Agendamento {    
   
    public Agendamento(String data, String status, Cliente cliente, Funcionario barbeiro, Servicos servico, Pagamento pagamento, Fila fila) {
       this.id = id;
       this.status = status;
       this.date = data;       
       this.customer = cliente;
       this.barber = barbeiro;
       this.haircut = servico;  
       this.payment = pagamento;
       this.queue = fila;
    } 
    
    private int id;
    private String date; 
    private String status;
    private Cliente customer;
    private Funcionario barber;
    private Servicos haircut;
    private Pagamento payment;
    private Fila queue;
    
    public int getId(){
        return id;
    }    
    
    
     public Fila getPFila() {
        return this.queue;
    }
    
    public void setFila(Fila queue) {
        this.queue = queue;
    }    
    
    
    public Pagamento getPagamento() {
        return this.payment;
    }
    
    public void setPagamento(Pagamento pagamento) {
        this.payment = pagamento;
    }    
    
    public String getDate() {
        return this.date;
    }
    
    public void setDate(String data) {
        this.date = data;
    }    
    
     public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }    
    
     public Cliente getCustomer() {
        return this.customer;
    }
    
    public void setCustomer(Cliente cliente) {
        this.customer = cliente;
    }    
    
    public Usuario getBarber() {
        return this.barber;
    }
    
    public void setBarber(Funcionario barbeiro) {
        this.barber = barbeiro;
    }    
    
    public Servicos getHairCut() {
        return this.haircut;
    }
    
    public void setHairCut(Servicos haircut) {
        this.haircut = haircut;
    }       
}
