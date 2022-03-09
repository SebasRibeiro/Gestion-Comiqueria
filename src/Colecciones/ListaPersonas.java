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

import ClaseElemento.Elemento;
import ClasePersonas.Empleado;
import ClasePersonas.Persona;
import Interfaces.IColecciones;

public class ListaPersonas<T> implements IColecciones<T>{
	
	HashMap<Integer, Persona>empleados;
	
	public ListaPersonas() {
		empleados= new HashMap<>();		
	}
	
	/**
	 * Agrega un objeto a la lista
	 * @param la persona a agregar
	 */
	@Override
	public void agregarObjLista(T obj) {
		Persona persona=(Persona) obj; 
		if(!empleados.containsKey(persona.getId())) {
			empleados.put(persona.getId(), persona);
		}
		else {
			empleados.replace(persona.getId(), empleados.get(persona.getId()));
		}
	}

	/**
	 * Busca al objeto y lo elimina
	 * @param el objeto
	 */
	@Override
	public void eliminarObjLista(T obj) {
		Persona persona=(Persona) obj;
		empleados.remove(persona.getId());
	}

	/**
	 * Busca a la paersona por id y la elimina
	 * @param el id de persona
	 */
	public void buscarYeliminarObj(int id) {
		empleados.remove(id);
	}

	/**
	 * Muestra la persona solicitada
	 * @param el objeto a buscar
	 * @return El string con los datos
	 */
	@Override
	public String mostrarObjLista(T obj) {
		Persona persona= (Persona) obj;
		Iterator<Entry<Integer, Persona>>it=empleados.entrySet().iterator();
		StringBuilder sb= new StringBuilder();
		while(it.hasNext()) {
			Entry<Integer, Persona>entry=  (Entry<Integer, Persona>)it.next();
			if(entry.getKey()==persona.getId()) {
				sb.append(entry.getKey()+"/"+entry.getValue().toString()+"\n");
			}
		}
		return sb.toString();
	}
	
	/**
	 * Busca Persona por numero ID y la retorna
	 * @param id
	 * @return La persona a buscar
	 */
	
	/*
	public Persona retornarPersona(int id) {



        Iterator<Entry<Integer, Persona>>it=empleados.entrySet().iterator();
        Persona persona= new Persona();
        while(it.hasNext()) 
        {
            Entry<Integer, Persona>entry=  (Entry<Integer, Persona>)it.next();
            if(id==entry.getKey())
            {
                persona=entry.getValue();
            }
        }

        return persona;

	}
	*/
	
	/**
	 * Muestra la lista completa de personas
	 * @return El string con los datos
	 */
	@Override
	public String mostrarLista() {
	
		Iterator<Entry<Integer, Persona>> it= empleados.entrySet().iterator();
		StringBuilder sb= new StringBuilder();
		while(it.hasNext()) {
			Entry<Integer, Persona>entry= (Entry<Integer, Persona>)it.next();
			sb.append(entry.getKey() + "/"+entry.getValue().toString()+"\n");
		}	
		return sb.toString();
	}
	
	/**
	 * Muestra las personas solo por nombre y apellido
	 * @return El string con los datos
	 */
	public String mostrarApYNomLista() {
		Iterator<Entry<Integer, Persona>> it= empleados.entrySet().iterator();
		StringBuilder sb= new StringBuilder();
		while(it.hasNext()) {
			Entry<Integer, Persona>entry= (Entry<Integer, Persona>)it.next();
			sb.append(entry.getKey() + "/"+entry.getValue().mostrarNomYAp()+"\n");	
		}
	return sb.toString();
	}
		
	/**
	 * Guarda en un archivo .bin los datos de la lista
	 */
	@Override
    public void guardarListaArchivo() {
        FileOutputStream archi = null;
        try {
            archi = new FileOutputStream("clientes.bin");
            ObjectOutputStream camino = new ObjectOutputStream(archi);
            Iterator<Entry<Integer, Persona>>it=empleados.entrySet().iterator();
            while(it.hasNext()) 
            {
                Entry<Integer, Persona>entry=  (Entry<Integer, Persona>)it.next();
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
                System.out.println("fffff");
            }
        }
    }
	
	/**
	 * Carga los datos del archivo .bin en una lista
	 */
	@Override
    public void cargarListaArchivo() {
        FileInputStream archi = null;
        try {
            archi = new FileInputStream("personas.bin");
            ObjectInputStream camino = new ObjectInputStream(archi);
            Persona persona;
            while(  ( persona = (Persona)camino.readObject()) != null)
            {
                System.out.println(persona);
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

	@Override
	public void ordenarLista() {
		
	}
	
}
