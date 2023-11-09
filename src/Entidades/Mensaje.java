package Entidades;

import java.util.Objects;

public class Mensaje {
 private Long id; //Id del propio mensaje
 private String texto;
 
 private Usuario usuario;
 
//---------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------
 
 public Mensaje(Long id, String texto, Usuario usuario) {
		setId(id);
		setTexto(texto);
		setUsuario(usuario);
	}
 
 public Mensaje(String texto, Usuario usuario) {
	 this(null, texto, usuario);
 }
 
 public Mensaje (Mensaje mensaje) {
	 this(mensaje.getId(), mensaje.getTexto(), mensaje.getUsuario());
 }

//---------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------
public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getTexto() {
	return texto;
}

public void setTexto(String texto) {
	if(texto == null || texto.trim().length() == 0) {
		throw new RuntimeException("No se admiten textos vacíos");
	}
	this.texto = texto;
}

public Usuario getUsuario() {
	return usuario;
}

public void setUsuario(Usuario usuario) {
	if(usuario == null) {
		throw new RuntimeException("El usuario no puede estar vacío");
	}
	this.usuario = usuario;
}

//---------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------
@Override
public String toString() {
	return "Mensaje [id=" + id + ", texto=" + texto + ", usuario=" + usuario + "]";
}

//---------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------
@Override
public int hashCode() {
	return Objects.hash(id, texto, usuario);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Mensaje other = (Mensaje) obj;
	return Objects.equals(id, other.id) && Objects.equals(texto, other.texto) && Objects.equals(usuario, other.usuario);
}


 
 
}
