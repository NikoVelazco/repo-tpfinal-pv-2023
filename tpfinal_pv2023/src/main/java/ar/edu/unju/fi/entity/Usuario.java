package ar.edu.unju.fi.entity;

import java.time.LocalDate;
import java.time.Period;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * @author Grupo9
 * Clase Usuario
 */
@Component
@Entity
@Table(name="usuario")
public class Usuario {
	
	//Atributos de la clase Usuario
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="usr_id")
	private Long id;
	
	@NotEmpty(message="el campo nombre no puede estar vacio")
	@Pattern(regexp = "^[\\p{L} ]+$", message = "El nombre solo puede contener letras y espacios")
	@Size(max=30,message="Máximo 30 caracteres")
	@Column(name="usr_nombre", length = 30, nullable = false)
	private String nombre;
	
	@NotEmpty(message="el campo apellido no puede estar vacio")
	@Pattern(regexp = "^[\\p{L} ]+$", message = "El apellido solo puede contener letras y espacios")
	@Size(max=30,message="Máximo 30 caracteres")
	@Column(name="usr_apellido", length = 30, nullable = false)
	private String apellido;
	
	@Email(message="Debe ingresar un email con formato válido")
	@NotEmpty(message="El correo no puede ser vacio")
	@Size(max=30,message="Máximo 30 caracteres")
	@Column(name="usr_email", length= 30, nullable = false)
	private String email;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@NotNull(message="La fecha no puede ser vacia")
	@Past(message="La fecha debe ser menor a la fecha actual")
	@Column(name="usr_fechaNacimiento")
	private LocalDate fechaNacimiento;
	
	@NotEmpty(message="el teléfono no puede estar vacio")
	@Pattern(regexp = "[0-9][0-9][0-9]+-+[0-9][0-9][0-9][0-9][0-9][0-9][0-9]", 
	 message = "Ingrese un número de teléfono válido Ej: (011-1234567)")
	@Size(min=11 , max=11, message="El telefono tiene que tener 11 digitos incluyendo guión")
	@Column(name="usr_telefono", length = 11, nullable = false)
	private String telefono;
	
	@NotEmpty(message="Debe seleccionar un sexo")
	@Column(name="usr_sexo", length = 30, nullable = false)
	private String sexo;
	
	@NotNull(message = "La estatura no puede estar vacía")
	@DecimalMin(value = "1.40", inclusive = true, message = "La estatura mínima permitida es 1.20 metros")
	@DecimalMax(value = "2.30", inclusive = true, message = "La estatura máxima permitida es 2.20 metros")
	private double estatura;
	
	@Column(name="usr_estado")
	private boolean estado;
	
	@Column(name="usr_es_admin")
	private boolean rolUsuario; /*Esto indica si es admin o no
	
	/**
	 * Constructor por defecto
	 */
	public Usuario() {
		
	}
	
	/**
	 * Constructor parametrizado
	 * @param nombre
	 * @param apellido
	 * @param email
	 * @param fechaNacimiento
	 * @param telefono
	 * @param sexo
	 * @param estatura
	 */
	public Usuario(Long id, String nombre, String apellido, String email, LocalDate fechaNacimiento, String telefono,
			String sexo, double estatura, boolean estado, boolean rolUsuario) {
		super();
		this.id=id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.telefono = telefono;
		this.sexo = sexo;
		this.estatura = estatura;
		this.estado=estado;
		this.rolUsuario=rolUsuario;
	}

	/**
	 * Obtiene nombre
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Setea nombre
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene apellido
	 * @return apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * Setea apellido
	 * @param apellido
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * Obtiene email
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setea email
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Obtiene fechaNacimiento
	 * @return
	 */
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * Setea fechaNacimiento
	 * @param fechaNacimiento
	 */
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * Obtiene telefono
	 * @return telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Setea telefono
	 * @param telefono
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * Obtiene sexo
	 * @return sexo
	 */
	public String getSexo() {
		return sexo;
	}

	/**
	 * Setea sexo
	 * @param sexo
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	/**
	 * Obtiene estatura
	 * @return estatura
	 */
	public double getEstatura() {
		return estatura;
	}

	/**
	 * Setea estatura
	 * @param estatura
	 */
	public void setEstatura(double estatura) {
		this.estatura = estatura;
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
	 * Obtiene estado
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
	 * Obtiene rol de usuario
	 * @return rolUsuario
	 */
	public boolean isRolUsuario() {
		return rolUsuario;
	}

	/**
	 * Setea rolUsuario
	 * @param rolUsuario
	 */
	public void setRolUsuario(boolean rolUsuario) {
		this.rolUsuario = rolUsuario;
	}
	
	/**
	 * Método para calcular la edad de un usuario
	 * @return edadUsuario
	 */
	public byte calcularEdadUsuario() {
		LocalDate fechaActual = LocalDate.now();
		byte edadUsuario;
		Period periodo = Period.between(fechaNacimiento, fechaActual);
		edadUsuario = (byte) (periodo.getYears());
		return edadUsuario;
	}

	
}