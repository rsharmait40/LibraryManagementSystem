import { Component, OnInit } from '@angular/core';
import { AdminserviceService } from '../adminservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-show-all-user',
  templateUrl: './show-all-user.component.html',
  styleUrls: ['./show-all-user.component.css']
})
export class ShowAllUserComponent implements OnInit {
  users: any[];

  constructor(public service: AdminserviceService, public router: Router) { }

  ngOnInit() {
    this.service.getAllUser().subscribe(resp => {
      this.users = resp['users'];
    })
  }

}
