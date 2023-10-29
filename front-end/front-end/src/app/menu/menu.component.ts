import { Component, OnInit } from '@angular/core';
import { UserService} from '../service/user.service';
import { Router } from '@angular/router';
import { SecurityService } from '../service/SECURITY_SERVICE';
import { KeycloakEventType, KeycloakService } from "keycloak-angular";
import { KeycloakProfile } from "keycloak-js";
@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styles: [
  ]
})
export class MenuComponent implements OnInit {
  name: string | undefined;
  role: string[] | undefined;
  id :any;
  keycloakService: any;
  userRoles: string[] | undefined;
  
  constructor(public userService: UserService,private router: Router ,public securityService:SecurityService,public kcService: KeycloakService) { }
  //constructor(public securityService:SecurityService,private router: Router){}

  ngOnInit(): void {
    this.name = this.securityService.profile?.username;
    const userRoles = this.securityService.userRoles;
    


    //this.name = localStorage.getItem("name");
    
    //this.id = localStorage.getItem("idUser");
    
    //this.role =localStorage.getItem("role");

  }
logOut()
{
  const postLogoutRedirectUri  = 'http://localhost:8080/realms/app/protocol/openid-connect/logout';
  const idTokenHint = this.kcService.getKeycloakInstance().idToken;
 /*  
  window.location.href = logoutUrl; */
  
  this.kcService.logout();
  


}
}

