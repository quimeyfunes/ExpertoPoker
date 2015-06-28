package modelo;

public class Contrincante {
	public enum TipoJugador{
		LoosePasivo,
		LooseAgresivo,
		TightPasivo,
		TightAgresivo,
		Indefinido
	}
	
	private int id = 0;
	private int rondasGanadas;
	private int cantidadFold;
	private int cantidadCall;
	private int cantidadRaise;
	
	
	private TipoJugador tipo;
	
	public Contrincante(int id){
		this.id = id;
		rondasGanadas = 0;
		cantidadFold = 0;
		cantidadCall = 0;
		cantidadRaise = 0;
	
		tipo = TipoJugador.Indefinido;
	}
	
	public int getId() {
		return this.id;
	}
	
	public int getTotalRondasJugadas(){
		return cantidadCall + cantidadFold + cantidadRaise;
	}
	
	public int getRondasGanadas() {
		return rondasGanadas;
	}

	public void setRondasGanadas(int rondasGanadas) {
		this.rondasGanadas = rondasGanadas;
	}

	public int getCantidadFold() {
		return cantidadFold;
	}

	public void setCantidadFold(int cantidadFold) {
		this.cantidadFold = cantidadFold;
	}

	public int getCantidadCall() {
		return cantidadCall;
	}

	public void setCantidadCall(int cantidadCall) {
		this.cantidadCall = cantidadCall;
	}

	public int getCantidadRaise() {
		return cantidadRaise;
	}

	public void setCantidadRaise(int cantidadRaise) {
		this.cantidadRaise = cantidadRaise;
	}

	public void setTipo(TipoJugador tipo) {
		this.tipo = tipo;
	}

	public TipoJugador getTipo() {
		return tipo;
	}
	
	public boolean ImprimirTipo(){
		System.out.println(this.getTipo());
		return true;
	}

	
	
	public String toString(){
		return "Id =" + this.id + ", R = " + this.cantidadRaise + ", C =" + this.cantidadCall + ", F = " + this.cantidadFold;
	}
	
	

	
}
