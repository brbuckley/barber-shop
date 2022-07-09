export class CommandResult {
    valid: boolean;
    message: string;
    data: any;

    constructor(valid: boolean, message: string, data: any) {
        this.valid = valid;
        this.message = message;
        this.data = data;
    }
}