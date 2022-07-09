import { To } from "./to";

export interface User extends To  {   
     name: string;  
     userName: string;
     email: string;
     passwordHash: string;
}