
import { Component, OnInit } from '@angular/core';
import { UserService } from '../../service/user.service'
import { ToastrService } from 'ngx-toastr';
import { FormBuilder, FormGroup, FormControl, Validators }
  from '@angular/forms';
import { Router } from '@angular/router';
import { MatDialogRef } from "@angular/material/dialog";
import { MustMatch } from '../../validator/must-match.validator';
import { ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-reset-password',
  templateUrl: './reset-password.component.html',
  styles: [
  ]
})
export class ResetPasswordComponent implements OnInit {
  submitted = false;
  token !: string;
  form !: FormGroup;
  get f() { return this.form.controls; }

  constructor(public service: UserService, public fb: FormBuilder, public toastr: ToastrService,
    private router: Router, private route: ActivatedRoute,
    public dialogRef: MatDialogRef<ResetPasswordComponent>) { }

  ngOnInit() {
    ;
    this.infoForm();
    this.route.queryParams.subscribe(params => {
      this.token = params['token'];
       // affiche le token dans la console
    });
      
      this.f['token'].setValue(this.token);
      
    }

  




  infoForm() {
    this.form = this.fb.group({
      password: [' ', [Validators.required, Validators.minLength(8)]],
      pwd: ['', [Validators.required]],
      
    }, {
      validator: MustMatch('password', 'pwd')
    });
  }



  onReset() {
    this.submitted = false;
    this.dialogRef.close();
    this.router.navigate(['/users']);
  }
  onSubmit() {
  
    this.submitted = true;
    this.service.resetPassword(this.token,this.form.value.password).
      subscribe(data => {
        this.router.navigate(['/login']);
      });
    
  }
}




















