import { Injectable } from '@angular/core';


const TOKEN_KEY = 'token';
const USER_KEY = 'user';


@Injectable({
  providedIn: 'root'
})
export class TokenStorageService {
  constructor() { }
  
  signOut(): void {
    sessionStorage.clear();
  }
  public saveToken(token: string): void {  
    sessionStorage.removeItem(TOKEN_KEY);
    sessionStorage.setItem(TOKEN_KEY, JSON.stringify(token));
  }
  public getToken(): string | null {
    return sessionStorage.getItem(TOKEN_KEY);
  }
  public saveUser(user: any): void {    
    sessionStorage.removeItem(USER_KEY);
    sessionStorage.setItem(USER_KEY, JSON.stringify(user));
  }
  public getUser(): any {    
    const user = sessionStorage.getItem(USER_KEY);
    if (user && user != 'undefined') {
      return JSON.parse(user);
    }
    return {};
  }
}