<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="comboPais" class="input-append dropdown">
	<input type="text" id="id_Pais" name="id_Pais" data-value="-1" placeholder="Pais">
	<button class="btn dropdown-toggle" data-toggle="dropdown">
		<span class="caret"></span>
	</button>
	<ul class="dropdown-menu">
		<c:forEach items="${paises}" var="pais">
			<li>
				<a href="#" id="btn_${pais.id}" data-value="${pais.id}" 
					onclick="$('#id_Pais').data('value', $('#btn_${pais.id}').data('value'))
					$('#id_Pais').val('${pais.nome}'); return false;">
					${pais.nome}
				</a> 
			</li>
		</c:forEach>
	</ul>
</div>