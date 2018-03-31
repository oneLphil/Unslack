var config = new Config();
var gsites = new Sites(config);

// console.log(gsites.sites);

//var sites = gsites.sites;
var i = 0;
var sitesData = new Array();
for (site in gsites.sites) {
    i++;
    sitesData.push([site, gsites.sites[site]]);
    // console.log(secondsToString(gsites.sites[site]))
    if (i === 15) { break; }
}

Highcharts.chart('website-chart-container', {
    chart: {
        type: 'pie'/*,
        options3d: {
            enabled: true,
            alpha: 45
        }*/
    },
    title: {
        text: 'Website usage time'
    },
    subtitle: {
        text: 'Top 15 websites visited'
    },
    /*plotOptions: {
        pie: {
            innerSize: 100,
            depth: 45
        }
    },*/
    tooltip: {
        formatter: function () {
            return 'Time spent:' + secondsToString(this.y);
        }
    },
    series: [{
        name: 'Time',
        data: sitesData, /*[
            ['Bananas', 8],
            ['Kiwi', 3],
            ['Mixed nuts', 1],
            ['Oranges', 6],
            ['Apples', 8],
            ['Pears', 4],
            ['Clementines', 4],
            ['Reddish (bag)', 1],
            ['Grapes (bunch)', 1]
        ]*/
    }]
});