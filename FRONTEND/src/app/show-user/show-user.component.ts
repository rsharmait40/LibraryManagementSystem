import { Component, OnInit,ViewChild } from '@angular/core';
import { AdminserviceService } from '../adminservice.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-show-user',
  templateUrl: './show-user.component.html',
  styleUrls: ['./show-user.component.css']
})
export class ShowUserComponent implements OnInit {
  users: any[];

  @ViewChild('form', { static: true }) formData: NgForm;
  constructor(public service: AdminserviceService, public router: Router) { }

  ngOnInit() {
  }


  getByUserId(formValues: NgForm) {
    this.service.getUserById(formValues.value.userId).subscribe(resp => {
      this.users = resp['users'];
    })
  }

}
