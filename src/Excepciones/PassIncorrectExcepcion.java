package Excepciones;

public class PassIncorrectExcepcion extends RuntimeException {

	private static final long serialVersionUID = 1L;

	//private String contraseņa;
	
	@Override
	public String getMessage() {
		
		return "Contraseņa o Usuario incorrecto, intente nuevamente...";
	}
	
}
