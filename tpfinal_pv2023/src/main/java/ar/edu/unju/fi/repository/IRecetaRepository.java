package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Receta;

/**
 * 
 * @author GRUPO 9
 * Interfaz Receta
 */

@Repository
public interface IRecetaRepository extends CrudRepository <Receta,Long>{
	
	/**
	 * Recupera la lista de Recetas segun el estado
	 * @param estado
	 * @return lista de recetas
	 */
	public List <Receta> findByEstado(boolean estado);
	public List <Receta> findByEstadoAndCategoria(boolean estado, String categoria);
	

}
