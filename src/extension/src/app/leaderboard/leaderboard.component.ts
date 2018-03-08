import { Component, OnInit, Input } from '@angular/core';
import { LeaderboardService } from '../leaderboard.service';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/of';
import {DataSource} from '@angular/cdk/collections';
import { User } from './user.model';
import {MatTableDataSource} from '@angular/material';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import { DATA } from './userdata';
import { ALLBOARDS } from './userdata';
import { Room } from '../room'

@Component({
  selector: 'app-leaderboard',
  templateUrl: './leaderboard.component.html',
  styleUrls: ['./leaderboard.component.css']
})
export class LeaderboardComponent implements OnInit, OnChanges {

  //@Input() room: Room;
  @Input() room: number;


  //dataSource = new MatTableDataSource(ALLBOARDS[room.id]);
  dataSource : MatTableDataSource<User>;
  displayedColumns = ['id', 'name', 'score', 'info'];
  constructor(/*private leaderboardService: LeaderboardService*/) {

  }

  ngOnChanges(changes: SimpleChanges){
    const room: SimpleChange = changes.room;
    this.room = room.currentValue;
    this.dataSource = new MatTableDataSource(ALLBOARDS[this.room-1]);
    this.dataSource.filter = "";
  }


  applyFilter(filterValue: string) {
    filterValue = filterValue.trim(); // Remove whitespace
    filterValue = filterValue.toLowerCase(); // MatTableDataSource defaults to lowercase matches
    this.dataSource.filter = filterValue;
  }

  ngOnInit() {
    this.dataSource = new MatTableDataSource(ALLBOARDS[this.room-1]);
  }

  getData(): MatTableDataSource<User> {
    return new MatTableDataSource(ALLBOARDS[this.room-1]);
  }

}
