import { Component, OnInit, OnChanges } from '@angular/core';
import { Room } from '../room';
import { RoomService } from '../room.service';
import { ServerService } from '../server.service';

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
    private roomService: RoomService,
    private serverService: ServerService
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
    const msg = {
      MessageType: 'JoinRoomRequest',
      RoomId: this.joinRoomIDField,
      UserName: this.joinRoomUserNameField
    };
    this.serverService.joinRoomRequest(msg).subscribe();
  }

  /**
   * Upon receipt of a new room id hash, create a new room and save it in the LocalStorage
   */
  create() {
    const msg = {
      MessageType: 'CreateRoomRequest',
      UserName: this.createRoomUserNameField,
      RoomName: this.createRoomNameField
    };
    const subscriber = this.serverService.createRoomRequest(msg).subscribe(
      data => this.roomService.addNewRoomToLocal(data['RoomId'], this.createRoomNameField),
      err => console.log('err in create: ', err)
    );
    console.log('create subscriber: ', subscriber);
  }

  changeRoomSettings() {

    const msg = {
      MessageType: 'ChangeRoomSettingsRequest',
      RoomId: this.changeRoomSettingsIDField,
      WebsiteSettings: [{'': 1}]
    };
    // preprocess the roomBlacklist string. Assume it to be comma separated.
    // get the string from this.changeRoomBlacklistField
    // bonus: if the user writes "google.com", change it so that it looks like
    // http://www.google.com
    this.serverService.changeRoomSettingsRequest(msg).subscribe();
  }
}
