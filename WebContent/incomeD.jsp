<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<!-- ===================================pie chart=============================== -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<!-- ===================================date=============================== -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>


</head>
<body>

<title>Insert title here</title>
<style type="text/css">

ul {
	list-style: none;
	/* line-height:53px; */
	font-size: 20px;
}

h1{
font-family: "Raleway", sans-serif;
	font-size: 20px;
	margin-left:1%;
	width: 60%;
	border: 3px solid red;
	
}

h2{
font-family: "Raleway", sans-serif;
	font-size: 20px;
	margin-left:1%;
	float: left;
}

h3 {
	font-family: "Raleway", sans-serif;
	font-size: 20px;
	margin-left:1%;
	float: left;
	width: 100%;

}
input[type=number], select {
	width: 50%;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
	resize: vertical;
	font-size: 20px;
	text-align: right;
}

input[type=text], select {
	width: 50%;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
	resize: vertical;
	font-size: 20px;
}

label {
	padding: 12px 12px 12px 0;
	display: inline-block;
}

button {
	background-color: #4CAF50;
	color: white;
	padding: 8px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	float: right;
}

input[type=submit]:hover {
	background-color: #45a049;
}

fieldset#valuesIncome {
	background-color: hsl(0, 0%, 47%);
	border-radius: 15px;
}



#butin {
	background-color: hsl(0, 0%, 94%);
	border-radius: 7px;
	width: 100%;
	margin-top: 1%;
	margin-bottom: 0.5%;
	text-align: center;
	font-size: 15px;
	border-style: none;
	border-radius: 15px;
	border-right: none;
	border-left: none;
	border-top: none;
	border-bottom: none;
}

#datepicker3, #datepicker4 {
	width: 50%;
}

fieldset#incomeD_all{
	width:100%;
	border-radius: 15px;
	background-color: hsl(0, 0%, 47%);
	margin-top: 0;
}
#line{
	width: 42%; 
	/* border: 3px solid blue; */		 
	float: right;
	z-index: 9999;
	margin-right: 2%;
		}

fieldset#values2 {
	float: left;
	background-color: hsl(0, 0%, 94%);
	border-radius: 7px;
	width: 56%;
	margin-bottom: 0.5%;
	z-index: 9999;
	line-height: 54px;
	margin-top: -1px;
}

fieldset#but {
	background-color: hsl(0, 0%, 47%);
	border-radius: 7px;
	width: 98.5%;
	margin-bottom: 0.5%;
	height: 450px;
	/* border: 3px solid green; *
	z-index: 9999;/
}

#lineSt{border-radius: 7px;}
</style>

</head>


<body>
<fieldset id="incomeD_All">

	<fieldset id="values2">
		<form action="#" method="post">						
			<%-- <%
			if (session.getAttribute("tableList") == null) {
			%> --%>
		   <ul>

				<li>
				<label for="날짜선택">날 짜</label> 
				<input type="text" id="datepicker3" placeholder="Start: 년-월-일" style=" text-align: center;" name="nal1" required="required" >
				~ <input type="text" id="datepicker4" placeholder="End: 년-월-일" style=" text-align: center;" name="nal2" required="required" >
				<input type="submit" value="호출하기">
				</li>
									
				<li>
				<label for="오늘 티켓 매출 평균">오늘 티켓 매출</label> 
				<input type="number" name="incomeDay" value="<%-- <%=toDayTicketSalse %> --%>" placeholder="일 평균 매출액" readonly="readonly">원
				<li>
								
				<li>
				<label for="오늘 매점 매출 평균">오늘 매점 매출</label> 
				<input type="number" name="incomeMon" value="<%-- <%=toDayMarketSalse %> --%>" placeholder="월 평균 매출액" readonly="readonly">원
				<li>
				
				<li>
				<label for="1인 매출액">1인당 평균매출</label> 
				<input type="number" name="incomeMon" value="<%-- <%=avgPeopleSalse %> --%>" placeholder="연 평균 매출액" readonly="readonly">원
				<li>
					
			</ul>
		</form>

	</fieldset>

					<!-- =============================Ticket line chart ===================================== -->
<div id="line">
<fieldset id="lineSt">
	<div id="containerlineT" style="width: 100%; height: 100%; margin: 0 auto;"></div>
		 <script>
		 Highcharts.chart('containerlineT', {
			    chart: {
			        type: 'line'
			    },
			    title: {
			        text: '매출액 추이'
			    },
			    subtitle: {
			        text: ''
			    },
			    xAxis: {
			        categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
			    },
			    yAxis: {
			        title: {
			            text: 'Temperature (°C)'
			        }
			    },
			    plotOptions: {
			        line: {
			            dataLabels: {
			                enabled: true
			            },
			            enableMouseTracking: false
			        }
			    },
			    series: [{
			        name: 'Tokyo',
			        data: [7.0, 6.9, 9.5, 14.5, 18.4, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6]
			    }, {
			        name: 'London',
			        data: [3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 16.6, 14.2, 10.3, 6.6, 4.8]
			    }]
			});
			
			</script>
			</fieldset>
	</div>


<!-- ==================================아래 총 가격 출력창========================= -->
<div id="buttum">
	<h3>날짜별 매출액</h3>
		<fieldset id="but">
			
			<table cellspacing="0" cellpadding="0" border="1" id="butin">
				<tr>
					<th>날짜</th>
					<th>티캣판매액</th>
					<th>매점판매액</th>
					<th>총판매액</th>
					<th>총할인액</th>
					<th>당기순이익</th>
				</tr>

				<c:forEach items="${list }" var="board">
					<tr>
						<td>${board.nal }</td>
						<td>${board.ticketSales }</td>
						<td>${board.marketSalse }</td>
						<td>${board.totalSalse }</td>
						<td>${board.totalDiscount }</td>
						<td>${board.netIncome }</td>
					</tr>
				</c:forEach>
			</table>
<%-- 			<center>
				<jsp:include page="#" flush="true" />
			</center> --%>
		</fieldset>
</div>
</fieldset>

<!-- =======================script 날짜========================= -->
  <script>
  $( function() {
   		 $( "#datepicker3" ).datepicker();
  } );
  </script>
	
  <script>
  $( function() {
  		  $( "#datepicker4" ).datepicker();
  } );
  </script>
						
						
</body>
</html>