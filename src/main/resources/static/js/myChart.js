var chartDataStr = decodeHtml(chartData);
var chartJsonArray = JSON.parse(chartDataStr);

var arrayLength = chartJsonArray.length;

var numericData=[];
var labelData=[];

for(var i=0; i<arrayLength; i++){
	numericData[i]=chartJsonArray[i].value;
	labelData[i]=chartJsonArray[i].label;
}

 new Chart(document.getElementById("myPieChart"),{
	type:'pie',
	data:{
  labels: labelData,
  datasets: [
    {
      label: 'Dataset 1',
      data: numericData,
      backgroundColor: ["#3e95cd", "#8e5ea2", "#3cb9f"],
      //borderColor: 'rgb(255,99,132)'
    }
  ]
},
	options:{}
});

function decodeHtml (html){
	var txt = document.createElement("textarea");
	txt.innerHTML=html;
	return txt.value;
}