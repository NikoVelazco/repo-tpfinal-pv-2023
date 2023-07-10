package ar.edu.unju.fi.entity;

import java.text.DecimalFormat;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

/**
 * @author Grupo9
 * Clase IndiceMasaCorporal
 */
@Component
@Entity
@Table(name = "imc")
public class IndiceMasaCorporal {
	
	//Atributos de la clase IndiceMasaCorporal
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_imc")
	private Long id; //id del imc
	
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@NotNull(message = "La fecha no puede estar vacía")
	@PastOrPresent(message = "Debe ingresar una fecha menor o igual a la Actual")
	@Column(name = "fecha_imc")
	private LocalDate fecha; //fecha del imc
	
	@Min(value = 30, message = "Ingrese un peso mayor a 25kg")
	@Column(name = "peso_imc")
	private double pesoUsuario; //peso del usuario
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "usr_id")
	private Usuario userImc; //objeto usuario
	
	@Column(name = "estado_imc")
	private boolean estado; //estado que indica 1 existe, 0 no
	
	/**
	 * Constructor por defecto
	 */
	public IndiceMasaCorporal() {
		
	}
	
	/**
	 * Constructor especializado
	 * @param id
	 * @param fecha
	 * @param userImc
	 * @param estado
	 * @param pesoUsuario
	 */
	public IndiceMasaCorporal(Long id, LocalDate fecha, Usuario userImc, boolean estado, double pesoUsuario) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.userImc= userImc;
		this.estado = estado;
		this.pesoUsuario = pesoUsuario;
	}
	
	/**
	 * Obtiene id
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Setea id
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Obtiene fecha
	 * @return
	 */
	public LocalDate getFecha() {
		return fecha;
	}

	/**
	 * Setea fecha
	 * @param fecha
	 */
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	/**
	 * Obtien estado
	 * @return estado
	 */
	public boolean isEstado() {
		return estado;
	}

	/**
	 * Setea estado
	 * @param estado
	 */
	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	/**
	 * Obtiene pesoUsuario
	 * @return pesoUsuarioo
	 */
	public double getPesoUsuario() {
		return pesoUsuario;
	}

	/**
	 * Setea pesoUsuario
	 * @param pesoUsuario
	 */
	public void setPesoUsuario(double pesoUsuario) {
		this.pesoUsuario = pesoUsuario;
	}
	
	/**
	 * obtiene userImc
	 * @return userImc
	 */
	public Usuario getUserImc() {
		return userImc;
	}

	/**
	 * Setea userImc
	 * @param userImc
	 */
	public void setUserImc(Usuario userImc) {
		this.userImc = userImc;
	}

	/**
	 * Método que calcula el imc de un usuario
	 * @return mensaje con el imc
	 */
	public String calculoImc() {
		DecimalFormat formateo = new DecimalFormat("#,##");
		double imcUsuario =  (pesoUsuario / Math.pow(userImc.getEstatura(), 2));
		if (imcUsuario<18.5) {
			return "Su imc es "+formateo.format(imcUsuario)+".Usted está por debajo de su peso ideal";
		}else {
			if(imcUsuario>=18.5 && imcUsuario<=25) {
				return "Su imc es "+formateo.format(imcUsuario)+".Usted está en su peso normal";
			}else {
				return "Su imc es "+formateo.format(imcUsuario)+".Usted tiene sobrepeso";
			}
		}
	}
	
}
