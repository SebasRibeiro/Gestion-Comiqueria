package ClasePersonas;

import java.io.Serializable;

public abstract class Persona implements Serializable {

	private String nombre;
	private String apellido;
	private String telefono;
	protected int id;

	public Persona() {
		super();
		this.nombre = "";
		this.apellido = "";
		this.telefono = "";
		this.id = 0;
	}

	public Persona(String nombre, String apellido, String telefono, int id) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.id = id;
	}
	
	/**
	* Muestra el apellido y nombre
	* @return Apellido y nombre
	*/
	public String mostrarNomYAp()
	{
		return "Individuo: "+getApellido()+" "+getNombre();
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Persona: nombre: " + nombre + ", apellido: " + apellido + ", telefono: " + telefono + ", id: " + id;
	}

}
