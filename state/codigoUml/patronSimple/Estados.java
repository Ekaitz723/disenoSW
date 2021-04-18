package StatePatronBien;

//Mejor ponerlo con indice en vez de ordinal, en el caso de querer cambiarlo, solo hay que cambiar indice().
public enum Estados {
	ACTUAL(0),
	CREADA(1),
	ADMITIDA(2),
	CURSADA(3),
	FINALIZADA(4),
	RECHAZADA(5);
	
	private int indice;
	
	private Estados(int i) {
		indice = i;
	}
	
	public int indice() {
		return indice;
	}
}
