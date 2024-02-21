import { Component, OnInit, Inject, EventEmitter, Output } from '@angular/core';
import { SpecialiteService } from '../../service/specialite.service'
import { ToastrService } from 'ngx-toastr';
import { FormBuilder, FormGroup, FormControl, ReactiveFormsModule, Validators }
  from '@angular/forms';
import { Router } from '@angular/router';
import { MatDialogRef } from "@angular/material/dialog";

@Component({
  selector: 'app-add-specialite',
  templateUrl: './add-specialite.component.html',
  styles: [
  ]
})
export class AddSpecialiteComponent implements OnInit {
  title: any;

  num: any;
  code !: string;
  submitted = false;
  libelle: string = '';
  showLibelleError: boolean=false;

  constructor(public crudApi: SpecialiteService, public fb: FormBuilder, public toastr: ToastrService,
    private router: Router, public dialogRef: MatDialogRef<AddSpecialiteComponent>) { }
  get f() { return this.crudApi.formData.controls }
  @Output() showInputErrorChange = new EventEmitter<boolean>();
  private _showInputError = false;
  ngOnInit() {

    if (this.crudApi.choixmenu == "A") {
      this.infoForm()
      this.onSelectCode()
      this.title = "Ajout Spécialité"
    }
    else {
      this.title = "Modification Spécialité"
    }
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
!formData.libelle
);
}
get showInputError(): boolean {
return this._showInputError;
} set showInputError(value: boolean) {
this._showInputError = value;
this.showInputErrorChange.emit(value);
}

  onSelectCode() {

    this.crudApi.getNumero().subscribe(
      response => {

        this.num = response;
        this.code = (1000 + this.num + 1).toString().substring(1);

        this.f['code'].setValue(this.code);
      }
    );
  }

  infoForm() {
    this.crudApi.formData = this.fb.group({
      id: null,
      code: ['', [Validators.required]],
      libelle: ['', [Validators.required]],
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

  lister() {
    this.router.navigate(['/specialites']);
  }

  addData() {

    this.crudApi.createData(this.crudApi.formData.value).
      subscribe(data => {
        this.dialogRef.close();
        this.crudApi.getAll().subscribe(
          response => { this.crudApi.list = response; }
        );
        this.router.navigate(['/specialites']);
      });
  }
  updateData() {
    this.crudApi.updatedata(this.crudApi.formData.value).
      subscribe(data => {
        this.dialogRef.close();
        this.crudApi.getAll().subscribe(
          response => { this.crudApi.list = response; }
        );
        this.router.navigate(['/specialites']);
      });
  }
  onLibelleChange(value: string) {
    this.libelle = value;
    this.showLibelleError = !value.trim(); 
  
  }

}

