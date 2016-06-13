<%@page contentType="text/html; charset=iso-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:paginabasica title="Gestiones">
<jsp:body>
	<div>
		<ul class="list-unstyled buttons">
		<li><a class="w8-icon l-blue" href="${pageContext.request.contextPath}/credencial/list.html">
				<img src="${pageContext.request.contextPath}/img/carpeta-azul.png"
						alt="logo_de_credenciales">Credenciales</a></li>
						
		<li><a class="w8-icon l-blue" href="${pageContext.request.contextPath}/direccion/list.html">
				<img style="display:block;margin:0 auto;" src="${pageContext.request.contextPath}/img/carpeta-azul.png"
						alt="logo_de_credenciales">Direcciones</a></li>
						
		<li><a class="w8-icon l-blue" href="${pageContext.request.contextPath}/factura/list.html">
				<img style="display:block;margin:0 auto;" src="${pageContext.request.contextPath}/img/carpeta-azul.png"
						alt="logo_de_credenciales">Facturas</a></li>
						
		<li><a class="w8-icon l-blue" href="${pageContext.request.contextPath}/imagen/list.html">
				<img style="display:block;margin:0 auto;" src="${pageContext.request.contextPath}/img/carpeta-azul.png"
						alt="logo_de_credenciales">Imagenes</a></li>
						
		<li><a class="w8-icon l-blue" href="${pageContext.request.contextPath}/periodo/list.html">
				<img style="display:block;margin:0 auto;" src="${pageContext.request.contextPath}/img/carpeta-azul.png"
						alt="logo_de_credenciales">Periodos</a></li>
						
		<li><a class="w8-icon l-blue" href="${pageContext.request.contextPath}/propiedad/list.html">
				<img style="display:block;margin:0 auto;" src="${pageContext.request.contextPath}/img/carpeta-azul.png"
						alt="logo_de_credenciales">Propiedades</a></li>
						
		<li><a class="w8-icon l-blue" href="${pageContext.request.contextPath}/puntuacion/list.html">
				<img style="display:block;margin:0 auto;" src="${pageContext.request.contextPath}/img/carpeta-azul.png"
						alt="logo_de_credenciales">Puntuaciones</a></li>
						
		<li><a class="w8-icon l-blue" href="${pageContext.request.contextPath}/respuestaPuntuacion/list.html">
				<img style="display:block;margin:0 auto;" src="${pageContext.request.contextPath}/img/carpeta-azul.png"
						alt="logo_de_credenciales">Respuestas de puntuacion</a></li>
						
		<li><a class="w8-icon l-blue" href="${pageContext.request.contextPath}/reserva/list.html">
				<img style="display:block;margin:0 auto;" src="${pageContext.request.contextPath}/img/carpeta-azul.png"
						alt="logo_de_credenciales">Reservas</a></li>
						
		<li><a class="w8-icon l-blue" href="${pageContext.request.contextPath}/usuario/list.html">
				<img style="display:block;margin:0 auto;" src="${pageContext.request.contextPath}/img/carpeta-azul.png"
						alt="logo_de_credenciales">Usuarios</a></li>
						
		<li><a class="w8-icon l-blue" href="${pageContext.request.contextPath}/servicio/list.html">
				<img style="display:block;margin:0 auto;" src="${pageContext.request.contextPath}/img/carpeta-azul.png"
						alt="logo_de_credenciales">Servicios</a></li>
						
		<li><a class="w8-icon l-blue" href="${pageContext.request.contextPath}/propiedadServicio/list.html">
				<img style="display:block;margin:0 auto;" src="${pageContext.request.contextPath}/img/carpeta-azul.png"
						alt="logo_de_credenciales">Propiedad servicios</a></li>
						
		<li><a class="w8-icon l-blue" href="${pageContext.request.contextPath}/mensaje/list.html">
				<img style="display:block;margin:0 auto;" src="${pageContext.request.contextPath}/img/carpeta-azul.png"
						alt="logo_de_credenciales">Mensajes</a></li>
		</ul>
	</div>
</jsp:body>
</t:paginabasica>