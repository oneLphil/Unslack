import { Injectable } from '@angular/core';
import { WEBSITES } from './mock-websites';
import { Websites } from './websites';

@Injectable()
export class ChartsService {

  constructor() { }

  getWebsitesData(): Websites {
    console.log('in charts.service.ts getWebsiteData');
    return WEBSITES;
  }

  // only work if obj[] with obj having a name property
  getNameCategoriesFromListOfObject(catlist: any[]): any[] {
    const categories: String[] = [];
    for (let item in catlist) {
      if (item) {
        // console.log(this.chartData[item].name);
        categories.push(catlist[item].name);
      }
    }
    return categories;
  }
  /* General method for
  getListArrayData(): any[] {
    return ... server request
  }*/
}
