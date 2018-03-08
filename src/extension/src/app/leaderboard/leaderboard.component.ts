import { Component, OnInit } from '@angular/core';
import { Person } from './person';
import { SCORES } from './temp-scores';

@Component({
  selector: 'app-leaderboard',
  templateUrl: './leaderboard.component.html',
  styleUrls: ['./leaderboard.component.css']
})
export class LeaderboardComponent implements OnInit {

  selectedPerson: Person;
  people = SCORES;

  onSelect(person: Person): void {
    this.selectedPerson = person;
  }

  constructor() { }

  ngOnInit() {
  }

}
