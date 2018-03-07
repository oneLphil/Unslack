import { Injectable } from '@angular/core';

import { Room } from './room';
import { ROOMS } from './mock-rooms';

// need this for HttpClient.get
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';

import { MessageService } from './message.service';

@Injectable()
export class RoomService {

  constructor(private messageService: MessageService) { }

  getRooms(): Observable<Room[]> {
    this.messageService.add('RoomService: fetched rooms');
    return of(ROOMS);
  }

  getRoom(id: number): Observable<Room> {
    // Todo: send the message _after_ fetching the room
    this.messageService.add(`roomService: fetched room id=${id}`);
    return of(ROOMS.find(room => room.id === id));
  }

}
