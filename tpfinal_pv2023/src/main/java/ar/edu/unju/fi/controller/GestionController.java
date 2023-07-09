package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.service.IUsuarioService;

/**
 * 
 * @author Noeli Mamaní; Sara Mercado; Alicia Roberts; Cristian Ortega; Nicolás Velazco
 * Clase controladora para la página ingresoadministrador.html
 */
@Controller
@RequestMapping("/gestion")
public class GestionController {
	
	@Autowired
	private Usuario unUsuario;
	
	@Autowired
	@Qualifier("UsuarioServiceMysqlImp")
	private IUsuarioService usuarioService;
	
	/**
	 * Peticion para el ingreso del administrador
	 * @param numero es la opcion que determina a que ABM se direcciona el Admin
	 * @param model necesario para usar la variable nro
	 * @return pagina ingresoadministrador
	 */
	@GetMapping("/inicio")
	public String getIngresoAdminPage(@RequestParam(name = "numero", required = false) int numero,Model model) {
		model.addAttribute("numero", numero); 
		model.addAttribute("usuarioEncontrado", true);
		model.addAttribute("usuarioAdmin", true);
		return "ingresoadministrador";
	}
	
	@PostMapping("/abm")
	public String getAltaBajaModificacionPage(@RequestParam("id") Long id, @RequestParam("numero") int numero, Model model){
		boolean existe = usuarioService.comprobarExistenciaUsuario(id);
		if (existe){
			unUsuario=usuarioService.findByUser(id);
			if (unUsuario.isEstado()) {
				if(unUsuario.isRolUsuario()) {
					switch (numero){
					case 1: return "redirect:/recetas/nuevo";
					case 2: return "redirect:/recetas/ediciones";
					case 3: return "redirect:/ingredientes/nuevo";
					case 4: return "redirect:/ingredientes/listado";
					case 5: return "redirect:/ingredientes/listado"; /*agregar ruta a formulario de usuario adminstrador*/
					case 6: return "redirect:/recetas/nuevo"; /*agregar ruta edicion de usuarios*/
					case 7: return "redirect:/recetas/nuevo"; /*agregar ruta edicion detestimonio*/
										
					}					
				}
				else {
					model.addAttribute("usuarioAdmin", false);
					model.addAttribute("usuarioEncontrado", true);					
				}				
			}
			else {
				model.addAttribute("usuarioAdmin", true);
				model.addAttribute("usuarioEncontrado", false);	
			}				
		}
		else {
			model.addAttribute("usuarioAdmin", false);
			model.addAttribute("usuarioEncontrado", false);				
		}
		
		return "ingresoadministrador";
		
	}

}
