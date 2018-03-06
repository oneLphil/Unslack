/*
SlackerServices provides a service to components for slacker information retrieval,
augmentation and management.

functions:

getSlackers(roomId:number): Slacker[]
getSlacker(userId:number): Slacker
... (maybe more if we can get statistics from RoomService)

retrieves data of all slackers for a given room id.

*/

import { Injectable } from '@angular/core';
import { Slacker } from './slacker';
//import { SLACKERS } from './mock-slackers';

import { MessageService } from './message.service';
import { RoomService } from './room.service'



@Injectable()
export class SlackerService {

  constructor(
    private messageService: MessageService,
    private roomService: RoomService
    ) { }

  /* Requests an Array of Slackers from RoomService */
  getSlackers(roomId: number): Slacker[]> {
    this.messageService.add('SlackerService: fetched slackers');
    return this.RoomService.getLocalRoomData().slackers;
    /*return this.http.get<Slacker[]>(this.slackersUrl)
      .pipe(
        tap(slackers => this.log(`fetched slackers`)),
        catchError(this.handleError('getHeroes, []'))
      );*/
  }

  getSlacker(id: number): Slacker {
    // Todo: send the message _after_ fetching the slacker
    this.messageService.add(`slackerService: fetched slacker id=${id}`);
    // local file version
    return this.RoomService.getLocalRoomData().slackers.find(slacker => slacker.id === id);

    // http version
    /*
    const url = `${this.slackersUrl}/${id}`;
    return this.http.get<Slacker>(url).pipe(
      tap(_ => this.log(`fetched slacker id=${id}`)),
      catchError(this.handleError<Slacker>(`getSlacker id=${id}`))
    ); */
  }

  /** Log a SlackerService message with the MessageService */
  private log(message: string) {
    this.messageService.add('SlackerService: ' + message);
  }


  /** PUT: update the hero on the server
  updateSlacker (slacker: Slacker): Observable<any> {
    return this.http.put(this.slackersUrl, slacker, httpOptions).pipe(
      tap(_ => this.log(`updated slacker id=${slacker.id}`)),
      catchError(this.handleError<any>('updateSlacker'))
    );
  }
  */

  /**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result

  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      this.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }*/


}
