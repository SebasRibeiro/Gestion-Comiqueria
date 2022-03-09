package ClasePersonas;

import java.io.Serializable;

import ClaseElemento.Elemento;
import Colecciones.CarroCompra;
import Colecciones.Catalogo;

public class Cliente extends Persona implements Serializable {

	private int sistemaPuntos;
	CarroCompra<Elemento> carrito;

	public Cliente() {
		super();
		this.sistemaPuntos = 0;
		this.carrito = new CarroCompra<>();
	}
	
	public Cliente(String nombre, String apellido, String telefono, int id, int sistemaPuntos) {
		super(nombre, apellido, telefono, id);
		this.sistemaPuntos = sistemaPuntos;
		this.carrito = new CarroCompra<>();
	}

	public int getSistemaPuntos() {
		return sistemaPuntos;
	}

	public void setSistemaPuntos(int sistemaPuntos) {
		this.sistemaPuntos = sistemaPuntos;
	}

	/**
	 * Agrega un obj del catalogo al carrito de compra usando la funcionalidad de la
	 * lista CarroCompra
	 * 
	 * @param catalogo
	 * @param codigoBarra
	 * @throws Exception
	 * @return true si hay stock y false si no hay stock
	 */
	public boolean agregarCompra(Catalogo catalogo, int codigoBarra) throws Exception {
		boolean tag=false;
		if(catalogo.isStock(codigoBarra)) {
			carrito.reducirStockEnLista(catalogo,codigoBarra);
			carrito.agregarObjLista(catalogo.buscarObjeto(codigoBarra));
			tag=true;
		}	
		return tag;
	}

	/**
	 * Muestra el carro de compra
	 * 
	 * @return String del carrito de compra
	 */
	public String mostrarCarritoCliente() {
		return carrito.mostrarLista();
	}

	/**
	 * Usa la funcionalidad de calcular el precio de los productos dentro de la
	 * lista de la clase carrito
	 * 
	 * @return
	 */
	public double calcPrecioTotal() {
		return carrito.precioTotalCompra();
	}

	@Override
	public String toString() {
		return super.toString() + "Cliente: sistemaPuntos: " + sistemaPuntos;
	}

	/**
	 * Suma puntaje en base al total gastado por el cliente
	 * 
	 * @param gastado
	 */
	public void sumarPuntaje(double gastado) {
		if (gastado > 0 && gastado < 1000) {
			this.sistemaPuntos = this.sistemaPuntos + 100;
		} else {
			if (gastado > 1000 && gastado < 2000) {
				this.sistemaPuntos = this.sistemaPuntos + 200;
			} else {
				this.sistemaPuntos = this.sistemaPuntos + 500;
			}
		}
	}

	/**
	 * Devuelve el porcentage de descuento en base a los puntos del cliente
	 * @param int puntos disponibles
	 * @return int descuento
	 */
	public int calcularDescuento(int puntos) {
		int descuento=0;
		if(this.sistemaPuntos>=1000) {
			descuento=10;
		}
			return descuento;
	}
	
	/**
	 * Aplica el cambio de puntos gastado por el cliente
	 * 
	 */
	public void gastarPuntos() {
		if(this.sistemaPuntos>1000) {
		this.sistemaPuntos = this.sistemaPuntos-1000;
		}
	}

	/**
	 * Devuelve true si el cliente tiene puntos disponibles
	 * @retur Boolean
	 */
	public boolean ifPuntos() {
		boolean tienePuntos = false;
		if (this.sistemaPuntos >= 1000) {
			tienePuntos = true;
		}
		return tienePuntos;
	}

	/**
	 * Devuelve el carro del cliente
	 */
	public CarroCompra devolverCarrito() {
		return this.carrito;
	}

	/**
	 * Vacia el carro de compra una vez hecha la compra
	 */
	public void vaciarCarrito() {
		this.carrito.vaciarCarro();
	}
	
}
