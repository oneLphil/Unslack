import { Component, OnInit } from '@angular/core';
import { Slacker } from '../slacker';
import { SLACKERS } from '../mock-slackers';

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

  slackers = SLACKERS;
  constructor() {

  }

  ngOnInit() {
  }

  selectedSlacker: Slacker;

  onSelect(slacker: Slacker): void {
    this.selectedSlacker = slacker;
  }


}
