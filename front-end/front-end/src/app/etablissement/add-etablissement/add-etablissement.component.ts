
  import { Component, ElementRef, EventEmitter, OnInit, Output, ViewChild } from '@angular/core';
  import { EtablissementService } from '../../service/etablissement.service'
  import { ToastrService } from 'ngx-toastr';
  import { FormBuilder, FormGroup, FormControl, ReactiveFormsModule, Validators }
    from '@angular/forms';
  import { Router } from '@angular/router';
  import { MatDialogRef } from "@angular/material/dialog";
  @Component({
    selector: 'app-add-etablissement',
    templateUrl: './add-etablissement.component.html',
    styles: [
      `
      .has-error {
  border: 1px solid red;
  background-color: #ffdddd;
      }
    `
    ]
  })
  export class AddEtablissementComponent implements OnInit {
  title : any;
  //showInputError: boolean = false;
  num : any;
  numericValue: string = "";
  code !: string;
  submitted = false;
  textInput: any = "";
  
    tel: string=''; libelle: string = '';ville: string = '';adresse: string = '';
  showLibelleError: boolean=false;showAdresseError : boolean=false;
  showVilleError : boolean=false;showTelError: boolean=false;
     
    
      constructor(public crudApi: EtablissementService, textInput: ElementRef ,public fb: FormBuilder, public toastr: ToastrService,
        private router: Router,public dialogRef:MatDialogRef<AddEtablissementComponent>) { }
        get f() { return this.crudApi.formData.controls }

        @Output() showInputErrorChange = new EventEmitter<boolean>();
        private _showInputError = false;



        get showInputError(): boolean {
          return this._showInputError;
        } set showInputError(value: boolean) {
          this._showInputError = value;
          this.showInputErrorChange.emit(value);
        }
      
      ngOnInit() {
    
        if (this.crudApi.choixmenu == "A") 
        { this.infoForm() 
        this.onSelectCode();
        this.title ="Ajout Etablissement"}
        else
        {
          this.title ="Modification Etablissement"
        };
      }
    

      allowNumbersPlus(event: any): void {
        const input = event.target;
        input.value = input.value.replace(/[^0-9+]/g, "");
      }
      limitLength(event: any): void {
        const input = event.target;
        if (input.value.length > 50) {
          input.value = input.value.substring(0, 50);
        }
      }

      ensureNotEmpty(event: any): void {
        const input = event.target;
        if (input.value === "") {
          input.value = '';
          this.toastr.error('Input cannot be empty!');
        } else {
          this.showInputError = false;
        }
      } get isInputEmpty(): boolean {
        const formData = this.crudApi.formData.value; // Get the form data
  return (
    !formData.libelle ||
    !formData.adresse ||
    !formData.ville ||
    !formData.tel
  );
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
          libelle: ['', [Validators.required ,Validators.maxLength(50),Validators.minLength(3)]],
          adresse: ['', [Validators.required ,Validators.maxLength(50),Validators.minLength(3)]],
          ville: ['', [Validators.required ,Validators.maxLength(50),Validators.minLength(3)]],
          tel: ['', [Validators.required ,Validators.maxLength(10),Validators.minLength(10)] ],
        });
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
      this.router.navigate(['/Etablissements']);
    }
    
      addData() {
        
        this.crudApi.createData(this.crudApi.formData.value).
          subscribe(data => {
            this.dialogRef.close();
            this.crudApi.getAll().subscribe(
              response =>{this.crudApi.list = response;}
             );                                            
            this.router.navigate(['/Etablissements']);
          });
      }
      updateData() {
        this.crudApi.updatedata( this.crudApi.formData.value).
          subscribe(data => {
            this.dialogRef.close();
            this.crudApi.getAll().subscribe(
              response =>{this.crudApi.list = response;}
             );
            this.router.navigate(['/Etablissements']);
          });
      }

      onLibelleChange(value: string) {
        this.libelle = value;
        this.showLibelleError = !value.trim(); 
      
      }
      onTelChange(value: string) {
        this.tel = value;
        this.showTelError = !value.trim();
  }
  onVilleChange(value: string) {
    this.ville = value;
    this.showVilleError = !value.trim();
  }
  onAdresseChange(value: string) {
    this.adresse = value;
    this.showAdresseError = !value.trim();
  }
}

