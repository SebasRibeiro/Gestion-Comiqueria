package ClasesMerchandising;

import java.io.Serializable;

import ClaseElemento.Elemento;

public class Merchandising extends Elemento implements Serializable {
	
	private String descripcion;
	private String fabricante;

	public Merchandising(int codigoBarra, double precio, int stock, String procedencia, String descripcion,
			String fabricante) {
		super(codigoBarra, precio, stock, procedencia);
		this.descripcion = descripcion;
		this.fabricante = fabricante;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	@Override
	public String toString() {
		return super.toString() + "Merchandising: descripcion: " + descripcion + ", fabricante: " + fabricante;
	}
	
}











