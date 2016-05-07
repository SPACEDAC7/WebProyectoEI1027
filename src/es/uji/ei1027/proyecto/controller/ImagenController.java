package es.uji.ei1027.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.uji.ei1027.proyecto.dao.ImagenDao;
import es.uji.ei1027.proyecto.domain.Imagen;
import es.uji.ei1027.proyecto.validator.ImagenValidator;

@Controller
@RequestMapping("/imagen")
public class ImagenController {
	private ImagenDao imagenDao;
	
	@Autowired
	public void setImagenDao( ImagenDao imagenDao){
		this.imagenDao = imagenDao;
	}
	
	//Listar
	@RequestMapping("/list")
	public String listImagenes(Model model){
		model.addAttribute("imagenes", imagenDao.getImagenes());
		return "imagen/list";
	}
	
	//A�adir	
	@RequestMapping(value="/add") 
	public String addImagen(Model model) {
		Imagen img = new Imagen();
		img.setId_imagen(imagenDao.nuevoIdImagen());
		model.addAttribute("imagen", img);
		return "imagen/add";
	}

	@RequestMapping(value="/add", method=RequestMethod.POST) 
	public String processAddSubmit(@ModelAttribute("imagen") Imagen imagen,
			BindingResult bindingResult) { 
		ImagenValidator imagenValidator = new ImagenValidator();
		imagenValidator.validate(imagen, bindingResult); 
		if (bindingResult.hasErrors())
			return "imagen/add";
		imagenDao.addImagen(imagen);
		return "redirect:list.html";
	}
	
	//Actualizar	
	@RequestMapping(value="/update/{id_imagen}", method = RequestMethod.GET)
	public String editImagen(Model model, @PathVariable int id_imagen) {
		model.addAttribute("imagen", imagenDao.getImagen(id_imagen));
		return "imagen/update"; 
	}

	@RequestMapping(value="/update/{id_imagen}", method = RequestMethod.POST) 
	public String processUpdateSubmit(@PathVariable int id_imagen, 
			@ModelAttribute("imagen") Imagen imagen, 
			BindingResult bindingResult) {
		ImagenValidator imagenValidator = new ImagenValidator();
		imagenValidator.validate(imagen, bindingResult); 
		if (bindingResult.hasErrors()) 
			return "imagen/update";
		imagenDao.updateImagen(imagen);
		return "redirect:../list.html"; 
	}
	
	//Borrar	
	@RequestMapping(value="/delete/{id_imagen}")
	public String processDelete(@PathVariable int id_imagen) {
		imagenDao.deleteImagen(id_imagen);
		return "redirect:../list.html"; 
	}
	
}
