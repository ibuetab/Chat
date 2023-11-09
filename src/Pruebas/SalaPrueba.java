package Pruebas;

import Entidades.Mensaje;
import Entidades.Sala;
import Entidades.Usuario;

public class SalaPrueba {
	
	public static void main (String[] args) {
		Sala sala =  new Sala(1L, "Principal");
		Usuario usuario = new Usuario("Asasa");
		
		sala.addUser(usuario);
		sala.addMessage(new Mensaje("Hola", usuario));
		
		
		
		
		
	}
	
}
