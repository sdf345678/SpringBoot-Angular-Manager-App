import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Site } from './site.component';

@Injectable({
  providedIn: 'root'
})
export class SiteService {

  private apiServerUrl='http://localhost:8080';

  public sites: Site[];

  constructor(private http:HttpClient){}

  public getSites(): Observable<Site[]> {
    return this.http.get<Site[]>(`${this.apiServerUrl}/site/all`);
}

public addSite(site: Site): Observable<Site> {
    return this.http.post<Site>(`${this.apiServerUrl}/site/add`,site);
}


public updateSite(site: Site): Observable<Site> {
    return this.http.put<Site>(`${this.apiServerUrl}/site/update`,site);
}

public deleteSite(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/site/delete/${id}`);
}
}
