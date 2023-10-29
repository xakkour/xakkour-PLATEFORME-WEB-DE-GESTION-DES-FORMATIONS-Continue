import { Injectable } from "@angular/core";
import { Router } from "@angular/router";
import { KeycloakEventType, KeycloakService } from "keycloak-angular";
import { KeycloakProfile } from "keycloak-js";

@Injectable({providedIn : "root"})
export class SecurityService {
public profile? : KeycloakProfile;
public admin: boolean = false;
public enseignant: boolean = false;
public expert: boolean = false;
public userRoles: string[] = [];


constructor (public kcService: KeycloakService,private router: Router) {
this.init();
}
init() {
  this.kcService.keycloakEvents$.subscribe({
    next: (e) => {
      if (e.type == KeycloakEventType.OnAuthSuccess) {
        this.kcService.loadUserProfile().then((profile) => {
          this.profile = profile;
          

          const userRoles = this.kcService.getUserRoles();
          if (userRoles.includes('ADMIN')) {
            this.admin = true;
           // this.router.navigate(['/home']);
          } else if (userRoles.includes('enseignant')) {
            this.enseignant = true;
           // this.router.navigate(['/formation']);
          } else if (userRoles.includes('expert')) {
            this.expert = true;
           // this.router.navigate(['/formation']);
          }
        });
      }
    },
  });

  this.userRoles = this.kcService.getUserRoles();

 /*  this.kcService.keycloakEvents$.subscribe({
    next: (e) => {
      if (e.type == KeycloakEventType.OnAuthLogout) {
        // User has logged out, navigate to localhost:4200
        console.log('User logged out');
        this.router.navigate(['/']);
      }
    },
  }); */

  
}


public getUserRoles(): string[] {
    const allRoles = this.kcService.getUserRoles();
    const additionalRoles = ['ADMIN', 'enseignant', 'expert'];
    const userRoles = allRoles.filter(role => additionalRoles.includes(role));
    return userRoles;
  }

 


}