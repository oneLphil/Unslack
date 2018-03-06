import { Component, OnInit } from '@angular/core';
import { Room } from '../room';
import { ROOMS } from '../mock-rooms';

@Component({
  selector: 'app-room',
  templateUrl: './room.component.html',
  styleUrls: ['./room.component.css']
})


export class RoomComponent implements OnInit {

  rooms = ROOMS;

  selectedRoom: Room;
  constructor() { }


  ngOnInit() {
  }

  onSelect(room: Room): void {
    this.selectedRoom = room;
  }

}
