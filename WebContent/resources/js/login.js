$(document).ready(function(){
	$("#window").hide();	
	
	$(".quatro-panel>.in>input").focusin(function(){
		$(this).addClass("transparent-background");
		$(this).parent().addClass("focus-field");
	});
	
	$("#login").focusout(function(){
		$(this).parent().removeClass("focus-field");
		if($(this).val() == ""){
			$(this).removeClass("transparent-background");
			$(this).parent().addClass("invalid-field");
		}
		else{
			$(this).parent().removeClass("invalid-field");
		}
	});	
	
	$("#password").focusout(function(){
		$(this).parent().removeClass("focus-field");	
		if($(this).val() == ""){
			$(this).removeClass("transparent-background");
			$(this).parent().addClass("invalid-field");
		}
		else{
			$(this).parent().removeClass("invalid-field");
		}
	});
	
	$("#button-entrar").mousedown(function(){
		$("#button-entrar .in").addClass("button-mousedown");
	});

	$("#button-entrar").mouseup(function(){
		$("#button-entrar .in").removeClass("button-mousedown");
	});
	
	$("#button-entrar").click(function(){
		var usuario = $("#login").val();
		var senha = $("#password").val();
		
		$.post("/UNA_PA/login", {login: usuario,  password: senha}, function(data, status, xmlhttp){
			if(data != "true"){
				var msg = "Usu&aacute;rio ou senha inv&aacute;lidos!";
				$("#window").show();
				if(data == "false"){
					$("#mensagem").html(msg);
				}
				else{
					msg = data;
					$("#mensagem").html(msg);
				}
			}
			else{
				document.location.replace("/UNA_PA/principal");
			}
		});
	});
	
	$(".button-close").click(function(){
		$("#window").hide();
	});
	
	$("body").keypress(function(event){
		if(event.which == 13){
			$("#button-entrar").click();
		}
	});
});