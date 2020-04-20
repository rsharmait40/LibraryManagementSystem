import { Component, OnInit } from '@angular/core';
import { UserserviceService } from '../userservice.service';


@Component({
  selector: 'app-list-book',
  templateUrl: './list-book.component.html',
  styleUrls: ['./list-book.component.css']
})
export class ListBookComponent implements OnInit {

  constructor(public service: UserserviceService) { }

  ngOnInit() {
  }

  listBook(form) {
    console.log(form.value);
    this.service.listOfBookRequest(form.value).subscribe(resp => {
      console.log('backend response', resp);
    }, err => {
      console.log(err);
      console.log('Book is not Present in List');
     });
  }
}
