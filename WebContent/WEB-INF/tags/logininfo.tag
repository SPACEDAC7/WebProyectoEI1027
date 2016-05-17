<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<!-- La sessió està disponible automàticament en l’objecte "session" -->
<c:set var="user" scope="request"
	value='${session.getAttribute("user")}' />
<p style="margin: 0px 0px 0px 0px;" class="loggeduser">
	<c:choose>
		<c:when test='${usuario == null}'>
			<t:botonmain></t:botonmain>
		</c:when>
		<c:otherwise>
			<ul class="nav navbar-nav navbar-right desplegable">

				<li><a href=""><p class="destacado" >${usuario.nombre}</p></a>
					<ul class="desplegable bordeado list-unstyled">
						<li><a class="letras-grises" href="">Submenu1</a></li>
						<li><a class="letras-grises" href="">Submenu2</a></li>
						<li><a class="letras-grises" href="">Submenu3</a></li>
						<li><a class="letras-grises" href="">Submenu4</a></li>
						<li><a class="elemento-rojo" href="${pageContext.request.contextPath}/logout.html">
						<span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>
						Eixir
						</a>
					</button>
				</form></li>
					</ul>
				</li>

				
			</ul>
		</c:otherwise>
	</c:choose>
</p>