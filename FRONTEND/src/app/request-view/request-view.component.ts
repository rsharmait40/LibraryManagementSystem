import { Component, OnInit } from '@angular/core';
import { AdminserviceService } from '../adminservice.service';

@Component({
  selector: 'app-request-view',
  templateUrl: './request-view.component.html',
  styleUrls: ['./request-view.component.css']
})
export class RequestViewComponent implements OnInit {
requests: any[];
  constructor(private service: AdminserviceService) { }

  ngOnInit() {
  }

  acceptRequest(userId: number) {
this.service.acceptRequest(userId);
  }

  rejectRequest(userId: number) {
    this.service.rejectRequest(userId);
      }

}
