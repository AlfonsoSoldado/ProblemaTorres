package pi3.torre.pl;

import pi3.torre.ProblemaTorre;
import us.lsi.pl.AlgoritmoPLI;


public class TestTorrePLI {
	
	public static void main(String[] args) {
		ProblemaTorre.create("bloques.txt");
		ProblemaTorre.h = 41;
		System.out.println("------");
		System.out.println("Altura total: " + ProblemaTorre.h);
		System.out.println("------");
		System.out.println("Bloques:\n" + ProblemaTorre.listaBloques);
		System.out.println("------");
		
		String r = TorrePLI.getConstraints();
		AlgoritmoPLI a = AlgoritmoPLI.create();
		a.setConstraints(r);
		a.ejecuta();
		
		System.out.println("Especificación LPSolve:");
		System.out.println(r);
		System.out.println("-------------------------------------");
		System.out.println("Objetivo Solución Óptima = " + a.getObjetivo());
		//System.out.println("Solución Óptima = " + a.getSolucion(0));
		System.out.println("-------------------------------------");
		System.out.println("Solución Óptima =");
		for(int i = 0; i < a.getNumVar(); i++){
			System.out.println(a.getNames().get(i) + " = " + a.getSolucion(i) + ";");
		}
	}

}
