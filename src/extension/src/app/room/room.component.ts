import { Component, OnInit } from '@angular/core';
import { Room } from '../room';
import { RoomService } from '../room.service';
import { RoomDetailComponent } from '../room-detail/room-detail-component';

@Component({
  selector: 'app-room',
  templateUrl: './room.component.html',
  styleUrls: ['./room.component.css']
})


export class RoomComponent implements OnInit {

  rooms: Room[] = this.roomService.getRooms(); //temporary since getRooms not async
  selectedRoom: Room;

  /* roomService is a singleton instance of RoomService
  */
  constructor(
    private roomService: RoomService
  ) {}

  // this runs upon a lifecycle
  // https://angular.io/guide/lifecycle-hooks
  ngOnInit() {
    this.getRooms();
  }

  onSelect(room: Room): void {
    this.selectedRoom = room;
  }

  /* Subscribe is needed to do async; wait until server responds
  */
  getRooms(): void {
    this.roomService.getRooms(); // .subscribe(room => this.rooms = room);
  }


}
