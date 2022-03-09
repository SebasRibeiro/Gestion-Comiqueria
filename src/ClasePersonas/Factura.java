package ClasePersonas;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;

import ClaseElemento.Elemento;
import Colecciones.CarroCompra;

public class Factura implements Serializable {

	private int idFactura;
	private int idCliente;
	CarroCompra<Elemento> carrito;
	private Date fechaEmisi�n;
	private float Total;
	
	public Factura( int idCliente, CarroCompra carrito, Date fechaEmisi�n, float total) {
		super();
		this.idFactura=generarIdAleatorio() ;
		this.idCliente = idCliente;
		carrito=new CarroCompra();
		this.fechaEmisi�n = fechaEmisi�n;
		Total = total;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public Date getFechaEmisi�n() {
		return fechaEmisi�n;
	}

	public void setFechaEmisi�n(Date fechaEmisi�n) {
		this.fechaEmisi�n = fechaEmisi�n;
	}

	public float getTotal() {
		return Total;
	}

	public void setTotal(float total) {
		Total = total;
	}

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	/**
	 * Genera aleatoriamente un numero para el ID 
	 * @return int ID
	 */
	public int generarIdAleatorio() {
		int id=0;
		id=(int)(Math.random()*100000+1);
		return id;
	}

	@Override
    public String toString() {
        return "Factura: " + ", idCliente: " + idCliente 
                + ", fechaEmisi�n: " + fechaEmisi�n + ", Total: " + Total;
    }
	
	public String toStringCarrito(CarroCompra miCarrito) {
		return miCarrito.mostrarLista();
	}
	
}
