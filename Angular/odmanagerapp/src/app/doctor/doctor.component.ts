import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { DoctorService } from './doctor.service';


export interface Doctor{
  id: number;
  address: string;
  services: string[];
  name: string;
}

@Component({
  selector: 'app-doctor',
  templateUrl: './doctor.component.html',
  styleUrls: ['./doctor.component.css']
})

export class DoctorComponent implements OnInit {

  constructor(private doctorService: DoctorService) {}

  public doctors: Doctor[];
public getDoctors(): void {
  this.doctorService.getDoctors().subscribe(
    (response: Doctor[]) => {
      this.doctors = response;
    },
    (error: HttpErrorResponse) => {
      alert(error.message);
    }
  );
}

ngOnInit(): void {
  this.getDoctors();
}
  
}
