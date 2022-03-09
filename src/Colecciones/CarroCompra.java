package Colecciones;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashSet;

import ClaseElemento.Elemento;
import Interfaces.IColecciones;

public class CarroCompra<T> implements IColecciones<T> , Serializable {
	
	LinkedHashSet<Elemento> carrito;
	
	public CarroCompra() {
		carrito= new LinkedHashSet<>();
	}
	
	/**
	* Agrega un cliente a la lista
	* @param la persona a agregar
	*/
	@Override
	public void agregarObjLista(T obj) {
		carrito.add((Elemento) obj);
	}

	/**
	* Elimina el carro de la lista
	* @param El carro a eliminar
	*/
	@Override
	public void eliminarObjLista(T obj) {
		carrito.remove(obj);
	}

	/**
	* Muestra el carro de la lista
	* @param El carro a mostrar
	*/
	@Override
	public String mostrarObjLista(T obj) {
		Elemento elemento= (Elemento) obj;
		Iterator<Elemento> it= carrito.iterator();
		StringBuilder sb= new StringBuilder();
		while(it.hasNext()){
			if(elemento.getCodigoBarra()==it.next().getCodigoBarra()) {
				sb.append(it.next().toString()+"\n");
			}
		}
		return sb.toString();
	}

	/**
	* Muestra la lista completa de carrito
	* @return La lista completa en formato String
	*/
	@Override
	public String mostrarLista() {
		Iterator<Elemento> it= carrito.iterator();
		StringBuilder sb= new StringBuilder();
		while(it.hasNext()) {
			sb.append(it.next().toString()+"\n");
			}
		return sb.toString();
	}

	/**
	 * Reduce el stock del articulo del carrito de compra
	 * @param idProducto
	 * @throws Exception 
	 */
	public boolean reducirStockEnLista(Catalogo catalogo,int idProducto) throws Exception {
		boolean tag= false;
		Iterator<Elemento>it= carrito.iterator();
		Elemento aux;
		while(it.hasNext()) {
			aux=it.next();
			if(aux.getCodigoBarra()==idProducto) {
				if(aux.getStock()<1) {
					tag=true;
					throw new Exception ("Error, ya no queda stock del producto");
				}
				else {
				it.next().reducirStock();
				}
			}
		}
		return tag;
	}
	
	/**
	 * Recorre la lista compra y va sumando el precio de los elementos
	 * @return la suma total
	 */	
	public double precioTotalCompra() {
		Iterator<Elemento>it=carrito.iterator();
		double suma=0;
		while(it.hasNext()) {
		suma=suma +it.next().getPrecio();
		}
		return suma;
	}
	
	public void vaciarCarro() {
		carrito.removeAll(carrito);
	}
	
	@Override
	public void ordenarLista() {
	}


	@Override
	public void guardarListaArchivo() {
	}

	@Override
	public void cargarListaArchivo() {	
	}
		
}
