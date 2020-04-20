import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class AdminserviceService {
  backendURL = 'http://localhost:8080/template';
  backendURL1 = 'http://localhost:8082';
  constructor(public http: HttpClient) { }

  deleteBookRequest(bookId): any {
    // console.log('delete book', bookId);
    return this.http.delete(`${this.backendURL1}/deleteBook/${bookId}` );
  }

  deleteUserRequest(userId): any {
    return this.http.delete(`${this.backendURL1}/deleteUser/${userId}`);
  }

  acceptRequest(userId): any {
    return this.http.get(`${this.backendURL1}/acceptRequest/${userId}`);
  }

  rejectRequest(userId): any {
    return this.http.get(`${this.backendURL1}/rejectRequest/${userId}`);
  }

  showBookRequest(int): any {
    return this.http.post(`${this.backendURL1}/show-book`, int);
  }

  showUserRequest(userId): any {
    return this.http.get(`${this.backendURL1}/getbyId/${userId}`);
  }
  updateUserRequest(data): any {
    return this.http.post(`${this.backendURL1}/updateUser`, data);
  }
  addBookRequest(data, userId): any {
    console.log('service book ', data);
    console.log('service book ');
    // return this.http.post(`${this.backendURL}/add-book`, data);
    return this.http.post(`${this.backendURL1}/addBook/${userId}` , data);
  }

  addUserRequest(data): any {
    console.log(data);
    return this.http.post(`${this.backendURL1}/addUser`, data);
  }
  borrowBookRequest(data): any {
    console.log(data);
    return this.http.post(`${this.backendURL1}/borrow`, data);
  }
  listOfBookRequest(data): any {
    console.log(data);
    return this.http.post(`${this.backendURL1}/getallBooks`, data);
  }
  searchBookRequest(data): any {
    console.log(data);
    return this.http.post(`${this.backendURL1}/getbyname`, data);
  }

  getUserById(userId) {
    return this.http.get(`${this.backendURL1}/getbyId/` + userId);
  }
  
  getAllUser(){
    return this.http.get(`${this.backendURL1}/getallUsers`);
  }

}
