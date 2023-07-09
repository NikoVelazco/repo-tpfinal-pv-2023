package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.service.IUsuarioService;
import jakarta.validation.Valid;

/**
 * @author Grupo9
 * Clase controladora para la página index.html
 */
@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	/**
	 * Inyecta e instancia el objeto usuarioService del tipo IUsuarioService al contendor
	 * la interfaz es IUsuarioService
	 */
	@Autowired
	@Qualifier("UsuarioServiceMysqlImp")
	private IUsuarioService usuarioService;
	
	/**
	 * Petición para dirigirse a la página usuario_nuevo
	 * @param model vincula la variable de tipo usr al formulario
	 * la variable modificar indica la acción que se debe realizar
	 * @return página usuario_nuevo
	 */
	@GetMapping("/nuevo")
	public String getNuevoUserPage(Model model) {
		boolean modificar = false;
		model.addAttribute("usuario", usuarioService.getUsuario());
		model.addAttribute("modificar", modificar);
		return "usuario_nuevo";
	}
	
	/**
	 * Petición para guardar el objeto usr dentro de la lista usuarios
	 * @param usuario es el objeto a guardar 
	 * @param result activa las validaciones dentro del modelo
	 * @return
	 */
	@PostMapping("/guardar")
	public ModelAndView getGuardarUserPage(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result) {
		ModelAndView modelView = new ModelAndView("generarid");
		if(result.hasErrors()) {
			modelView.setViewName("usuario_nuevo");
			modelView.addObject("usuario", usuario);
			return modelView;
		}
		usuarioService.guardarUsuario(usuario);
		modelView.addObject("idUserGenerate", usuario.getId());
		return modelView;
	}
	
	
	/**
	 * Petición para modificar un usuario
	 * @param id a modificar
	 * @param model usado para enviar el objeto usado a la página
	 * @return usuario_nuevo
	 */
	@GetMapping("/modificar/{id}")
	public String getModificarUsuarioPage(@PathVariable(value="id")Long id, Model model) {
		boolean modificar = true;
    	model.addAttribute("modificar", modificar);
    	Usuario usuarioEncontrado = usuarioService.findByUser(id);
		model.addAttribute("usuario", usuarioEncontrado);
		return "usuario_nuevo";
	}
	
	/**
	 * Petición para guardar el objeto modificado 
	 * @param usuario objeto que contiene a los usuarios
	 * @param result activa las validaciones
	 * @param model vincula la variable usr al formulario
	 * @return usuario_nuevo
	 */
	@PostMapping("/modificar")
	public String modificarUsuario(@Valid @ModelAttribute("usuario")Usuario usuario, BindingResult result, Model model) {
		Usuario usuarioEncontrado = usuarioService.findByUser(usuario.getId());
	    boolean modificar = true;
		if (result.hasErrors()) {
			usuario.setId(usuarioEncontrado.getId());
			model.addAttribute("usuario", usuario);
			model.addAttribute("modificar", modificar);
			return "usuario_nuevo";
		} else {
			usuarioService.modificarUsuario(usuarioEncontrado);
			return "redirect:/usuario/listado";
		}
	}
	
	/**
	 * Petición para eliminar un servicio según el id
	 * @param id a eliminar
	 * @return usuarios
	 */
	@GetMapping("/eliminar/{id}")
	public String eliminarUsuario(@PathVariable(value="id")Long id) {
		Usuario usuarioEncontrado = usuarioService.findByUser(id);
		usuarioService.eliminarUsuario(usuarioEncontrado);
		return "redirect:/usuario/listado";
	}
	
}