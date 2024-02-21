import { Component, OnInit } from '@angular/core';
import { RequestService } from '../service/RequestService ';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-admin-confirmation-component',
  templateUrl: './admin-confirmation-component.component.html',
  styleUrls: ['./admin-confirmation-component.component.css']
})
export class AdminConfirmationComponent implements OnInit {
  requests: any[] = [];
  newFormationProposal: any = {
  type: '',
  objectives: '',
  description: '',
  title: ''

  }; // Object to store the new formation proposal data

  constructor(private requestService: RequestService) { }

  ngOnInit(): void {
    this.getRequests(); // Load existing requests on component initialization
  }

  getRequests(): void {
    this.requestService.getRequests().subscribe(data => {
      this.requests = data;
    });
  }

  confirmRequest(id: number): void {
    this.requestService.confirmRequest(id).subscribe(response => {
      console.log('Request confirmed:', response);
      this.getRequests(); // Refresh the list of requests
    });
  }

  denyRequest(id: number): void {
    this.requestService.denyRequest(id).subscribe(response => {
      console.log('Request denied:', response);
      this.getRequests(); // Refresh the list of requests
    });
  }

 /*  // Method to submit a new formation proposal
  submitFormationProposal(): void {
    // Assuming your RequestService has a method for submitting formation proposals
    this.requestService.submitFormationProposal(this.newFormationProposal).subscribe(response => {
      console.log('Formation proposal submitted:', response);
      this.getRequests(); // Refresh the list of requests
    });

    // Clear the form after submission (optional)
    this.newFormationProposal = {};
  } */
}
