import { Injectable, OnInit } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import {  map } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})

export class AdminService implements OnInit {
  
  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.getAdminAsync();    
  }

  protected url(param: string = ""): string {
    return `${environment.api_url}/admin/${param}`;
  }


  async AdminAsync(eventDto: any): Promise<any> {    
    try {
      return await this.http.post<any>(this.url(`new`), eventDto)
      .pipe(map(x => {
        return {
          message: x.message,
          valid: x.valid,
          data: x.data
        }
        })).toPromise();         
    } catch (error) {
      throw error;
    }
  } 


  async getAdminAsync(): Promise<any> {
      try {
        return await this.http.get<any>(this.url())
          .pipe(map(x => {
            return {
              message: x.message,
              valid: x.valid,
              data: x.data
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
            message: x.message,
            valid: x.valid,
            data: x.data
          }
        })).toPromise();         
    } catch (error) {      
      throw error;
    }
  }
}