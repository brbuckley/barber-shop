import { Injectable, OnInit } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import {  map } from 'rxjs/operators';
import { DialogService } from '../helpers/dialog-service';


@Injectable({
  providedIn: 'root'
})

export class AdminService implements OnInit {
  
  constructor(private http: HttpClient, private dialog: DialogService) {}

  ngOnInit(): void {      
  }

  protected url(param: string = ""): string {
    return `${environment.api_url}/admin/${param}`;
  }


  async createAdminAsync(adminDto: any): Promise<any> {    
    try {
      return await this.http.post<any>(this.url(`new`), adminDto)
      .pipe(map(x => {
          this.dialog.showAlert('Sucesso', 'Usuário criado com sucesso !'); 
          this.dialog.reloadPage();
        })).toPromise();         
    } catch (error) {
      this.dialog.showErr('Atenção', 'Falha no processo. Tente novamente');   
    }
  } 

  async updateAdminAsync(admin: any): Promise<any> {    
    try {
      return await this.http.post<any>(this.url(`update`), admin)
      .pipe(map(x => {
          this.dialog.showAlert('Sucesso', 'Usuário atualizado com sucesso !'); 
          this.dialog.reloadPage();      
        })).toPromise();          
    } catch (error) {
      this.dialog.showErr('Atenção', 'Falha no processo. Tente novamente');   
    }
  } 


  async getAdminAsync(id: number): Promise<any> {
      try {
        return await this.http.get<any>(this.url(`${id}`))
          .pipe(map(x => {
            return {
             // Ver o retorno
            }
          })).toPromise();         
      } catch (error) {
        throw error;
      }
     }
  
  async getAdminByIdAsync(id: number) : Promise<any> {
    try {
      return await this.http.get<any>(this.url(`${id}`))
        .pipe(map(x => {
          return {
           // Ver o retorno
          }
        })).toPromise();         
    } catch (error) {      
      throw error;
    }
  }

  async deleteAdminAsync(id: number) {
    try {
      return await this.http.delete(this.url(`delete/${id}`))
      .subscribe({
          next: data => {
            //  ver o que fazer com  retorno
          },
          error: error => {
              //  ver o que fazer com  retorno             
          }
      });
    } catch (error) {
      throw error;
    }
  }
}