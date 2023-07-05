package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author Noeli Mamaní; Sara Mercado; Alicia Roberts; Cristian Ortega; Nicolás Velazco
 * Clase controladora para la página index.html
 */
@Controller
@RequestMapping("/")
public class IndexController {
	
	/**
	 * Metodo que solicita acceso a la página index.html
	 * @return index.html
	 */
	@GetMapping("/index")
	public String getIndexPage() {
		
		return "index";
	}
	
}