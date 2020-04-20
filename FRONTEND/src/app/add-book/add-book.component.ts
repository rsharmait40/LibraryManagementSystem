import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { AdminserviceService } from '../adminservice.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css']
})
export class AddBookComponent implements OnInit {

  @ViewChild('form', { static: true }) addBookData: NgForm;

  message;
  constructor(public service: AdminserviceService, public router: Router) { }

  ngOnInit() {
  }


  addBook() {
    console.log(this.addBookData.value);
    this.service.addBookRequest(this.addBookData.value,48).subscribe(resp => {
      console.log('backend response', resp);
      if(resp.statusCode === 201) {
        this.message = 'Book added Successfully';
      }
    }, err => {
      console.log(err);
      this.message = 'Book added is not added';
      console.log('Book not added');
    });
    //const result = this.service.addBookRequest(data);
    //this.service.setLoggedIn(result.loggedIn);
    //this.service.setIsAdmin(result.isAdmin);
    //if(!result.loggedIn) {
    // error message
    //} else {
    //this.router.navigate(['home'])
    //}

    
  }


}
