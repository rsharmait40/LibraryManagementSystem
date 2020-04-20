import { Component, OnInit, DoCheck } from '@angular/core';
import { UserserviceService } from '../userservice.service';
import { ThrowStmt } from '@angular/compiler';
import { Router } from '@angular/router';

import { from } from 'rxjs';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit, DoCheck {
  role: any;
  isLogin = false;
  constructor(public router: Router, public userService: UserserviceService) { }



  ngOnInit() {
    
  }

  ngDoCheck() {
    this.isLogin = this.userService.checkLogin;
    const userDetail = JSON.parse(localStorage.getItem('user'));
    if(!userDetail) {
      return; 
    }
    const usersList = userDetail.users || [{}];
    const user = usersList[0];
    this.role = user.role;
  }


  logout() {
    this.userService.checkLogin = false;
    localStorage.clear();
    this.role = null;
    localStorage.removeItem('user')
    this.router.navigateByUrl('/login');
  }

}
