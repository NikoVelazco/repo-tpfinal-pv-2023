package ar.edu.unju.fi.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ar.edu.unju.fi.entity.IndiceMasaCorporal;
import ar.edu.unju.fi.entity.Usuario;

/**
 * @author Grupo9
 * Interfaz IIndiceMasaCorporalRepository
 */
@Repository
public interface IIndiceMasaCorporalRepository extends CrudRepository<IndiceMasaCorporal, Long>{
	
	public List<IndiceMasaCorporal> findByEstado(boolean estado); //Busca por estado
	public List<IndiceMasaCorporal> findByUserImcAndEstado(Usuario usuario, boolean estado); //Busca por estado y usuario
	public List<IndiceMasaCorporal> findByUserImc(Usuario usuario);//Busca por usuario
	
}