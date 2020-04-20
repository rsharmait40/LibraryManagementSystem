import { Component, OnInit } from '@angular/core';
import { AdminserviceService } from '../adminservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-show-book',
  templateUrl: './show-book.component.html',
  styleUrls: ['./show-book.component.css']
})
export class ShowBookComponent implements OnInit {

  constructor(public service: AdminserviceService, public router: Router) { }

  ngOnInit() {
  }

  showBook(form) {
    console.log(form.value);
    this.service.showBookRequest(form.value).subscribe(resp => {
      console.log(resp);
      localStorage.setItem('user', JSON.stringify(resp));
      console.log( 'logged in');
    }, err => {
      console.log(err);
    }, () => {
      console.log('Not show Book');
    });
  }

}
