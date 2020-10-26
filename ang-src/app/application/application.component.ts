import {Component, NgModule, OnInit} from '@angular/core';

@Component({
  selector: 'app-application',
  templateUrl: './application.component.html',
  styleUrls: ['./application.component.css']
})

export class ApplicationComponent {
  title: string;

  constructor() {
    this.title = 'Automated teller machine (ATM)';

  }


}
