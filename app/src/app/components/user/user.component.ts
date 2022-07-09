import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { DialogService } from 'src/app/helpers/dialog-service';
import { AuthService } from 'src/app/service/auth/auth.service';
import { TokenStorageService } from 'src/app/service/auth/token-storage.service';


@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  rCpf: string = '';
  rEmail: string = '';
  rPassword: string = '';
  email: string = '';
  password: string = '';  
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';
  isLoggedIn = false;
  isLoginFailed = false;
  userObject: any;
  data: any;
  signInForm: FormGroup;
  signUpForm: FormGroup;

  constructor(private dialog: DialogService, private _authService: AuthService, private tokenStorage: TokenStorageService, 
    private router: Router, private si: FormBuilder, private su: FormBuilder) {

      this.signInForm = this.si.group({
          email: ['', Validators.required ],
          password: ['', Validators.required ]
      });

      this.signUpForm = this.su.group({
        cpf: ['', Validators.required ],
        rEmail: ['', Validators.required ],
        rPassword: ['', Validators.required ]
    });
  }
  
  ngOnInit(): void {    
    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
      this.router.navigate(['home'])
    }    
  }

  async registerAsync() {  
      try {    
        await this._authService.create(this.rCpf, this.rEmail, this.rPassword);
        this.isSuccessful = true;
        this.isSignUpFailed = false;
        await this.dialog.showAlert('Sucesso', 'Usuário criado com sucesso !'); 
        this.dialog.reloadPage();
      } catch (error: any) {        
        this.dialog.showErr('Atenção', error.error);   
        this.isSignUpFailed = true;   
      }
}

async loginAsync() {  
  try {    
        const result = await this._authService.login(this.email, this.password);
        this.tokenStorage.saveToken(result.message);
        this.tokenStorage.saveUser(result.data);
    
        this.isLoginFailed = false;
        this.isLoggedIn = true;
        this.dialog.reloadPage();

      } catch (error: any) {        
        this.dialog.showErr('Atenção', error.error);      
      }
  } 
  
    change() {
      debugger
      const entrar = document.getElementById('entrar');
      const cadastrar = document.getElementById('cadastrar');
    
      if (entrar!.style.display !== 'none') {
        entrar!.style.display = 'none';
        cadastrar!.style.display = 'block';
      } else {
        entrar!.style.display = '';
        cadastrar!.style.display = 'none';
      }
  }
}



