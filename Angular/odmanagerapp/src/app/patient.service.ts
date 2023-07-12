import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Patient } from './patient'

@Injectable ({
    providedIn: 'root'
})

export class Service{
    private apiServerUrl='http://localhost:8080';

    constructor(private http: HttpClient) {}

    public getPatients(): Observable<Patient[]> {
        return this.http.get<Patient[]>(`${this.apiServerUrl}/patient/all`);
    }

    public addPatient(patient: Patient): Observable<Patient> {
        return this.http.post<Patient>(`${this.apiServerUrl}/patient/add`,patient);
    }
    

    public updatePatient(patient: Patient): Observable<Patient> {
        return this.http.put<Patient>(`${this.apiServerUrl}/patient/update`,patient);
    }

    public deletePatient(id: number): Observable<void> {
        return this.http.delete<void>(`${this.apiServerUrl}/patient/delete/${id}`);
    }


}