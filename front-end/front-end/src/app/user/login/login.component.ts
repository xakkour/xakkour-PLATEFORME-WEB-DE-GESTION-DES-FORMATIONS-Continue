
import { Component, OnInit } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';
import { Router } from '@angular/router';
import { SecurityService } from 'src/app/service/SECURITY_SERVICE';
import { KeycloakProfile } from 'keycloak-js';

@Component({
  selector: 'app-login',
  templateUrl: '../../home/home.component.html',
  //templateUrl: '../../menu/menu.component.html',
})
export class LoginComponent implements OnInit {
  user: any = {};
  submitted = false;
  errorMessage !: string;
  name !: string;
  Wdate: any;
  annee !: 0;
  public profile?: KeycloakProfile;
  userService: any;
  datePipe: any;
  //userService.islogin = true;

  constructor(
    private keycloakService: KeycloakService,
    private router: Router,
    public securityService: SecurityService
  ) {}

  async ngOnInit() {  
    this.securityService.admin = false;


    // Check if the user is already authenticated
    if (await this.keycloakService.isLoggedIn()) {
      const userRoles = this.keycloakService.getUserRoles();
      this.userService.islogin = true;
      
      if (userRoles.includes('ADMIN')) {
        this.securityService.admin = true;
        this.router.navigate(['/home']); // Redirect to admin dashboard
      } else if (userRoles.includes('enseignant')) {
        this.securityService.enseignant = true;
        this.router.navigate(['/cours']); // Redirect to enseignant dashboard
      } else if (userRoles.includes('expert')) {
        this.securityService.expert = true;
        this.router.navigate(['/cours']); // Redirect to expert dashboard
      } else {
        // Handle other roles or scenarios as needed
        this.router.navigate(['/other-dashboard']); // Redirect to a generic dashboard or handle accordingly
      }
    }
  }

  logOut() {
    const logoutUrl = 'http://localhost:8080/realms/app/protocol/openid-connect/logout';

  // Add an event listener to detect when the logout is complete
  window.addEventListener('unload', function () {
    
    // Redirect the user to the login page after logout is complete
    window.location.href = 'http://localhost:4200/login';
  });

  // Redirect the user to the logout URL
  window.location.href = logoutUrl;


  
}
transformDate(date: any) {
  return this.datePipe.transform(date, 'yyyy-MM-dd');
}
}








/* ********************** Version 2 ******************** */

/* import { Component, OnInit } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';
import { Router } from '@angular/router';
import { SecurityService } from 'src/app/service/SECURITY_SERVICE';
import { KeycloakProfile } from 'keycloak-js';
import { UserService } from '../../service/user.service';


@Component({
  selector: 'app-login',
  templateUrl: '../../menu/menu.component.html',
})
export class LoginComponent implements OnInit {
  user: any = {};
  submitted = false;
  errorMessage !: string;
  name !: string;
  Wdate: any;
  annee !: 0;
 
  public profile? : KeycloakProfile;
  userService: any;
  toastr: any;
  constructor(
    private keycloakService: KeycloakService,
    private router: Router,
    public securityService:SecurityService
  ) {}

  async ngOnInit() {
    
    if (await this.keycloakService.isLoggedIn()) {
      
        const userRoles = this.keycloakService.getUserRoles();
        this.userService.admin = true;
       
  }
 }
 logOut() {
  const logoutUrl = 'http://localhost:8080/realms/app/protocol/openid-connect/logout';
  window.location.href = logoutUrl; // Redirect the user to the logout URL
}
} 
 */



/* ******************** Version 1 ***************************** */


/*  login() {
    
    this.keycloakService.init().then(() => {
      
    });
    
  }

    private redirectAfterLogin() {
    // Define the route you want to redirect to after login
    const targetRoute = 'www.google.com'; // Change this to your desired route

    // Use the Angular Router to navigate to the target route
    this.router.navigate(['/about']);
  } 
  
  
  
  
  
  
  
  
  
  
  
  login() {
    this.keycloakService.init().then(() => {
      // The user is now authenticated via Keycloak
    });
  }
  
  
  
  
  



/*
 import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { UserService } from '../../service/user.service';
import { FormBuilder, FormGroup, FormControl, ReactiveFormsModule, Validators }
  from '@angular/forms';
import { Router } from '@angular/router';

import { DatePipe } from '@angular/common';
import { AuthGaurdService } from 'src/app/service/auth-gaurd.service';
import { KeycloakService } from 'keycloak-angular';
import { KeycloakProfile } from 'keycloak-js';
  @Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styles: [
    ]
  })
export class LoginComponent implements OnInit {
  public profile? : KeycloakProfile;
 
  user: any = {};
  form!: FormGroup;
  loading = false;
  submitted = false;
  errorMessage !: string;
  name !: string;
  Wdate: any;
  annee !: 0;
  loginForm !: FormGroup;

  constructor(private router: Router, private userService: UserService,
    public toastr: ToastrService, private datePipe: DatePipe, public fb: FormBuilder,private  keycloakService: KeycloakService) { }
  ngOnInit() {
    this.userService.islogin = false;
    this.userService.admin = false;
    this.userService.enseignant = false;
    this.userService.etudiant = false;
    this.userService.rfi = false;
    this.userService.rit = false; 

    this.form = this.fb.group({
      'username': [null, Validators.required],
      'password': [null, Validators.required]
    }); 
  }
  get f() { return this.form.controls; }

   onSubmit() {
    this.submitted = true;

    // stop here if form is invalid
   if (this.form.invalid) {
      return;
    }
    const username = this.keycloakService.getUsername; 
    
   
    this.userService.login(val.username)
    
    .subscribe(
      res => {
      
        this.user = res;
        if (this.user)
        {
      if (this.user.password == val.password) {
          localStorage.setItem("name", this.user.nom);
          localStorage.setItem("idUser", this.user.id);
          localStorage.setItem("code", this.user.matricule);
          localStorage.setItem("role", this.user.role);
          localStorage.setItem("matricule", this.user.matricule);
          this.userService.islogin = true;
       
          if (this.user.role == "ETUDIANT") {
            this.userService.etudiant = true;
            this.router.navigate(['/course']);
          }
          else {
            this.router.navigate(['/about']);
            if (this.user.role == "ENSEIGNANT")
              this.userService.enseignant = true;
            else if (this.user.role == "RIT")
              this.userService.rit = true;
              else if (this.user.role == "RFI")
              this.userService.rfi = true;
              else if (this.user.role == "ADMIN")
              this.userService.admin = true;
          }
        }
        else {
          this.toastr.warning('Mot de Passe  Incorrecte ')
        }
      }
       else
       {
        this.toastr.warning('Login Incorrecte ')
       }

        

    }
    );
  }


  register() {
    this.router.navigate(['/register']);
  }

  logOut() {
    localStorage.removeItem("name");
  }



  transformDate(date: any) {
    return this.datePipe.transform(date, 'yyyy-MM-dd');
  }
  logout() {
    // remove user from local storage and set current user to null
    localStorage.removeItem('name');

  }
}


 */