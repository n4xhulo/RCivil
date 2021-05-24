<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<jsp:include page="../templates/header.jsp"></jsp:include>
	
	

	<main class="container mt-6">
	
		<c:if test="${mensaje != null }">
			<div class="columns is-centered mb-6">
				<div class="column is-6">
					<div class="notification is-info">
						<p>${mensaje}</p>
					</div>
				</div>
			</div>
		</c:if>
		
		<c:if test="${errores != null}">
			<div class="columns is-centered is-info">
				<div class="column is-6">
					<div class="notification is-info has-background-warning">
						<h1 class="has-text-black">ERROR</h1>
						<ul>
							<c:forEach var="error" items="${errores}">
								<li class="has-text-black">${error}</li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
		</c:if>
	
		<div class="columns is-centered">
			<div class="column is-6">
				<form method="POST" action="AgregarClienteController.do">
					<div class="card">
						<div class="card-header has-background-info">
							<span class="card-header-title has-text-white">Agregar Cliente</span>
						</div>
						<div class="card-content">
						
							<div class="field">
							  <label class="label">Nombre y Apellido</label>
							  <div class="control">
							    <input class="input" type="text" id="nombre-txt" name="nombre-txt">
							  </div>
							</div>
							
							<div class="field">
							  <label class="label">Rut</label>
							  <div class="control">
							    <input class="input" type="text" id="rut-txt" name="rut-txt">
							  </div>
							</div>
							
							<div class="field">
								<label class="label" for="atencion-select">Tipo de Atencion</label>
								<div class="control">
									<div class="select">
										<select name="atencion-select" id="atencion-select">
											<option id="one">Solicitud de Cedula de Identidad</option>
											<option id="two">Retiro de Cedula de Identidad</option>
											<option id="tre">Solicitud de Certificado de Nacimiento</option>
											<option id="f4r">Solicitud de Certificado de Defucion</option>
											
										</select>
									</div>
								</div>
							</div>
							
							<c:if test="atencion_select == two">
								<div class="field is-right">
							 	 <label class="label">Numero de atencion</label>
							  		<div class="control">
							    		<input class="input" type="text" id="at_num" name="at_num">
							  		</div>
								</div>
							</c:if>
							
							<div class="card-footer has-background-info">
								<div class="card-footer-item">
									<button type="submit" class="button is-white" id="btn_registrar">Registrar Cliente</button>
								</div>
							</div>
							
						</div>
						<div class="card-footer">
						</div>
					</div>
				</form>
			</div>
		</div>
		
	</main>

</body>
</html>