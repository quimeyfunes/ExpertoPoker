package modelo;

import java.util.LinkedList;
import java.util.List;



public class Jugador {
	
	public enum Mano{
		EscaleraReal,
		EscaleraColor,
		Poker,
		Full,
		Color,
		Escalera,
		Trio,
		DoblePareja,
		Pareja,
		CartaAlta		
	}
	
	public enum Accion{
		Call,
		Fold,
		Raise
	}
	
	private Mano mano;
	private int odds;
	private int ajusteOdds;
	private Accion accion;
	
	
	private List<Contrincante> contrincantes;
	
	
	public Jugador(){
		this.contrincantes = new LinkedList<Contrincante>() ;
		this.setAjusteOdds(0);
	}
	
	public Mano getMano() {
		return mano;
	}

	public void setMano(Mano mano) {
		this.mano = mano;
	}

	public void setOdds(int odds) {
		this.odds = odds;
	}

	public int getOdds() {
		return odds;
	}

	public List<Contrincante> getContrincantes() {
		return contrincantes;
	}
	
	public Accion getAccion() {
		return accion;
	}

	public void setAccion(Accion accion) {
		this.accion = accion;
	}

	public int getAjusteOdds() {
		return ajusteOdds;
	}

	public void setAjusteOdds(int ajusteOdds) {
		this.ajusteOdds = ajusteOdds;
	}
	
	public int getOddsFinales(){
		return this.getOdds() + this.getAjusteOdds();
	}
	
	public String toString(){
		return "Jugador: odds=> " + this.getOdds() + " - ajuste=> " + this.getAjusteOdds() + ", odds totales => " + this.getOddsFinales() ; 
	}
}
