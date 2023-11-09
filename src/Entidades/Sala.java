package Entidades;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class Sala {
	private Long id; //Id de la Sala
	private String nombre;
	
	private TreeMap<Long, Usuario> usuarios = new TreeMap<>();	
	private TreeMap<Long, Mensaje> mensajes = new TreeMap<>();
	
	
	//No hace falta constructor ni métodos para mensajes y usuarios porque ya son colecciones, se supone que se van a añadiendo
	
	
	public Sala(Long id, String nombre) {	
		setId(id);
		setNombre(nombre);
	}

	//---------------------------------------------------------------------------------------------------------
	//---------------------------------------------------------------------------------------------------------

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		if(nombre == null || nombre.trim().length()==0) {
			throw new RuntimeException("El nombre no puede estrar vacío");
		}
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	//---------------------------------------------------------------------------------------------------------
	//---------------------------------------------------------------------------------------------------------

	@Override
	public int hashCode() {
		return Objects.hash(id, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sala other = (Sala) obj;
		return Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Sala [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
	public void addUser(Usuario usuario) {
		Long id = usuarios.size() > 0 ? usuarios.lastKey() + 1L : 1L;
		usuario.setId(id);
		usuarios.put(id, usuario);
	}
	
	public void addMessage(Mensaje mensaje) {
		Long id = mensajes.size() > 0 ? mensajes.lastKey() +1L : 1L;
		mensaje.setId(id);
		mensajes.put(id, mensaje);
	}
	
	public Iterable<Mensaje> getMensajes(){
		return mensajes.values();
	}
	
	public Iterable<Usuario> getUsuarios(){
		return usuarios.values();
	}
	
	
	
	
	
	
	
}
