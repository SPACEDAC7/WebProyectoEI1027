<%@page contentType="text/html; charset=iso-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/natacio.css">
<title>Easy Rent - Crear nova credencial</title>
</head>
<body>
	<h2>Nova credencial</h2>
	<form:form method="post" modelAttribute="credencial">
		<table>
			<tr>
				<td><form:label path="id_credencial">ID. Credencial</form:label></td>
				<td><form:input path="id_credencial" /></td>
				<td><form:errors path="id_credencial" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="nick_usuario">Nick </form:label></td>
				<td><form:input path="nick_usuario" /></td>
			</tr>
			<tr>
				<td><form:label path="password">Password </form:label></td>
				<td><form:input path="password" /></td>
			</tr>
			<tr>
				<td><form:label path="rol">Rol</form:label></td>
				<td><form:input path="rol" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Afegeix credencial" />
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>
