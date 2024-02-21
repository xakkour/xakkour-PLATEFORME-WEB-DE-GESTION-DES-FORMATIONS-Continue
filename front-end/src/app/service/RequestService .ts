import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { FormGroup } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class RequestService {
  private baseUrl='http://localhost:8081/api';
  list: any = [];
  public formData !: FormGroup;
  choixmenu: string = 'A';
  constructor(private httpClient: HttpClient) { }


  getAll(): Observable<any> {
    return this.httpClient.get(`${this.baseUrl}/formation`);
  }
  
  

  // Fetch requests that require admin confirmation
  getRequests(): Observable<any[]> {
    const url = `${this.baseUrl}/formation/proposals/api/formation/pending`; 
    return this.httpClient.get<any[]>(url);
  }

  
  confirmRequest(id: number): Observable<any> {
    const url = `${this.baseUrl}/formation/approve/${id}`; 
    return this.httpClient.put(url, null);
  }
  deleteData(id: number): Observable<any> {
    return this.httpClient.delete(`${this.baseUrl}/formation/${id}`,
     { responseType: 'text' });
  }


  denyRequest(id: number): Observable<any> {
    const url = `${this.baseUrl}/formation/reject/${id}`; 
    return this.httpClient.put(url, null);
  }
  updatedata( value: any): Observable<Object> {
    return this.httpClient.put(`${this.baseUrl}/formation`, value);
  }

  submitFormationProposal(proposalData: any): Observable<any> {
    const url = `${this.baseUrl}/formation`; 
    return this.httpClient.post(url, proposalData);
  }
  searchData(query: string): Observable<any[]> {
    return this.httpClient.get<any[]>(`http://localhost:8081/api/formation/search/?query=${query}`);
  }
  
}
