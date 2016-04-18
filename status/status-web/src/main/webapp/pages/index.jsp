<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<head>
<meta charset=UTF-8 />
<title>Sistema Status</title>
<script type="text/javascript">
	$(document).ready(function() {

		setTimeout('location.reload();', 60000);

	});
</script>
</head>
<body style="font-size: 13px;">
	<div class="container">
		<div class="row-fluid">
			<!-- TESTE DE MEDIA INICIO -->
			
			<!-- TESTE DE MEDIA FIM -->
			<div style="float: left; margin-left: 10%">
				<img id="internet" src="/status/resources/images/internet.jpg" class="hidden-xs hidden-sm"
					alt="internet" width="80px;" height="80px;"> 
					
					<img id="internet" src="/status/resources/images/internet.jpg" class="hidden-md hidden-lg hidden-xl"
					alt="internet" width="30px;" height="30px;"> 
					
					
					<img id="barra1" class="hidden-xs hidden-sm"
					src="/status/resources/images/barra.png" alt="barra" width="300px;"
					height="5px;">
					
					<img id="barra1" class="hidden-md hidden-lg hidden-xl"
					src="/status/resources/images/barra.png" alt="barra" width="60px;"
					height="5px;">
					 <br>
				<h5>${internet.nome}</h5>
				<c:choose>
					<c:when test="${internet.status == '200'}">
						<img style="margin-left: 2%;" class="hidden-xs hidden-sm"
							src="/status/resources/images/ok.png" alt="ok" width="50px;"
							height="50px;">
							
							<img style="margin-left: 2%;" class="hidden-md hidden-lg hidden-xl"
							src="/status/resources/images/ok.png" alt="ok" width="20px;"
							height="20px;">
					</c:when>
					<c:otherwise>
						<img style="margin-left: 2%;" class="hidden-xs hidden-sm"
							src="/status/resources/images/erro.png" alt="erro" width="50px;"
							height="50px;">
							
							<img style="margin-left: 2%;" class="hidden-md hidden-lg hidden-xl"
							src="/status/resources/images/erro.png" alt="erro" width="20px;"
							height="20px;">
					</c:otherwise>
				</c:choose>
			</div>
			<div style="float: left; margin-left: 0%">
				<img id="fornax" src="/status/resources/images/fornax.jpg" class="hidden-xs hidden-sm"
					alt="fornax" width="80px;" height="80px;">
					
					<img id="fornax" src="/status/resources/images/fornax.jpg" class="hidden-md hidden-lg hidden-xl"
					alt="fornax" width="30px;" height="30px;">
					
					<img id="barra2" class="hidden-xs hidden-sm"
					src="/status/resources/images/barra.png" alt="barra" width="300px;"
					height="5px;">
					
					<img id="barra2" class="hidden-md hidden-lg hidden-xl"
					src="/status/resources/images/barra.png" alt="barra" width="60px;"
					height="5px;">
					
					 <br>
				<h5>FORNAX</h5>
				<img style="margin-left: 2%;" src="/status/resources/images/ok.png" class="hidden-xs hidden-sm"
					alt="ok" width="50px;" height="50px;">
					
					<img style="margin-left: 2%;" src="/status/resources/images/ok.png" class="hidden-md hidden-lg hidden-xl"
					alt="ok" width="20px;" height="20px;">
			</div>
			<div style="margin-left: 0%;">
				<img id="porto" src="/status/resources/images/porto.png" alt="porto" class="hidden-xs hidden-sm"
					width="80px;" height="80px;"> 
					<img id="porto" src="/status/resources/images/porto.png" alt="porto" class="hidden-md hidden-lg hidden-xl"
					width="30px;" height="30px;">
					<br>
				<h5>VPN</h5>
				<c:choose>
					<c:when test="${u28.status == '200' || nt770.status == '200'}">
						<img src="/status/resources/images/ok.png" alt="ok" width="50px;" class="hidden-xs hidden-sm"
							height="50px;">
							
							<img src="/status/resources/images/ok.png" alt="ok" width="20px;" class="hidden-md hidden-lg hidden-xl"
							height="20px;">
					</c:when>
					<c:otherwise>
						<img src="/status/resources/images/erro.png" alt="erro" class="hidden-xs hidden-sm"
							width="50px;" height="50px;">
							
							<img src="/status/resources/images/erro.png" alt="erro" class="hidden-md hidden-lg hidden-xl"
							width="20px;" height="20px;">
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		<!-- Maquinas Cadastradas no Banco - INICIO -->
		<c:forEach items="${maquinas}" var="maquina">
			<br />
			<br />
			<div class="row-fluid">
			<!-- TESTE DE MEDIA INICIO -->
			
			<!-- TESTE DE MEDIA FIM -->
			<!-- INTERNET - INICIO -->
			<div style="float: left; margin-left: 10%">
				<img id="internet" src="/status/resources/images/branco.png" class="hidden-xs hidden-sm"
					alt="internet" width="80px;" height="80px;"> 
					
					<img id="internet" src="/status/resources/images/branco.png" class="hidden-md hidden-lg hidden-xl"
					alt="internet" width="30px;" height="30px;"> 
					
					
					<img id="barra1" class="hidden-xs hidden-sm"
					src="/status/resources/images/branco.png" alt="barra" width="300px;"
					height="5px;">
					
					<img id="barra2" class="hidden-md hidden-lg hidden-xl"
					src="/status/resources/images/branco.png" alt="barra" width="60px;"
					height="5px;">
					 <br>
				<h5></h5>
				<c:choose>
					<c:when test="${internet.status == '200'}">
						<img style="margin-left: 2%;" class="hidden-xs hidden-sm"
							src="/status/resources/images/branco.png" alt="ok" width="50px;"
							height="50px;">
							
							<img style="margin-left: 2%;" class="hidden-md hidden-lg hidden-xl"
							src="/status/resources/images/branco.png" alt="ok" width="20px;"
							height="20px;">
					</c:when>
					<c:otherwise>
						<img style="margin-left: 2%;" class="hidden-xs hidden-sm"
							src="/status/resources/images/branco.png" alt="erro" width="50px;"
							height="50px;">
							
							<img style="margin-left: 2%;" class="hidden-md hidden-lg hidden-xl"
							src="/status/resources/images/branco.png" alt="erro" width="20px;"
							height="20px;">
					</c:otherwise>
				</c:choose>
			</div>
			<!-- INTERNET - FIM -->
			<!-- MAQUINA - INICIO -->
			<div style="float: left; margin-left: 0%">
				<img id="fornax" src="/status/resources/images/fornax.jpg" class="hidden-xs hidden-sm"
					alt="fornax" width="80px;" height="80px;">
					
					<img id="fornax" src="/status/resources/images/fornax.jpg" class="hidden-md hidden-lg hidden-xl"
					alt="fornax" width="30px;" height="30px;">
					
					<img id="barra3" class="hidden-xs hidden-sm"
					src="/status/resources/images/branco.png" alt="barra" width="300px;"
					height="5px;">
					
					<img id="barra4" class="hidden-md hidden-lg hidden-xl"
					src="/status/resources/images/branco.png" alt="barra" width="60px;"
					height="5px;">
					
					 <br>
				<h5>${maquina.nome}</h5>
				<c:choose>
				<c:when test="${u28.status == '200' && maquina.status == '200'}">
				<img style="margin-left: 2%;" src="/status/resources/images/ok.png" class="hidden-xs hidden-sm"
					alt="ok" width="50px;" height="50px;">
					
					<img style="margin-left: 2%;" src="/status/resources/images/ok.png" class="hidden-md hidden-lg hidden-xl"
					alt="ok" width="20px;" height="20px;">
					</c:when>
					<c:otherwise>
					<img src="/status/resources/images/erro.png" alt="erro" class="hidden-xs hidden-sm"
							width="50px;" height="50px;">
							
							<img src="/status/resources/images/erro.png" alt="erro" class="hidden-md hidden-lg hidden-xl"
							width="20px;" height="20px;">
					</c:otherwise>
				</c:choose>
			</div>
			<!-- MAQUINA - FIM -->
			<!-- VPN - INICIO -->
			<div style="margin-left: 0%;">
				<img id="porto" src="/status/resources/images/branco.png" alt="porto" class="hidden-xs hidden-sm"
					width="80px;" height="80px;"> 
					<img id="porto" src="/status/resources/images/branco.png" alt="porto" class="hidden-md hidden-lg hidden-xl"
					width="30px;" height="30px;">
					<br>
				<h5></h5>
				<c:choose>
					<c:when test="${u28.status == '200' && maquina.status == '200'}">
						<img src="/status/resources/images/branco.png" alt="ok" width="50px;" class="hidden-xs hidden-sm"
							height="50px;">
							
							<img src="/status/resources/images/branco.png" alt="ok" width="20px;" class="hidden-md hidden-lg hidden-xl"
							height="20px;">
					</c:when>
					<c:otherwise>
						<img src="/status/resources/images/branco.png" alt="erro" class="hidden-xs hidden-sm"
							width="50px;" height="50px;">
							
							<img src="/status/resources/images/branco.png" alt="erro" class="hidden-md hidden-lg hidden-xl"
							width="20px;" height="20px;">
					</c:otherwise>
				</c:choose>
			</div>
			<!-- VPN - FIM -->
		</div>
		</c:forEach>
		<!-- Maquinas Cadastradas no Banco - FIM -->
	</div>
</body>
</html>