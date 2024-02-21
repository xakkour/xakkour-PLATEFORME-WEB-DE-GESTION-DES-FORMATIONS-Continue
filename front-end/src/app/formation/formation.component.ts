import { Component, Inject, OnInit } from '@angular/core';
import { RequestService } from '../service/RequestService ';
import { ToastrService } from 'ngx-toastr';
import { FormBuilder, FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { MAT_DIALOG_DATA, MatDialog, MatDialogConfig, MatDialogRef } from '@angular/material/dialog';
import { AddFormationComponent } from './add-formation/add-formation.component';
import { SecurityService } from '../service/SECURITY_SERVICE';
import { Subject, debounceTime, distinctUntilChanged, switchMap } from 'rxjs';

@Component({
  selector: 'app-formation',
  templateUrl: './formation.component.html',
  
  styles: [
  ]
})
export class FormationComponent  {
  requests: any[] = [];
  SearchText:any;
  p :number = 1;
  newFormationProposal: any= {};
  searchSubject: Subject<string> = new Subject<string>();
  constructor(public request: RequestService, public toastr: ToastrService,public securityService:SecurityService,
    private router: Router, public fb: FormBuilder,
    private matDialog: MatDialog,
    @Inject(MAT_DIALOG_DATA) public data: any,
    public dialogRef: MatDialogRef<AddFormationComponent>,) { }
    ngOnInit() {
      imports: [
        FormsModule,
      ]
      this.getData();
  
  
      
      this.searchSubject.pipe(
        debounceTime(300),
        distinctUntilChanged(), 
        switchMap((text: string) => {
            return this.request.searchData(text);
        })
      ).subscribe((result: any) => {
        
        this.request.list = result;
      });
    }
    onSearchTextChange() {
     
      this.searchSubject.next(this.SearchText);
    }


  getRequests(): void {
    this.request.getRequests().subscribe(data => {
      this.requests = data;
    });
  } 
  getData() {
    this.request.getAll().subscribe(
      response => {
        this.request.list = response;
        this.requests.sort((a, b) => a.id - b.id);
        
      }
    );
  }
  
  submitFormationProposal(): void {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.autoFocus = true;
    dialogConfig.disableClose = true;
    dialogConfig.width = "50%";
    this.matDialog.open(AddFormationComponent, dialogConfig);
    }
    selectData(item: any) {
      this.request.choixmenu = "M";
      this.request.formData = this.fb.group(Object.assign({}, item));
      const dialogConfig = new MatDialogConfig();
      dialogConfig.autoFocus = true;
      dialogConfig.disableClose = true;
      dialogConfig.width = "70%";
  
      this.matDialog.open(AddFormationComponent, dialogConfig);
    }


    
      confirmRequest(id: number): void {
        this.request.confirmRequest(id).subscribe(response => {
          console.log('Request confirmed:', response);
          
          // After successful approval, re-fetch the updated list of requests
          this.request.getRequests().subscribe(data => {
            this.requests = data;
          });
      
          // Optionally, you can also sort the data by ID
          this.requests.sort((a, b) => a.id - b.id);
        });
        this.reload() ;
      }

    denyRequest(id: number): void {
      this.request.denyRequest(id).subscribe(response => {
        console.log('Request denied:', response);
        this.getData(); // Refresh the list of requests
      });
      this.reload() ;
    }
    reload(){
      window.location.reload();
    }
    removeData(id: number) {
      if (window.confirm('Are sure you want to delete this Etablissement ?')) {
        this.request.deleteData(id)
          .subscribe(
            data => {
              console.log(data);
              this.toastr.warning(' data successfully deleted!');
              this.getData();
            },
            error => console.log(error));
      }
    }

   
   /*  confirmRequest(id: number): void {
        this.request.confirmRequest(id).subscribe(response => {
          console.log('Request confirmed:', response);
          this.request.getRequests().subscribe(data => {
            this.requests = data;
        });
      } */

}
