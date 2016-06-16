<%@page contentType="text/html; charset=iso-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:paginabasica title="Nueva reserva">
	<jsp:body>
	<div style="margin-bottom:20px" class="container">
	<h2>Nova reserva</h2>
	<form:form method="post" modelAttribute="reserva">
		<table class="table table-condensed">
			<tr>
				<td><form:label path="id_reserva">ID. Reserva </form:label></td>
				<td><form:input path="id_reserva" readonly="true" /></td>
				<td><form:errors style="color:#F44336" path="id_reserva" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="id_usuario">ID. Usuario</form:label></td>
				<td><form:input path="id_usuario" /></td>
				<td><form:errors style="color:#F44336" path="id_usuario" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="id_propiedad">ID. Propiedad</form:label></td>
				<td><form:input path="id_propiedad" /></td>
				<td><form:errors style="color:#F44336" path="id_propiedad" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="fechaReserva">Fecha Reserva</form:label></td>
				<td><form:input path="fechaReserva" class="datepicker"/></td>
				<td><form:errors style="color:#F44336" path="fechaReserva" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="fechaCheckIn">Fecha Check In</form:label></td>
				<td><form:input path="fechaCheckIn" class="datepicker"/></td>
				<td><form:errors style="color:#F44336" path="fechaCheckIn" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="fechaCheckOut">Fecha Check Out</form:label></td>
				<td><form:input path="fechaCheckOut" class="datepicker"/></td>
				<td><form:errors style="color:#F44336" path="fechaCheckOut" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="precio_reserva">Precio Reserva</form:label></td>
				<td><form:input path="precio_reserva" /></td>
				<td><form:errors style="color:#F44336" path="precio_reserva" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="estado">Estado</form:label></td>
				<td><form:input path="estado" /></td>
				<td><form:errors style="color:#F44336" path="estado" cssClass="error"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Afegeix reserva" />
				</td>
			</tr>
		</table>
	</form:form>
	</div>
	</jsp:body>
</t:paginabasica>
<t:datepicker></t:datepicker> 