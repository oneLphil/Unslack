import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { DashboardComponent } from './dashboard/dashboard.component';
import { SlackerComponent } from './slacker/slacker.component';
import { ChartsComponent } from './charts/charts.component';
import { RoomComponent } from './room/room.component';
//import { LeaderboardComponent } from './leaderboard/leaderboard.component';

const routes: Routes = [
    {
        path: '',
        redirectTo: 'Dashboard',
        pathMatch: 'full'
    },
    { path: 'Dashboard', component: DashboardComponent },
    { path: 'Slacker', component: SlackerComponent },
    { path: 'Charts', component: ChartsComponent },
    { path: 'Room', component: RoomComponent },
    { path: '**', redirectTo: 'Dashboard', pathMatch: 'full' }
];

@NgModule({
    imports: [
        RouterModule.forRoot(routes)
    ],
    exports: [
        RouterModule
    ]
})
export class AppRoutingModule { }
