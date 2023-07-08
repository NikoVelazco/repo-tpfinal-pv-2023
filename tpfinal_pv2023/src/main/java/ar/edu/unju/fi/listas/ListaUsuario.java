package ar.edu.unju.fi.listas;

import org.springframework.stereotype.Component;
import ar.edu.unju.fi.entity.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Grupo9
 */
@Component
public class ListaUsuario {
	
	private List<Usuario> usuarios;
	
	/**
	 * Contructor especializado
	 */
	public ListaUsuario() {
		usuarios = new ArrayList<Usuario>();
	}

	/**
	 * Obtiene la lista de Usuarios
	 * @return lista de usuarios
	 */
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	/**
	 * Setea la lista de usuarios
	 * @param usuarios
	 */
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	
	
}
