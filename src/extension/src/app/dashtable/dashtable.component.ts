import { Component } from '@angular/core';
//import { Summary } from './trace';
//import { DISPLAY_VALUES } from './temp-scores';
import {MatTableDataSource} from '@angular/material';

@Component({
  selector: 'app-dashtable',
  templateUrl: './dashtable.component.html',
  styleUrls: ['./dashtable.component.css']
})
export class DashtableComponent {

  displayedColumns = ['Website', 'Time Elapsed'];
  dataSource = new MatTableDataSource(TRACE_DATA);
  applyFilter(filterValue: string) {
    filterValue = filterValue.trim(); // Remove whitespace
    filterValue = filterValue.toLowerCase(); // MatTableDataSource defaults to lowercase matches
    this.dataSource.filter = filterValue;
  }

export interface Summary {
  site: string;
  time: string;
}

const SUMMARY_DATA: Summary[] = [

   { site: 'www.youtube.com', time: 'Hrs: 1 Min: 37'},
   { site: 'www.<domain name>.com', time: 'Hrs: <> Min: <>'},
   { site: 'www.facebook.com', time: 'Hrs: 2 Min: 01'},
   { site: 'www.<domain name>.com', time: 'Hrs: <> Min: <>'},
   { site: 'www.twitter.com', time: 'Hrs: <0> Min: <11>'},
   { site: 'www.<domain name>.com', time: 'Hrs: <> Min: <>'},
   { site: 'www.wikipedia.org', time: 'Hrs: <> Min: <>'},
   { site: 'www.<domain name>.com', time: 'Hrs: <> Min: <>'},
   { site: 'www.<domain name>.com', time: 'Hrs: <> Min: <>'},
   { site: 'www.<domain name>.com', time: 'Hrs: <> Min: <>'}
 ];

constructor() {}

  selectedSummary: Summary;
  sites = SUMMARY_VALUES;
