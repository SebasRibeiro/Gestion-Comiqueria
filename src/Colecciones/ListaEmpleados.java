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

import ClasePersonas.Empleado;
import ClasePersonas.Persona;
import Interfaces.IColecciones;

public class ListaEmpleados<T> implements IColecciones<T>{

	HashMap<Integer, Empleado>empleados;
	
	
	
	 public ListaEmpleados() {
		empleados= new HashMap<>();
	}
	
	/**
	* Agrega un empleado a la lista
	* @param el cliente a agregar
	*/
	@Override
	public void agregarObjLista(T obj) {
		Empleado empleado=(Empleado) obj; 
		if(!empleados.containsKey(empleado.getId())) {
			empleados.put(empleado.getId(), empleado);
		}
		else {
			empleados.replace(empleado.getId(), empleados.get(empleado.getId()));
		}
		}

	/**
	 * Busca al empleado y lo elimina
	 * @param el empleado
	 */
	@Override
	public void eliminarObjLista(T obj) {
		Empleado empleado=(Empleado) obj;
		empleados.remove(empleado.getId());
	}
	
	/**
	 * Busca al empleado por id y lo elimina
	 * @param el id de empleado
	 */
	public void buscarYeliminarObj(int id) {
		empleados.remove(id);
	}

	/**
	 * Busca un empleado y lo retorna
	 * @param id
	 * @return Empleado con el numero ID
	 */
	@Override
	public String mostrarObjLista(T obj) {
		Empleado empleado= (Empleado) obj;
		Iterator<Entry<Integer, Empleado>>it=empleados.entrySet().iterator();
		StringBuilder sb= new StringBuilder();
		while(it.hasNext()) {
			Entry<Integer, Empleado>entry=  (Entry<Integer, Empleado>)it.next();
			if(entry.getKey()==empleado.getId()) {
				sb.append(entry.getKey()+"/"+entry.getValue().toString()+"\n");
			}
		}
		return sb.toString();
	}

	/**
	 * Busca un empleado por numero ID y lo retorna
	 * @param id
	 * @return Empleado con el numero ID
	 */
	 public Persona retornarEmpleado(int id) {
		Iterator<Entry<Integer, Empleado>>it=empleados.entrySet().iterator();
	    Empleado empleado= new Empleado();
	    while(it.hasNext()) 
	    {
	    	Entry<Integer, Empleado>entry=  (Entry<Integer, Empleado>)it.next();
	    	if(id==entry.getKey())
	        {
	    		empleado=entry.getValue();
	        }
	    }
	    return empleado;
	}
	
	/**
	 * Recorre la lista y la muestra 
	 * @return el String con los datos
	 */
	@Override
	public String mostrarLista() {
		Iterator<Entry<Integer, Empleado>> it= empleados.entrySet().iterator();
		StringBuilder sb= new StringBuilder();
		while(it.hasNext()) {
			Entry<Integer, Empleado>entry= (Entry<Integer, Empleado>)it.next();
			sb.append(entry.getKey() + "/"+entry.getValue().toString()+"\n");
		}	
		return sb.toString();
	}
		
	/**
	 * Recorre la lista y muestra solo el nombre y apellido del empleado
	 * @return el String con el nombre y apellido
	 */
	public String mostrarApYNomLista() {
		Iterator<Entry<Integer, Empleado>> it= empleados.entrySet().iterator();
		StringBuilder sb= new StringBuilder();
		while(it.hasNext()) {
			Entry<Integer, Empleado>entry= (Entry<Integer, Empleado>)it.next();
			sb.append(entry.getKey() + "/"+entry.getValue().mostrarNomYAp()+"\n");	
		}
		return sb.toString();
	}
	
	@Override
	public void ordenarLista() {
	}

	/**
	 * Guarda en un archivo .bin la informacion de la lista empleados
	 */
	@Override
	public void guardarListaArchivo() {
		FileOutputStream archi = null;
	    try {
	    	archi = new FileOutputStream("empleados.bin");
	    	ObjectOutputStream camino = new ObjectOutputStream(archi);
	        Iterator<Entry<Integer, Empleado>>it=empleados.entrySet().iterator();
	        while(it.hasNext()) 
	        {
	        	Entry<Integer, Empleado>entry=  (Entry<Integer, Empleado>)it.next();
	            camino.writeObject(entry.getValue());
	        }
	        camino.close();
	        }catch(FileNotFoundException e){
	            System.out.println("Archivo no encontrado");
	        }catch(IOException e){
	        }
	        finally {
	            try {
	            	archi.close();
	            }catch(IOException e) {
	                System.out.println(e.getMessage());
	            }
	        }
	}
		
		
	/*
	 * Carga la informacion del archivo a la lista con objetos tipo Empleado
	 */
	@Override
	public void cargarListaArchivo() {
		FileInputStream archi = null;
		try {
			archi = new FileInputStream("empleados.bin");
	        ObjectInputStream camino = new ObjectInputStream(archi);
	        Empleado empleado;
	        while(  ( empleado = (Empleado)camino.readObject()) != null)
	        {
	         	empleados.put(empleado.getId(), empleado);
	            System.out.println(empleado);
	        }
	        camino.close();
	        }catch(FileNotFoundException e){
	            System.out.println("Archivo no encontrado");
	        }catch(IOException e){
	        }catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	        finally {
	            try {
	                archi.close();
	            }catch(IOException e) {
	                System.out.println(e.getMessage());
	            }
	        }
	}
	
}
