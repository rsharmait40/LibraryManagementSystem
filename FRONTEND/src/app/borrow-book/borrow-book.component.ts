import { Component, OnInit } from '@angular/core';
import { UserserviceService } from '../userservice.service';

@Component({
  selector: 'app-borrow-book',
  templateUrl: './borrow-book.component.html',
  styleUrls: ['./borrow-book.component.css']
})
export class BorrowBookComponent implements OnInit {

  constructor(public service: UserserviceService) { }

  ngOnInit() {
  }

  borrowBook(form) {
    console.log(form.value);
    this.service.borrowBookRequest(form.value).subscribe(resp => {
      console.log('backend response', resp);
    }, err => {
      console.log(err);
      console.log(' Borrow Book not Present');
    });
  }
}
