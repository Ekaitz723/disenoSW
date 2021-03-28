package DecoratorPatron;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Cuantos ninios? (se va a colar uno extra)");
		//Se le añade uno pues porque se cuela. Si, asi es como funciona esta guarderia.
		Nino ninios[] = new Nino[input.nextInt()+1];
		for(int i=0;i<ninios.length;i++)
			ninios[i] = new NinoVanilla();
		
		//364 ya que es 7*x - 1, por lo que empezara en lunes (maxDias%7==1)
		int maxDias=364;
		int tmp=-1;
		boolean puedeSeguirnt = true;
		int cual;
		//Nino borrar = null;
		Nino ninoTmp = null;

		/*ninios[0] = new Pegatinado(ninios[0]);
		ninios[0] = new Pegatinado(ninios[0]);
		ninios[0] = new Pegatinado(ninios[0]);
		ninios[0] = new Pegatinado(ninios[0]);
		ninios[0] = new Pegatinado(ninios[0]);
		ninios[0] = new NinoSemana(ninios[0]);
		ninios[0] = new Certificado(ninios[0]);
		ninios[0].leerPremios();
		maxDias=0;*/
		
		while(maxDias-->0) {
			
			//Si es domingo se quita el niño de la semana.
			//Tambien se pregunta si se quiere seguir.
			if(maxDias%7==0) {
				System.out.println("Quieres seguir?(y/n)");
				if(input.next().equals("n"))
					break;
				if(tmp>=0);
					ninios[tmp] = ((NinoDecorator) ninios[tmp]).limpiarDecorador(new NinoSemana(null));
			}
			
			//Si es finde no habren.
			if(maxDias%7<2)
				continue;
			
			//Se les da todos los dias una pegatina uwu
			//Las pegatinas no se quitan. Eso es una crueldad inecesaria.
			//Un random[0,1]*3 para que haya 2/3 de que vayan al baño. Si van, se dan certificados. Si no, se quitan todos.
			for(int i=0;i<ninios.length;i++) {
				ninios[i] = new Pegatinado(ninios[i]);
				//System.out.println("es: "+i);
				if((int)(3*Math.random())>0) {
					//System.out.println("certificasion");
					ninios[i] = new Certificado(ninios[i]);
				}
				else {
					ninoTmp = ninios[i];
					while(ninoTmp instanceof NinoDecorator) {
						if(ninoTmp instanceof Certificado) {
							//Ya que aunque el que se "elimina" aun guarda una referencia al siguiente, el recolector de basura puede ser más rapido.
							ninoTmp = ((NinoDecorator)ninios[i]).getNino();
							ninios[i] = ((NinoDecorator) ninios[i]).limpiarDecorador(new Certificado(null));
						}
						else {
							//System.out.println("xd: "+ninoTmp);
							//borrar = ninoTmp;
							ninoTmp = ((NinoDecorator)ninoTmp).getNino();
							//System.out.println("pero: "+ninoTmp);
							//System.out.println("y entoces: "+(borrar==ninoTmp));
							//if(borrar==ninoTmp) break;
						}
					}
				}
			}
			
			//Si es viernes
			if(maxDias%7==2){
				tmp = (int) ((ninios.length) * Math.random());
				ninios[tmp] = new NinoSemana(ninios[tmp]);
				//System.out.println("Niño de la semana: [ID: "+(tmp+1)+"] "+ninios[tmp]);
				ninios[tmp].darLibro("Libro"+maxDias);
				System.out.println("Quieres preguntar a algun niño por sus libros? (y/n)");
				if(input.next().equals("y")) {
					while(puedeSeguirnt) {
						System.out.println("A cual? [1-"+(ninios.length)+"] | n: 0");
						cual = input.nextInt();
						if((cual-1)<0 || cual>ninios.length) {
							break;
						}
						/*ninios[cual-1].leerPremios();
						ninios[cual-1].leerLibros();*/
						System.out.println(ninios[cual-1]);
					}
				}
			}
		}
		input.close();
		
		//Para probar lo de eliminar. No lo quito pues porque quiero dejarlo porsiacaso.
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
