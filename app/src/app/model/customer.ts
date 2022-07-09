import { To } from "./to";

export interface Customer extends To  {   
    name: string;  
    userName: string;
    email: string;
    passwordHash: string;
}