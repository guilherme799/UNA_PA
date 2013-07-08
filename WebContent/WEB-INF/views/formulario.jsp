<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="grid_12 obra-conteudo">
	<h1 style="text-align: center;">Obras</h1>
	<div class="obra-textfield">
		<label for="paginas">Páginas:</label> 
		<input type="text" name="paginas" id="paginas"/>
	</div>
	<div class="obra-textfield">
		<label for="lancamento">lançamento:</label>
		<input type="text" name="lancamento" id="lancamento"/>
	</div>
	<div class="obra-textfield">
		<label for="autor">Autor:</label>
		<input type="text" name="autor" id="autor"/>
	</div>
	<div class="obra-textfield">
		<label for="assunto">Assunto:</label> 
		<input type="text" name="assunto" id="assunto"/>
	</div>
	<div class="obra-textfield">
		<label for="isbn">ISBN:</label> 
		<input type="text" name="isbn" id="isbn"/>
	</div>
	<div class="obra-textfield">
		<label for="titulo" >Título:</label> 
		<input type="text" name="titulo" id="titulo"/>
	</div>
	<div class="obra-textfield">
		<input type="button" value="Pesquisar" id="Pesquisar" name="Pesquisar" />
	</div>
</div>