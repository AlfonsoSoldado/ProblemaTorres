package pi3.torre;

import java.util.*;
import us.lsi.stream.Stream2;

public class ProblemaTorre {

	public static List<Bloque> listaBloques; 
	public static Integer h;
		
	public ProblemaTorre(String file) {
		super();
		leeBloques(file);
	}
	
	public static void leeBloques(String file){	
		List<String> ls = Stream2.fromFile(file).toList();
		listaBloques = new ArrayList<Bloque>();
		int index = 0;
		for(String s : ls){
			String[] at = Stream2.fromString(s, ",").toArray((int x)->new String[x]);
			Bloque b = Bloque.create(index, at);
			listaBloques.add(b);
			index++;
		}
	}

	public static ProblemaTorre create(String file) {		
		return new ProblemaTorre(file);
	}

}
