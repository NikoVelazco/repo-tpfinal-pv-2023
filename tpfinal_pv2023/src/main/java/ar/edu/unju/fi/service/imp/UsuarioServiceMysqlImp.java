package ar.edu.unju.fi.service.imp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.repository.IUsuarioRepository;
import ar.edu.unju.fi.service.IUsuarioService;

/**
 * @author Grupo9
 */
@Service("UsuarioServiceMysqlImp")
public class UsuarioServiceMysqlImp implements IUsuarioService{

	/**
	 * Inyecta e instancia la intergaz IUsuarioRepository en el contenedor
	 */
	@Autowired
	public IUsuarioRepository usuarioRepository;
	
	/**
	 * Inyecta e instancia el objeto Usuario en el contenedor
	 */
	@Autowired
	private Usuario usuario;
	
	/**
	 * Busca al usuario por estado
	 */
	@Override
	public List<Usuario> getListaUsuario() {
		// TODO Auto-generated method stub
		return usuarioRepository.findByEstado(true);
	}

	/**
	 * Método para guardar al usuario
	 */
	@Override
	public void guardarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		usuario.setEstado(true);
		usuarioRepository.save(usuario);
	}

	/**
	 * Obtiene usuario por id
	 */
	@Override
	public Usuario findByUser(Long id) {
		// TODO Auto-generated method stub
		return usuarioRepository.findById(id).get();
	}

	/**
	 * Método para modificar un usuario
	 */
	@Override
	public void modificarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		usuario.setId(usuario.getId());
		usuario.setEstado(true);
		usuarioRepository.save(usuario);
	}

	
	/**
	 * Método que realiza la eliminación lógica
	 */
	@Override
	public void eliminarUsuario(Usuario usuarioEncontrado) {
		// TODO Auto-generated method stub
		usuarioEncontrado.setEstado(false);
		usuarioRepository.save(usuarioEncontrado);
	}

	@Override
	public Usuario getUsuario() {
		// TODO Auto-generated method stub
		return usuario;
	}
	
	/**
	 * Método para comprobar la existencia de un usuario
	 */
	@Override
	public boolean comprobarExistenciaUsuario(Long id) {
		boolean existeUsuario = false;
		for (Usuario usuario : getListaUsuario()) {
			if (usuario.getId() == id) {
				existeUsuario = true;
				break;
			}
		}
		return existeUsuario;
	}

}