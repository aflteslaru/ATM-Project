import {Component, OnInit} from '@angular/core';
import {Response} from '../response';
import {Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-bank-employee',
  templateUrl: './bank-employee.component.html',
  styleUrls: ['./bank-employee.component.css']
})
export class BankEmployeeComponent {
  response: Response;

  constructor(private router: Router,
              private http: HttpClient) {
  }


  onClick() {
    this.http.get('http://localhost:8080/resetDb').subscribe(responseData => {
      this.response = responseData as Response;
      alert(this.response.detail);
    });
    this.navigateToLogin();
  }

  navigateToLogin() {
    this.router.navigateByUrl('home/employee');
  }
}
