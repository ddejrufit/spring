<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>index.jsp</title>
<script src="https://cdn.canvasjs.com/canvasjs.min.js"></script>
<script type="text/javascript" src="resources/jQuery.js"></script>
<script type="text/javascript">
	$(()=>{
		//alert('ㅇㅇ')
		
		// AJAX로 hour / temp / wfKor 에 대한 정보를 table에 넣기
		$.ajax({
			url:"k.weather.get",
			success: function(asdf){
				let td1 = $('<th></th>').text('시간');
				let td2 = $('<th></th>').text('기온');
				let td3 = $('<th></th>').text('날씨');
				
				let trr = $('<tr></tr>').append(td1,td2,td3);
				let ar =[];
				
				$(asdf).find('data').each(function(i,d){
					let hour = $(d).find('hour').text();
					let temp = $(d).find('temp').text();
					let wfKor = $(d).find('wfKor').text();
					
					let td1 = $('<td></td>').text(hour);
					let td2 = $('<td></td>').text(temp);
					let td3 = $('<td></td>').text(wfKor);
					
					let tr = $('<tr></tr>').append(td1, td2, td3);
					
					$('table').append(tr);
					
					ar[i] = {label: hour,y: temp * 1 };
			
				});
					
					var chart = new CanvasJS.Chart("chartContainer", {
						animationEnabled: true,
						exportEnabled: true,
						theme: "dark2",
						title:{
							text: "날씨"              
						},
						data: [              
						{
							// Change type to "doughnut", "line", "splineArea", etc.
							type: "column",
							dataPoints: ar
							
						}
						]
					});
					chart.render();
				
			}
		});
		
	});
	



</script>
</head>
<body>
<div id="chartContainer" style="height: 300px; width: 100%;"></div>
	<table border="1"></table>
</body>
</html>