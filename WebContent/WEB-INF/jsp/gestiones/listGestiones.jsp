<%@page contentType="text/html; charset=iso-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:paginabasica title="Gestiones">
<jsp:body>
	  <!-- INICIO PAGE CONTAINER-->
	  <div class="page-content"> 
		<div class="content">
			<div class="row">
				<div class="col-md-3 single-colored-widget">
					<a href="${pageContext.request.contextPath}/credencial/list.html"><div class="content-wrapper green">
						<h4 class="text-white center-text"><img class="mini-logo" src="${pageContext.request.contextPath}/img/icon/credenciales.png" width="100"" height="100"" alt=""><br><span class="semi-bold">Credenciales</span></h4>
						<div class="clearfix"></div>
					</div>
					<div class="heading">
						<div class="pull-left">
							<p>Esto es una corta descripción de lo que se puede hacer aquí</p>
						</div>
						<div class="clearfix"> </div>
					</div></a>
				</div>
				<div class="col-md-3 single-colored-widget">
					<a href="${pageContext.request.contextPath}/direccion/list.html"><div class="content-wrapper green">
						<h4 class="text-white center-text"><img class="mini-logo" src="${pageContext.request.contextPath}/img/icon/direcciones.png" width="100"" height="100"" alt=""><br><span class="semi-bold">Direcciones</span></h4>
						<div class="clearfix"></div>
					</div>
					<div class="heading">
						<div class="pull-left">
							<p>Esto es una corta descripción de lo que se puede hacer aquí</p>
						</div>
						<div class="clearfix"> </div>
					</div></a>
				</div>
				<div class="col-md-3 single-colored-widget">
					<a href="${pageContext.request.contextPath}/factura/list.html"><div class="content-wrapper green">
						<h4 class="text-white center-text"><img class="mini-logo" src="${pageContext.request.contextPath}/img/icon/facturas.png" width="100"" height="100"" alt=""><br><span class="semi-bold">Facturas</span></h4>
						<div class="clearfix"></div>
					</div>
					<div class="heading">
						<div class="pull-left">
							<p>Esto es una corta descripción de lo que se puede hacer aquí</p>
						</div>
						<div class="clearfix"> </div>
					</div></a>
				</div>
				<div class="col-md-3 single-colored-widget">
					<a href="${pageContext.request.contextPath}/imagen/list.html"><div class="content-wrapper green">
						<h4 class="text-white center-text"><img class="mini-logo" src="${pageContext.request.contextPath}/img/icon/imagenes.png" width="100"" height="100"" alt=""><br><span class="semi-bold">Imágenes</span></h4>
						<div class="clearfix"></div>
					</div>
					<div class="heading">
						<div class="pull-left">
							<p>Esto es una corta descripción de lo que se puede hacer aquí</p>
						</div>
						<div class="clearfix"> </div>
					</div></a>
				</div>
			</div><br>
			<div class="row">
				<div class="col-md-3 single-colored-widget">
					<a href="${pageContext.request.contextPath}/periodo/list.html"><div class="content-wrapper green">
						<h4 class="text-white center-text"><img class="mini-logo" src="${pageContext.request.contextPath}/img/icon/periodos.png" width="100"" height="100"" alt=""><br><span class="semi-bold">Periodos</span></h4>
						<div class="clearfix"></div>
					</div>
					<div class="heading">
						<div class="pull-left">
							<p>Esto es una corta descripción de lo que se puede hacer aquí</p>
						</div>
						<div class="clearfix"> </div>
					</div></a>
				</div>
				<div class="col-md-3 single-colored-widget">
					<a href="${pageContext.request.contextPath}/propiedad/list.html"><div class="content-wrapper green">
						<h4 class="text-white center-text"><img class="mini-logo" src="${pageContext.request.contextPath}/img/icon/propiedades.png" width="100"" height="100"" alt=""><br><span class="semi-bold">Propiedades</span></h4>
						<div class="clearfix"></div>
					</div>
					<div class="heading">
						<div class="pull-left">
							<p>Esto es una corta descripción de lo que se puede hacer aquí</p>
						</div>
						<div class="clearfix"> </div>
					</div></a>
				</div>
				<div class="col-md-3 single-colored-widget">
					<a href="${pageContext.request.contextPath}/puntuacion/list.html"><div class="content-wrapper green">
						<h4 class="text-white center-text"><img class="mini-logo" src="${pageContext.request.contextPath}/img/icon/puntuaciones.png" width="100"" height="100"" alt=""><br><span class="semi-bold">Puntuaciones</span></h4>
						<div class="clearfix"></div>
					</div>
					<div class="heading">
						<div class="pull-left">
							<p>Esto es una corta descripción de lo que se puede hacer aquí</p>
						</div>
						<div class="clearfix"> </div>
					</div></a>
				</div>
				<div class="col-md-3 single-colored-widget">
					<a href="${pageContext.request.contextPath}/respuestaPuntuacion/list.html"><div class="content-wrapper green">
						<h4 class="text-white center-text"><img class="mini-logo" src="${pageContext.request.contextPath}/img/icon/respuestas-puntuacion.png" width="100"" height="100"" alt=""><br><span class="semi-bold">Comentarios</span></h4>
						<div class="clearfix"></div>
					</div>
					<div class="heading">
						<div class="pull-left">
							<p>Esto es una corta descripción de lo que se puede hacer aquí</p>
						</div>
						<div class="clearfix"> </div>
					</div></a>
				</div>
			</div><br>
			<div class="row">
				<div class="col-md-3 single-colored-widget">
					<a href="${pageContext.request.contextPath}/reserva/list.html"><div class="content-wrapper green">
						<h4 class="text-white center-text"><img class="mini-logo" src="${pageContext.request.contextPath}/img/icon/reservas.png" width="100"" height="100"" alt=""><br><span class="semi-bold">Reservas</span></h4>
						<div class="clearfix"></div>
					</div>
					<div class="heading">
						<div class="pull-left">
							<p>Esto es una corta descripción de lo que se puede hacer aquí</p>
						</div>
						<div class="clearfix"> </div>
					</div></a>
				</div>
				<div class="col-md-3 single-colored-widget">
					<a href="${pageContext.request.contextPath}/usuario/list.html"><div class="content-wrapper green">
						<h4 class="text-white center-text"><img class="mini-logo" src="${pageContext.request.contextPath}/img/icon/usuarios.png" width="100"" height="100"" alt=""><br><span class="semi-bold">Usuarios</span></h4>
						<div class="clearfix"></div>
					</div>
					<div class="heading">
						<div class="pull-left">
							<p>Esto es una corta descripción de lo que se puede hacer aquí</p>
						</div>
						<div class="clearfix"> </div>
					</div></a>
				</div>
				<div class="col-md-3 single-colored-widget">
					<a href="${pageContext.request.contextPath}/servicio/list.html"><div class="content-wrapper green">
						<h4 class="text-white center-text"><img class="mini-logo" src="${pageContext.request.contextPath}/img/icon/servicios.png" width="100"" height="100"" alt=""><br><span class="semi-bold">Servicios</span></h4>
						<div class="clearfix"></div>
					</div>
					<div class="heading">
						<div class="pull-left">
							<p>Esto es una corta descripción de lo que se puede hacer aquí</p>
						</div>
						<div class="clearfix"> </div>
					</div></a>
				</div>
				<div class="col-md-3 single-colored-widget">
					<a href="${pageContext.request.contextPath}/propiedadServicio/list.html"><div class="content-wrapper green">
						<h4 class="text-white center-text"><img class="mini-logo" src="${pageContext.request.contextPath}/img/icon/propiedad-servicios.png" width="100"" height="100"" alt=""><br><span class="semi-bold">¿Mantenimiento?</span></h4>
						<div class="clearfix"></div>
					</div>
					<div class="heading">
						<div class="pull-left">
							<p>Esto es una corta descripción de lo que se puede hacer aquí</p>
						</div>
						<div class="clearfix"> </div>
					</div></a>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3 single-colored-widget">
					<a href="${pageContext.request.contextPath}/mensaje/list.html"><div class="content-wrapper green">
						<h4 class="text-white center-text"><img class="mini-logo" src="${pageContext.request.contextPath}/img/icon/mensajes.png" width="100"" height="100"" alt=""><br><span class="semi-bold">Mensajes</span></h4>
						<div class="clearfix"></div>
					</div>
					<div class="heading">
						<div class="pull-left">
							<p>Esto es una corta descripción de lo que se puede hacer aquí</p>
						</div>
						<div class="clearfix"> </div>
					</div></a>
				</div>
			</div>
	    </div>
	  </div>
	 </div>
	<!-- FIN CONTAINER --> 
</jsp:body>
</t:paginabasica>