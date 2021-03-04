package ejercicio3;

import java.util.Scanner;

public class Consola implements EntradaSalida {
	private Scanner output;
	private static Consola instancia = new Consola();
	
	private Consola() {}
	
	public static Consola instancia() {
		if(instancia==null)
			instancia = new Consola();
		return instancia;
	}
	
	public static void instanciaFlush() {
		if(instancia!=null)
			instancia = null;
	}
	
	@Override
	public String input() {
		output = new Scanner(System.in);
		String texto = "";
		while(output.hasNext()) {
			texto += output.nextLine()+"\n";
		}
		return texto;
	}

	@Override
	public void output(DocumentoConFecha obj) {
		System.out.println(obj);
	}
}
