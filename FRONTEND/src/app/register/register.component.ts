import { Component, OnInit } from '@angular/core';
import { UserserviceService } from '../userservice.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  message;

  constructor(public service: UserserviceService) { }

  ngOnInit() {
  }

  

  registerUser(form) {
    console.log(form.value);
    this.service.registerRequest(form.value).subscribe(response => {
      console.log('Response', response);
      if(response.statusCode === 201) {
        this.message = 'Register Successfully';
      }
    }, err => {
      console.log(err);
      this.message = 'Registration Unsuccessful';
      console.log('Registration Unsuccessful', err);
     });
    }

}
