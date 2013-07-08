<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<form id="formObra" class="form-horizontal">
	<div class="control-group">
		<label class="control-label" for="titulo">Título:</label>
		<div class="controls">
			<input id="titulo" name="titulo" type="text" class="input-xlarge" placeholder="Título" required>
		</div>
	</div>
	<div class="control-group">
		<label for="isbn" class="control-label">ISBN:</label>
		<div class="controls">
			<input id="isbn" name="isbn" type="text" placeholder="ISBN" required>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="ano">Lançamento:</label>
		<div class="controls">
			<input id="lancamento" name="lancamento" type="text" placeholder="Lançamento">
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="pagina">Páginas:</label>
		<div class="controls">
			<input id="pagina" name="pagina" type="text" placeholder="Páginas">
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="editora">Editora:</label>
		<div class="controls">
			<jsp:include page="/WEB-INF/views/user-controls/combo-editora.jsp" flush="true"/>
		</div>
	</div>			
	<div class="control-group">			
		<label class="control-label" for="pais">Pais:</label>
		<div class="controls">
			<jsp:include page="/WEB-INF/views/user-controls/combo-pais.jsp" flush="true"/>
		</div>
	</div>
</form>