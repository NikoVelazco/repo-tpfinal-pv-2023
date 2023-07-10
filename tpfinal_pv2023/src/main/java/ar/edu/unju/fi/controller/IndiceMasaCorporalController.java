package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.entity.IndiceMasaCorporal;
import ar.edu.unju.fi.service.IIndiceMasaCorporalService;
import ar.edu.unju.fi.service.IUsuarioService;
import jakarta.validation.Valid;

/**
 * @author Grupo9
 * Clase Controladora para la interfaz IndiceMasaCorporal
 */
@Controller
@RequestMapping("/servicios")
public class IndiceMasaCorporalController {
	
	/**
	 * Inyección de dependencia de la implementación UsuarioServiceMysqlImp de la interfaz IUsuarioService.
	 * @Autowired para realizar la inyección de forma automática.
	 * @Qualifier para especificar el bean con el nombre "UsuarioServiceMysqlImp".
	 */
	@Autowired
	@Qualifier("UsuarioServiceMysqlImp")
	private IUsuarioService usuarioService;
	
	/**
	 * Inyección de dependencia de la implementación IndiceMasaCorporalServiceMysqlImp de la interfaz IIndiceMasaCorporalService.
	 * @Autowired para realizar la inyección de forma automática.
	 * @Qualifier para especificar el bean con el nombre "IndiceMasaCorporalServiceMysqlImp".
	 */
	@Autowired
	@Qualifier("IndiceMasaCorporalServiceMysqlImp")
	private IIndiceMasaCorporalService indiceMasaCorporalService;
	
	/**
	 * Método GetMapping que maneja la solicitud de la página "/imc".
	 * @param model El objeto Model utilizado para pasar datos a la vista.
	 * @return El nombre de la vista "imc" que se mostrará al usuario.
	 */
	@GetMapping("/imc")
	public String getImcPage(Model model) {
		boolean bandUsuario=true;
		model.addAttribute("imco", indiceMasaCorporalService.getImc()); //fijarse
		model.addAttribute("usuarioEncontrado", bandUsuario);
		return "imc";
	}
	
	/**
	 * Método POST que maneja la solicitud de la página "/imc-calculo" para realizar el cálculo del IMC.
	 * @param imc El objeto IndiceMasaCorporal obtenido a través del formulario.
	 * @param result El objeto BindingResult que contiene los resultados de la validación del formulario.
	 * @param idUsuario El ID del usuario asociado al cálculo del IMC.
	 * @return Un objeto ModelAndView que representa la vista generada.
	 */
	@PostMapping("/imc-calculo")
	public ModelAndView getCalculoImcPage(@Valid @ModelAttribute("imco") IndiceMasaCorporal imc ,BindingResult result, Long idUsuario) {
		ModelAndView modelAndView = new ModelAndView("generarimc");
		boolean bandUsuario;
		if(usuarioService.comprobarExistenciaUsuario(idUsuario)) {
			bandUsuario = true;
			if(result.hasErrors()) {
				modelAndView.addObject("usuarioEncontrado", bandUsuario);
				modelAndView.setViewName("imc");
				modelAndView.addObject("imco", imc);
				return modelAndView;
			}else {
			indiceMasaCorporalService.guardarImc(imc, idUsuario);
			modelAndView.addObject("usuarioEncontrado", bandUsuario);
			modelAndView.addObject("usuario", imc.getUserImc());
			modelAndView.addObject("resultado", indiceMasaCorporalService.obtenerImc(imc));
			}
		}else {
			bandUsuario=false;
			if(result.hasErrors()) {
				modelAndView.addObject("usuarioEncontrado", bandUsuario);
				modelAndView.setViewName("imc");
				modelAndView.addObject("imco", imc);
				return modelAndView;
			}
		modelAndView.addObject("usuarioEncontrado", bandUsuario);
		modelAndView.setViewName("imc");
		}
		return modelAndView;
	}
	
	
}
