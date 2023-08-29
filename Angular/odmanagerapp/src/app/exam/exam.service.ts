import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Exam } from './exam.component';

@Injectable({
  providedIn: 'root'
})
export class ExamService {

  private apiServerUrl='http://localhost:8080';

  public exams: Exam[];

  constructor(private http:HttpClient){}

  public getExams(): Observable<Exam[]> {
    return this.http.get<Exam[]>(`${this.apiServerUrl}/exam/all`);
}

public addExam(exam: Exam): Observable<Exam> {
    return this.http.post<Exam>(`${this.apiServerUrl}/exam/add`,exam);
}


public updateExam(exam: Exam): Observable<Exam> {
    return this.http.put<Exam>(`${this.apiServerUrl}/exam/update`,exam);
}

public deleteExam(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/exam/delete/${id}`);
}
}
