import { Component, OnInit } from '@angular/core';
import { AdminserviceService } from '../adminservice.service';

@Component({
  selector: 'app-delete-book',
  templateUrl: './delete-book.component.html',
  styleUrls: ['./delete-book.component.css']
})
export class DeleteBookComponent implements OnInit {

  message;


  constructor(public service: AdminserviceService) { }

  ngOnInit() {
  }

  deleteBook(form) {
    console.log('delete book***',form.value["bookId"]);
    this.service.deleteBookRequest(form.value["bookId"]).subscribe(resp => {
      console.log('service', form.value);
      console.log('backend response', resp);
      if(resp.statusCode === 201) {
        this.message = 'Book is deleted Successfully';
      }
    }, err => {
      console.log(err);
      this.message = 'Book is not deleted ';
      console.log('Book not Deleted');
     });
  }

}
