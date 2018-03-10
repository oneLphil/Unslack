import { Component, OnInit, Input, OnChanges } from '@angular/core';
import { MaterialModule } from '../material';
import { ChartsService } from '../charts.service';
import { Websites} from '../websites';
import * as Highcharts from 'highcharts';
import * as Highcharts3d from 'highcharts/highcharts-3d';
import * as HighchartsExport from 'highcharts/modules/exporting';
import { TimetrackerService } from '../timetracker.service';
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
    private chartsService: ChartsService,
    private timetrackerService: TimetrackerService
  ) { }

  Highcharts = Highcharts;
  chartConstructor = 'chart';
  chartOptions = {
    chart: {
      type: /*'pie',*/ this.chartType,
      options3d: {
          enabled: false,
          alpha: 45
      },
      height: 600
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
      },
      series: {
        pointWidth: 20,
        minPointLength: 10
      }
    },
    xAxis: {
      /*categories: this.getCategories(),*/
      type: 'category'
    },
    yAxis: {
      title: {
        text: 'Fruit eaten'
      }
    },
    tooltip: {
      formatter: function () {
        let years = Math.floor(this.y * 360 / 31536000);
        let days = Math.floor((this.y * 360 % 31536000) / 86400);
        let hours = Math.floor(((this.y * 360 % 31536000) % 86400) / 3600);
        let mins = Math.floor((((this.y * 360 % 31536000) % 86400) % 3600) / 60);
        let secs = (((this.y * 360 % 31536000) % 86400) % 3600) % 60;
        let s = '';
        if (years) {
          s = s + ' ' + years + 'y';
        }
        if (days) {
          s = s + ' ' + days + 'd';
        }
        if (hours) {
          s = s + ' ' + hours + 'h';
        }
        if (mins) {
          s = s + ' ' + mins + 'm';
        }
        if (secs) {
          s = s + ' ' + secs.toFixed(0) + 's';
        }
        return 'Time spent:' + s;
      }
    },
    series: [{
      name: 'Time spent per website (hrs)',
      data: this.getChartData() // this.chartsService.getWebsitesData().tracked
    }]
  };
  updateFlag = false;
  chartCallback = function (chart) { console.log('callback!'); };

  ngOnInit() {
    // console.log(this.chartData);
  }

  ngOnChanges() {
    const currData = this.getChartData();
    const currCategories = this.getCategories();
    this.chartOptions = {
      chart: {
        type: this.chartType,
        options3d: {
            enabled: false,
            alpha: 45
        },
        height: currData.length * 30
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
        },
        series: {
          pointWidth: 20,
          minPointLength: 1
        }
      },
      xAxis: {
        /*categories: currCategories,*/
        type: 'category'
      },
      yAxis: {
        title: {
          text: 'Fruit eaten'
        }
      },
      tooltip: {
        formatter: function () {
          let years = Math.floor(this.y * 360 / 31536000);
          let days = Math.floor((this.y * 360 % 31536000) / 86400);
          let hours = Math.floor(((this.y * 360 % 31536000) % 86400) / 3600);
          let mins = Math.floor((((this.y * 360 % 31536000) % 86400) % 3600) / 60);
          let secs = (((this.y * 360 % 31536000) % 86400) % 3600) % 60;
          let s = '';
          if (years) {
            s = s + ' ' + years + 'y';
          }
          if (days) {
            s = s + ' ' + days + 'd';
          }
          if (hours) {
            s = s + ' ' + hours + 'h';
          }
          if (mins) {
            s = s + ' ' + mins + 'm';
          }
          if (secs) {
            s = s + ' ' + secs.toFixed(0) + 's';
          }
          return 'Time spent:' + s;
        }
      },
      series: [{
        name: 'Time spent per website',
        data: currData // this.chartsService.getWebsitesData().tracked
      }]
    };
  }

  getChartData(): any[] {
    return this.chartData;
  }

  getCategories(): any[] {
    let categories: String[] = [];
    for (let item in this.chartData) {
      if (item) {
        // console.log(this.chartData[item].name);
        categories.push(this.chartData[item].name);
      }
    }
    return categories;
  }

}
