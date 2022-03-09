package ClaseElemento;

import java.io.Serializable;
import java.util.Date;

public class Comic extends Libro implements Serializable {
	
	private String colorista;
	private String guionista;
	
	public Comic(int codigoBarra, double precio, int stock, String procedencia, String nombre, String editorial,
			String genero, Date fechaPublicacion, String idioma, int volumen, String tipoTapa, String formato,
			String colorista, String guionista) {
		super(codigoBarra, precio, stock, procedencia, nombre, editorial, genero, fechaPublicacion, idioma, volumen,
				tipoTapa, formato);
		this.colorista = colorista;
		this.guionista = guionista;
	}

	public String getColorista() {
		return colorista;
	}

	public void setColorista(String colorista) {
		this.colorista = colorista;
	}

	public String getGuionista() {
		return guionista;
	}

	public void setGuionista(String guionista) {
		this.guionista = guionista;
	}
	
	@Override
	public String toString() {
		return super.toString() + "Comic: colorista: " + colorista + ", guionista: " + guionista;
	}
	
}
