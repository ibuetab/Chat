package Pruebas;

import Entidades.Usuario;

public class UsuarioPruebas {

	public static void main(String[] args) {
		Usuario usuario  = new Usuario();
		
		//usuario.setFechaUltimaConexion(null);
		
		System.out.println(usuario);
		
		Usuario copia = new Usuario(usuario);
		copia.setId(1L);
		System.out.println(copia);
		
	}

}
