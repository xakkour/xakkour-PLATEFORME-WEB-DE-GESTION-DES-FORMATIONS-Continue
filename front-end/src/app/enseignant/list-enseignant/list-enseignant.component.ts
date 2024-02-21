import { Component, OnInit, Inject } from '@angular/core';
import { EnseignantService } from '../../service/enseignant.service';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';
import { FormBuilder, FormsModule } from '@angular/forms';
import { MatDialog, MatDialogConfig, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { AddEnseignantComponent } from '../../enseignant/add-enseignant/add-enseignant.component';
import { SecurityService } from 'src/app/service/SECURITY_SERVICE';
import { Subject, debounceTime, distinctUntilChanged, switchMap } from 'rxjs';
@Component({
  selector: 'app-list-enseignant',
  templateUrl: './list-enseignant.component.html',
  styles: [
  ]
})
export class ListEnseignantComponent implements OnInit {
  Enseignant :any;
  SearchText:any;
  p :number = 1;
  name: string | undefined;
  role: string[] | undefined;
  keycloakService: any;
  userRoles: string[] | undefined;
  searchSubject: Subject<string> = new Subject<string>();
  
  constructor(public crudApi: EnseignantService, public toastr: ToastrService,public securityService:SecurityService,
    private router: Router, public fb: FormBuilder,
    private matDialog: MatDialog,
    @Inject(MAT_DIALOG_DATA) public data: any,
    public dialogRef: MatDialogRef<AddEnseignantComponent>,) { }

    ngOnInit() {
      imports: [
        FormsModule,
      ]
      this.getData();
  
  
      
      this.searchSubject.pipe(
        debounceTime(300),
        distinctUntilChanged(), 
        switchMap((text: string) => {
            return this.crudApi.searchData(text);
        })
      ).subscribe((result: any) => {
        
        this.crudApi.list = result;
      });
    }
    onSearchTextChange() {
     
      this.searchSubject.next(this.SearchText);
    }


  getData() {
    this.crudApi.getAll().subscribe(
      response => {
        this.crudApi.list = response;
      }
    );
  }

  removeData(id : number) {
    if (window.confirm('Are sure you want to delete this Catégorie ?')) {
      this.crudApi.deleteData(id)
        .subscribe(
          data => {
            console.log(data);
            this.toastr.warning(' data successfully deleted!');
            this.getData();
          },
          error => console.log(error));
    }
  }
  selectData(item: any) {
    this.crudApi.choixmenu = "M";
    this.crudApi.formData = this.fb.group(Object.assign({}, item));
    const dialogConfig = new MatDialogConfig();
    dialogConfig.autoFocus = true;
    dialogConfig.disableClose = true;
    dialogConfig.width = "70%";

    this.matDialog.open(AddEnseignantComponent, dialogConfig);
  }
  addEnseignant() {
    this.crudApi.choixmenu = "A";
    const dialogConfig = new MatDialogConfig();
    dialogConfig.autoFocus = true;
    dialogConfig.disableClose = true;
    dialogConfig.width = "70%";
    this.matDialog.open(AddEnseignantComponent, dialogConfig);
  }
}




  




