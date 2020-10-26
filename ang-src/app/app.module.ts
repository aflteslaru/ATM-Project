import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ApplicationComponent } from './application/application.component';
import {HttpClientModule} from '@angular/common/http';
import {NgSelectModule} from '@ng-select/ng-select';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { CardHolderComponent } from './card-holder/card-holder.component';
import { BankEmployeeComponent } from './bank-employee/bank-employee.component';
import { AddFormComponent } from './add-form/add-form.component';
import {WithdrawFormComponent} from './withdraw-form/withdraw-form.component';

@NgModule({
  declarations: [
    AppComponent,
    ApplicationComponent,
    BankEmployeeComponent,
    CardHolderComponent,
    BankEmployeeComponent,
    AddFormComponent,
    WithdrawFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgSelectModule,
    FormsModule,
    ReactiveFormsModule
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

