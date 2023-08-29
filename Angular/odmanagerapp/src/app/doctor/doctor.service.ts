import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Doctor } from './doctor.component';

@Injectable({
  providedIn: 'root'
})
export class DoctorService {

  private apiServerUrl='http://localhost:8080';

  public doctors: Doctor[];

  constructor(private http:HttpClient){}

  public getDoctors(): Observable<Doctor[]> {
    return this.http.get<Doctor[]>(`${this.apiServerUrl}/doctor/all`);
}

public addDoctor(doctor: Doctor): Observable<Doctor> {
    return this.http.post<Doctor>(`${this.apiServerUrl}/doctor/add`,doctor);
}


public updateDoctor(doctor: Doctor): Observable<Doctor> {
    return this.http.put<Doctor>(`${this.apiServerUrl}/doctor/update`,doctor);
}

public deleteDoctor(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/doctor/delete/${id}`);
}
}
