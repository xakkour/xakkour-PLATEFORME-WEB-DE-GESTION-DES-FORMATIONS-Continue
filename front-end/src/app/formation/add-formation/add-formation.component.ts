import { DatePipe } from '@angular/common';
import { Component, EventEmitter, Inject, Output } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { RequestService } from 'src/app/service/RequestService ';
import { ClasseService } from 'src/app/service/classe.service';
import { MatiereService } from 'src/app/service/matiere.service';

@Component({
  selector: 'app-add-formation',
  templateUrl: './add-formation.component.html',
  styleUrls: [

  ]
})
export class AddFormationComponent {
  requests: any[] = [];
  
    title: string = '';
    description: string = '';
    objectif: string = '';
    type: string = '';

  
  title1 : any;
  formationList  :any = [];
  matiereList  :any = [];
  numero : any;
  code !: string;
  num :any;
  submitted = false;showtypeError: boolean=false;  
  showodescriptionError: boolean=false;showobjectifeError: boolean=false; 
  showtitleError: boolean=false; 
  constructor(public requestService: RequestService, public fb: FormBuilder, public toastr: ToastrService,
    private router: Router,public dialogRef:MatDialogRef<AddFormationComponent>,public classeService: ClasseService,
    @Inject(MAT_DIALOG_DATA) public data :any,
    public matiereService: MatiereService, public datePipe : DatePipe) { }
    get f() { return this.requestService.formData.controls }
    @Output() showInputErrorChange = new EventEmitter<boolean>();
    private _showInputError = false;
    ngOnInit() {
  
      if (this.requestService.choixmenu == "A") 
      { this.infoForm()  
      this.title1 = "Ajouter Formation";
    }
      else
      {
        this.title1 = "Modification Formation";
      }
      this.requestService.getAll().subscribe(
        response => { this.formationList = response; }
      );
      }

  infoForm() {
    this.requestService.formData = this.fb.group({
      id: null,
      title: ['', [Validators.required]],
      description: ['', [Validators.required]],
      aprroved: null,
      objectif:['', [Validators.required]],
    });
  }

  limitLength(event: any): void {
    const input = event.target;
    if (input.value.length > 50) {
      input.value = input.value.substring(0, 50);
    }
  }   get isInputEmpty(): boolean {
    
    const formData = this.requestService.formData.value; 
   
return (
  !formData.title||
  !formData.description||
  !formData.objectif
  

);
}
get showInputError(): boolean {
return this._showInputError;
} set showInputError(value: boolean) {
this._showInputError = value;
this.showInputErrorChange.emit(value);
}


  addData() {
      
    this.requestService.submitFormationProposal(this.requestService.formData.value).
      subscribe(data => {
        this.dialogRef.close();
        this.requestService.getAll().subscribe(
          response =>{this.requestService.list = response;}
         );                                            
        this.router.navigate(['/formation']);
      });
  }
  updateData() {
    this.requestService.updatedata( this.requestService.formData.value).
      subscribe(data => {
        this.dialogRef.close();
        this.requestService.getAll().subscribe(
          response =>{this.requestService.list = response;}
         );
        this.router.navigate(['/formation']);
      });
  }
  
  onSubmit() {
   
    this.submitted = true;
    if (!this.isInputEmpty) {
      if (this.requestService.choixmenu == "A") {
        this.addData();
      } else {
        this.updateData();
      }
    } else {
         this.showInputError = true;
    }
      
  
  
  }



  getRequests(): void {
    this.requestService.getRequests().subscribe(data => {
      this.requests = data;
    });
  }
 
  ontypeChange(value: string) {
    this.type = value;
    this.showtypeError = !value.trim(); 
  
  }onobjectifChange(value: string) {
    this.objectif = value;
    this.showobjectifeError = !value.trim(); 
  
  }onodescriptionChange(value: string) {
    this.description = value;
    this.showodescriptionError = !value.trim(); 
  
  }ontitleChange(value: string) {
    this.title = value;
    this.showtitleError = !value.trim(); 
  
  }

  

}
