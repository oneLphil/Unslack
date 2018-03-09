import { Component, OnInit, Input, OnChanges } from '@angular/core';
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
export class ChartsComponent implements OnInit, OnChanges {
  @Input() chartData: any[];
  @Input() chartType: string;
  websitesData: Websites;
  constructor(
    private chartsService: ChartsService
  ) { }

  Highcharts = Highcharts;
  chartConstructor = 'chart';
  chartOptions = {
    chart: {
      type: 'pie', //this.chartType
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
      data: this.getChartData()//this.chartsService.getWebsitesData().tracked
  }]
  };
  updateFlag = false;
  chartCallback = function (chart) { console.log('callback!'); };

  ngOnInit() {
    console.log(this.chartData);
  }

  ngOnChanges() {
    console.log(this.chartData);
    this.chartOptions = {
      chart: {
        type: this.chartType,
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
        data: this.getChartData()//this.chartsService.getWebsitesData().tracked
    }]
    };
  }

  getChartData(): any[] {
    return this.chartData;
  }

}
