import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminserviceService } from '../adminservice.service';

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.css']
})
export class UpdateUserComponent implements OnInit {

  constructor(public service: AdminserviceService, public router: Router) { }

  message;
  ngOnInit() {
  }

  updateUser(form) {
    console.log('form.value', form.value);
    this.service.updateUserRequest(form.value).subscribe(resp => {
      console.log(resp);
      localStorage.setItem('user', JSON.stringify(resp));
      if (resp.statusCode === 201) {
        this.message = 'Updated Successfully';
      }
    }, err => {
      console.log(err);
      this.message = 'Update not Successfully';
    });
  }

}
