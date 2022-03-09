package Colecciones;


import java.sql.Date;
import java.util.ArrayList;
import java.util.Comparator;

import ClaseElemento.Comic;
import ClaseElemento.Elemento;
import ClaseElemento.Libro;
import ClaseElemento.Manga;
import ClaseElemento.Revista;
import ClasesMerchandising.Carta;
import ClasesMerchandising.Figura;
import ClasesMerchandising.JuegoDeMesa;
import ClasesMerchandising.Remera;
import Interfaces.IColecciones;

public class Catalogo<T extends Comparable<T>> implements IColecciones<T>{

	private ArrayList<Elemento> listaElemento;
	
	public Catalogo() {
		listaElemento= new ArrayList<>();
	}

	/**
	* Agrega un elemento a la lista
	* @param El elemento a agregar
	*/
	@Override
	public void agregarObjLista(T obj) {
		listaElemento.add((Elemento) obj);
	}
	
	/**
	* Devuelve la cantidad de elementos del catalogo
	* @return cantidad de elementos
	*/
	public int cantidad()
	{
		return listaElemento.size();
	}
	
	/**
	 * Elimina un objeto de la lista y tira una excepcion si no existe
	 */
	
	@Override
	public void eliminarObjLista(T obj) throws Exception {
		boolean algo=listaElemento.remove(obj);
		if(algo==false)
		{
			throw new Exception("Objeto no esta en la lista");
		}
	}
	
	/**
	 * Buscar un productor por codigo de barra y retorna el objeto
	 * @param codigoBarra
	 * @return objeto
	 */
	public Elemento buscarObjeto(int codigoBarra) {
		Elemento aux=null;
		for(int i=0;i<listaElemento.size();i++) {
			if(listaElemento.get(i).getCodigoBarra()==codigoBarra) {
				return listaElemento.get(i);
			}
		}
		return aux;		
	}
	
	/**
	 * Muestra el elemento solicitada
	 * @param el elemento a buscar
	 * @return El string con los datos del elemento
	 */
	@Override
	public String mostrarObjLista(T obj) {
		Elemento elemento= (Elemento) obj;
		StringBuilder sb= new StringBuilder();
		for(int i=0;i<listaElemento.size();i++) {
			if(elemento.getCodigoBarra()==listaElemento.get(i).getCodigoBarra()) {
				sb.append(listaElemento.get(i).toString()+"\n");
			}
		}
		return sb.toString();
	}

	/**
	 * Muestra la lista completa de elementos
	 * @return El string con los datos
	 */
	@Override
	public String mostrarLista() {
		StringBuilder sb= new StringBuilder();
		for(int i=0;i<listaElemento.size();i++) {
			sb.append(listaElemento.get(i).toString()+"\n");
		}
		return sb.toString();
	}
	
	/**
	 * Devuelve true si hay stock del producto
	 * @return true si encuentra el codigo de barra
	 */
	public boolean isStock(int codBarra) {
		for(int i=0;i<listaElemento.size();i++) {
			if( (listaElemento.get(i).getStock() > 0 ) && 
				(listaElemento.get(i).getCodigoBarra()==codBarra) )
			{
				return true;
			}	
		}
		return false;
	}
	
	/**
	 * Reduce el stock del elemento en 1 buscandolo por codigo de barra
	 * @param codBarra
	 */
	public void reducirStock(int codBarra)  {
		for (int i=0;i<listaElemento.size();i++) {
			if(listaElemento.get(i).getCodigoBarra()== codBarra) {
				listaElemento.get(i).reducirStock();
			}
		}
	}
	
	/**
	 * Ordena los elementos de la lista catalogo por numero de codigo de barra
	 */
	@Override
	public void ordenarLista() {
		listaElemento.sort(null);
	}

	@Override
	public void guardarListaArchivo() {
	}

	@Override
	public void cargarListaArchivo() {
	}
	
}
