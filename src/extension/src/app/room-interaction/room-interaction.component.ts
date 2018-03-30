import { Component, OnInit, OnChanges } from '@angular/core';
import { Room } from '../room';
import { RoomService } from '../room.service';
import { ServerService } from '../server.service';
import { SlackerService } from '../slacker.service';

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
  changeRoomAddBlacklistField = ''; // comma separated
  changeRoomRemoveBlacklistField = ''; // comma separated
  createdRoomId = '';
//  createRoomIdMessage = 'Your new room id: ';

  panelOpenState = false;

  constructor(
    private roomService: RoomService,
    private serverService: ServerService,
    private slackerService: SlackerService
  ) { }

  ngOnInit() {
  }

  ngOnChanges() {
    this.rooms = this.roomService.getRooms();
  }

  join() {
    const msg = {
      MessageType: 'JoinRoomRequest',
      RoomId: this.joinRoomIDField,
      UserName: this.joinRoomUserNameField
    };

    const roomId: number = parseInt(this.joinRoomIDField, 10);

    // check if user has already joined this room
    if (this.slackerService.getSlackerName(roomId)) {
      this.serverService.joinRoomRequest(msg).subscribe(
        data => {
          if (data['MessageType'] !== 'Error') {
            this.serverService.addNewRoomToLocal(roomId, 'joined room');
            this.serverService.addRoomIdToNameToLocal(roomId, this.joinRoomUserNameField);
          } else {
            console.log(data);
          }
        },
        err => console.log(err)
      );
    } else {
      console.log('Error: Already joined room:', roomId);
    }
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
      data => {
        if (!(data['MessageType'] === 'Error')) {
          this.serverService.addNewRoomToLocal(data['RoomId'], this.createRoomNameField);
          this.serverService.addRoomIdToNameToLocal(data['RoomId'], this.createRoomUserNameField);
          // This is the correct way to set the string but can't tell if server
          // is retrieving and displaying the message
          this.createdRoomId = data['RoomId'];
        } else {
          console.log('subscribe data: ', data);
        }
      },
      err => console.log('err in create: ', err)
    );
    console.log('create subscriber: ', subscriber);
    document.getElementById('welcomeDiv').style.display = 'inline-block';

  }

  changeRoomSettings() {
    var ATB = this.websiteParser(this.changeRoomAddBlacklistField);
    var RFB = this.websiteParser(this.changeRoomRemoveBlacklistField);
    const msg = {
      MessageType: 'ChangeRoomSettingsRequest',
      RoomId: this.changeRoomSettingsIDField,
      AddToBlacklist: ATB,
      RemoveFromBlacklist: RFB
    };
    this.serverService.changeRoomSettingsRequest(msg).subscribe();
  }

  // Parse blacklisted websites from HTML input
  // 'websites' is passed as a comma separated string: "youtube.com, facebook.com"
  websiteParser (websites) {
    // Base string from HTML
    var sitesArray = new Array();
    var sitesTrimmed = new String();
    sitesTrimmed = websites.replace(/ /g, ""); //Trim whitespace
    sitesArray = sitesTrimmed.split(",");
    var i = 0;
    var prefix = "https://";
    // Fix the formatting of the passed websites
    for (i = 0; i < sitesArray.length; i++) {
      var first = sitesArray[i].substring(0,7); //get first 8char substring
      if (first === prefix) { //If substring == "https://"
        //Check for www.
  //      if (second.equals)
      }
      else {
        var temp = sitesArray[i];
        sitesArray[i] = prefix.concat(temp);
      }
    }
    return sitesArray;
  }

    // preprocess the roomBlacklist string. Assume it to be comma separated.
    // get the string from this.changeRoomBlacklistField
    // bonus: if the user writes "google.com", change it so that it looks like
    // http://www.google.com

  // }
}
