import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit {
  title = 'Unslack';

  routeLinks: any[];
  activeLinkIndex = -1;

  constructor(private router: Router) {
    this.routeLinks = [
      {
        label: 'Dashboard',
        link: './dashboard',
        index: 0
      }, {
        label: 'Slackers',
        link: './slackers',
        index: 1
      }, {
        label: 'Sample Charts',
        link: './charts',
        index: 2
      }, {
        label: 'Rooms',
        link: './room',
        index: 3
      }, {
        label: 'Time Tracker',
        link: './timetracker',
        index: 4
      }
    ];
  }
  ngOnInit(): void {
    this.router.events.subscribe((res) => {
      this.activeLinkIndex = this.routeLinks.indexOf(this.routeLinks.find(tab => tab.link === '.' + this.router.url));
    });
  }

}
