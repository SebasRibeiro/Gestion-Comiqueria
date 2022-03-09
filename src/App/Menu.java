package App;

public class Menu {
	
	private int select;
	private boolean salida;
	
	public Menu() {
		super();
		this.select = 0;
		this.salida = false;
	}

	public int getSelect() {
		return select;
	}

	public void setSelect(int select) {
		this.select = select;
	}

	public boolean isSalida() {
		return salida;
	}

	public void setSalida(boolean salida) {
		this.salida = salida;
	}
	
}
