import { Component, OnInit, Inject } from '@angular/core';
import { ClasseService } from '../../service/classe.service';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';
import { FormBuilder, FormsModule } from '@angular/forms';
import { MatDialog, MatDialogConfig, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { AddClasseComponent } from '../../classe/add-classe/add-classe.component';
import { Subject, debounceTime, distinctUntilChanged, switchMap } from 'rxjs';

@Component({
  selector: 'app-list-classe',
  templateUrl: './list-classe.component.html',
  styles: [
  ]
})
export class ListClasseComponent implements OnInit {
  p :number = 1;
  SearchText:string = '';
    searchSubject: Subject<string> = new Subject<string>();
  classe : any;
  constructor(public crudApi: ClasseService, public toastr: ToastrService,
    private router: Router, public fb: FormBuilder,
    private matDialog: MatDialog,
    @Inject(MAT_DIALOG_DATA) public data: any,
    public dialogRef: MatDialogRef<AddClasseComponent>,) { }


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

  removeData(id: number) {
    if (window.confirm('Are sure you want to delete this Classe ?')) {
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
    dialogConfig.width = "50%";

    this.matDialog.open(AddClasseComponent, dialogConfig);
  }
  addClasse() {
    this.crudApi.choixmenu = "A";
    const dialogConfig = new MatDialogConfig();
    dialogConfig.autoFocus = true;
    dialogConfig.disableClose = true;
    dialogConfig.width = "50%";
    this.matDialog.open(AddClasseComponent, dialogConfig);
  }
}



