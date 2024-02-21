import { Component, OnInit,Inject, EventEmitter, Output } from '@angular/core';
import { ClasseService } from '../../service/classe.service';
import { SpecialiteService } from '../../service/specialite.service';
import { DomaineService } from '../../service/domaine.service';
import { CycleService } from '../../service/cycle.service';
import { ToastrService } from 'ngx-toastr';
import { FormBuilder, FormGroup, FormControl, ReactiveFormsModule, Validators }
  from '@angular/forms';
import { Router } from '@angular/router';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
@Component({
  selector: 'app-add-classe',
  templateUrl: './add-classe.component.html',
  styles: [
  ]
})
export class AddClasseComponent implements OnInit {
  title : any;
  specialiteList  :any = [];
  domaineList  :any = [];
  cycleList  :any = [];
  num : any;
  code !: string;
  submitted = false;
  libelle: string = '';
  showcycleError: boolean=false; showspecialiteError: boolean=false;showLibelleError: boolean=false;showdomainError: boolean=false;
    constructor(public crudApi: ClasseService, public fb: FormBuilder, public toastr: ToastrService,
      private router: Router,public dialogRef:MatDialogRef<AddClasseComponent>,public specialiteService: SpecialiteService,
      @Inject(MAT_DIALOG_DATA) public data :any,
      public domaineService: DomaineService,public cycleService: CycleService) { }
      get f() { return this.crudApi.formData.controls }
      @Output() showInputErrorChange = new EventEmitter<boolean>();
      private _showInputError = false;
    ngOnInit() {
  
      if (this.crudApi.choixmenu == "A") 
      { this.infoForm() 
        
      this.onSelectCode();
      this.title = "Ajout Classe";
    }
      else
      {
        this.title = "Modification Classe";
      }
      this.specialiteService.getAll().subscribe(
        response => { this.specialiteList = response; }
      );
      this.domaineService.getAll().subscribe(
        response => { this.domaineList = response; }
      );
      this.cycleService.getAll().subscribe(
        response => { this.cycleList = response; }
      );
    }
     limitLength(event: any): void {
      const input = event.target;
      if (input.value.length > 50) {
        input.value = input.value.substring(0, 50);
      }
    }
    get isInputEmpty(): boolean {
      const formData = this.crudApi.formData.value; // Get the form data
return (
  !formData.libelle||
  !formData.codeSpecialite||
  !formData.codeDomaine||
  !formData.codeCycle
  );
}get showInputError(): boolean {
  return this._showInputError;
} set showInputError(value: boolean) {
  this._showInputError = value;
  this.showInputErrorChange.emit(value);
}
  
    onSelectCode() {
      
      this.crudApi.getNumero().subscribe(
        response => {
        
          this.num = response;
          this.code = ( 1000 + this.num +1).toString().substring(1);
        
          this.f['code'].setValue(this.code);
        }
      );
    }
  
    infoForm() {
      this.crudApi.formData = this.fb.group({
        id: null,
        code: ['', [Validators.required]],
        libelle: ['', [Validators.required]],
        codeSpecialite: ['', [Validators.required]],
        codeDomaine: ['', [Validators.required]],
        codeCycle: ['', [Validators.required]],

      });
    }
    ResetForm() {
      this.crudApi.formData.reset();
    }
    onSubmit() {
     
      this.submitted = true;
      if (!this.isInputEmpty) {
        if (this.crudApi.choixmenu == "A") {
          this.addData();
        } else {
          this.updateData();
        }
      } else {
           this.showInputError = true;
      }
    
    
    }
  
  lister()
  {
    this.router.navigate(['/classes']);
  }
  
    addData() {
      
      this.crudApi.createData(this.crudApi.formData.value).
        subscribe(data => {
          this.dialogRef.close();
          this.crudApi.getAll().subscribe(
            response =>{this.crudApi.list = response;}
           );                                            
          this.router.navigate(['/classes']);
        });
    }
    updateData() {
      this.crudApi.updatedata( this.crudApi.formData.value).
        subscribe(data => {
          this.dialogRef.close();
          this.crudApi.getAll().subscribe(
            response =>{this.crudApi.list = response;}
           );
          this.router.navigate(['/classes']);
        });
    }
    onLibelleChange(value: string) {
      this.libelle = value;
      this.showLibelleError = !value.trim(); 
    
    }
  }
  
