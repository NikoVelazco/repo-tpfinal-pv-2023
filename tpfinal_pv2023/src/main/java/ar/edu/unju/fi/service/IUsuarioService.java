package ar.edu.unju.fi.service;

import ar.edu.unju.fi.entity.Usuario;
import java.util.List;

/**
 * @author Grupo9
 * Interfaz IUsuarioService
 */
public interface IUsuarioService {
	
	List<Usuario> getListaUsuario();
	void guardarUsuario (Usuario usuario);
	Usuario getBy(Long id);
	void modificarUsuario(Usuario usuario, Long id);
	void eliminarUsuario(Usuario usuarioEncontrado);
	Usuario getUsuario();
	
}