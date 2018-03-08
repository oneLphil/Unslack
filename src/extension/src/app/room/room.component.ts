import { Component, OnInit } from '@angular/core';
import { Room } from '../room';
import { RoomService } from '../room.service';
import { ALLBOARDS } from '../leaderboard/userdata';
import { User } from '../leaderboard/user.model';

@Component({
  selector: 'app-room',
  templateUrl: './room.component.html',
  styleUrls: ['./room.component.css']//,
})


export class RoomComponent implements OnInit {

  rooms: Room[];
  selectedRoom: Room;
  leaderboards = ALLBOARDS;
  selectedLeaderboard: User[];

  /* roomService is a singleton instance of RoomService
  */
  constructor(private roomService: RoomService) {

  }

  // this runs upon a lifecycle
  // https://angular.io/guide/lifecycle-hooks
  ngOnInit() {
    this.rooms = this.getRooms();
  }

  onSelect(room: Room): void {
    this.selectedRoom = room;
    this.selectedLeaderboard = this.leaderboards[room.id];
  }

  /* Subscribe is needed to do async; wait until server responds
  */
  getRooms(): Room[] {
    return this.roomService.getRooms();//.subscribe(room => this.rooms = room);
  }


}
