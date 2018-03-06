import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'; // <-- NgModel lives here

// Import routes modules to do routing on this domain
import { AppRoutingModule } from './app-routing.module';

// Slacker
import { AppComponent } from './app.component';
import { SlackerComponent } from './slacker/slacker.component';
import { ChartsComponent } from './charts/charts.component';
import { RoomComponent } from './room/room.component';
import { SlackerDetailComponent } from './slacker-detail/slacker-detail.component';
import { MessagesComponent } from './messages/messages.component';
import { DashboardComponent } from './dashboard/dashboard.component';

// Highcharts
import { HighchartsChartComponent } from '../../node_modules/highcharts-angular/src/app/highcharts-chart.component';

// Material
import { MaterialModule } from './material';

// Services
import { SlackerService } from './slacker.service';
import { MessageService } from './message.service';
import { LeaderboardComponent } from './leaderboard/leaderboard.component';

@NgModule({
  declarations: [
    AppComponent,
    SlackerComponent,
    ChartsComponent,
    RoomComponent,
    SlackerDetailComponent,
    MessagesComponent,
    DashboardComponent,
    HighchartsChartComponent,
    LeaderboardComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    MaterialModule
  ],
  providers: [
    SlackerService,
    MessageService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
