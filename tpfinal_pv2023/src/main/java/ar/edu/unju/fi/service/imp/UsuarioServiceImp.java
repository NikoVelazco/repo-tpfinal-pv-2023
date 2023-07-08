package ar.edu.unju.fi.service.imp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.service.IUsuarioService;
import ar.edu.unju.fi.listas.ListaUsuario;

/**
 * @author Grupo9
 */
@Service("UsuarioServiceImp")
public class UsuarioServiceImp implements IUsuarioService{

	/**
	 * Inyecta e instancia el objeto ListaUsuario en el contenedor
	 */
	@Autowired
	private ListaUsuario listaUsuarios;
	
	/**
	 * Inyecta e instancia el objeto usuario en el contenedor
	 */
	@Autowired
	private Usuario usuario;
	
	/**
	 * Método que retorna la lista usuario
	 */
	@Override
	public List<Usuario> getListaUsuario() {
		// TODO Auto-generated method stub
		return listaUsuarios.getUsuarios();
	}

	/**
	 * Método que guarda la lista paseo;
	 */
	@Override
	public void guardarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		listaUsuarios.getUsuarios().add(usuario);
	}

	/**
	 * Método de busqueda por el id de usuario
	 */
	@Override
	public Usuario getBy(Long id) {
		// TODO Auto-generated method stub
		Usuario usuarioEncontrado = null;
		for(Usuario usr : listaUsuarios.getUsuarios()) {
			if(usr.getId()==id) {
				usuarioEncontrado=usr;
				break;
			}
		}
		return usuarioEncontrado;
	}

	/**
	 * Método para modificar los atributos del objeto Usuario
	 */
	@Override
	public void modificarUsuario(Usuario usuario, Long id) {
		// TODO Auto-generated method stub
		for(Usuario usr : listaUsuarios.getUsuarios()) {
			if(usr.getId()==id) {
				usr.setNombre(usuario.getNombre());
				usr.setApellido(usuario.getApellido());
				usr.setEmail(usuario.getEmail());
				usr.setFechaNacimiento(usuario.getFechaNacimiento());
				usr.setTelefono(usuario.getTelefono());
				usr.setSexo(usuario.getSexo());
				usr.setEstatura(usuario.getEstatura());
				break;
			}
		}
	}

	/**
	 * Método para eliminar un servicio de la lista
	 */
	@Override
	public void eliminarUsuario(Usuario usuarioEncontrado) {
		// TODO Auto-generated method stub
		listaUsuarios.getUsuarios().remove(usuarioEncontrado);
	}

	@Override
	public Usuario getUsuario() {
		// TODO Auto-generated method stub
		return usuario;
	}

}