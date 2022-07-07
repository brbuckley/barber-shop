export class User {
    id: number;  
    cpf: string;  
    account: number;  
    branch: number;
    patrimonyId: number;
    userId: number;
    
    constructor(id: number, cpf: string, account: number, branch: number, patrimonyId: number, userId: number){
        this.id = id;
        this.cpf = cpf;
        this.account = account;
        this.branch = branch;
        this.patrimonyId = patrimonyId;
        this.userId = userId;
    }
}