import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { ExamService } from './exam.service';


export interface Exam{
  id: number;
  price: number;
  examdate: Date;
  convention: string;
}

@Component({
  selector: 'app-exam',
  templateUrl: './exam.component.html',
  styleUrls: ['./exam.component.css']
})

export class ExamComponent implements OnInit {

  constructor(private examService: ExamService) {}

  public exams: Exam[];
public getExams(): void {
  this.examService.getExams().subscribe(
    (response: Exam[]) => {
      this.exams = response;
    },
    (error: HttpErrorResponse) => {
      alert(error.message);
    }
  );
}

ngOnInit(): void {
  this.getExams();
}
  
}
