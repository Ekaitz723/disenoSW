package observer.corregido.corregidoUtil;

@SuppressWarnings("deprecation")
public class Test {
	public static void main(String[] args) {
		Biblioteca biblio = new Biblioteca();
		
		biblio.addObserver(new AdministracionPull(biblio));
		biblio.addObserver(new ComprasPull(biblio));
		biblio.addObserver(new StockPull(biblio));
		
		biblio.addObserver(new AdministracionPush());
		biblio.addObserver(new ComprasPush());
		biblio.addObserver(new StockPush());
		
		biblio.devuelveLibro(new AlarmaLibro("How to read",false));
		biblio.devuelveLibro(new AlarmaLibro("Design Patterns: Elements of Reusable Object-Oriented Software"));
		
	}
}
