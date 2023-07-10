package ar.edu.unju.fi.service.imp;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.entity.IndiceMasaCorporal;
import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.repository.IIndiceMasaCorporalRepository;
import ar.edu.unju.fi.service.IIndiceMasaCorporalService;
import ar.edu.unju.fi.service.IUsuarioService;

/**
 * @author Grupo9
 * Clase IndiceMasaCorporalServiceMysqlImp
 */

@Service("IndiceMasaCorporalServiceMysqlImp")
public class IndiceMasaCorporalServiceMysqlImp implements IIndiceMasaCorporalService{

	/**
	 * Inyección de dependencia de la implementación UsuarioServiceMysqlImp de la interfaz IUsuarioService.
	 * @Autowired para realizar la inyección de forma automática.
	 * @Qualifier para especificar el bean con el nombre "UsuarioServiceMysqlImp".
	 */
	@Autowired
	@Qualifier("UsuarioServiceMysqlImp")
	private IUsuarioService usuarioService;
	
	/**
	 * Inyección de dependencia de la interfaz IIndiceMasaCorporalRepository en la variable imcRepository.
	 * @Autowired para realizar la inyección de forma automática.
	 */
	@Autowired
	private IIndiceMasaCorporalRepository imcRepository;
	
	/**
	 * Creación de una nueva instancia de la clase IndiceMasaCorporal.
	 * @Autowired para realizar la inyección de forma automática.
	 * La instancia se asigna a la variable imcNuevo.
	 */
	@Autowired
	private IndiceMasaCorporal imcNuevo;
	
	/**
	 * Método que sirve para obtener el imc de un usuario
	 * devuelve mensaje imc
	 */
	@Override
	public String obtenerImc(IndiceMasaCorporal imc) {
		// TODO Auto-generated method stub
		return imcRepository.findById(imc.getId()).get().calculoImc();
	}

	/**
	 * Método que obtiene la lista de Imc
	 */
	@Override
	public List<IndiceMasaCorporal> getListaImc() {
		// TODO Auto-generated method stub
		return imcRepository.findByEstado(true);
	}

	/**
	 * Método que busca un imc por id
	 */
	@Override
	public IndiceMasaCorporal getBy(Long id) {
		// TODO Auto-generated method stub
		return imcRepository.findById(id).get();
	}

	/**
	 * Método que obtiene el imc
	 */
	@Override
	public IndiceMasaCorporal getImc() {
		// TODO Auto-generated method stub
		return imcNuevo;
	}

	/**
	 * Método que guarda el objeto Imc
	 */
	@Override
	public void guardarImc(IndiceMasaCorporal imc, Long idUser) {
		// TODO Auto-generated method stub
		imc.setEstado(true);
		imc.setUserImc(usuarioService.findByUser(idUser));
		imcRepository.save(imc);
	}

	/**
	 * Método que elimina un objeto de Imc
	 */
	@Override
	public void eliminarImc(Long id) {
		// TODO Auto-generated method stub
		IndiceMasaCorporal imcEliminar = new IndiceMasaCorporal();
		imcEliminar = getBy(id);
		imcEliminar.setEstado(false);
		imcRepository.save(imcEliminar);
	}

	/**
	 * Método que modifica el objeto imc
	 */
	@Override
	public void modificarImc(IndiceMasaCorporal imc) {
		// TODO Auto-generated method stub
		imcRepository.save(imc); //fijarse
	}

	/**
	 * Método que obtiene el peso ideal de un usuario
	 */

	/**
	 * Método que ordena la lista de imc realizada por un usuario
	 */
	@Override
	public List<IndiceMasaCorporal> getFechaImcDesc(Long id) {
		// TODO Auto-generated method stub
		Usuario usuarioFiltroFecha = new Usuario();
		List<IndiceMasaCorporal> imcList = new ArrayList<IndiceMasaCorporal>();
		usuarioFiltroFecha = usuarioService.findByUser(id);
		imcList = imcRepository.findByUserImcAndEstado(usuarioFiltroFecha, true);
		imcList.sort((imc1,imc2) -> imc2.getFecha().compareTo(imc1.getFecha()));
		return imcList;
	}

}
