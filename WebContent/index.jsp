<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:paginabasica title="EASY RENT">
<jsp:body>
<!--  <aside> -->
	<div id="sidebar-wrapper">
		<ul>
		<li class="sidbar-header">
			<form action="${pageContext.request.contextPath}/logout.html" method="get">
				<button type="submit" class="btn btn-primary ">
					<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
					BUSCAR
				</button>
			</form>
		</li>
		<li><a href="credencial/list.html">Gestion de credenciales</a></li>
		<li><a href="direccion/list.html">Gestion de direcciones</a></li>
		<li><a href="factura/list.html">Gestion de facturas</a></li>
		<li><a href="imagen/list.html">Gestion de imagenes</a></li>
		<li><a href="periodo/list.html">Gestion de periodos</a></li>
		<li><a href="propiedad/list.html">Gestion de propiedades</a></li>
		<li><a href="puntuacion/list.html">Gestion de puntuaciones</a></li>
		<li><a href="respuestaPuntuacion/list.html">Gestion de respuestas de puntuacion</a></li>
		<li><a href="reserva/list.html">Gestion de reservas</a></li>
		<li><a href="usuario/list.html">Gestion de usuarios</a></li>
		<li><a href="servicio/list.html">Gestion de servicios</a></li>
		<li><a href="propiedadServicio/list.html">Gestion de propiedad servicios</a></li>
		</ul>
	</div>
	<!--  </aside> -->
</jsp:body>
</t:paginabasica>