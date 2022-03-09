package ClasePersonas;

import java.io.Serializable;

import Excepciones.PassIncorrectExcepcion;

public class Empleado extends Persona implements Serializable {
	
	private String contraseña;
	private float salario;
	private boolean estado;
	
	public Empleado( ) {
		super();
		this.contraseña = "";
		this.salario = 0;
		this.estado = false;
	}
	
	public Empleado(String nombre, String apellido, String telefono, int id, String contraseña, float salario) {
		super(nombre, apellido, telefono, id);
		this.contraseña = contraseña;
		this.salario = salario;
		this.estado = true;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}
	
	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public void darDeBaja() {
		this.estado=false;
	}

	/**
	 * Se encarga de verificar si el String enviado por parametro es igual a la contraseña del Empleado.
	 * @param pass
	 * @return boolean
	 */
	public boolean verificarCuenta(String pass) {
		if(this.contraseña.contains(pass)==true) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Se encarga de verificar si el entero enviado por parametro es igual al Id del Empleado.
	 * @param id
	 * @return
	 */
	public boolean verificarId( int id) {
		if(this.id==id){
			return true;
		}
		else {
			return false;
		}
	} 
	
	/**
	 * Verifica usuario y contraseña usando los emtodos anteriores
	 * @param pass
	 * @param id
	 * @return booleano dependiente si es correcto o no.
	 */
	public boolean verificarUsu(String pass, int id)throws PassIncorrectExcepcion {
		boolean flag=false;
		if( verificarId(id) && verificarCuenta(pass) )
		{
			flag=true;
		}else {
			flag=false;
			throw new PassIncorrectExcepcion();
		}
		return flag;
	}

	@Override
	public String toString() {
		return super.toString() + "Empleado: contraseña: " + contraseña + ", salario: " + salario + ", Estado: "+ estado;
	}
	
}
