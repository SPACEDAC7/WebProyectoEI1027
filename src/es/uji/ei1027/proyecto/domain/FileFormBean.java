package es.uji.ei1027.proyecto.domain;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class FileFormBean {
	
	CommonsMultipartFile imagen;

	public CommonsMultipartFile getImagen() {
		return imagen;
	}

	public void setImagen(CommonsMultipartFile imagen) {
		this.imagen = imagen;
	}
	

}
