import { Component, OnInit } from '@angular/core';
import { ChartsService } from '../charts.service';

@Component({
  selector: 'app-timetracker',
  templateUrl: './timetracker.component.html',
  styleUrls: ['./timetracker.component.css']
})
export class TimetrackerComponent implements OnInit {
  
  constructor(
    private chartsService: ChartsService
  ) { }

  ngOnInit() {
  }

}
