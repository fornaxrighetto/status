<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<head>
<meta charset=UTF-8 />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrar Maquina</title>
<script type="text/javascript">
	function validarMaquina() {
		var nome = $("#nome").val();
		var ip = $("#ip").val();
		$
				.post(
						"/status/consultarMaquina?nome=" + nome + "&ip=" + ip,
						function(existe) {
							if (existe) {
								$("#alertadocdiv").remove();
								var alerta = "<div id='alertadocdiv' class='alert alert-warning'>"
										+ "<span style='color: #000000'><strong>Alerta!</strong>"
										+ "A Maquina informada já está cadastrada no sistema.</span></div>";
								$("#alertas").append(alerta);
								$("#usuario").val("").focus();
							} else {
								$("#alertadocdiv").remove();
							}
						});
	}
</script>
</head>
<body>
	<div class="section">
		<div class="container">
			<h4 class="title-screen">Editar Maquina</h4>
			<hr />
			<div id="alertas"></div>
			<form action='<c:url value="/editarMaquina"></c:url>' method="POST" role="form">
				<input type="hidden" name="id" value="${maquinas.id}">
				<div class="row">
					<div class="form-group col-md-offset-2 col-md-4">
						<label for="nome">Nome da Maquina:</label> <input type="text"
							class="form-control" id="nome" name="nome"
							placeholder="Digite o nome" value="${maquinas.nome}" required
							autofocus>
					</div>
					<div class="form-group col-md-4">
						<label for="ip">IP da Maquina:</label> <input type="text"
							class="form-control" id="ip" name="ip" placeholder="Digite o IP"
							value="${maquinas.ip}" required autofocus>
					</div>
					<div class="form-group col-md-offset-2 col-md-4">
						<label for="url">URL:</label> <input type="text"
							class="form-control" id="url" name="url"
							placeholder="Digite a URL" value="${maquinas.url}" required
							autofocus>
					</div>
					<div style="clear: both;"
						class="form-group col-md-offset-2 col-md-4">
						<div class="radio">
							<label>Enviar e-mail de Status?</label>
							<c:choose>
								<c:when test="${maquinas.enviarEmail == true}">
									<label><input type="radio" name="enviarEmail"
										value="true" checked="checked" required>Sim</label>
									<label><input type="radio" name="enviarEmail"
										value="false" required>Não</label>
								</c:when>
								<c:otherwise>
								<label><input type="radio" name="enviarEmail"
									value="true" required>Sim</label>
								<label><input type="radio" name="enviarEmail"
									value="false" checked="checked" required>Não</label>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>
				<hr />
				<div class="form-group col-xs-offset-0">
					<a href='<c:url value="/" />'
						style="float: left; background-color: #333; color: #fff; border-color: #333"
						class="btn btn-default">Cancelar</a>
					<button type="submit"
						style="float: right; background-color: #333; color: #fff; border-color: #333"
						class="btn btn-default">Salvar Maquina</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>