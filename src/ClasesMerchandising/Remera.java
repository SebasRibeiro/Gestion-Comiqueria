package ClasesMerchandising;

import java.io.Serializable;

public class Remera extends Merchandising implements Serializable {

	
	private String marca;
	private String modelo;
	private char genero;
	private String tipoDeManga;
	private String tipoDeCuello;

	public Remera(int codigoBarra, double precio, int stock, String procedencia, String descripcion, String fabricante,
			String marca, String modelo, char genero, String tipoDeManga, String tipoDeCuello) {
		super(codigoBarra, precio, stock, procedencia, descripcion, fabricante);
		this.marca = marca;
		this.modelo = modelo;
		this.genero = genero;
		this.tipoDeManga = tipoDeManga;
		this.tipoDeCuello = tipoDeCuello;
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

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	public String getTipoDeManga() {
		return tipoDeManga;
	}

	public void setTipoDeManga(String tipoDeManga) {
		this.tipoDeManga = tipoDeManga;
	}

	public String getTipoDeCuello() {
		return tipoDeCuello;
	}


	public void setTipoDeCuello(String tipoDeCuello) {
		this.tipoDeCuello = tipoDeCuello;
	}


	@Override
	public String toString() {
		return super.toString() + "Remera: marca: " + marca + ", modelo: " + modelo + ", genero: " + genero + ", tipoDeManga: " + tipoDeManga
				+ ", tipoDeCuello: " + tipoDeCuello + "]";
	}

}
