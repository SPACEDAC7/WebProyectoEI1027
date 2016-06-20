<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- La sessió està disponible automàticament en l’objecte "session" -->
<c:set var="user" scope="request" value='${session.getAttribute("user")}' />
<c:set var="rol" scope="request" value='${session.getAttribute("rol")}' />
<!-- <p style="margin: 0px 0px 0px 0px;" class="loggeduser">  -->
	<c:choose>
		<c:when test='${usuario == null}'>
			<t:botonmain></t:botonmain>
		</c:when>
		<c:when test='${rol == "inquilino"}'>
		
			<ul class="nav navbar-nav navbar-right desplegable">

				<li><a href="${pageContext.request.contextPath}/usuario/perfil/${usuario.id_usuario}.html"><p class="destacado" >${usuario.nombre}</p></a>
					<ul class="desplegable bordeado list-unstyled">
						<li><a class="letras-grises" href="${pageContext.request.contextPath}/usuario/perfil/${usuario.id_usuario}.html">Perfil</a></li>
						<li><a class="letras-grises" href="${pageContext.request.contextPath}/mensaje/bandejaEntrada.html">Mensajes</a></li>
						<li><a class="letras-grises" href="${pageContext.request.contextPath}/reserva/misReservas.html">Mis Reservas</a></li>
						<li><a class="elemento-rojo" href="${pageContext.request.contextPath}/logout.html">
						<span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>
						Salir
						</a>
					</button>
				</form></li>
					</ul>
				</li>
			</ul>
		</c:when>
				<c:when test='${rol == "propietario"}'>
			<ul class="nav navbar-nav navbar-right desplegable">

				<li><a href="${pageContext.request.contextPath}/usuario/perfil/${usuario.id_usuario}.html"><p class="destacado" >${usuario.nombre}</p></a>
					<ul class="desplegable bordeado list-unstyled">
						<li><a class="letras-grises" href="${pageContext.request.contextPath}/usuario/perfil/${usuario.id_usuario}.html">Perfil</a></li>
						<li><a class="letras-grises" href="${pageContext.request.contextPath}/mensaje/bandejaEntrada.html">Mensajes</a></li>
						<li><a class="letras-grises" href="${pageContext.request.contextPath}/propiedad/misPropiedades.html">Mis Propiedades</a></li>
						<li><a class="elemento-rojo" href="${pageContext.request.contextPath}/logout.html">
						<span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>
						Salir
						</a>
					</button>
				</form></li>
					</ul>
				</li>
			</ul>
		</c:when>
	</c:choose>
<!-- </p>  -->