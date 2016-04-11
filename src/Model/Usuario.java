package Model;

public class Usuario {
	
	private String nombre;
	private String password;
	private boolean userLoaded;
	
	private static Usuario mUsuario;

	private Usuario() {
		if(mUsuario==null){
			mUsuario = new Usuario();
			checkUserLoaded();
		}
	}

	public static Usuario getUsuario() {
		return mUsuario;
	}
	
	public void setUsuario(String pNombre){
		nombre = pNombre;
		checkUserLoaded();
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public void setPassword(String pPassword){
		password = pPassword;
		checkUserLoaded();
	}
	
	public String getPassword(){
		return password;
	}
	
	private void checkUserLoaded(){
		if(nombre!=null && password!=null)
			userLoaded = true;
		else
			userLoaded = false;
	}
	
	public boolean getUserLoaded(){
		return userLoaded;
	}

}
