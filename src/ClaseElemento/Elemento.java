package ClaseElemento;

import java.io.Serializable;

import Excepciones.OutOfStockException;

public class Elemento implements Serializable,Comparable {
	
	private int codigoBarra;
	private double precio;
	private int stock;
	private String procedencia;
	
	public Elemento(int codigoBarra, double precio, int stock, String procedencia) {
		super();
		this.codigoBarra = codigoBarra;
		this.precio = precio;
		this.stock = stock;
		this.procedencia = procedencia;
	}

	public int getCodigoBarra() {
		return codigoBarra;
	}

	public void setCodigoBarra(int codigoBarra) {
		this.codigoBarra = codigoBarra;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getProcedencia() {
		return procedencia;
	}

	public void setProcedencia(String procedencia) {
		this.procedencia = procedencia;
	}
	
	/**
	 * Reduce stock de los productos a medida de que sean consumidos
	 * @return boolean dependiente si queda o no stock, true si queda sotck y false si no queda.
	 * @throws Exception 
	 */
	public void reducirStock() throws OutOfStockException {
			if(this.stock >0) {
			this.stock= this.stock-1;
			}else {
				throw new OutOfStockException();
			}
	}

	@Override
	public String toString() {
		return "Elemento: codigoBarra: " + codigoBarra + ", precio: " + precio + ", stock: " + stock + ", procedencia: "
				+ procedencia;
	}

	@Override
	public int compareTo(Object o) {
		Elemento elemento = (Elemento)o;
		if(getCodigoBarra()> elemento.getCodigoBarra()) return 1;
		else if(elemento.getCodigoBarra() > getCodigoBarra()) return -1;
		else return 0;
	}
	
}
