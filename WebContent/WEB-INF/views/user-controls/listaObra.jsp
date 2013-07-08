<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<style>
label.obra {
	color: #E6B800;
	font-style: italic;
	font-weight: bold;
}

div.botton {
	border-bottom-style: dotted;
	border-bottom-color: #E6B800;
}

.botton p {
	margin: 5px;
}
</style>

<ul class="obra">
	<c:forEach items="${obras}" var="obra">
		<li>
			<div id="obra_${obra.id}" class="botton">
				<h1>${obra.titulo}</h1>
				<p><label class="obra">Autor: </label>${obra.autor}</p>
				<p><label class="obra">Paginas: </label>${obra.paginas}</p>
				<p><label class="obra">Idioma: </label>${obra.idioma}</p>
				<p><label class="obra">ISBN: </label>${obra.isbn}</p>
				<p><label class="obra">Sinopse: </label>${obra.sinopse}</p>
			</div>
		</li>
	</c:forEach>
</ul>