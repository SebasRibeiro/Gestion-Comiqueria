package ClasesMerchandising;

import java.io.Serializable;

public class JuegoDeMesa extends Merchandising implements Serializable{

	private String marca;
	private String nombre;
	private String edicion;
	private String modeloAlfanumerico;
	private String tipoDeJuego;
	private int cantidadMinimaJugadores;
	private int edadMinimaRecomendada;
	
	public JuegoDeMesa(int codigoBarra, double precio, int stock, String procedencia, String descripcion,
			String fabricante, String marca, String nombre, String edicion, String modeloAlfanumerico,
			String tipoDeJuego, int cantidadMinimaJugadores, int edadMinimaRecomendada) {
		super(codigoBarra, precio, stock, procedencia, descripcion, fabricante);
		this.marca = marca;
		this.nombre = nombre;
		this.edicion = edicion;
		this.modeloAlfanumerico = modeloAlfanumerico;
		this.tipoDeJuego = tipoDeJuego;
		this.cantidadMinimaJugadores = cantidadMinimaJugadores;
		this.edadMinimaRecomendada = edadMinimaRecomendada;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEdicion() {
		return edicion;
	}

	public void setEdicion(String edicion) {
		this.edicion = edicion;
	}

	public String getModeloAlfanumerico() {
		return modeloAlfanumerico;
	}

	public void setModeloAlfanumerico(String modeloAlfanumerico) {
		this.modeloAlfanumerico = modeloAlfanumerico;
	}

	public String getTipoDeJuego() {
		return tipoDeJuego;
	}

	public void setTipoDeJuego(String tipoDeJuego) {
		this.tipoDeJuego = tipoDeJuego;
	}

	public int getCantidadMinimaJugadores() {
		return cantidadMinimaJugadores;
	}

	public void setCantidadMinimaJugadores(int cantidadMinimaJugadores) {
		this.cantidadMinimaJugadores = cantidadMinimaJugadores;
	}

	public int getEdadMinimaRecomendada() {
		return edadMinimaRecomendada;
	}

	public void setEdadMinimaRecomendada(int edadMinimaRecomendada) {
		this.edadMinimaRecomendada = edadMinimaRecomendada;
	}

	@Override
	public String toString() {
		return super.toString() + "JuegoDeMesa: marca: " + marca + ", nombre: " + nombre + ", edicion: " + edicion + ", modeloAlfanumerico: "
				+ modeloAlfanumerico + ", tipoDeJuego: " + tipoDeJuego + ", cantidadMinimaJugadores: "
				+ cantidadMinimaJugadores + ", edadMinimaRecomendada: " + edadMinimaRecomendada;
	}
	
}
