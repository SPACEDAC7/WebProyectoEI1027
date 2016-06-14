<%@page contentType="text/html; charset=iso-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<head>
<script>
		$(function () {
			$.datepicker.setDefaults($.datepicker.regional["es"]);
			$("#datepicker2").datepicker({
				firstDay: 1
			});
		});
	</script>
</head>
<t:datepicker></t:datepicker> 
<t:paginabasica title="Nuevo periodo">
	<jsp:body>
	<h2>Nou periodo</h2>
	<form:form method="post" modelAttribute="periodo">
		<table class="table table-condensed">
			<tr>
				<td><form:label path="id_periodo">ID. Periodo</form:label></td>
				<td><form:input path="id_periodo" readonly="true"/></td>
				<td><form:errors style="color:#F44336" path="id_periodo" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="id_propiedad">ID. Propiedad </form:label></td>
				<td><form:input path="id_propiedad" /></td>
			</tr>
			<tr>
			    <td><form:label path="fechaInicio">Fecha inicio: </form:label></td>
			    <td><form:input path="fechaInicio" id="datepicker2"></form:input></td>
			    <td><form:errors style="color:#F44336" path="fechaInicio" cssClass="error"/></td>
			</tr>
			<!--<tr>
				<td><form:label path="fechaInicio">Dia inicio </form:label></td>
				<td><form:input path="fechaInicio" /></td>
			</tr>-->
			<tr>
			    <td><form:label path="fechaFinal">Fecha inicio: </form:label></td>
			    <td><form:input path="fechaFinal" id="datepicker"></form:input></td>
			    <td><form:errors style="color:#F44336" path="fechaFinal" cssClass="error"/></td>
			</tr>
			<!--<tr>
				<td><form:label path="fechaFinal">D�a final </form:label></td>
				<td><form:input path="fechaFinal" /></td>
			</tr>-->
			<tr>
				<td colspan="2"><input type="submit" value="Afegeix periodo" />
				</td>
			</tr>
		</table>
	</form:form>
	</jsp:body>
</t:paginabasica>
