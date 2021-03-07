package ejercicio3;

public class Fecha {
	protected int dia;
	protected int mes;
	
	public Fecha(int dia, int mes) {
		this.dia = dia;
		this.mes = mes;
	}
	public Fecha(Fecha f) {
		this.dia = f.getDia();
		this.mes = f.getMes();
	}
	public Fecha() {
		this(0,0);
	}
	
	public int getDia() {
		return dia;
	}
	public int getMes() {
		return mes;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	
	public boolean sigDia() {
		if(++dia>29) {
			dia = 0;
			mes++;
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return ""+dia+"/"+mes;
	}
}
