/*
SlackerServices provides a service to the Slacker components for slacker
information retrieval, augmentation and management.

functions:

myUsage : UsageChart


*/

import { Injectable } from '@angular/core';
import { Slacker } from './slacker';
import { SLACKER } from './mock-slacker';

import { MessageService } from './message.service';
import { RoomService } from './room.service'



@Injectable()
export class SlackerService {

  constructor(
    private messageService: MessageService,
    private roomService: RoomService
    ) { }

  getSlacker(): Slacker {
    // Todo: send the message _after_ fetching the slacker
    this.log(`fetched slacker id=${SLACKER.id}`);
    // local file version
    return SLACKER;

  }

  // Log a SlackerService message with the MessageService
  private log(message: string) {
    this.messageService.add('SlackerService: ' + message);
  }

  /*
  // Requests an Array of Slackers from RoomService
  getSlackers(roomId: number): Slacker[]> {
    this.messageService.add('SlackerService: fetched slackers');
    return this.RoomService.getLocalRoomData().slackers;
  }

  getSlacker(id: number): Slacker {
    // Todo: send the message _after_ fetching the slacker
    this.messageService.add(`slackerService: fetched slacker id=${id}`);
    // local file version
    return this.RoomService.getLocalRoomData().slackers.find(slacker => slacker.id === id);

  }
  */



}
