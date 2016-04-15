<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Sistema status</title>

<!-- Bootstrap Core CSS -->
<link href="/status/resources/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="/status/resources/css/shop-item.css" rel="stylesheet">

<!-- jQuery Version 1.11.0 -->
<script src="/status/resources/js/jquery-1.11.0.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="/status/resources/js/bootstrap.min.js"></script>

<script type="text/javascript">
function Pesquisa(){
	location.href+= "pesquisarMaquina/" + $("#pesquisarMaquina").val();
}
</script>
</head>
<body>
	<!-- Navigation -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header" style="margin-left: 44%;">
				<a class="navbar-brand" href="/status"
					style="color: #FFFFFF; font-family: verdana; font-size: 20px;">Sistema
					Status</a>
			</div>
		</div>

		<!-- /.container -->
	</nav>
		<div class="navbar-form navbar-center" role="search" style="margin-left: 30%;">
			<div class="form-group">
			<a href='<c:url value="/listar"></c:url>'
			<button type="button" href class="btn btn-default" style="background-color: #333; color: #fff; border-color: #333">Listar Maquinas</button></a>
				<input type="text" id="pesquisarMaquina" class="form-control" placeholder="Pesquisar Maquina">
			</div>
			<button type="button" onclick="" class="btn btn-default">Pesquisar</button>
		</div>
		
