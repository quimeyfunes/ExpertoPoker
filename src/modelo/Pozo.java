package modelo;

public class Pozo {
	
	private int monto;
	private int apuestaRequerida;
	
	public Pozo(){
		this.monto = 0;
		this.apuestaRequerida = 0;
	}
	
	public int getMonto() {
		return monto;
	}
	public void setMonto(int monto) {
		this.monto = monto;
	}
	public int getApuestaRequerida() {
		return apuestaRequerida;
	}
	public void setApuestaRequerida(int apuestaRequerida) {
		this.apuestaRequerida = apuestaRequerida;
	}
	
	public int getOdds(){
		return this.getMonto() / this.getApuestaRequerida();
	}
}
