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
	function Pesquisa() {
		location.href = '<c:url value="/"></c:url>' + "pesquisarMaquina/"
				+ $("#pesquisarMaquina").val();
	}
</script>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" style="color: #FFFFFF;" href='<c:url value="/"></c:url>'>Sistema
					Status</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a style="font-size: 18px; color: #FFFFFF;" href='<c:url value="/listar"></c:url>'>Listar Maquinas <span class="sr-only">(current)</span></a></li>
				</ul>
			
			<form class="navbar-form navbar-left" role="search">
				<div class="form-group">
					<input type="text" id="pesquisarMaquina" class="form-control"
						placeholder="Digite a maquina ...">
				</div>
				<button type="button" onclick="Pesquisa();" class="btn btn-default">Pesquisar</button>
			</form>
			</div>
		</div>
		<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>