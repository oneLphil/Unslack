import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'; // <-- NgModel lives here

// Slacker
import { AppComponent } from './app.component';
import { SlackerComponent } from './slacker/slacker.component';

// Chart component

// Room Creation Component

// Room Joining Component

// Tracking Component

@NgModule({
  declarations: [
    AppComponent,
    SlackerComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
