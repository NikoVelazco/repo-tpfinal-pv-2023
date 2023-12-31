package ar.edu.unju.fi.service;

import ar.edu.unju.fi.entity.Usuario;
import java.util.List;

/**
 * @author Grupo9
 * Interfaz IUsuarioService
 */
public interface IUsuarioService {

	List<Usuario> getListaUsuario();
	Usuario getUsuario();
	void guardarUsuario(Usuario usuario);
	void modificarUsuario(Usuario usuario);
	void eliminarUsuario(Usuario usuario);
	Usuario findByUser(Long id);
	boolean comprobarExistenciaUsuario(Long id);
}