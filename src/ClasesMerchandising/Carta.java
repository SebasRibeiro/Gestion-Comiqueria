package ClasesMerchandising;

import java.io.Serializable;

public class Carta extends Merchandising implements Serializable {
	
	private String marca;
	private String modelo;
	private boolean folio;
	private String tipoRareza;

	public Carta(int codigoBarra, double precio, int stock, String procedencia, String descripcion, String fabricante,
			String marca, String modelo, boolean folio, String tipoRareza) {
		super(codigoBarra, precio, stock, procedencia, descripcion, fabricante);
		this.marca = marca;
		this.modelo = modelo;
		this.folio = folio;
		this.tipoRareza = tipoRareza;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public boolean isFolio() {
		return folio;
	}

	public void setFolio(boolean folio) {
		this.folio = folio;
	}

	public String getTipoRareza() {
		return tipoRareza;
	}

	public void setTipoRareza(String tipoRareza) {
		this.tipoRareza = tipoRareza;
	}

	@Override
	public String toString() {
		return super.toString() +  "Carta: marca: " + marca + ", modelo: " + modelo + ", folio: " + folio + ", tipoRareza: " + tipoRareza;
	}
	
}
