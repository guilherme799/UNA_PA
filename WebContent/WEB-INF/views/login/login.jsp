<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Autenticação</title>
	<script type="text/javascript" src="/UNA_PA/resources/js/jquery-1.9.1.js"></script>
	<script type="text/javascript" src="/UNA_PA/resources/js/jquery-ui-1.10.2.custom.js"></script>
	<script type="text/javascript" src="/UNA_PA/resources/js/login.js"></script>
	<link rel="stylesheet" href="/UNA_PA/resources/css/login.css" type="text/css" />
</head>
	<body class="radial-gradient-background">
		<div id="principal" class="grid">
			<div class="inline-panel">
			</div>
			<div class="quatro-panel lateral-right">
				<div class="in">
					<input type="text" id="login" name="login" class="text_1" placeholder="login"/>
				</div>
			</div>
			<div class="um-panel lateral-left">
				<div class="in linear-gradient-background">
					<img src="resources/images/user.png"/>
				</div>
			</div>
			<div class="quatro-panel lateral-right">
				<div class="in">
					<input type="password" id="password" name="password" class="text_2" placeholder="senha"/>
				</div>
			</div>
			<div class="um-panel lateral-left">
				<div class="in linear-gradient-background">
					<img src="resources/images/lock.png"/>
				</div>				
			</div>
			<div id="button-entrar" class="in-button float-right">
				<div class="dois-panel lateral-right">
					<div class="in" style="background-color: #85FF5C; border-color: #85FF5C;">
						<p class="conteudo">entrar</p>
					</div>
				</div>
				<div class="um-panel lateral-left">
					<div class="in" style="background-color: #85FF5C; border-color: #85FF5C;">
						<img class="conteudo" src="resources/images/arrow_right.png"></img>
					</div>
				</div>
			</div>		
		</div>
		<div id="window" class="grid">
			<div class="tres-panel float-right">
				<b>Mensagem</b>
				<img src="resources/images/close.png" class="button-close" />
			</div>
			<div class="tres-panel" id="mensagem">
			</div>
		</div>
	</body>
</html>