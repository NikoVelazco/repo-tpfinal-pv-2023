package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Receta;


/**
 * Servicio Receta
 * @author GRUPO 9
 *
 */
public interface IRecetaService {
	
	List<Receta> getListaReceta();	
	void guardar(Receta receta);	
	Receta getBy(Long id);	
	void modificar(Receta receta);	
	void eliminar(Receta recetaEncontrada);	
	Receta getReceta();	
	List<Receta> getListaRecetaFiltrada(String categoria);

}
