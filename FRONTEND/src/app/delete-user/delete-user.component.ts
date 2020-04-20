import { Component, OnInit } from '@angular/core';
import { AdminserviceService } from '../adminservice.service';

@Component({
  selector: 'app-delete-user',
  templateUrl: './delete-user.component.html',
  styleUrls: ['./delete-user.component.css']
})
export class DeleteUserComponent implements OnInit {
  message;
  constructor(public service: AdminserviceService) { }

  ngOnInit() {
  }

  deleteUser(form) {
    console.log("form.value",form.value["userId"]);
    this.service.deleteUserRequest(form.value["userId"]).subscribe(resp => {
      console.log('backend response', resp);
      if(resp.statusCode === 201) {
        this.message = 'User is deleted Successfully';
      }
    }, err => {
      console.log(err);
      this.message = 'User is deleted Successfully';
      console.log('Book not Deleted');
     });
  }

}
