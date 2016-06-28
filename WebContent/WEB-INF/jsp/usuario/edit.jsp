<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<c:set var="rol" scope="request" value='${session.getAttribute("rol")}' />
<t:paginabasica title="Editar el perfil">
	<jsp:body>
		<div id="service">
<div class="container">
      <div class="row">
        <div class="col-md-8 toppad" >   
          <div class="panel panel-info">
            <div class="panel-heading">
              <h3 class="panel-title"> Editar perfil de  ${usuario.nombre} ${usuario.apellido}</h3>
            </div>
            <form:form method="post" modelAttribute="usuario"> 
            <div class="panel-body">
                <div class="col-md-6 col-lg-6 " align="center"> <img style="margin-bottom:10px" alt="User Pic" src="${usuario.url_imagen_perfil}" class="img-responsive"> </div>
                <div class=" col-md-12 col-lg-12 "> 
                 
                  <table class="table table-user-information">
                    <tbody>
                      <tr>
                      	<td><form:label class="col-md-3 col-xs-5 control-label" path="url_imagen_perfil">Url Imagen Perfil </form:label></td>
							<td><form:input class="form-control input-md" path="url_imagen_perfil" /></td>
                      
							<td><form:input type="hidden" class="form-control input-md" path="id_usuario" readonly="true" value="${usuario.id_usuario}"/></td>
							<td><form:errors style="color:#F44336" path="id_usuario" cssClass="error"/></td>

							<td><form:input type="hidden" class="form-control input-md" path="id_credencial" value="${usuario.id_credencial}"/></td>
							<td><form:errors style="color:#F44336" path="id_credencial" cssClass="error"/></td>

							
						</tr>
						<tr>
							<td><form:label class="col-md-3 col-xs-5 control-label" path="nombre">Nombre </form:label></td>
							<td><form:input class="form-control input-md" path="nombre" /></td>
							<td><form:errors style="color:#F44336" path="nombre" cssClass="error"/></td>
						</tr>
						<tr>
							<td><form:label class="col-md-3 col-xs-5 control-label" path="apellido">Apellido</form:label></td>
							<td><form:input class="form-control input-md" path="apellido" /></td>
							<td><form:errors style="color:#F44336" path="apellido" cssClass="error"/></td>
						</tr>
						<tr>
							<td><form:label class="col-md-3 col-xs-5 control-label" path="nif">NIF</form:label></td>
							<td><form:input class="form-control input-md" path="nif" /></td>
							<td><form:errors style="color:#F44336" path="nif" cssClass="error"/></td>
						</tr>
						<tr>
							<td><form:label class="col-md-3 col-xs-5 control-label" path="email">Email</form:label></td>
							<td><form:input class="form-control input-md" path="email" /></td>
							<td><form:errors style="color:#F44336" path="email" cssClass="error"/></td>
					
							<td><form:input type="hidden" class="form-control input-md" path="id_direccion" value="${usuario.id_direccion}" /></td>
							<td><form:errors style="color:#F44336" path="id_direccion" cssClass="error"/></td>
					
						    <td><form:input type="hidden" path="fechaRegistro" class="form-control input-md datepicker" value="${usuario.fechaRegistro}"></form:input></td>
						    <td><form:errors style="color:#F44336" path="fechaRegistro" cssClass="error"/></td>
						</tr>
						<tr>
							<td><form:label class="col-md-3 col-xs-5 control-label" path="telefono">Telefono</form:label></td>
							<td><form:input class="form-control input-md" path="telefono" /></td>
							<td><form:errors style="color:#F44336" path="telefono" cssClass="error"/></td>

							<td><form:input type="hidden" class="form-control selectpicker" path="estado_usuario" value="true"></form:input></td>
							<td><form:errors style="color:#F44336" path="estado_usuario" cssClass="error"/></td>
						</tr>
			             <tr>
			             <td>Direccion:</td>
			             <td>C/  ${direccion.calle}  ${direccion.numero}<br>
			             ${direccion.codigo_postal}, ${direccion.localidad} <br>
			             ${direccion.provincia}<br>
			             <a style="margin-top:9px" class="btn btn-sm btn-primary" href="${pageContext.request.contextPath}/usuario/editDireccion/${usuario.id_usuario}.html" type="button" class="btn btn-sm btn-caution">Editar direcci&oacuten</a></td>
			           </tr>
                                           
                    </tbody>
                  </table>
             	
                </div>
              </div>
            
                 <div class="panel-footer">
                        <input type="submit" class="btn btn-sm btn-primary" value="Acabar edición"/>
                        <span class="pull-right">
                            <a href="${pageContext.request.contextPath}/usuario/perfil/${usuario.id_usuario}.html" data-original-title="Edit this user" data-toggle="tooltip" type="button" class="btn btn-sm btn-danger"><i class="glyphicon glyphicon-remove"></i> Cancelar edici&oacuten</a>
                        </span>
          		</div>
          </form:form>
        </div>
        </div>
  </div>
  </div>
  </div>
  </jsp:body>
  </t:paginabasica>