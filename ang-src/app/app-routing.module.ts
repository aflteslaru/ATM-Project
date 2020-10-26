import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {CardHolderComponent} from './card-holder/card-holder.component';
import {BankEmployeeComponent} from './bank-employee/bank-employee.component';
import {AddFormComponent} from './add-form/add-form.component';
import {WithdrawFormComponent} from './withdraw-form/withdraw-form.component';
import {ApplicationComponent} from './application/application.component';

const routes: Routes = [
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {
    path: 'home', component: ApplicationComponent,
    children: [
      {
        path: 'employee', component: BankEmployeeComponent,
        children: [
          {
            path: 'add', component: AddFormComponent,
          },
        ]
      },
      {
        path: 'card-holder', component: CardHolderComponent,
        children: [
          {
            path: 'withdraw', component: WithdrawFormComponent,
          },
        ]
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
