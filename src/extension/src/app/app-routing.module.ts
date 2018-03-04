import { NgModule } from '@angular/core';

// Import routes modules to do routing on this domain
import { RouterModule, Routes } from '@angular/router';

// Import components to reference in the view
import { SlackerComponent } from './slacker/slacker.component';
import { DashboardComponent }   from './dashboard/dashboard.component';
import { SlackerDetailComponent }  from './slacker-detail/slacker-detail.component';

const routes: Routes = [
  { path: 'slackers', component: SlackerComponent },
  { path: 'dashboard', component: DashboardComponent },
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  { path: 'detail/:id', component: SlackerDetailComponent }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule { }
