package ar.edu.unju.fi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ar.edu.unju.fi.entity.Usuario;
import java.util.List;

/**
 * @author Grupo9
 * Interfaz IUsuarioRepository
 */
@Repository
public interface IUsuarioRepository extends CrudRepository<Usuario,Long>{
	
	/*Obtiene la Lista de Usuario por estado*/
	public List<Usuario> findByEstado(boolean estado);
	
}