import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminConfirmationComponentComponent } from './admin-confirmation-component.component';

describe('AdminConfirmationComponentComponent', () => {
  let component: AdminConfirmationComponentComponent;
  let fixture: ComponentFixture<AdminConfirmationComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminConfirmationComponentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminConfirmationComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
