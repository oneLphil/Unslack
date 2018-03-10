import { Component, OnInit, Input, OnChanges } from '@angular/core';
import { MaterialModule } from '../material';
import { ChartsService } from '../charts.service';
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
  @Input() xAxis: any[];
  @Input() chartTitle: string;
  @Input() subTitle: string;
  constructor(
    private chartsService: ChartsService,
    private timetrackerService: TimetrackerService
  ) { }

  Highcharts = Highcharts;
  chartConstructor = 'chart';
  chartOptions = {
    chart: {
      type: this.chartType
      /*options3d: {
          enabled: false,
          alpha: 45
      },*/
      //height: 600
    },
    title: {
      text: this.chartTitle
    },
    subtitle: {
      text: this.subTitle
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
      categories: this.xAxis,
      type: 'category'
    },
    yAxis: {
      title: {
        text: ''
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
      data: this.getChartData()
    }]
  };
  updateFlag = false;
  chartCallback = function (chart) { console.log('callback!'); };

  ngOnInit() {
    // console.log(this.chartData);
  }

  ngOnChanges() {
    console.log(this.xAxis);
    console.log(this.getChartData);

    const currCategories = this.xAxis;
    //const currCategories = this.xAxis;
    //console.log(this.getCategories());
    this.chartOptions = {
      chart: {
        type: this.chartType
        /*options3d: {
            enabled: false,
            alpha: 45
        },*/
        //height: currData.length * 30
      },
      title: {
        text: this.chartTitle
      },
      subtitle: {
        text: this.subTitle
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
        categories: currCategories,
        type: 'category'
      },
      yAxis: {
        title: {
          text: ''
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
        data: this.getChartData()
      }]
    };
  }

  getChartData(): any[] {
    return this.chartData;
  }

}
