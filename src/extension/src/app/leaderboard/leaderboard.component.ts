import { Component, OnInit, Input, OnChanges, SimpleChanges, SimpleChange } from '@angular/core';
import { LeaderboardService } from '../leaderboard.service';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/of';
import {DataSource} from '@angular/cdk/collections';
import { User } from './user.model';
import {MatTableDataSource} from '@angular/material';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
// import { DATA } from './userdata';
// import { ALLBOARDS } from './userdata';
import { Room } from '../room';
import { ServerService } from '../server.service';

@Component({
  selector: 'app-leaderboard',
  templateUrl: './leaderboard.component.html',
  styleUrls: ['./leaderboard.component.css']
})
export class LeaderboardComponent implements OnInit, OnChanges {

  // @Input() room: Room;
  @Input() room: number;


  // dataSource = new MatTableDataSource(ALLBOARDS[room.id]);
  // dataSource : MatTableDataSource<User>;
  dataSource : User[];

  // displayedColumns = ['rank', 'name', 'score'];
  columns = [
    { columnDef: 'rank',  header: 'Rank',  cell: (user: User) => `${user.rank}`  },
    { columnDef: 'name',  header: 'Name',  cell: (user: User) => `${user.name}`  },
    { columnDef: 'score', header: 'Score', cell: (user: User) => `${user.score}` }
  ];


  constructor(private serverService: ServerService) {

  }

  ngOnChanges(changes: SimpleChanges){
    const room: SimpleChange = changes.room;
    this.room = room.currentValue;
    //this.dataSource = ALLBOARDS[this.room-1];
    this.getData();
  }


  /*applyFilter(filterValue: string) {
    filterValue = filterValue.trim(); // Remove whitespace
    filterValue = filterValue.toLowerCase(); // MatTableDataSource defaults to lowercase matches
    //this.dataSource.filter = filterValue;
  }*/

  ngOnInit() {
    // this.dataSource = ALLBOARDS[this.room-1];
    this.getData();
  }

  /*getData(): MatTableDataSource<User> {
    return new MatTableDataSource(ALLBOARDS[this.room-1]);
  }*/

  getData() {
    /*this.serverService.getLeaderboardRequest(this.room).subscribe(
      (data) =>
            this.dataSource = data[0];
            console.log("this.dataSource =", this.dataSource);
          );*/

    //
    this.serverService.updateRoomScores(this.room);
    const currRooms: Room[] = JSON.parse(localStorage.slackerRooms);
    const thisRoom = currRooms.find(room => room.id === this.room);

    this.dataSource = [];

    const index = currRooms.indexOf(thisRoom);
    const sortedByRank = thisRoom['scores'][0]['LastDay'];
    sortedByRank.sort( function(a, b) { return b[1] - a[1]; } );

    if (index > -1) {

      /*this.dataSource = thisRoom['lastDay'].map(person =>
                                { 'rank': ?,
                               'name': person[0],
                               'score': person[1] });*/

      for (let i = 0; i < sortedByRank.length; i++) {

        this.dataSource[i] = { 'rank': i + 1,
                               'name': sortedByRank[i][0],
                               'score': sortedByRank[i][1] };
      }

    }

  }

}
