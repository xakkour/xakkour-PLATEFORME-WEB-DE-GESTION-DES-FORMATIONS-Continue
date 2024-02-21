// notification.service.ts
import { Injectable } from '@angular/core';
import { ToastrService } from 'ngx-toastr';

@Injectable({
  providedIn: 'root'
})
export class NotificationService {
  constructor(private toastr: ToastrService) {}

  showSuccess(message: string, title?: string) {
    // Implement the logic to display a success notification
  }

  showError(message: string, title?: string) {
    // Implement the logic to display an error notification
  }
}
