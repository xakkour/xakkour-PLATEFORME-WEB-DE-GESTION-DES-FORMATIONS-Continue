import { Component, OnInit,Inject } from '@angular/core';
  import { CycleService } from '../../service/cycle.service';
  import { ToastrService } from 'ngx-toastr';
  import { Router } from '@angular/router';
  import { FormBuilder, FormsModule } from '@angular/forms';
  import {MatDialog, MatDialogConfig,MatDialogRef,MAT_DIALOG_DATA  } from '@angular/material/dialog';
  import { AddCycleComponent } from '../../cycle/add-cycle/add-cycle.component';
import { Subject, debounceTime, distinctUntilChanged, switchMap } from 'rxjs';

@Component({
  selector: 'app-list-cycle',
  templateUrl: './list-cycle.component.html',
  styles: [
  ]
})
export class ListCycleComponent implements OnInit {
  Specialite :any;
  SearchText:string = '';
  p :number = 1;
  searchSubject: Subject<string> = new Subject<string>(); // Create a subject for search
  constructor(public crudApi: CycleService, public toastr: ToastrService,
    private router: Router, public fb: FormBuilder,
    private matDialog: MatDialog,
    @Inject(MAT_DIALOG_DATA) public data: any,
    public dialogRef:MatDialogRef<AddCycleComponent>,) { }

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
  

  removeData(code: string) {
    if (window.confirm('Are sure you want to delete this Cycle ?')) {
      this.crudApi.deleteData(code)
        .subscribe(
          data => {
            console.log(data);
            this.toastr.warning(' data successfully deleted!');
            this.getData();
          },
          error => console.log(error));
    }
  }
  selectData(item : any) {
    this.crudApi.choixmenu = "M";
    this.crudApi.formData = this.fb.group(Object.assign({},item));
    const dialogConfig = new MatDialogConfig();
    dialogConfig.autoFocus = true;
    dialogConfig.disableClose = true;
    dialogConfig.width="50%";
    
    this.matDialog.open(AddCycleComponent, dialogConfig);
  }
  addCycle()
  {
    this.crudApi.choixmenu = "A";
      const dialogConfig = new MatDialogConfig();
      dialogConfig.autoFocus = true;
      dialogConfig.disableClose = true;
      dialogConfig.width="50%";
      this.matDialog.open(AddCycleComponent, dialogConfig);
    }

}

