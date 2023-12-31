import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { ExamComponent } from './exam/exam.component';
import { SiteComponent } from './site/site.component';
import { DoctorComponent } from './doctor/doctor.component';
import { PatientComponent } from './patient/patient.component';

const routes : Routes = [
  {
    path:"exam",
    component: ExamComponent
  },
  {
    path:"site",
    component: SiteComponent
  },
  {
    path:"doctor",
    component: DoctorComponent
  },
  {
    path:"patient",
    component: PatientComponent
  }
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
