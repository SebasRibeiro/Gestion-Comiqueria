package Excepciones;

public class PassIncorrectExcepcion extends RuntimeException {

	private static final long serialVersionUID = 1L;

	//private String contrase�a;
	
	@Override
	public String getMessage() {
		
		return "Contrase�a o Usuario incorrecto, intente nuevamente...";
	}
	
}
