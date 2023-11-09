package Entidades;

import java.time.LocalDateTime;
import java.util.Objects;

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
	
	//Constructor de copia
	public Usuario(Usuario usuario) {
		this(usuario.getId(), usuario.getNombreUsuario(), usuario.getFechaUltimaConexion() );
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
		if(nombreUsuario == null || nombreUsuario.length() == 0  ||nombreUsuario.trim().length()==0) {
			throw new RuntimeException("El nombre no puede estar vacío");
		}
		this.nombreUsuario = nombreUsuario.trim();
	}
	public void setFechaUltimaConexion(LocalDateTime fechaUltimaConexion) {
		if( fechaUltimaConexion == null || fechaUltimaConexion.isAfter(LocalDateTime.now())) {
			throw new RuntimeException("La fecha no puede ser posterior a la fecha actual ni estar vacía");
		}
		this.fechaUltimaConexion = fechaUltimaConexion;
	}
	
	
	//---------------------------------------------------------------------------------------------------------
	//---------------------------------------------------------------------------------------------------------

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombreUsuario=" + nombreUsuario + ", fechaUltimaConexion=" + fechaUltimaConexion
				+ "]";
	}

	
	
	//---------------------------------------------------------------------------------------------------------
	//---------------------------------------------------------------------------------------------------------
	
	@Override
	public int hashCode() {
		return Objects.hash(fechaUltimaConexion, id, nombreUsuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(fechaUltimaConexion, other.fechaUltimaConexion) && Objects.equals(id, other.id)
				&& Objects.equals(nombreUsuario, other.nombreUsuario);
	}
	
	
}
