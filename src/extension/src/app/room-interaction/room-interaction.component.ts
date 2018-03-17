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
  createRoomNameField = '';
  createRoomUserNameField = '';
  joinRoomIDField = '';
  joinRoomUserNameField = '';
  // field for a new change room settings component
  // with a dropdown menu to select a room
  changeRoomSettingsIDField = '';
  changeRoomBlacklistField = ''; // comma separated


  panelOpenState = false;

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

  join() {
    this.roomService.joinRoom(
      this.joinRoomIDField,
      this.joinRoomUserNameField
    );
  }

  create() {
    this.roomService.createRoom(
      this.createRoomUserNameField,
      this.createRoomNameField
    );
  }

  changeRoomSettings() {
    this.roomService.changeRoomSettings(
      this.changeRoomSettingsIDField,
      this.changeRoomBlacklistField
    );
  }



}
