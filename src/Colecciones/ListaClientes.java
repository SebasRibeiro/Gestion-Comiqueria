package Colecciones;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import ClasePersonas.Cliente;
import ClasePersonas.Empleado;
import ClasePersonas.Persona;
import Interfaces.IColecciones;

public class ListaClientes <T> implements IColecciones<T> {

	HashMap<Integer, Cliente>clientes;
	
	
	
	 public ListaClientes() {
		
		 clientes= new HashMap<>();
		
	}
	
	/**
	* Agrega un cliente a la lista
	* @param la persona a agregar
	*/
	@Override
	public void agregarObjLista(T obj) {
		Cliente cliente=(Cliente) obj; 
		if(!clientes.containsKey(cliente.getId())) {
			clientes.put(cliente.getId(), cliente);
		}
		else {
			clientes.replace(cliente.getId(), clientes.get(cliente.getId()));
		}
	}

	/**
	 * Busca al cliente y lo elimina
	 * @param el cliente
	 */
	@Override
	public void eliminarObjLista(T obj) {
		Cliente cliente=(Cliente) obj;
		clientes.remove(cliente.getId());
	}
	
	/**
	 * Busca al cliente por id y lo elimina
	 * @param el id de cliente
	 */
	public void buscarYeliminarObj(int id) {
		clientes.remove(id);
	}

	/**
	 * Muestra el cliente solicitada
	 * @param el cliente a buscar
	 * @return El string con los datos
	 */
	@Override
	public String mostrarObjLista(T obj) {
		Cliente cliente= (Cliente) obj;
		Iterator<Entry<Integer, Cliente>>it=clientes.entrySet().iterator();
		StringBuilder sb= new StringBuilder();
		while(it.hasNext()) {
			Entry<Integer, Cliente>entry=  (Entry<Integer, Cliente>)it.next();
			if(entry.getKey()==cliente.getId()) {
				sb.append(entry.getKey()+"/"+entry.getValue().toString()+"\n");
			}
		}
		return sb.toString();
	}

	/**
	 * Busca Cliente en la lista por id y la retorna 
	 * @param id
	 * @return Cliente encontrado
	 */
	public Cliente retornaCliente(int id) {
		Iterator<Entry<Integer, Cliente>>it=clientes.entrySet().iterator();
		Cliente cliente= new Cliente();
	    while(it.hasNext()) 
       {
       Entry<Integer, Cliente>entry=  (Entry<Integer, Cliente>)it.next();
	   if(id==entry.getKey())
       {
		   cliente=entry.getValue();
       }
       }
	   return cliente;
	}
	
	/**
	 * Devuelve true si el cliente se encuentra en el sistema
	 * @return true si esta en el sistema
	 */
	public boolean isCliente(int id) {
		Iterator<Entry<Integer, Cliente>>it=clientes.entrySet().iterator();
	    Cliente cliente= new Cliente();
	    while(it.hasNext()) 
	    {
	    	Entry<Integer, Cliente>entry=  (Entry<Integer, Cliente>)it.next();
	    	if(id==entry.getKey())
	    	{
	    		return true;
	    	}
	    }
	    return false;
	}
	
	/**
	 * Muestra la lista completa de clientes
	 * @return El string con los datos
	 */
	@Override
	public String mostrarLista() {
		Iterator<Entry<Integer, Cliente>> it= clientes.entrySet().iterator();
		StringBuilder sb= new StringBuilder();
		while(it.hasNext()) {
			Entry<Integer, Cliente>entry= (Entry<Integer, Cliente>)it.next();
			sb.append(entry.getKey() + "/"+entry.getValue().toString()+"\n");
		}	
		return sb.toString();
		}
	
	/**
	 * Muestra los clientes solo por nombre y apellido
	 * @return El string con los datos
	 */
	public String mostrarApYNomLista() {
		Iterator<Entry<Integer, Cliente>> it= clientes.entrySet().iterator();
		StringBuilder sb= new StringBuilder();
		while(it.hasNext()) 
		{
			Entry<Integer, Cliente>entry= (Entry<Integer, Cliente>)it.next();
			sb.append(entry.getKey() + "/"+entry.getValue().mostrarNomYAp()+"\n");	
		}
			return sb.toString();
	}
			
	@Override
	public void ordenarLista() {
	}

	/**
	 * Guarda los CLIENTES del sistema a un archivo .bin
	 */
	@Override
	public void guardarListaArchivo() {
		FileOutputStream archi = null;
	    try {
	    	archi = new FileOutputStream("clientes.bin");
	        ObjectOutputStream camino = new ObjectOutputStream(archi);
	        Iterator<Entry<Integer, Cliente>>it=clientes.entrySet().iterator();
	        while(it.hasNext()) 
	        {
	        	Entry<Integer, Cliente>entry=  (Entry<Integer, Cliente>)it.next();
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
	
	/**
	 * Carga los CLIENTES del archivo .bin en una lista
	 */
	@Override
	public void cargarListaArchivo() {
		FileInputStream archi = null;
	    try {
	    	archi = new FileInputStream("clientes.bin");
	    	ObjectInputStream camino = new ObjectInputStream(archi);
	        Cliente cliente;
	        while(  ( cliente = (Cliente)camino.readObject()) != null)
	        {
	         	clientes.put(cliente.getId(), cliente);
	            System.out.println(cliente);
	        }
	        camino.close();
	        }catch(FileNotFoundException e){
	            System.out.println("Archivo no encontrado");
	        }catch(IOException e){
	        } catch (ClassNotFoundException e) {
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
