import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Location } from '@angular/common';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit {
  title = 'Unslack';

  routeLinks: any[];
  activeLinkIndex = -1;

  constructor(private router: Router, private location: Location) {
    this.routeLinks = [
      {
        label: 'Dashboard',
        link: './dashboard',
        index: 0
      }, {
        label: 'My Slacker Stats',
        link: './slacker',
        index: 1
      }, {
        label: 'Rooms',
        link: './room',
        index: 2
      }
    ];
  }
  ngOnInit(): void {
    // this.load();
    // this.router.navigate(['./dashboard']);
    console.log(this.router.url);
    this.router.events.subscribe((res) => {
      this.activeLinkIndex = this.routeLinks.indexOf(this.routeLinks.find(tab => tab.link === '.' + this.router.url));
    });
    console.log(this.router.events);
  }
  /*load() {
    location.reload();
  }*/

}
