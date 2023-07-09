package ar.edu.unju.fi.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ar.edu.unju.fi.entity.Ingrediente;

 /**
  * Interfaz Ingrediente
  * @author GRUPO 9
  *
  */
@Repository
public interface IIngredienteRepository extends CrudRepository <Ingrediente,Long> {
	
	/**
	 * Recupera la lista de ingredientes
	 * @param estado
	 * @return lista de ingredientes
	 */
	public List<Ingrediente> findByEstado(boolean estado);
	public List<Ingrediente> findAllById(Iterable<Long> ingredientesIds);

}