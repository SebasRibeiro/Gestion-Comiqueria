package Excepciones;

public class OutOfStockException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		
		return "no hay stock";
	}
	
}
