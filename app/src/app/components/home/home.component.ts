import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DialogService } from 'src/app/helpers/dialog-service';
import { HairCutService } from 'src/app/service/haircut-service';
import { TokenStorageService } from '../../service/auth/token-storage.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

   isLoggedIn = false;
   user: any;
   listaClientes: any[] = [];

  constructor(private dialog: DialogService, private tokenStorage: TokenStorageService, 
    private router: Router, private services: HairCutService){}

  ngOnInit(): void {
    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
      this.router.navigate(['home'])     
      this.user = this.tokenStorage.getUser();
    // this.getUserPositionAsync(this.user.id);
    }
    else
      this.router.navigate(['login']);

      this.listaClientes.push(
        {
            name: "Bruno"
        },
        {
          name: "Alexandre"
        },
        {
          name: "Laurent"
      })
  }

  async logoutAsync() {    
    if (await this.dialog.confirm('Sair', 'Deseja realmente sair?')){
      this.tokenStorage.signOut();
      window.location.reload();
    }
  }

  async createNewService(){

    let descricao = (document.getElementById('descricao') as HTMLInputElement).value;
    let preco = (document.getElementById('preco') as HTMLInputElement).value;

    var haircut = {  description: descricao, price: parseFloat(preco) }
    this.services.createHairCutAsync(haircut)
  }
}


