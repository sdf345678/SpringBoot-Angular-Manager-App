import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { PatientService } from './patient.service';


export interface Patient{
  id: number;
  address: string;
  services: string[];
  name: string;
}

@Component({
  selector: 'app-patient',
  templateUrl: './patient.component.html',
  styleUrls: ['./patient.component.css']
})

export class PatientComponent implements OnInit {

  constructor(private patientService: PatientService) {}

  public patients: Patient[];
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

ngOnInit(): void {
  this.getPatients();
}
  
}
