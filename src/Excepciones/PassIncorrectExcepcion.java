package Excepciones;

public class PassIncorrectExcepcion extends RuntimeException {

	private static final long serialVersionUID = 1L;

	//private String contraseña;
	
	@Override
	public String getMessage() {
		
		return "Contraseña o Usuario incorrecto, intente nuevamente...";
	}
	
}
