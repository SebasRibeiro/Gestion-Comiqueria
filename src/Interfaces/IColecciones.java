package Interfaces;

/**
 * Interfaz generica para implementar
 * en las distintas colecciones colecciones.
 * 
 */
public interface IColecciones <T > {

	public void agregarObjLista(T obj);
	public void eliminarObjLista(T obj) throws Exception;
	public String mostrarObjLista(T obj);
	public String mostrarLista();
	public void ordenarLista();
	public void guardarListaArchivo();
	public void cargarListaArchivo();
}
