import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { catchError, map, tap } from 'rxjs/operators';
import { MessageService } from './message.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';

const httpOptions = {
  headers: new HttpHeaders({ })
};

@Injectable()
export class ServerService {
  serverUrl : string = ''; 
  constructor(
    private MessageService,
    private http: HttpClient
  ) { }

  /*
  === Create Room ===
  This message is to be sent when the user intends to create a brand-new room. It
  requires them to submit a userid/username, and will return their room id.

  The send message is formatted as follows:
    {
      "MessageType":"CreateRoomRequest",
      "UserName":<user's name>,                                           # string
      "RoomName":<room name>						# string
    }

  The response message is formatted as follows:
    {
      "MessageType":"CreateRoomResponse",
      "RoomId":<room id>                                                  # string
    }
  */

  createRoomRequest() : Observable<Object> {

    var msg = {
      MessageType: "CreateRoomRequest",
      UserName: "",
      RoomName: ""
    };

    return this.http.post(this.serverUrl, msg, httpOptions);
    
  }

  /**
   * === Join Room ===
    This message is sent when a user tries to join an existing room. Note that if
    the user gives a name already in the given room, we will return an error. After
    sending this message, the client ought to send messages requesting room data.

    The send message is formatted as follows:
      {
        "MessageType":"JoinRoomRequest",
        "RoomId":<room id>,                                                 # string
        "UserName":<user's name>                                              # string
      }

    The response message is formatted as follows:
      {
        "MessageType":"JoinRoomResponse"
      }
   */

  joinRoomRequest() : Observable<Object> {

    var msg = {
      MessageType: "JoinRoomRequest",
      RoomId: "",
      UserName: ""
    };

    return this.http.post(this.serverUrl, msg, httpOptions);
    
  }

  /**
   * === Send Browsing Data ===
    This message is sent periodically to give the user's data for scoring.

    The send message is formatted as follows:
      {
        "MessageType":"SendDataRequest",
        "RoomId":<room id>,                                                 # string
        "UserId":<user's name>,                                             # string
        "History": [ [<website>,<time>], ...],      # list of website strings
                                                    # paired with time spent (int?)
        "LastSubmitTime":<time stamp>                 # last time the user submitted
      }

    The response message is formatted as follows:
      {
        "MessageType":"SendDataResponse"
      }
   */
  sendDataRequest() : Observable<Object> {

    var msg = {
      MessageType: "SendDataRequest",
      RoomId: "",
      UserId: "",
      History: [[1,1]],
      LastSubmitTime: ""
    };

    return this.http.post(this.serverUrl, msg, httpOptions);
    
  }

  /**
   * === Get Leaderboard Data ===
    This message is sent periodically to get the room's scores.

    The send message is formatted as follows:
      {
        "MessageType":"GetLeaderboardRequest",
        "RoomId":<room id>                                                  # string
      }

    The response message is formatted as follows:
      {
        "MessageType":"GetLeaderboardResponse",
        "LastDay": [ [<user name>, <score>], ...],    # All a list of username-score
        "LastWeek": [ [<user name>, <score>], ...],   # pairs, sorted in order of
        "LastMonth": [ [<user name>, <score>], ...]   # best or worst score for the
                                                      # period.
      }
   */
  getLeaderboardRequest() : Observable<Object> {
    var msg = {
      MessageType: "GetLeaderboardRequest",
      RoomId: ""
    };

    return this.http.post(this.serverUrl, msg, httpOptions);
  }

  /**
   * === Change Room Settings ===
    This message is sent when the user intends to change some parameter of an
    existing room.

    The send message is formatted as follows:
      {
        "MessageType":"ChangeRoomSettingsRequest",
        "RoomId":<room id>,                                                 # string
        "WebsiteSettings": [{<website>:<weight>}, ...],  # list of object website strings
                                                      # mapped to numerical weights
      }

    The response message is formatted as follows:
      {
        "MessageType":"ChangeRoomSettingsResponse"
      }
   */
  changeRoomSettingsRequest() : Observable<Object> {
    var msg = {
      MessageType: "ChangeRoomSettingsRequest",
      RoomId: "",
      WebsiteSettings: [{"":1}]
    };

    return this.http.post(this.serverUrl, msg, httpOptions);
  }

  /**
   * === Get Room Settings ===
    This message is sent when the user needs an updated set of rules for their room.

    The send message is formatted as follows:
      {
        "MessageType":"GetRoomSettingsRequest",
        "RoomId":<room id>                                                  # string
      }

    The response message is formatted as follows:
      {
        "MessageType":"GetRoomSettingsResponse",
        "WebsiteSettings": [<website>:<weight>, ...],      # list of website strings
                                                          # mapped to weights
        "Users": [<user name>, ...]                        # list of user names
      }
   */
  getRoomSettingsRequest() : Observable<Object> {
    var msg = {
      MessageType: "GetRoomSettingsRequest",
      RoomId: ""
    };

    return this.http.post(this.serverUrl, msg, httpOptions);
  }
}
