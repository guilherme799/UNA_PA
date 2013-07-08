<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Biblioteca virtual 1.0</title>
	<script type="text/javascript" src="/UNA_PA/resources/js/jquery-1.9.1.js"></script>
	<script type="text/javascript" src="/UNA_PA/resources/js/jquery-ui-1.10.2.custom.js"></script>
	<script type="text/javascript" src="/UNA_PA/resources/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript" src="/UNA_PA/resources/js/principal.js"></script>
		<script type="text/javascript" src="/UNA_PA/resources/js/beans.js"></script>
	<link rel="stylesheet" href="/UNA_PA/resources/css/principal.css" type="text/css" />		
	<link rel="stylesheet" href="/UNA_PA/resources/bootstrap/css/bootstrap.css" type="text/css" />
	<link rel="stylesheet" href="/UNA_PA/resources/bootstrap/css/bootstrap-responsive.css" type="text/css" />		
</head>
<body style="padding-top: 50px;">
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<ul class="nav" style="margin: 0px;">
					<li class="dropdown">
		                <button class="btn btn-large btn-inverse dropdown-toggle" data-toggle="dropdown">
		                	<i class="icon-book icon-white"></i>
		                	<span>Obras</span> 
			                <span class="caret"></span>
		                </button>
		                <ul id="menu_obras" class="dropdown-menu pull-right">
		                  <li><a href="#myModal" data-toggle="modal" id="btnCadastrarObra">Cadastrar Obra</a></li>
		                </ul>
	            	</li>
					<li class="dropdown">
		                <button class="btn btn-large btn-inverse dropdown-toggle" data-toggle="dropdown">
		                	<i class="icon-user icon-white"></i>
		                	<span>Usuários</span>
			                <span class="caret"></span>
		                </button>
		                <ul id="menu_usuarios" class="dropdown-menu">
		                  <li><a href="#">Action</a></li>
		                  <li><a href="#">Another action</a></li>
		                  <li><a href="#">Something else here</a></li>
		                  <li class="divider"></li>
		                  <li><a href="#">Separated link</a></li>
		                </ul>
	            	</li>	            	
            	</ul>
			</div>
		</div>
	</div>
	<header class="subhead">
		<div class="container">
			<h1>Biblioteca virtual 1.0</h1>
		</div>
	</header>
	<div class="container">
		<div class="row">
			<div class="offset1 span10"></div>
		</div>
	</div>
	<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelladby="myModallabel" aria-hidden="true">
		<div class="modal-header">
			<button class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			<h3 id="myModalLabel"></h3>
			<div id="alerta"></div>
		</div>
		<div class="modal-body"></div>
		<div class="modal-footer">
			<button class="btn btn-danger" data-dismiss="modal" aria-hidden="true">Cancelar</button>
			<button id="modalBtnLimpar" class="btn">Limpar</button>
			<button id="modalBtnSalvar" class="btn btn-success">Salvar</button>
		</div>	
	</div>
</body>
</html>