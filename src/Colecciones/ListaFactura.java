package Colecciones;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import ClasePersonas.Factura;
import ClasePersonas.Persona;
import Interfaces.IColecciones;

public class ListaFactura<T> implements IColecciones<T> {

	HashMap<Integer, Factura> listaFacturas;

	public ListaFactura() {
		listaFacturas = new HashMap<>();
	}

	/**
	 * Agrega una factura a la lista
	 * @param La factura a agregar
	 */
	@Override
	public void agregarObjLista(T obj) {
		Factura factura = (Factura) obj;
		if (!listaFacturas.containsKey(factura.getIdFactura())) {
			listaFacturas.put(factura.getIdFactura(), factura);
		} else {
			listaFacturas.replace(factura.getIdFactura(), listaFacturas.get(factura.getIdFactura()));
		}
	}

	/**
	 * Elimina una factura en particular
	 * @param La factura a eliminar
	 */
	@Override
	public void eliminarObjLista(T obj) {
		Factura factura = (Factura) obj;
		listaFacturas.remove(factura.getIdFactura());
	}

	/**
	 * Elimina una factura en particular
	 * @param El id factura a eliminar
	 */
	public void buscarYeliminarObj(int id) {
		listaFacturas.remove(id);
	}

	/**
	 * Muestra una factura en particular
	 * @param la factura a busar
	 * @return la factura en formato string
	 */
	@Override
	public String mostrarObjLista(T obj) {
		Factura factura = (Factura) obj;
		Iterator<Entry<Integer, Factura>> it = listaFacturas.entrySet().iterator();
		StringBuilder sb = new StringBuilder();
		while (it.hasNext()) {
			Entry<Integer, Factura> entry = (Entry<Integer, Factura>) it.next();
			if (entry.getKey() == factura.getIdFactura()) {
				sb.append(entry.getKey() + "/" + entry.getValue().toString() + "\n");
			}
		}
		return sb.toString();
	}

	/**
	 * Muestra la lista de facturas
	 */
	@Override
	public String mostrarLista() {

		Iterator<Entry<Integer, Factura>> it = listaFacturas.entrySet().iterator();
		StringBuilder sb = new StringBuilder();
		while (it.hasNext()) {
			Entry<Integer, Factura> entry = (Entry<Integer, Factura>) it.next();
			sb.append(entry.getKey() + "/" + entry.getValue().toString() + "\n");
		}
		return sb.toString();
	}

	/**
	 * Guarda la informacion de las facturas en un archivo .bin
	 */
	
	@Override
	public void guardarListaArchivo() {
		FileOutputStream archi = null;
		try {
			archi = new FileOutputStream("ListaFacturas.bin");
			ObjectOutputStream camino = new ObjectOutputStream(archi);
			Iterator<Entry<Integer, Factura>> it = listaFacturas.entrySet().iterator();
			while (it.hasNext()) {
				Entry<Integer, Factura> entry = (Entry<Integer, Factura>) it.next();
				camino.writeObject(entry.getValue());
			}
			camino.close();
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado");
		} catch (IOException e) {
		}
		finally {
			try {
				archi.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	/**
	 * Carga la informacion del archivo .bin y lo guarda en la lista de facturas
	 */
	@Override
	public void cargarListaArchivo() {
		FileInputStream archi = null;
		try {
			archi = new FileInputStream("ListaFacturas.bin");
			ObjectInputStream camino = new ObjectInputStream(archi);
			Factura factura;
			while ((factura = (Factura) camino.readObject()) != null) {
				listaFacturas.put(factura.getIdFactura(), factura);
				System.out.println(factura);
			}
			camino.close();
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado");
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			try {
				archi.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void ordenarLista() {
	}

}
