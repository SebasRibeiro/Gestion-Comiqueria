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
	private Date fechaEmisión;
	private float Total;
	
	public Factura( int idCliente, CarroCompra carrito, Date fechaEmisión, float total) {
		super();
		this.idFactura=generarIdAleatorio() ;
		this.idCliente = idCliente;
		carrito=new CarroCompra();
		this.fechaEmisión = fechaEmisión;
		Total = total;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public Date getFechaEmisión() {
		return fechaEmisión;
	}

	public void setFechaEmisión(Date fechaEmisión) {
		this.fechaEmisión = fechaEmisión;
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
                + ", fechaEmisión: " + fechaEmisión + ", Total: " + Total;
    }
	
	public String toStringCarrito(CarroCompra miCarrito) {
		return miCarrito.mostrarLista();
	}
	
}
