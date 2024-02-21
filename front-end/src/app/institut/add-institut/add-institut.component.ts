
  import { Component, EventEmitter, OnInit, Output } from '@angular/core';
  import { InstitutService } from '../../service/institut.service'
  import { ToastrService } from 'ngx-toastr';
  import { FormBuilder, FormGroup, FormControl, ReactiveFormsModule, Validators }
    from '@angular/forms';
  import { Router } from '@angular/router';
  import { MatDialogRef } from "@angular/material/dialog";
  @Component({
    selector: 'app-add-institut',
    templateUrl: './add-institut.component.html',
    styles: [
    ]
  })
  export class AddInstitutComponent implements OnInit {
  title : any;
  num : any;
  code !: string;
  submitted = false;
  textInput: any = "";
  slogant: string='';
  email: string='';
  tel2: string='';
  tel1: string=''; 
  libelle: string = '';
  libelleCourt: string = '';
  adresse: string = '';
  showLibelleCourtError: boolean=false; showLibelleError: boolean=false;showAdresseError : boolean=false;
  showslogantError : boolean=false;showTel1Error: boolean=false;showTel2Error: boolean=false;
  showEmailError: boolean=false;
      constructor(public crudApi: InstitutService, public fb: FormBuilder, public toastr: ToastrService,
        private router: Router,public dialogRef:MatDialogRef<AddInstitutComponent>) { }
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
        { this.infoForm() ;
        this.title ="Ajout Institut";
        this.onSelectCode();
      }
        else
        {
          this.title ="Modification Institut"
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
      validateEmail(event: any) {
        const input = event.target.value;
        this.email = input; 
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
    !formData.libelleCourt||
    !formData.adresse || 
    !formData.tel1 ||
    !formData.tel2 ||
    !formData.email ||
    !formData.slogant
  );
      }
    
      infoForm() {
        this.crudApi.formData = this.fb.group({
          id: null,
          code: ['', [Validators.required]],
          libelle: ['', [Validators.required]],
          libelleCourt: ['', [Validators.required]],
          adresse: ['', [Validators.required]],
          tel1: ['', [Validators.required]],
          tel2: ['', [Validators.required]],
          email: ['', [Validators.required]],
          slogant: ['', [Validators.required]],
        });
      }
      ResetForm() {
        this.crudApi.formData.reset();
      }
      onSelectCode() {
      
        this.crudApi.getCode().subscribe(
          response => {
          
            this.num = response;
            this.code = ( 1000 + this.num +1).toString().substring(1);
          
            this.f['code'].setValue(this.code);
          }
        );
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
      this.router.navigate(['/Instituts']);
    }
    
      addData() {
        
        this.crudApi.createData(this.crudApi.formData.value).
          subscribe(data => {
            this.dialogRef.close();
            this.crudApi.getAll().subscribe(
              response =>{this.crudApi.list = response;}
             );                                            
            this.router.navigate(['/instituts']);
          });
      }
      updateData() {
        this.crudApi.updatedata( this.crudApi.formData.value).
          subscribe(data => {
            this.dialogRef.close();
            this.crudApi.getAll().subscribe(
              response =>{this.crudApi.list = response;}
             );
            this.router.navigate(['/instituts']);
          });
      }

      onLibelleChange(value: string) {
        this.libelle = value;
        this.showLibelleError = !value.trim(); 
      }
  onLibellecourtChange(value: string) {
        this.libelleCourt = value;
        this.showLibelleCourtError = !value.trim(); 
      
      }
  onTel2Change(value: string) {
        this.tel2 = value;
        this.showTel2Error = !value.trim();
  }
  onTel1Change(value: string) {
    this.tel1 = value;
    this.showTel1Error = !value.trim();}

  onslogantChange(value: string) {
    this.slogant = value;
    this.showslogantError = !value.trim();
  }
  onAdresseChange(value: string) {
    this.adresse = value;
    this.showAdresseError = !value.trim();
  } 
  onEmailChange(value: string) {
    this.email = value;
    this.showEmailError = !value.trim();
  }


  isEmailValid(email: string): boolean {
    const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
    return emailRegex.test(email);
  }
    
  }
  

