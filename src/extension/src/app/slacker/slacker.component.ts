import { Component, OnInit } from '@angular/core';
import { Slacker } from '../slacker';
import { SlackerService } from '../slacker.service';
import { SlackerDetailComponent } from '../slacker-detail/slacker-detail.component';


@Component({
  selector: 'app-slacker',
  templateUrl: './slacker.component.html',
  styleUrls: ['./slacker.component.css']
})
export class SlackerComponent implements OnInit {

  selectedSlacker: Slacker;

  /* slackerService is a singleton instance of SlackerService
  */
  constructor(private slackerService: SlackerService) {
  }

  // this runs upon a lifecycle
  // https://angular.io/guide/lifecycle-hooks
  ngOnInit() {
  }


}
