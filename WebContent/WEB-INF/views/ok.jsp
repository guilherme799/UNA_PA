<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
	<script type="text/javascript" src="/UNA_PA/resources/js/jquery-1.9.1.js"></script>
	<script type="text/javascript" src="/UNA_PA/resources/js/jquery-ui-1.10.2.custom.js"></script>
	<script type="text/javascript" src="/UNA_PA/resources/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript" src="/UNA_PA/resources/js/beans.js"></script>
	<link rel="stylesheet" href="/UNA_PA/resources/bootstrap/css/bootstrap.css" type="text/css" />
	<link rel="stylesheet" href="/UNA_PA/resources/bootstrap/css/bootstrap-responsive.css" type="text/css" />	
		<script type="text/javascript">
		/*$(document).ready(function(){
				$("#file").fileupload({
					dataType: "text",
					done: function(e, data){
						$("<li>").html("Arquivo: " + data.result + " salvo com sucesso!").appendTo("#arquivos");
					}
				});
				
				$.post("/UNA_PA/teste",(new Pais()), function(data, status){
					debugger;
					document.write(data);
				});
			});*/
			
			var file_OnChange = function(sender, e){
				var xmlhttp = new XMLHttpRequest();
				var file = new FormData();
				file.append('file', sender.files[0]);
				
				xmlhttp.open("POST", sender.dataset.url, true);
				xmlhttp.onreadystatechange = function(){
					if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
						document.getElementById("resposta").innerHTML = xmlhttp.responseText;
					}
				};
				xmlhttp.send(file);
			};
		</script>
		<style type="text/css">
			*{
				margin: 0px;
				padding: 0px;
				text-align: left;
				vertical-align: baseline;
				list-style: none;
				outline: none;				
			}
			
			body{
				margin-top: 80px;
			}
			
			.in-fileupload{
				margin-right: auto;
				background-color: #ADFF85;
				border-radius: 10px;
				width: 90px;
				height: 30px;
				border:2px outset;
				overflow: hidden;
				-webkit-box-pack: center;				
			}			
			
			.in-fileupload input{
				display: inline;
				cursor: pointer;
				direction: ltr;
				opacity: 0;
				margin-left: -197px;
				margin-top: -32px;
				height: 30px;
			}
			
			.in-fileupload span{
				color: white;
				font-weight: bold;
				font-size: 28px;
			}
		</style>
	</head>
	<body>
		<!--<form method="post" id="form1" enctype="multipart/form-data">
		<div class="in-fileupload">-->
			<input type="file" id="file" name="file" data-url="/UNA_PA/ok"
			onchange="file_OnChange(this, event);" formenctype="multipart/form-data" accept="image/*"></input>
		<!--</div>
		<ol id="arquivos"></ol>
		</form>-->
		<div id="resposta"></div>
	</body>
</html>