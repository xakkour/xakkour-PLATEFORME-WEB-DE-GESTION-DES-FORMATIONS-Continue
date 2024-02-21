import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { FormBuilder, FormGroup, FormControl, ReactiveFormsModule, Validators }
  from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class EnseignantService {
  private baseUrl = 'http://localhost:8081/api/enseignants';
  private base='http://localhost:8081/api/Enseignants'
  host: string = 'http://localhost:8081';
  addimg: String = 'N';
  choixmenu: string = 'A';
  list: any = [];
  public formData !: FormGroup;
  constructor(private http: HttpClient) { }


  getData(id: number): Observable<Object> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  getEnseignant(id: string): Observable<Object> {
    return this.http.get(`${this.baseUrl}/E/${id}`);
  }
  getMatricule(ann: number) {
   
    return this.http.get(`${this.baseUrl}/7/${ann}`);
  }

  createData(info: Object): Observable<Object> {
    return this.http.post(`${this.base}`, info);
  }

  saveData(info: Object): Observable<Object> {
    return this.http.post(`${this.base}`, info);
  }

  updatedata(value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}`, value);
  }

  deleteData(id: number): Observable<any> {

    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getAll(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
  exporToPdf() {
    alert("pdf service");
    return this.http.get(`${this.baseUrl}/report`);
  }

  getExcelData() {
    return this.http.get<any>(`${this.baseUrl}/export/excel`, { responseType: 'arraybuffer' as 'json' });
  }
  searchData(query: string): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/search/?query=${query}`);
  }
}



