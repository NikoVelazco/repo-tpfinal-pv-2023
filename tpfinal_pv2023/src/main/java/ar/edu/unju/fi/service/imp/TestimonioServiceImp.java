package ar.edu.unju.fi.service.imp;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import ar.edu.unju.fi.entity.Testimonio;
import ar.edu.unju.fi.listas.ListaTestimonio;
import ar.edu.unju.fi.service.ITestimonioService;

@Service("TestimonioServiceImp")
public class TestimonioServiceImp implements ITestimonioService {

	
	@Autowired
	private ListaTestimonio listaTestimonio;
	
	@Autowired
	private Testimonio testimonio;
	
	@Override
	public List<Testimonio> getListaTestimonio() {
		
		return listaTestimonio.getTestimonio();
	}

	@Override
	public void guardar(Testimonio testimonio) {
		listaTestimonio.getTestimonio().add(testimonio);
		
	}

	@Override
	public void modificar(Testimonio testimonio, Long id) {
		for(Testimonio testi : listaTestimonio.getTestimonio()) {
			if(testi.getId()== testimonio.getId()) {
				testi.setUsuario(testimonio.getUsuario());
				testi.setFecha(testimonio.getFecha());
				testi.setComentario(testimonio.getComentario());
						
				break;
			}
		}
		
	}

	@Override
	public void eliminar(Testimonio testimonioEncontrado) {
	listaTestimonio.getTestimonio().remove(testimonioEncontrado);
		
	}

	@Override
	public Testimonio getTestimonio() {
		// TODO Auto-generated method stub
		return testimonio;
	}

	@Override
	public Testimonio getBy(Long id) {
		Testimonio testimonioEncontrado = null;
		  for(Testimonio testi : listaTestimonio.getTestimonio()) {
			if (testi.getId() == id) {
			 testimonioEncontrado = testi;
			 break;

			}			
		}

		return testimonioEncontrado;
	}
	
	@Override
	public List<Testimonio> buscarTestimonioPorFecha(LocalDate fecha) {
		// TODO Auto-generated method stub
		return null;
	}
}