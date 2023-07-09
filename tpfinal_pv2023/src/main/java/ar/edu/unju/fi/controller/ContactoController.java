package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author Grupo9
 * Clase controladora para la página contactos.html
 */
@Controller
@RequestMapping("/")
public class ContactoController {
	
	/**
	 * Recibe la petición para la página contactos
	 * @return contactos.html
	 */
	@GetMapping("/contactos")
	public String getContactoPage() {
		return "contactos";
	}
	
}
