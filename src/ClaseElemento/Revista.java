package ClaseElemento;

import java.io.Serializable;
import java.util.Date;

public class Revista extends Libro implements Serializable {
	
	private String categoria;

	public Revista(int codigoBarra, double precio, int stock, String procedencia, String nombre, String editorial,
			String genero, Date fechaPublicacion, String idioma, int volumen, String tipoTapa, String formato,
			String categoria) {
		super(codigoBarra, precio, stock, procedencia, nombre, editorial, genero, fechaPublicacion, idioma, volumen,
				tipoTapa, formato);
		this.categoria = categoria;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return super.toString() + "Revista: categoria: " + categoria;
	}
	
}
