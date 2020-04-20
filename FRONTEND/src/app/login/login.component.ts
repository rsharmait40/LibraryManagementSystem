import { Component, OnInit } from '@angular/core';
import { UserserviceService } from '../userservice.service';
import { Router } from '@angular/router';
import { AdminserviceService } from '../adminservice.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  message;
  constructor(public service: UserserviceService, public router: Router, public adminService: AdminserviceService) { }

  ngOnInit() {
    console.log('Initializing...');
    // this.adminService.getUserById().subscribe(resp => {
    //   console.log(resp);
    // }, err => {
    //   console.log(err);
    // }, () => {
    //   console.log('get user by id request send');
    // });
  }



  loginData(form) {
    console.log(form.value);
    this.service.loginRequest(form.value).subscribe(resp => {
      console.log(resp);
      this.service.checkLogin = true;
      if (resp != null && resp.users[0].role === 'ROLE_ADMIN') {
         this.router.navigateByUrl('/admin');
         if(resp.statusCode === 201) {
          localStorage.setItem('user', JSON.stringify(resp));
          this.message = 'login Successfully';
        }
      } else if (resp != null && resp.users[0].role === 'ROLE_USER') {
        this.router.navigateByUrl('/user');
        if(resp.statusCode === 201) {
          localStorage.setItem('user', JSON.stringify(resp));
          this.message = 'login Successfully';
        }
      }
      
    }, err => {
      console.log(err);
      this.message = 'login Unsuccessful';
      // }, () => {
      //   console.log('Login Unsuccessful');
    });
  }
}
