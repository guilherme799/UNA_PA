$(document).ready(function(){
	$("#btnCadastrarObra").click(function(){
		$.get("/UNA_PA/cadastrarobra", function(data, status){
			$("#myModalLabel").html("Nova obra");
			$(".modal-body").html(data);
			$("#modalBtnSalvar, #modalBtnLimpar").data("registro", "obra");
		});
	});
	
	$("#modalBtnSalvar").click(function(){
		var form;
		
		switch ($(this).data("registro")) {
			case "obra":
				form = $("#formObra");
				cadastrarObra(form);
				break;

			case "usuario":
				break;
			
			default:
				break;
		}
	});
	
	$("#modalBtnLimpar").click(function(){
		var form;
		
		switch ($(this).data("registro")) {
			case "obra":
				form = $("#formObra");
				limparFormObra(form);
				break;

			case "usuario":
				break;
			
			default:
				break;
		}
	});
	
	function cadastrarObra(form){
		try{
			var obra = new Obra();
			obra.id_editora = form.find("[id='id_editora']").data("value");
			obra.id_pais = form.find("[id='id_Pais']").data("value");
			obra.isbn = form.find("[id='isbn']").val();
			obra.lancamento = form.find("[id='lancamento']").val();
			obra.pagina = form.find("[id='pagina']").val();
			obra.titulo = form.find("[id='titulo']").val();
			
			$.post("/UNA_PA/cadastrarobra", obra, function(data, status){
				limparFormObra(form);
				$("#alerta").html(data);
			});
		}
		catch(ex){
			console.error(ex);
		}
	}
	
	function limparFormObra(form){
		form.find("[id='id_editora']").data("value", "-1");
		form.find("[id='id_Pais']").data("value", "-1");
		form.find("[id='id_editora']").val("");
		form.find("[id='id_Pais']").val("");
		form.find("[id='isbn']").val("");
		form.find("[id='lancamento']").val("");
		form.find("[id='pagina']").val("");
		form.find("[id='titulo']").val("");
	}
});