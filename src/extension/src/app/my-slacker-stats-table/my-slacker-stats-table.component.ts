import { Component, OnInit } from '@angular/core';
import { Site } from '../site';
// import { RoomService } from '../room.service';

@Component({
  selector: 'app-my-slacker-stats-table',
  templateUrl: './my-slacker-stats-table.component.html',
  styleUrls: ['./my-slacker-stats-table.component.css']
})
export class SummaryTableComponent implements OnInit {
  // parameter definitions of the columns
  columns = [
    { columnDef: 'website',     header: 'Website',   cell: (site: Site) => `${site.name}`     },
    { columnDef: 'duration',   header: 'Duration', cell: (site: Site) => `${site.time}`   }
  ];

  webStats: Site[] = [
    { name: 'www.youtube.com', time: 'Hrs: 1 Min: 37'},
    { name: 'www.<domain name>.com', time: 'Hrs: <> Min: <>'},
    { name: 'www.facebook.com', time: 'Hrs: 2 Min: 01'},
    { name: 'www.<domain name>.com', time: 'Hrs: <> Min: <>'},
    { name: 'www.twitter.com', time: 'Hrs: <0> Min: <11>'},
    { name: 'www.<domain name>.com', time: 'Hrs: <> Min: <>'},
    { name: 'www.wikipedia.org', time: 'Hrs: <> Min: <>'},
    { name: 'www.<domain name>.com', time: 'Hrs: <> Min: <>'},
    { name: 'www.<domain name>.com', time: 'Hrs: <> Min: <>'},
    { name: 'www.<domain name>.com', time: 'Hrs: <> Min: <>'}
  ];

  constructor() {}

  ngOnInit() {}

}
