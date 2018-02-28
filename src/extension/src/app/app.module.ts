import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'; // <-- NgModel lives here

// Slacker
import { AppComponent } from './app.component';
import { SlackerComponent } from './slacker/slacker.component';
import { ChartsComponent } from './charts/charts.component';
import { RoomComponent } from './room/room.component';

// Chart component

// Room Creation Component

// Room Joining Component

// Tracking Component

@NgModule({
  declarations: [
    AppComponent,
    SlackerComponent,
    ChartsComponent,
    RoomComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
