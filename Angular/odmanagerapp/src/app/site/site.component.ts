import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { SiteService } from './site.service';


export interface Site{
  id: number;
  address: string;
  code: String;
  services: string[];
  name: string;
}

@Component({
  selector: 'app-site',
  templateUrl: './site.component.html',
  styleUrls: ['./site.component.css']
})

export class SiteComponent implements OnInit {

  constructor(private siteService: SiteService) {}

  public sites: Site[];
public getSites(): void {
  this.siteService.getSites().subscribe(
    (response: Site[]) => {
      this.sites = response;
    },
    (error: HttpErrorResponse) => {
      alert(error.message);
    }
  );
}

ngOnInit(): void {
  this.getSites();
}
  
}
