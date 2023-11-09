package Entidades;

import java.time.LocalDateTime;

public class Usuario {
	
	//---------------------------------------------------------------------------------------------------------
	//---------------------------------------------------------------------------------------------------------
	
	//Variables de instancia
	private Long id;
	private String nombreUsuario;
	private LocalDateTime fechaUltimaConexion = LocalDateTime.now(); //Fecha más reciente = Última conexion
	
	//---------------------------------------------------------------------------------------------------------
	//---------------------------------------------------------------------------------------------------------
	
	//Constructores
	public Usuario(Long id, String nombreUsuario, LocalDateTime fechaUltimaConexion) {
		//Sutituir this por setters para mayor eficiencia
		setId(id);
		setNombreUsuario(nombreUsuario);
		setFechaUltimaConexion(fechaUltimaConexion);
	}
	
	//Sobrecarga
	//Permite valores por defecto
	//Van llamando sucesivamente al constructor principal
	
	//Permite pasar el id como null por defecto
	public Usuario(String nombreUsuario, LocalDateTime fechaUltimaConexion) {
		this(null, nombreUsuario, fechaUltimaConexion);
	}
	
	//Permite que solo sea necesario pasar el nombre del usuario
	public Usuario(String nombreUsuario) {
		this(null, nombreUsuario, LocalDateTime.now());
	}
	
	//Permite que no sea obligatorio pasarle ningún valor y pone los mismos por defecto
	public Usuario() {
		this(null, "Anónimo", LocalDateTime.now());
	}
	
	//---------------------------------------------------------------------------------------------------------
	//---------------------------------------------------------------------------------------------------------

	
	//Getters 
	public Long getId() {
		return id;
	}
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	
	public LocalDateTime getFechaUltimaConexion() {
		return fechaUltimaConexion;
	}
	
	
	//Setters
	public void setId(Long id) {
		if(id !=null && id < 0){
			throw new RuntimeException("El id no puede ser menor que 0 ");
		}
		this.id = id;
	}
	
	public void setNombreUsuario(String nombreUsuario) {
		if(nombreUsuario == null) {
			throw new RuntimeException("El nombre no puede estar vacío");
		}
		this.nombreUsuario = nombreUsuario;
	}
	public void setFechaUltimaConexion(LocalDateTime fechaUltimaConexion) {
		if(fechaUltimaConexion.isAfter(LocalDateTime.now()) || fechaUltimaConexion == null) {
			throw new RuntimeException("La fecha no puede ser posterior a la fecha actual ni estar vacía");
		}
		this.fechaUltimaConexion = fechaUltimaConexion;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombreUsuario=" + nombreUsuario + ", fechaUltimaConexion=" + fechaUltimaConexion
				+ "]";
	}
	
	
	//---------------------------------------------------------------------------------------------------------
	//---------------------------------------------------------------------------------------------------------
	
	
}
