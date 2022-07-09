import { Injectable, OnInit } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import {  map } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})

export class QueueService implements OnInit {
  
  constructor(private http: HttpClient) {}

  ngOnInit(): void {      
  }

  protected url(param: string = ""): string {
    return `${environment.api_url}/queue/${param}`;
  }


  async createQueueAsync(eventDto: any): Promise<any> {    
    try {
      return await this.http.post<any>(this.url(`new`), eventDto)
      .pipe(map(x => {
        return {
         // Ver o retorno
        }
        })).toPromise();         
    } catch (error) {
      throw error;
    }
  } 

  async updateQueueAsync(customer: any): Promise<any> {    
    try {
      return await this.http.post<any>(this.url(`update`), customer)
      .pipe(map(x => {
        return {
          // Ver o retorno
        }
        })).toPromise();         
    } catch (error) {
      throw error;
    }
  } 
  
  async getQueueAsync(id: number) : Promise<any> {
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

  async deleteQueueAsync(id: number) {
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