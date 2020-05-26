package domain;

public class Usuario {

private int id_usuario;
private String usuario; 
private String password;

public Usuario() {
	super();
}

public Usuario(int id_usuario, String usuario, String password) {
	super();
	this.usuario = usuario;
	this.password = password;
	this.id_usuario = id_usuario;
}

public Usuario(String usuario, String password) {
	super();
	this.usuario = usuario;
	this.password = password;
}

public String getUsuario() {
	return usuario;
}

public void setUsuario(String usuario) {
	this.usuario = usuario;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public int getId_usuario() {
	return id_usuario;
}

public void setId_usuario(int id_usuario) {
	this.id_usuario = id_usuario;
}

@Override
public String toString() {
	return "Usuario [usuario=" + usuario + ", password=" + password + "]";
}


	
}
