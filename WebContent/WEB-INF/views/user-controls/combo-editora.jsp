<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="comboEditora" class="input-append dropdown">
	<input type="text" id="id_editora" name="id_editora" data-value="-1" placeholder="Editora" required>
	<button class="btn dropdown-toggle" data-toggle="dropdown">
		<span class="caret"></span>
	</button>
	<ul class="dropdown-menu">
		<c:forEach items="${editoras}" var="editora">
			<li>
				<a href="#" id="btn_${editora.id}" data-value="${editora.id}" 
					onclick="$('#id_editora').data('value', $('#btn_${editora.id}').data('value'))
					$('#id_editora').val('${editora.nome}'); return false;">
					${editora.nome}
				</a> 
			</li>
		</c:forEach>
	</ul>
</div>