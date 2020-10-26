import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {FormBuilder, Validators} from '@angular/forms';
import {Response} from '../response';

@Component({
  selector: 'app-withdraw-form',
  templateUrl: './withdraw-form.component.html',
  styleUrls: ['./withdraw-form.component.css']
})
export class WithdrawFormComponent {
  isSubmitted = false;
  response: Response;
  withdrawForm = this.fb.group({
    withdrawSum: ['', [Validators.required, Validators.pattern(/^-?(0|[1-9]\d*)?$/)]]
  });

  constructor(private router: Router,
              private http: HttpClient,
              private fb: FormBuilder) {
  }

  onSubmit() {
    this.isSubmitted = true;
    if (!this.withdrawForm.valid) {
      console.log('Uncompleted fields!');
      return false;
    } else {
      alert(JSON.stringify(this.withdrawForm.value.withdrawSum));
      console.log(this.withdrawForm.value.withdrawSum);
    }
    this.http.get('http://localhost:8080/withdraw?sum=' + this.withdrawForm.value.withdrawSum).subscribe(responseData => {
      // alert(JSON.stringify(responseData).replace(',', '\n')
      //   .replace(/,/g, '\n'));
      this.response = responseData as Response;
      alert(this.response.detail + '\n' + '\n' +
        JSON.stringify(this.response.responseObject)
          .replace(',', '\n')
          .replace(/,/g, '\n'));
    });
  }

  navigateToLogin() {
    this.router.navigateByUrl('home/employee');
  }
}
