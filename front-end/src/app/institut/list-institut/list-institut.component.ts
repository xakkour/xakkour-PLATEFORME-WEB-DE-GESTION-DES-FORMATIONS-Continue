
  import { Component, OnInit, Inject } from '@angular/core';
  import { InstitutService } from '../../service/institut.service';
  import { ToastrService } from 'ngx-toastr';
  import { Router } from '@angular/router';
  import { FormBuilder, FormsModule } from '@angular/forms';
  import { MatDialog, MatDialogConfig, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
  import { AddInstitutComponent } from '../../institut/add-institut/add-institut.component';
import { Subject, debounceTime, distinctUntilChanged, switchMap } from 'rxjs';
  
  @Component({
    selector: 'app-list-institut',
    templateUrl: './list-institut.component.html',
    styles: [
    ]
  })
  export class ListInstitutComponent implements OnInit {
    Institut :any;
    p :number = 1;
    SearchText:string = '';
      searchSubject: Subject<string> = new Subject<string>();
    constructor(public crudApi: InstitutService, public toastr: ToastrService,
      private router: Router, public fb: FormBuilder,
      private matDialog: MatDialog,
      @Inject(MAT_DIALOG_DATA) public data: any,
      public dialogRef: MatDialogRef<AddInstitutComponent>,) { }
  
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
      if (window.confirm('Are sure you want to delete this Institut ?')) {
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
  
      this.matDialog.open(AddInstitutComponent, dialogConfig);
    }
    addInstitut() {
      this.crudApi.choixmenu = "A";
      const dialogConfig = new MatDialogConfig();
      dialogConfig.autoFocus = true;
      dialogConfig.disableClose = true;
      dialogConfig.width = "70%";
      this.matDialog.open(AddInstitutComponent, dialogConfig);
    }
  
  }
  

