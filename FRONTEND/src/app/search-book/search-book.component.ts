import { Component, OnInit } from '@angular/core';


import { UserserviceService } from '../userservice.service';

@Component({
  selector: 'app-search-book',
  templateUrl: './search-book.component.html',
  styleUrls: ['./search-book.component.css']
})
export class SearchBookComponent implements OnInit {

  books: any[];
  constructor(public service: UserserviceService) { }

  ngOnInit() {
  }

  searchBook(form) {
    console.log(form.value);
    this.service.searchBookRequest(form.value).subscribe(resp => {
      console.log('backend response', resp);
    this.books = resp.book;
    }, err => {
      console.log(err);
      console.log('Book is not Present in List');
     });
  }
}
