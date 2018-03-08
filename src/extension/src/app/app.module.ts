import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'; // <-- NgModel lives here
import { HttpClientModule } from '@angular/common/http';

// testing purposes
// import { HttpClientInMemoryWebApiModule } from 'angular-in-memory-web-api';
// import { InMemoryDataService }  from './in-memory-data.service';

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
import { LeaderboardComponent } from './leaderboard/leaderboard.component';
//import { DashtableComponent} from './dashtable/dashtable.component';

// Highcharts
import { HighchartsChartComponent } from '../../node_modules/highcharts-angular/src/app/highcharts-chart.component';

// Material
import { MaterialModule } from './material';

// Services
import { SlackerService } from './slacker.service';
import { RoomService } from './room.service';
import { MessageService } from './message.service';
import { TimetrackerComponent } from './timetracker/timetracker.component';
import { ChartsService } from './charts.service';

import { RoomDetailComponent } from './room-detail/room-detail.component';
import { TableComponent } from './table/table.component';


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
    LeaderboardComponent,
    RoomDetailComponent,
    TableComponent,
    TimetrackerComponent
    //DashtableComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    MaterialModule,
    HttpClientModule,

    // The HttpClientInMemoryWebApiModule module intercepts HTTP requests
    // and returns simulated server responses.
    // Remove it when a real server is ready to receive requests.
    // HttpClientInMemoryWebApiModule.forRoot(
    //  InMemoryDataService, { dataEncapsulation: false }
    // )
  ],
  providers: [
    SlackerService,
    MessageService,
    RoomService,
    ChartsService
    //InMemoryDataService


  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
