export class Asset {
    public symbol: string;  
    public price: number;  
    public qt: number;
 
    
    constructor(symbol: string, price: number, qt: number){
        this.symbol = symbol;
        this.price  = price;
        this.qt = qt;
    }
}