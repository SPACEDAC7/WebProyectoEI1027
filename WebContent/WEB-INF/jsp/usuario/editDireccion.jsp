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
              <h3 class="panel-title"> Editar direccion de  ${usuario.nombre} ${usuario.apellido}</h3>
            </div>
            <form:form method="post" modelAttribute="direccion"> 
            <div class="panel-body">
                <div class=" col-md-12 col-lg-12 "> 
                 
                  <table class="table table-user-information">
                    <tbody>
						<tr>
							<td><form:label class="col-md-3 col-xs-5 control-label" path="calle">Calle</form:label></td>
							<td><form:input class="form-control input-md" path="calle" /></td>
							<td><form:errors style="color:#F44336"  path="calle" cssClass="error"/></td>
							
							<td><form:input type="hidden" class="form-control input-md" path="id_direccion" readonly="true" value="${direccion.id_direccion}"/></td>
							<td><form:errors style="color:#F44336"  path="id_direccion" cssClass="error"/></td>
						</tr>
						<tr>
							<td><form:label class="col-md-3 col-xs-5 control-label" path="numero">Numero</form:label></td>
							<td><form:input class="form-control input-md" path="numero" /></td>
							<td><form:errors style="color:#F44336"  path="numero" cssClass="error"/></td>
						</tr>
						<tr>
							<td><form:label class="col-md-3 col-xs-5 control-label" path="codigo_postal">Codigo Postal</form:label></td>
							<td><form:input class="form-control input-md" path="codigo_postal" /></td>
							<td><form:errors style="color:#F44336"  path="codigo_postal" cssClass="error"/></td>
						</tr>
							<tr>
							<td><form:label class="col-md-3 col-xs-5 control-label" path="localidad">Localidad</form:label></td>
							<td><form:input class="form-control input-md" path="localidad" /></td>
							<td><form:errors style="color:#F44336"  path="localidad" cssClass="error"/></td>
						</tr>
							<tr>
							<td><form:label class="col-md-3 col-xs-5 control-label" path="provincia">Provincia</form:label></td>
							<td><form:input class="form-control input-md" path="provincia" /></td>
							<td><form:errors style="color:#F44336"  path="provincia" cssClass="error"/></td>
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