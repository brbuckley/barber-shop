import { Injectable, OnInit } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import {  map } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})

export class AppointmentService implements OnInit {
  
  constructor(private http: HttpClient) {}

  ngOnInit(): void {       
  }

  protected url(param: string = ""): string {
    return `${environment.api_url}/appointment/${param}`;
  }


  async createAppointmentAsync(appointmentDto: any): Promise<any> {    
    try {
      return await this.http.post<any>(this.url(`new`), appointmentDto)
      .pipe(map(x => {
        return {
         // Ver o retorno
        }
        })).toPromise();         
    } catch (error) {
      throw error;
    }
  } 

  async updateAppointmentAsync(appointId: number, status: string): Promise<any> {    
    try {
      return await this.http.post<any>(this.url(`update`), {appointId, status})
      .pipe(map(x => {
        return {
          // Ver o retorno
        }
        })).toPromise();         
    } catch (error) {
      throw error;
    }
  } 


  async getAppointmentAsync(): Promise<any> {
      try {
        return await this.http.get<any>(this.url())
          .pipe(map(x => {
            return {
              // Ver o retorno
            }
          })).toPromise();         
      } catch (error) {
        throw error;
      }
  }

  async deleteAppointmentAsync(id: number) {
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