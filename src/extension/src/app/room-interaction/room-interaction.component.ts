import { Component, OnInit, OnChanges} from '@angular/core';
import { Room } from '../room';
import { RoomService} from '../room.service';

@Component({
  selector: 'app-room-interaction',
  templateUrl: './room-interaction.component.html',
  styleUrls: ['./room-interaction.component.css']
})
export class RoomInteractionComponent implements OnInit, OnChanges {

  rooms: Room[] = this.roomService.getRooms();
  panelOpenState: boolean = false;

  constructor(
    private roomService: RoomService
  ) { }

  ngOnInit() {
  }

  ngOnChanges() {
    this.updateRooms();
  }

  updateRooms() {
    this.rooms = this.roomService.getRooms(); // later there should be a getUserRooms param for id
  }

  join(room: Room) {
    console.log(room);
  }

  create() {

  }



}
