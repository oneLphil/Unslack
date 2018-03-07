import { Injectable } from '@angular/core';
import { WEBSITES } from './mock-websites';
import { Websites } from './websites';

@Injectable()
export class ChartsService {

  constructor() { }

  getWebsitesData(): Websites {
    return WEBSITES;
  }
}
