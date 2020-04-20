import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AdminserviceService } from '../adminservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent implements OnInit {

  @ViewChild('form', {static: true}) addUserData: NgForm;

  message;
  constructor(public service: AdminserviceService, public router: Router) { }

  ngOnInit() {
  }

  addUser() {
    console.log(this.addUserData.value);
    this.service.addUserRequest(this.addUserData.value).subscribe(resp => {
      console.log(resp);
      if(resp.statusCode === 201) {
        this.message = 'User added Successfully';
      }
    }, err => {
      console.log(err);
      this.message = 'User is not added ';
      console.log('user not added');
    }, () => {
      
      console.log('add user request send');
    });
  }

}
