import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DialogService } from 'src/app/helpers/dialog-service';
import { Asset } from 'src/app/model/asset';
import { TokenStorageService } from '../../service/auth/token-storage.service';
import { Patrimony } from 'src/app/model/patrimony';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  topAssets: Asset[] = [];
  totalInvested: number = 0;
  patrimony: Patrimony = { accountAmount: 0, totalAmount: 0, assets: null};
  isLoggedIn = false;
  user: any;
  asset: any;
  listaClientes: any[] = [];

  constructor(private dialog: DialogService, private tokenStorage: TokenStorageService, 
    private router: Router){}

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
}


