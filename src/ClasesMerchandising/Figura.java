package ClasesMerchandising;

import java.io.Serializable;

public class Figura extends Merchandising implements Serializable {

	private String franquicia;
	private String personaje;
	private String versionDelPersonaje;
	private boolean articulada;
	private int altura; //centimetros	
	
	public Figura(int codigoBarra, double precio, int stock, String procedencia, String descripcion,
			String fabricante, String franquicia, String personaje, String versionDelPersonaje, boolean articulada, int altura)
	{
		super(codigoBarra, precio, stock, procedencia, descripcion, fabricante);
		this.franquicia = franquicia;
		this.personaje = personaje;
		this.versionDelPersonaje = versionDelPersonaje;
		this.articulada = articulada;
		this.altura = altura;
	}
	
public String getFranquicia() {
		return franquicia;
	}

	public void setFranquicia(String franquicia) {
		this.franquicia = franquicia;
	}

	public String getPersonaje() {
		return personaje;
	}

	public void setPersonaje(String personaje) {
		this.personaje = personaje;
	}

	public String getVersionDelPersonaje() {
		return versionDelPersonaje;
	}

	public void setVersionDelPersonaje(String versionDelPersonaje) {
		this.versionDelPersonaje = versionDelPersonaje;
	}

	public boolean isArticulada() {
		return articulada;
	}

	public void setArticulada(boolean articulada) {
		this.articulada = articulada;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	@Override
	public String toString() {
		return super.toString() + "Figura:  franquicia: " + franquicia + ", personaje: " + personaje + ", versionDelPersonaje: "
				+ versionDelPersonaje + ", articulada: " + articulada + ", altura: " + altura;
	}
	
}
