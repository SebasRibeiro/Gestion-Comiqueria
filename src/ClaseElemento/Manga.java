package ClaseElemento;

import java.io.Serializable;
import java.util.Date;

public class Manga extends Libro implements Serializable{

	private String revista;
	private String mangaka;
	private String dibujante;
	
	public Manga(int codigoBarra, double precio, int stock, String procedencia, String nombre, String editorial,
			String genero, Date fechaPublicacion, String idioma, int volumen, String tipoTapa, String formato,
			String revista, String mangaka, String dibujante) {
		super(codigoBarra, precio, stock, procedencia, nombre, editorial, genero, fechaPublicacion, idioma, volumen,
				tipoTapa, formato);
		this.revista = revista;
		this.mangaka = mangaka;
		this.dibujante = dibujante;
	}

	public String getRevista() {
		return revista;
	}

	public void setRevista(String revista) {
		this.revista = revista;
	}

	public String getMangaka() {
		return mangaka;
	}

	public void setMangaka(String mangaka) {
		this.mangaka = mangaka;
	}

	public String getDibujante() {
		return dibujante;
	}

	public void setDibujante(String dibujante) {
		this.dibujante = dibujante;
	}

	@Override
	public String toString() {
		return super.toString() + "Manga:  revista: " + revista + ", mangaka: " + mangaka + ", dibujante: " + dibujante;
	}
	
}
