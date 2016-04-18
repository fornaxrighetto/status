<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<head>
<meta charset=UTF-8 />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Ping - Porto Seguro</title>
<script type="text/javascript">
	$(function() {
		//pegaMaquina();
	});

	function pegaMaquina() {
		// 		var url = location.href;
		// 		var maquina = url.split("/")[5];
		// 		var url2 = "http://172.26.162.15/cgi-bin/ping.pl?maquina=" + maquina;
		// 		$("#maquina_porto").attr("src", url2);

	}
</script>
</head>
<body>
	<div class="section">
		<div class="container">
			<div style="float: left; margin-left: 30%">
				<h4 class="title-screen">Pingando maquina: ${maquina}</h4>
				<br /><br />
				<iframe frameborder="0" id="maquina_porto" name="maquina_porto" align="center"
					marginheight="0px" marginwidth="0px" width="400px" height="400px"
					src="http://172.26.162.15/cgi-bin/ping.pl?maquina=${maquina}"></iframe>
			</div>
		</div>
	</div>
</body>
</html>