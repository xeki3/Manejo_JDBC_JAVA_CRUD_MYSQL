package test;


import java.util.List;

import datos.UsuarioJDBC;
import domain.Usuario;

public class ManejoUsuarios {

	public static void main(String[] args) {
	
		UsuarioJDBC usuario = new UsuarioJDBC();
				
	//Usuario user = new Usuario("Javiera", "2012");
		
	//	usuario.insert(user);
		
		List<Usuario>  usuarios = usuario.select();

		//System.out.println(usuario.select().toString());
		
		for(Usuario user1 : usuarios){
			System.out.println(user1.toString());
		}
//		
		Usuario user2 = new Usuario();
//		user2.setId_usuario(2);
//		user2.setUsuario("Belen");
//		user2.setPassword("bb");
//		usuario.update(user2);
//		System.out.println(usuario.update(user2));
		
		user2.setId_usuario(3);
		usuario.delete(user2);
		
		List<Usuario>  usuarios3 = usuario.select();
		
		for(Usuario user3 : usuarios3){
			System.out.println(user3.toString());
		}
		
	}

}