<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro Civil</title>
<link rel="stylesheet" href="vendor/bulma/css/bulma.min.css">
</head>
<body>

<header>

<nav class="navbar has-background-primary pt-6 pb-3" role="navigation" aria-label="main navigation">
	
  <div class="navbar-brand r-3 ml-5 mr-5">
    <a class="navbar-item is-full" href="index.jsp">
      <img class="is-full" src="img/bigi.jpg" ></a>
  </div>

  <div id="navbarBasicExample" class="navbar-menu">
    <div class="navbar-start">
      
      	
      	  <div class="navbar-item has-dropdown is-hoverable has-background-light">
        	<a class="navbar-link">Opciones</a>

		        <div class="navbar-dropdown">
		        	<a class="navbar-item" href="AgregarClienteController.do"> Ingresar Solicitud</a>
      				<a class="navbar-item" href="MostrarClienteController.do"> Atender Solicitud</a>
		        </div>
      </div>
    
      	
  	</div>
  </div>
</nav>

</header>