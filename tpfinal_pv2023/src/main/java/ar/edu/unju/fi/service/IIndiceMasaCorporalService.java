package ar.edu.unju.fi.service;

import java.util.List;
import ar.edu.unju.fi.entity.IndiceMasaCorporal;

/**
 * @author Grupo9
 * Interfaz IIndiceMasaCorporalService
 */
public interface IIndiceMasaCorporalService {
	
	String obtenerImc(IndiceMasaCorporal imc); //Obtiene el imc de un usuario
	List<IndiceMasaCorporal> getListaImc(); //Obtiene la lista de imc
	IndiceMasaCorporal getBy(Long id); //Busca imc por id
	IndiceMasaCorporal getImc(); //Obtine imc
	void guardarImc(IndiceMasaCorporal imc, Long idUser); //Guardar un imc
	void eliminarImc(Long id); //Elimina un imc
	void modificarImc(IndiceMasaCorporal imc);//Modifica un imc
	//double getPesoIdeal(Long id);//Obtiene el peso ideal de un usuario
	List<IndiceMasaCorporal> getFechaImcDesc(Long id);//Lista que contiene a los imc ordenado de manera decreciente
	
}
