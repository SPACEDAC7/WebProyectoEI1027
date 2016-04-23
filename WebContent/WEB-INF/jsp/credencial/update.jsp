<%@page contentType="text/html; charset=iso-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Competició Natació - Modificar un nadador</title>
</head>
<body>
	<h2>Modificar nadador</h2>
	<form:form method="post" modelAttribute="nadador">
		<table>
			<tr>
				<td><form:label path="nom">Nom</form:label></td>
				<td><form:input path="nom" /></td>
			</tr>
			<tr>
				<td><form:label path="numFederat">Num. Federat </form:label></td>
				<td><form:input path="numFederat" /></td>
			</tr>
			<tr>
				<td><form:label path="pais">Pais </form:label></td>
				<td><form:input path="pais" /></td>
			</tr>
			<tr>
				<td><form:label path="edat">Edat</form:label></td>
				<td><form:input path="edat" /></td>
			</tr>
			<tr>
				<td><form:label path="sexe">Sexe</form:label></td>
				<td><form:input path="sexe" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Modificar nadador" />
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>