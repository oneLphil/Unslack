import { Component, OnInit } from '@angular/core';
import { Slacker } from '../slacker';
import { SlackerService } from '../slacker.service';

@Component({
  selector: 'app-slacker',
  templateUrl: './slacker.component.html',
  styleUrls: ['./slacker.component.css']
})
export class SlackerComponent implements OnInit {
  /*
  slacker1: Slacker = {
    id: 1,
    name: 'Alana'
  };*/

  slackers: Slacker[];
  selectedSlacker: Slacker;

  /* slackerService is a singleton instance of SlackerService
  */
  constructor(private slackerService: SlackerService) {

  }

  // this runs upon a lifecycle
  // https://angular.io/guide/lifecycle-hooks
  ngOnInit() {
    this.getSlackers();
  }

  onSelect(slacker: Slacker): void {
    this.selectedSlacker = slacker;
  }

  /* Subscribe is needed to do async; wait until server responds
  */
  getSlackers(): void {
    this.slackerService.getSlackers().subscribe(slackers => this.slackers = slackers);
  }


}
