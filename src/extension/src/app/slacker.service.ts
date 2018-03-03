import { Injectable } from '@angular/core';

import { Slacker } from './slacker';
import { SLACKERS } from './mock-slackers';

// need this for HttpClient.get
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';

import { MessageService } from './message.service';

@Injectable()
export class SlackerService {

  constructor(private messageService: MessageService) { }

  getSlackers(): Observable<Slacker[]> {
    this.messageService.add('SlackerService: fetched slackers');
    return of(SLACKERS);
  }

  getSlacker(id: number): Observable<Slacker> {
    // Todo: send the message _after_ fetching the slacker
    this.messageService.add(`slackerService: fetched slacker id=${id}`);
    return of(SLACKERS.find(slacker => slacker.id === id));
  }

}
