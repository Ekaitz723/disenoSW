package DecoratorPatron;

import java.util.Scanner;

public class MainNinoSemanaSingleton {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Cuantos ninios?");
		//Se le añade uno pues porque se cuela.
		Nino ninios[] = new Nino[input.nextInt()+1];
		
		//364 ya que es 7*x - 1, por lo que empezara en lunes (maxDias%7==1)
		int maxDias=364;
		boolean quitarPremios = true;
		while(maxDias-->0) {
			
			//Si es finde no habren.
			if(maxDias%7>5)
				continue;
			//Si es lunes.
			if(maxDias%7==1) {
				//Aunque tambien se pueda eliminar de forma convencional con un
				// limpiarDecorador(new Decorador(ninio[x]))
				//como el resto de los decoradores, en el caso de este decorador se puede hacer de esta forma:
				//NinoSemanaSingleton.setNinoSemana(null);
				for(Nino n: ninios) {
					if(n instanceof NinoSemanaSingleton) {
						n.limpiarDecorador(NinoSemanaSingleton.getNinoSemana());
						break;
					}
				}
				System.out.println("Quieres seguir?(y/n)");
				if(input.nextLine().equals("n"))
					break;
				while(quitarPremios) {
					
				}
				System.out.println("Quieres quitarle un premio a alguien?(y/n)");
				if(input.nextLine().equals("y")) {
					System.out.println("A cual? [0-"+(ninios.length-1)+"]");
					//Si no pones algo coherente, va a preguntar al 0. Si. Y no pienso hacer nada para evitarlo. No es un bug, es una feature.
					System.out.println("Que premio?(Pegatina/Certificado)");
					if(input.nextLine().equals("n"))
						break;
					ninios[input.nextInt()].leerLibros();
				}
			}
			
			//Si es domingo se quitan las pegatinas
			//Se les da todos los dias una pegatina uwu
			//Un random[0,1]*3 para que haya 2/3 de que vayan al baño.
			for(Nino n: ninios) {
				n = new Pegatinado(n);
				if(3*Math.random()>0)
					n = new Certificado(n);
				//Random de 2/tam ninios de que a alguien se le de el nino de la semana. Se va disputando durante la semana.
				if((ninios.length) * Math.random()==0) {
					n = NinoSemanaSingleton.setNinoSemana(n);
				}
			}
			
			//Si es viernes
			if(maxDias%7==5){
				if(NinoSemanaSingleton.getNinoSemana()!=null)
					NinoSemanaSingleton.getNinoSemana().darLibro("Libro"+maxDias);
				//Le dejo tener el niño de la semana hasta el lunes.
				
				System.out.println("Quieres preguntar a algun niño por sus libros? (y/n)");
				if(input.nextLine().equals("y")) {
					System.out.println("A cual? [0-"+(ninios.length-1)+"]");
					//Si no pones algo coherente, va a preguntar al 0. Si. Y no pienso hacer nada para evitarlo. No es un bug, es una feature.
					ninios[input.nextInt()].leerLibros();
				}
			}
		}
		input.close();
		/*Nino paco = new NinoVanilla();
		//paco = new Pegatinado(new Certificado(new NinoSemana(new Certificado(paco))));
		paco = new Pegatinado(paco);
		paco = new Pegatinado(paco);
		paco = new Pegatinado(paco);
		paco = new Pegatinado(paco);
		paco = new Pegatinado(paco);
		paco = new NinoSemana(paco);
		paco = new Certificado(paco);
		
		paco = paco.limpiarDecorador(new NinoSemana(null));
		paco = paco.limpiarDecorador(new NinoSemana(null));
		paco = paco.limpiarDecorador(new Pegatinado(null));
		paco = paco.limpiarDecorador(new Certificado(null));
		paco = paco.limpiarDecorador(new Certificado(null));
		paco = paco.limpiarDecorador(new Pegatinado(null));
		paco = paco.limpiarDecorador(new Pegatinado(null));
		paco = paco.limpiarDecorador(new Pegatinado(null));
		paco = paco.limpiarDecorador(new Pegatinado(null));
		paco = paco.limpiarDecorador(new Certificado(null));

		paco.leerPremios();*/
	}
}
