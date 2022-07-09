import { To } from "./to";

export class User extends To {
    
    public name: string;  
    public userName: string;
    public email: string;
    public passwordHash: string;
 
    
    constructor(id: number, name: string, userName: string, email: string, passwordHash: string)
    {
        super(id);      
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.passwordHash = passwordHash;
    }
}