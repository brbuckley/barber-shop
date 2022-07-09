import { Injectable } from '@angular/core';
import Swal from 'sweetalert2';

@Injectable({
  providedIn: 'root'
})
export class DialogService {
  
  async showAlert(title: string, message: string): Promise<void> {
    await Swal.fire({
      title: title,
      text: message,
      icon: 'success',
      showCancelButton: false,
      confirmButtonText: 'OK'
    });
  }

  reloadPage(): void {
    window.location.reload();
  }
 
  async showErr(title: string, message: string): Promise<void> {
    await Swal.fire({
      title: title,
      text: message,
      icon: 'warning',
      showCancelButton: false,
      confirmButtonText: 'OK'
    });
  } 

  async info(title: string, message?: string): Promise<void> {
    await Swal.fire({
      title: title,
      html: message,
      icon: 'info',
      showCancelButton: false,
      confirmButtonText: 'OK',
      allowOutsideClick: false,
      allowEscapeKey: false,
      allowEnterKey: false,
      confirmButtonColor: '##0062CC'
    });
  }


  async confirm(title: string, message?: string): Promise<boolean> {
    const result = await Swal.fire<boolean>({
      title: title,
      html: message,
      icon: 'question',
      showCancelButton: true,
      cancelButtonText: 'Não',
      confirmButtonText: 'Sim',
      allowOutsideClick: false,
      allowEscapeKey: false,
      allowEnterKey: false,
      confirmButtonColor: '##0062CC'
    });
    return await result.value as boolean;
  }
}