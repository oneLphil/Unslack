import { Component, OnInit } from '@angular/core';
import { MaterialModule } from '../material';
import { ChartsService } from '../charts.service';
import { Websites} from '../websites';
import * as Highcharts from 'highcharts';
import * as Highcharts3d from 'highcharts/highcharts-3d';
import * as HighchartsExport from 'highcharts/modules/exporting';
Highcharts3d(Highcharts);
HighchartsExport(Highcharts);

@Component({
  selector: 'app-charts',
  templateUrl: './charts.component.html',
  styleUrls: ['./charts.component.css']
})
export class ChartsComponent implements OnInit {
  websitesData: Websites;
  constructor(
    private chartsService: ChartsService
  ) { }

  Highcharts = Highcharts;
  chartConstructor = 'chart';
  chartOptions = {
    chart: {
      type: 'pie',
      options3d: {
          enabled: true,
          alpha: 45
      }
    },
    title: {
      text: 'Web Browsing Breakdown'
    },
    subtitle: {
      text: 'Time Spent for Websites'
    },
    plotOptions: {
      pie: {
          innerSize: 100,
          depth: 45
      }
    },
    series: [{
      name: 'Time Spent (hrs) per Website',
      data: this.chartsService.getWebsitesData().tracked/*[
          ['facebook.com', 8],
          ['teach.cs.utoronto.ca', 3],
          ['youtube.com', 1],
          ['ebay.ca', 6],
          ['portal.utoronto.ca', 8],
          ['mail.utoronto.ca', 4],
          ['workopolis.com', 4],
          ['reddit.com', 1],
          ['urbanoutfitters.com', 1]
      ]*/
  }]
  };
  updateFlag = false;
  chartCallback = function (chart) { console.log('callback!'); };

  ngOnInit() {
  }

}
