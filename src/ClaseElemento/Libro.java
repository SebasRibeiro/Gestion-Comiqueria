package ClaseElemento;

import java.io.Serializable;
import java.util.Date;

public class Libro extends Elemento implements Serializable{

	private String nombre;
	private String editorial;
	private String genero;
	private Date fechaPublicacion;
	private String idioma;
	private int volumen;
	private String tipoTapa;
	private String formato;
	
	public Libro(int codigoBarra, double precio, int stock, String procedencia, String nombre, String editorial,
			String genero, Date fechaPublicacion, String idioma, int volumen, String tipoTapa, String formato) {
		super(codigoBarra, precio, stock, procedencia);
		this.nombre = nombre;
		this.editorial = editorial;
		this.genero = genero;
		this.fechaPublicacion = fechaPublicacion;
		this.idioma = idioma;
		this.volumen = volumen;
		this.tipoTapa = tipoTapa;
		this.formato = formato;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public int getVolumen() {
		return volumen;
	}

	public void setVolumen(int volumen) {
		this.volumen = volumen;
	}

	public String getTipoTapa() {
		return tipoTapa;
	}

	public void setTipoTapa(String tipoTapa) {
		this.tipoTapa = tipoTapa;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	@Override
	public String toString() {
		return super.toString() +  "Libro: nombre: " + nombre + ", editorial: " + editorial + ", genero: " + genero + ", fechaPublicacion: "
				+ fechaPublicacion + ", idioma: " + idioma + ", volumen: " + volumen + ", tipoTapa: " + tipoTapa
				+ ", formato: " + formato;
	}
	
}
