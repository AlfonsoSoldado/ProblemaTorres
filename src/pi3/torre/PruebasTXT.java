package pi3.torre;

import pi3.torre.pl.TorrePLI;

public class PruebasTXT {

	
	public static void main(String[] args) {
		
		ProblemaTorre.leeBloques("bloques.txt");
		
		String r = TorrePLI.getConstraints();
		System.out.println(r);

	}

}
