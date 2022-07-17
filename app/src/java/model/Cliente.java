package model;

public class Cliente extends Usuario  { 
    
    public Cliente(int id, String name, String email) {
        super(id, name, email);
    }
    
    public Cliente(String name, String email) {
        super(name, email);
    }
    
    private String address;
    private int age;     
    private String birthday; 
    
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
     public String getBirthday() {
        return this.birthday;
    }
    
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    
    public int getAge() {
        return this.age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }  
}