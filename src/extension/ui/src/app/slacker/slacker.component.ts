import { Component, OnInit } from '@angular/core';
import { Slacker } from '../slacker';

@Component({
  selector: 'app-slacker',
  templateUrl: './slacker.component.html',
  styleUrls: ['./slacker.component.css']
})
export class SlackerComponent implements OnInit {
  slacker1: Slacker = {
    id: 1,
    name: 'Alana'
  };
  constructor() {

  }

  ngOnInit() {
  }

}
