import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {FormBuilder, Validators} from '@angular/forms';
import {Response} from '../response';

@Component({
  selector: 'app-add-form',
  templateUrl: './add-form.component.html',
  styleUrls: ['./add-form.component.css']
})
export class AddFormComponent {
  response: Response;
  isSubmitted = false;
  registrationForm = this.fb.group({
    _1: ['', [Validators.required, Validators.min(0), Validators.max(100000), Validators.pattern(/^-?(0|[1-9]\d*)?$/)]],
    _5: ['', [Validators.required, Validators.min(0), Validators.max(100000), Validators.pattern(/^-?(0|[1-9]\d*)?$/)]],
    _10: ['', [Validators.required, Validators.min(0), Validators.max(100000), Validators.pattern(/^-?(0|[1-9]\d*)?$/)]],
    _50: ['', [Validators.required, Validators.min(0), Validators.max(100000), Validators.pattern(/^-?(0|[1-9]\d*)?$/)]],
    _100: ['', [Validators.required, Validators.min(0), Validators.max(100000), Validators.pattern(/^-?(0|[1-9]\d*)?$/)]],
    _200: ['', [Validators.required, Validators.min(0), Validators.max(100000), Validators.pattern(/^-?(0|[1-9]\d*)?$/)]],
    _500: ['', [Validators.required, Validators.min(0), Validators.max(100000), Validators.pattern(/^-?(0|[1-9]\d*)?$/)]]
  });

  constructor(private router: Router,
              private http: HttpClient,
              private fb: FormBuilder,
  ) {
  }

  onSubmit() {
    this.isSubmitted = true;
    this.http.post('http://localhost:8080/addBills', this.registrationForm.value).subscribe(responseData => {
      this.response = responseData as Response;
      alert(this.response.detail);
    });
  }

  navigateToLogin() {
    this.router.navigateByUrl('home/employee');
  }
}
