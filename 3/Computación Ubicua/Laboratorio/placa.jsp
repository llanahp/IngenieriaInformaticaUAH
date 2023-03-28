<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.CallableStatement"%>
<%@page import="java.sql.Date"%>
<%
  String id = request.getParameter("userId");
  String driverName = "com.mysql.jdbc.Driver";
  String connectionUrl = "jdbc:mysql://testinstance.cu852n4mo2tc.us-east-1.rds.amazonaws.com:3306/";
  String dbName = "placas";
  String userId = "root";
  String password = "rootroot";
  Connection connection = null;
  try {
    Class.forName(driverName);
    connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
  } catch (ClassNotFoundException e) {
    e.printStackTrace();
  }
  Statement statement = null;
  Statement statement2 = null;
  Statement statement3 = null;
  Statement statement4 = null;
  Statement statement5 = null;

  ResultSet resultSet = null;
  ResultSet resultSet2 = null;
  ResultSet resultSet3 = null;
  ResultSet resultSet4 = null;
  ResultSet resultSet5 = null;
%>
<tr>
<%
	try{
	
  statement=connection.createStatement();
		String sqlaviso ="SELECT * FROM `placa` where (sensor1=0 OR sensor2=0 OR sensor3=0 OR sensor4=0 ) and DATE(fecha) = CURDATE(); ";
		ResultSet Resultaviso = statement.executeQuery(sqlaviso);
		if (Resultaviso.next())
		{
			%>
			  <blockquote>
			    Parece que uno de los sensores no estï¿œ en perfecto estado y lee poco adecuados. Por favor, revise la placa
			  </blockquote>
			<%
		}
	}catch(Exception exc)
	{
		
	}
%>

</tr>


<h2 id="enunciadoTablas" align="center">Media de los sensores en los ultimos 4 dias</h2>
<div>
  <canvas id="myChart" width="0.9" height="400" style="border:3px solid"></canvas>
</div>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script>
  const labels = [
    'Sensor 1',
    'Sensor 2',
    'Sensor 3',
    'Sensor 4',
    'Sensor 5',
    
  ];
  <%
  try{ 
  String sql ="SELECT avg(placa.sensor1)as s1, avg(placa.sensor2) as s2, avg( placa.sensor3) as s3,  avg(placa.sensor4) as s4,  avg(placa.sensor5) as s5, fecha FROM `placa` GROUP by DAY(fecha)   ORDER by fecha desc LIMIT 4;";
	int i=1;
  resultSet = statement.executeQuery(sql);
  resultSet.next();
  %>

  const data = {
    labels: labels,
    datasets: [{
      label: 'Hoy',
       borderWidth: 3 ,
       backgroundColor:  "rgba(255, 99, 132, 0.4)",
      borderColor: 'rgba(255, 99, 132, 1)',
      fill: true,
      data: [<%=resultSet.getString("s1") %>
      , <%=resultSet.getString("s2") %>
      , <%=resultSet.getString("s3") %>
      , <%=resultSet.getString("s4") %>
      , <%=resultSet.getString("s5") %>],
    },
    <%
    	i++;
    	resultSet.next();
    %>
     {
    	label: 'Ayer',
    	 borderWidth: 3 ,
        backgroundColor: 'rgba(75, 192, 192, 0.4)',
        borderColor: 'rgba(75, 192, 192,1)',
        fill: true,
        data: [<%=resultSet.getString("s1") %>
        , <%=resultSet.getString("s2") %>
        , <%=resultSet.getString("s3") %>
        , <%=resultSet.getString("s4") %>
        , <%=resultSet.getString("s5") %>],
      },
      <%
  	i++;
  	resultSet.next();
  %>
      {
    	  label: 'antes de ayer',
    	  borderWidth: 3 ,
         backgroundColor: 'rgba(0, 187, 45,0.4)',
         borderColor: 'rgba(0, 187, 45,1)',
         fill: true,
         data: [<%=resultSet.getString("s1") %>
         , <%=resultSet.getString("s2") %>
         , <%=resultSet.getString("s3") %>
         , <%=resultSet.getString("s4") %>
         , <%=resultSet.getString("s5") %>],
       },
       <%
     	i++;
     	resultSet.next();
     %>
         {
       	  label: 'ante antes de ayer',
       	  borderWidth: 3 ,
            backgroundColor: 'rgba(244, 208, 63,0.4)',
            borderColor: 'rgba(244, 208, 63,1)',
            fill: true,
            data: [<%=resultSet.getString("s1") %>
            , <%=resultSet.getString("s2") %>
            , <%=resultSet.getString("s3") %>
            , <%=resultSet.getString("s4") %>
            , <%=resultSet.getString("s5") %>],
          }
      ]
  
  };
  <%
 
  

  } catch (Exception e) {
  	e.printStackTrace();
  }
  %>

  const config = {
    type: 'line',
    data: data,
    options: {},
    
  };
</script>
<script>
  const myChart = new Chart(
    document.getElementById('myChart'),
    config
  );
</script>
<!--  -->
<div class="container">
<select id="fechas1" class="edit" onchange="myFunction()">
<%
 try{ 
	Statement statementfecha1 = connection.createStatement();
	ResultSet resultFecha1 = statementfecha1.executeQuery("SELECT date_format(fecha,'%Y-%m-%d') as fe FROM `placa` GROUP by DAY(fecha);");
		while(resultFecha1.next())
		{
			String fec="\""+resultFecha1.getString("fe")+"\"";
			%>
				<option value=<%=fec%>> <%=resultFecha1.getString("fe") %> </option>
			<%
		}
	}
	catch(Exception exc)
	{
	}
	%>
 </select>
<select id="fechas2" class="edit pull-right" onchange="myFunction()">
	<%
 try{ 
	Statement statementfecha1 = connection.createStatement();
	ResultSet resultFecha1 = statementfecha1.executeQuery("SELECT date_format(fecha,'%Y-%m-%d') as fe FROM `placa` GROUP by DAY(fecha);");
		while(resultFecha1.next())
		{
			String fec="\""+resultFecha1.getString("fe")+"\"";
			%>
				<option value=<%=fec%>> <%=resultFecha1.getString("fe") %> </option>
			<%
		}
	}
	catch(Exception exc)
	{
	}
	%>
</select>

<script>
const valores1={};
const valfun1=[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0];
const valfun2=[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0];
function myFunction() {

	var y= valores1[document.getElementById("fechas1").value];


	var y2= valores1[document.getElementById("fechas2").value];
	


	for (var i=0;i<valfun1.length;i++)
	{ 
   		valfun1[i]=y[i];
		valfun2[i]=y2[i];
	}
	myChart2.update();
	console.log("actualizados");

}
</script>
</div>
	<!-- -->
<h2 id="enunciadoTablas" align="center">Comparacion</h2>
<div>
  <canvas id="myChart2" width="0.9" height="400" style="border:3px solid"></canvas>
</div>
<script id="segundo" src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script>
  const labels2 = [
    '00',    '01',    '02',    '03',
    '04',    '05',    '06',    '07',
    '08',    '09',    '10',    '11',
    '12',    '13',    '14',    '15',
    '16',    '17',    '18',    '19',
    '20',    '21',    '22',    '23',
  ];
<%
try{ 
	Statement statementvaluesday = connection.createStatement();
	ResultSet resultvaluesday = statementvaluesday.executeQuery("SELECT (date_format(fecha,'%Y-%m-%d')) as fe FROM `placa` GROUP by DAY(fecha);");
	while(resultvaluesday.next())
	{
		
		String fec = resultvaluesday.getString("fe");
		
		//Statement statementvaluesdayin = connection.createStatement();
		String consulday="call par1(\""+fec+"\");";
		CallableStatement cb = connection.prepareCall(consulday);
		StringBuilder valoresDay = new StringBuilder("[");
		ResultSet resultvaluesdayin = cb.executeQuery();
		int i=0;
		while (1==1) {
			//ResultSet resultvaluesdayin = cb.executeQuery();	
			//ResultSet resultvaluesdayin = statementvaluesdayin.executeQuery(consulday);
			
			resultvaluesdayin.next();
			if (i != 0)
	       	       	  	valoresDay.append(",");
			i++;
			valoresDay.append(resultvaluesdayin.getString("res"));
			 if (!cb.getMoreResults()) 
				break;
			  resultvaluesdayin = cb.getResultSet();
		}
		valoresDay.append("]"); 
	String[] parts = fec.split("-");
	String day = parts[2];
	if (day.charAt(0) == 48)
	{
	%>
	var si=<%=parts[0]%>+"-"+<%=parts[1]%>+"-0"+<%=day%>;
	<%
	}
	else{
	%>
		var si=<%=parts[0]%>+"-"+<%=parts[1]%>+"-"+<%=day%>;
	<%
	}
%>		valores1[si] = <%=valoresDay%>;

	<%
		
	}
}
catch(Exception exc)
{
	%> alert(<%=exc%>)<%
	System.out.print(exc);
}
%>


  <%
  try{ 
	Statement statementcomparacion=connection.createStatement();
 	String sql2 ="SELECT avg(placa.sensor1)as s1, avg(placa.sensor2) as s2, avg( placa.sensor3) as s3,  avg(placa.sensor4) as s4,  avg(placa.sensor5) as s5, fecha FROM `placa` GROUP by DAY(fecha)   ORDER by fecha desc LIMIT 4;";
	int is = 1;
	ResultSet resultSetcomparacion = statementcomparacion.executeQuery(sql2);
	resultSetcomparacion.next();
  %>

  const data2 = {
    labels: labels2,
    datasets: [{
      label: 'Hoy',
       borderWidth: 3 ,
       backgroundColor:  "rgba(136, 8, 8, 0.4)",
      borderColor: 'rgba(136, 8, 8, 1)',
      data: valfun1,
    },
    <%
    	is++;
    resultSetcomparacion.next();
    %>
     {
    	label: 'Ayer',
    	 borderWidth: 3 ,
        backgroundColor: 'rgba(8, 8, 136, 0.4)',
        borderColor: 'rgba(8, 8, 136)',
        data:valfun2,
      }
     ]
  };
  <%
  } catch (Exception e) {
  	e.printStackTrace();
  }
  %>

  const config2 = {
    type: 'line',
    data: data2,
    options: {},
  };
</script>
<script>
  const myChart2 = new Chart(
    document.getElementById('myChart2'),
    config2
  );
</script>


<!-- -->
<h2 id="enunciadoTablas" align="center"><font><strong>Datos placa solar</strong></font></h2>
<table align="center" cellpadding="5" cellspacing="5" border="1">
<tr bgcolor="#A52A2A">
<td><b>ID</b></td>
<td><b>Sensor 1</b></td>
<td><b>Sensor 2</b></td>
<td><b>Sensor 3</b></td>
<td><b>Sensor 4</b></td>
<td><b>Sensor 5</b></td>
<td><b>Fecha</b></td>
</tr>
<%
try{ 
	
	statement=connection.createStatement();
	String sql ="SELECT * FROM placa";

resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr bgcolor="#DEB887">
	<td><%=resultSet.getString("ID") %></td>
	<td><%=resultSet.getString("sensor1") %></td>
	<td><%=resultSet.getString("sensor2") %></td>
	<td><%=resultSet.getString("sensor3") %></td>
	<td><%=resultSet.getString("sensor4") %></td>
	<td><%=resultSet.getString("sensor5") %></td>
	<td><%=resultSet.getString("fecha") %></td>
</tr>

<% 
}

} catch (Exception e) {
e.printStackTrace();
}
%>
</table>
<style>

  blockquote{
    font-size: 1.4em;
    width:60%;
    margin:50px auto;
    font-family:Open Sans;
    font-style:italic;
    color: #555555;
    padding:1.2em 30px 1.2em 75px;
    border-left:8px solid #78C0A8 ;
    line-height:1.6;
    position: relative;
    background:#EDEDED;
  }
  
  blockquote::before{
    font-family:Arial;
    content: "\201C";
    color:#78C0A8;
    font-size:4em;
    position: absolute;
    left: 10px;
    top:-10px;
  }
  
  blockquote::after{
    content: '';
  }
  
  blockquote span{
    display:block;
    color:#333333;
    font-style: normal;
    font-weight: bold;
    margin-top:1em;
  }
  
  #enunciadoTablas{
  font-style:italic;
    line-height:1.6;
    padding-left:50;
    background:#EDEDED;
    }
    
    
input {
     display: flex;
     align-items: center;
     justify-content: center;
     margin: 0 auto;
   }

label {
     display: flex;
     align-items: center;
     justify-content: center;
     margin: 0 auto;
   }

select {
     margin-bottom: 10px;
     margin-top: 10px;
   }
.container {
   margin: 0 40px;
}

.edit {
    width: 120px;
    max-width: 50%;
}

.pull-right {
    float:right;
}
  </style>
