$(document).ready(function(){
    random();
});

let ctx = document.getElementById('myChart');

let myChart = new Chart(ctx, {
    data: {
        datasets: [{
            label: '평균기온',
            type: 'line',
            yAxisID: 'y-left',
            data: [],
            borderWidth: 2,
            pointRadius: 0
        },{
            label: '평균습도',
            type: 'line',
            yAxisID: 'y-right',
            data: [],
            borderWidth: 2,
            pointRadius: 0
        }],
        labels: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
    },
    options: {
        scales: {
            x: {
                grid: {
                    display: false
                },
            },
            'y-left': {
                type: 'linear',
                position: 'left',
                title: {
                    display: true,
                    text: '평균 기온 ( ℃ )'
                },
                ticks: {
                    min: 0,
                    max: 40,
                    stepSize: 10,
                },
                grid: {
                    display: true
                },
            },
            'y-right': {
                type: 'linear',
                position: 'right',
                title: {
                    display: true,
                    text: '평균 습도 ( % )',
                },
                ticks: {
                    min: 20,
                    max: 100,
                    stepSize: 20,
                },
                grid: {
                    display: false
                },
            }
        }
    }
});

const path = window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2));

function random() {
    console.log("랜덤 버튼을 눌렀습니다." + path)
    $.ajax({
        url: path + '/api/random',
        type: 'GET',
        dataType: 'json',
        success: function(data) {

            console.log('랜덤 데이터:', data);

            for (let i = 1; i <= 12; i++) {
                document.getElementById('temperature' + i).value = data.randomTemperature[i - 1];
                document.getElementById('climate' + i).value = data.randomClimate[i - 1];
            }

            myChart.data.datasets[0].data = data.randomTemperature;
            myChart.data.datasets[1].data = data.randomClimate;

            myChart.update();
        },
        error: function(xhr, status, error) {
            console.error('에러:', error);
        }
    });
}

function updateChart() {
    let temperatureValues = [];
    let climateValues = [];

    $('.temperature').each(function() {
        temperatureValues.push(Number($(this).val()));
    });

    $('.climate').each(function() {
        climateValues.push(Number($(this).val()));
    });

    myChart.data.datasets[0].data = temperatureValues;
    myChart.data.datasets[1].data = climateValues;
    myChart.update();
}