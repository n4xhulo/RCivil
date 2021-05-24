<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<jsp:include page="../templates/header.jsp"></jsp:include>
	
	<main class="container mt-6">
		<div class="card is-primary is-centered">
			<div class="card-header has-background-primary">
				<div class="card-header-title is-centered">Formulario de Atencion al Cliente</div>
			</div>	
			<div class="card-content has-background">
				<div class="columns is-centered">
					<div class="column is-11">
						<p class="is-size-5">Filtrar por Tipo de Atencion</p>
						<table class="table is-hovered is-bordered">
							<thead class="has-background-light">
								<tr>
									<th><div class="select">
										<select>
											<option></option>
											<option>Solicitud de Cedula de Identidad</option>
											<option>Retiro de Cedula de Identidad</option>
											<option>Solicitud de Certificado de Nacimiento</option>
											<option>Solicitud de Certificado de Defucion</option>
										</select>
									</div></th>
									<th>
									<button class="button has-background-dark has-text-white">Filtrar</button>
									</th>
								</tr>
							</thead>
						</table>
					</div>		
				</div>
				
				<div class="columns is-centered">	
					<div class="column is-5">
						<table class="table is-hovered is-bordered is-fullwidth">
							<thead class="has-background-primary">
								<tr>
									<th>Num Atencion</th>
									<th>Nombre Cliente</th>
									<th>Tipo Solicitud</th>
									<th>Atender</th>
								</tr>
							</thead>
							<tbody class="has-background-light">
								<c:forEach var="cliente" items="${clientes}">
									<tr>
										<td>${cliente.numSolicitud}</td>
										<td>${cliente.nombre}</td>
										<td>${cliente.tipoSolicitud}</td>
										<td><a href="MostrarClienteController.do?nombreEliminar=${cliente.nombre}" class="has-text-danger">Atender</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>	
		
		</div>
	</main>

</body>
</html>