import { Barber } from "./barber";
import { To } from "./to";

export interface Shop extends To {
    name: string;
    phone1: string;
    phone2: string;
    email: string;
    address: string;
    barbers: Array<Barber>;
}
   