package observer;

public class Test {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Biblioteca biblio = new Biblioteca();
		AlarmaLibroPull alarmaPull = new AlarmaLibroPull(biblio);
		AlarmaLibroPush alarmaPush = new AlarmaLibroPush();
		
		alarmaPull.addObserver(new AdministracionPull(alarmaPull));
		alarmaPull.addObserver(new ComprasPull(alarmaPull));
		alarmaPull.addObserver(new StockPull(alarmaPull));
		
		alarmaPush.addObserver(new AdministracionPush());
		alarmaPush.addObserver(new ComprasPush());
		alarmaPush.addObserver(new StockPush());
		
		biblio.addObserver(alarmaPull);
		biblio.addObserver(alarmaPush);
		
		biblio.devuelveLibro(new EstadoLibro("How to read",false));
		biblio.devuelveLibro(new EstadoLibro("Design Patterns: Elements of Reusable Object-Oriented Software"));
	}
}
