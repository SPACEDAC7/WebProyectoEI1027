<%@page contentType="text/html; charset=iso-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:paginabasica title="Gestiones">
<jsp:body>
	<div>
		<ul>
		<li><a href="${pageContext.request.contextPath}/credencial/list.html">Gestion de credenciales</a></li>
		<li><a href="${pageContext.request.contextPath}/direccion/list.html">Gestion de direcciones</a></li>
		<li><a href="${pageContext.request.contextPath}/factura/list.html">Gestion de facturas</a></li>
		<li><a href="${pageContext.request.contextPath}/imagen/list.html">Gestion de imagenes</a></li>
		<li><a href="${pageContext.request.contextPath}/periodo/list.html">Gestion de periodos</a></li>
		<li><a href="${pageContext.request.contextPath}/propiedad/list.html">Gestion de propiedades</a></li>
		<li><a href="${pageContext.request.contextPath}/puntuacion/list.html">Gestion de puntuaciones</a></li>
		<li><a href="${pageContext.request.contextPath}/respuestaPuntuacion/list.html">Gestion de respuestas de puntuacion</a></li>
		<li><a href="${pageContext.request.contextPath}/reserva/list.html">Gestion de reservas</a></li>
		<li><a href="${pageContext.request.contextPath}/usuario/list.html">Gestion de usuarios</a></li>
		<li><a href="${pageContext.request.contextPath}/servicio/list.html">Gestion de servicios</a></li>
		<li><a href="${pageContext.request.contextPath}/propiedadServicio/list.html">Gestion de propiedad servicios</a></li>
		<li><a href="${pageContext.request.contextPath}/mensaje/list.html">Gestion de mensajes</a></li>
		</ul>
	</div>
</jsp:body>
</t:paginabasica>