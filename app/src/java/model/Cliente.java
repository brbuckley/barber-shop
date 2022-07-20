package model;

public class Cliente extends Usuario  { 
    
    public Cliente(int id) {
        super(id);
    }
    
    public Cliente(int id, String name, String email, String endereco, int idade, String dataAniversario) {
        super(id, name, email);
        
        this.address = endereco;
        this.age = idade;
        this.birthDay = dataAniversario;
    }
    
    public Cliente(String name, String email, String endereco, int idade, String dataAniversario) {
        super(name, email);
        
        this.address = endereco;
        this.age = idade;
        this.birthDay = dataAniversario;
    }
    
    private String address;
    private int age;     
    private String birthDay; 
    
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
     public String getBirthDay() {
        return this.birthDay;
    }
    
    public void setBirthDay(String birthday) {
        this.birthDay = birthday;
    }
    
    public int getAge() {
        return this.age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }  
}