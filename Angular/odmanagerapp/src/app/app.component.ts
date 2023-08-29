import { Component, OnInit } from '@angular/core';
import { Patient } from './patient';
import { Service } from './patient.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'odmanagerapp';

  public patients: Patient[];

  constructor(private patientService: Service) {}

  ngOnInit(): void {
      this.getPatients();
  }

  public getPatients(): void {
    this.patientService.getPatients().subscribe(
      (response: Patient[]) => {
        this.patients = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onOpenModal(patient: Patient | null): void {
    const container = document.getElementById('nav')
    const button=document.createElement('button');
    button.type = 'button';
    //button.style.display= 'none';
    button.setAttribute('data-toggle','modal');
    button.setAttribute('data-target','#addPatient');
    container?.appendChild(button);
    button.click();
  }
}
