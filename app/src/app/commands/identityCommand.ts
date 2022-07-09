interface  RegisterCommand {    
    name: number;  
    cpf: string;
    email: string;
    password : string;
 }

 interface  LoginCommand {    
    email: string;
    password: string;
 }