import { Injectable, OnInit } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import {  map } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})

export class BarberService implements OnInit {
  
  constructor(private http: HttpClient) {}

  ngOnInit(): void {      
  }

  protected url(param: string = ""): string {
    return `${environment.api_url}/barber/${param}`;
  }


  async createBarberAsync(barberDto: any): Promise<any> {    
    try {
      return await this.http.post<any>(this.url(`new`), barberDto)
      .pipe(map(x => {
        return {
         // Ver o retorno
        }
        })).toPromise();         
    } catch (error) {
      throw error;
    }
  } 

  async updateBarberAsync(barber: any): Promise<any> {    
    try {
      return await this.http.post<any>(this.url(`update`), barber)
      .pipe(map(x => {
        return {
          // Ver o retorno
        }
        })).toPromise();         
    } catch (error) {
      throw error;
    }
  } 
  
  async getBarberAsync(id: number) : Promise<any> {
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

  async deleteBarberAsync(id: number) {
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