import { Component, OnInit } from '@angular/core';
import { Slacker } from '../slacker';
import { SlackerService } from '../slacker.service';
import { SlackerDetailComponent } from '../slacker-detail/slacker-detail.component';
import { ChartsService } from '../charts.service';

@Component({
  selector: 'app-slacker',
  templateUrl: './slacker.component.html',
  styleUrls: ['./slacker.component.css']
})
export class SlackerComponent implements OnInit {
  slackerChartType: string = "pie";
  slackerData: any[]= this.chartsService.getWebsitesData().tracked;
  selectedSlacker: Slacker;

  /* slackerService is a singleton instance of SlackerService
  */
  constructor(
    private slackerService: SlackerService,
    private chartsService: ChartsService
  ) { }

  // this runs upon a lifecycle
  // https://angular.io/guide/lifecycle-hooks
  ngOnInit() {
    this.slackerData = this.chartsService.getWebsitesData().tracked;
    console.log(this.slackerData);
  }


}
