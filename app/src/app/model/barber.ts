import { To } from "./to";

export interface Barber extends To  {   
    name: string;  
    userName: string;
    email: string;
    passwordHash: string;  
}