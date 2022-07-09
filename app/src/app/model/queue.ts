import { Barber } from "./barber";
import { To } from "./to";

export interface Queue  extends To {
    barber: Barber;  
    assets: any;  
    totalAmount: number;  
}
   