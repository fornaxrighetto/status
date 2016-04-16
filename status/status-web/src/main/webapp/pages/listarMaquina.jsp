<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
</head>
<body>
	<div class="section">
		<div class="container">
			<h4 class="title-screen">Lista de Maquinas</h4>
			<div id="alertas"></div>
			<table id="tbUsuarios" class="table table-responsive">
				<thead>
					<tr>
						<td class="text-center"><span style="font-weight: bold;">#</span></td>
						<td class="text-center"><span
							style="font-weight: bold;">Nome</span></td>
						<td class="text-center hidden-xs hidden-sm"><span style="font-weight: bold;">IP</span></td>
						<td class="text-center hidden-xs hidden-sm"><span
							style="font-weight: bold;">Envia E-mail</span></td>
						<td class="text-center hidden-xs hidden-sm"><span
							style="font-weight: bold;">URL</span></td>
						<td class="text-center"><span style="font-weight: bold;">Editar</span></td>
						<td class="text-center"><span style="font-weight: bold;">Deletar</span></td>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${not empty maquinas}">
							<c:forEach items="${maquinas}" var="maquina">
								<tr>
									<td class="text-center">${maquina.id}</td>
									<td class="text-center">${maquina.nome}</td>
									<td class="text-center hidden-xs hidden-sm">${maquina.ip}</td>
									<td class="text-center hidden-xs hidden-sm">${(maquina.enviarEmail == true ?
										'Sim' : 'Não')}</td>
									<td class="text-center hidden-xs hidden-sm">${maquina.url}</td>
									<td class="text-center"><a href="editar/${maquina.id}"><span
											class="glyphicon glyphicon-pencil"></span></a></td>
											<td class="text-center"><a href="deletar/${maquina.id}"><span
											class="glyphicon glyphicon-trash"></span></a></td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="6">Não há dados a serem exibidos</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
			<a href='<c:url value="cadastro"></c:url>'
				class="btn btn-default btn-add">Nova Maquina</a>
		</div>
	</div>
</body>
</html>