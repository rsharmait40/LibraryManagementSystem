import { Component, OnInit } from '@angular/core';
import { UserserviceService } from '../userservice.service';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent implements OnInit {

  constructor(public service: UserserviceService) { }

  ngOnInit() {
  }

  forgotPassword(formValues) {
this.service.forgotPassword(formValues.value).subscribe(resp => {
  console.log(resp)
})
  }

}
