import { Component, OnInit } from '@angular/core';
import { SlackerService } from '../slacker.service';
import { Slacker } from '../slacker';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  slackers: Slacker[] = [];

  constructor(private slackerService: SlackerService) { }

  ngOnInit() {
    this.getSlackers();
  }

  getSlackers(): void {
    this.slackerService.getSlackers()
      .subscribe(slackers => this.slackers = slackers.slice(1, 5));
  }

}
