<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="url" scope="request" value='${session.getAttribute("nextURL")}' />
<t:paginabasica title="Nueva factura">
	<jsp:body>
	<div style="margin-bottom:20px" class="container">
	<h3 align="center"><font color=red>${mensajeError.mensaje}</font></h3>
		<table>
			<tr>
				<td align="center"><input onclick="history.back()" class="btn btn-primary" type="button" value="Cancelar"/>
			</tr>
		</table>
	</div>
	</jsp:body>
</t:paginabasica>