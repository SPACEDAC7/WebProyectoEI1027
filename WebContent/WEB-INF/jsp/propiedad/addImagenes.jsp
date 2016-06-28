<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<t:paginabasica title="Nueva Propiedad">
	<jsp:body>
	<div style="margin-bottom:20px;background:white;margin-left:250px" class="container">
		<ul class="breadcrumb">
			<li><p>ESTÁS AQUÍ</p></li>
			<li><a href="${pageContext.request.contextPath}/propiedad/list.html" class="active">GESTIÓN DE PROPIEDADES</a> </li>
		</ul>
		<div class="page-title"><a href="${pageContext.request.contextPath}/propiedad/list.html"><i class="icon-custom-left"></i></a>
			<h3>Propiedades - <span class="semi-bold">Añadir propiedad</span></h3>
		</div>
		 <div class="row">
		<div class="grid simple">
		<div class="grid-body no-border">
		<div class="row-fluid">
		<div class="col-md-12">
		<h3><span class="semi-bold">Añadir las imágenes de la propiedad</span></h3>
	<form:form method="post" enctype="multipart/form-data">
		<table class="table table-condensed">
			<tr>
				<td>Selecciona fichero: </td>
           		<td><input type="file" name="fichero"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
    			<input type="submit" value="Subir fichero"></td>
			</tr>
		</table>
	</form:form>
	</div>
	</div>
	</div>
	</div>
	</div>
	</div>
	</jsp:body>
</t:paginabasica>