import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { UserService } from './user.service';
import { KeycloakService } from 'keycloak-angular';
import { SecurityService } from './SECURITY_SERVICE';

@Injectable({
  providedIn: 'root'
})
export class AuthGaurdService implements CanActivate {
   role =this.securityService.getUserRoles();
  constructor(private router: Router,public securityService:SecurityService,private keycloakService: KeycloakService,
    private userService: UserService) { }

  async canActivate(): Promise<boolean>  {
    if (await this.keycloakService.getToken()) {
      
      return true; // User is authenticated
    }   if ( this.role.includes('ADMIN'||'enseignant')) {
      return true; // Allow access to the route
    } else {
      this.router.navigate(['/access-denied']); // Redirect to an access-denied page or any other appropriate page
      return false; // Prevent access to the route
    }
  }
}
