import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class UserserviceService {
 backendURL = 'http://localhost:8080/template';
  backendURL1 = 'http://localhost:8083';
  backendURL2 = 'http://localhost:8090';
  backendURL3 = 'http://localhost:8084';
  checkLogin = null;
  constructor(public http: HttpClient, public router: Router) { }
  registerRequest(data): any {
    console.log('service', data);
    return this.http.post(`${this.backendURL1}/register`, data);
  } 

  loginRequest(data): any {
    return this.http.post(`${this.backendURL2}/login`, data, { withCredentials: true });
  }
  borrowBookRequest(data): any {
    console.log(data);
    return this.http.get(`${this.backendURL3}/requestBook?bookId=` +data.bookId +'&username='+data.username);
  }
  listOfBookRequest(data): any {
    console.log(data);
    return this.http.post(`${this.backendURL}/getallBooks`, data);
  }
  searchBookRequest(data): any {
    console.log(data, this.backendURL3);
    return this.http.post(`${this.backendURL3}/searchBook/`, data);
  }
  forgotPassword(data) {
    return this.http.put(`${this.backendURL1}/forgot-password`, data, { withCredentials: true });
  }



}
