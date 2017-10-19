package pi3.torre.pl;

import pi3.torre.Bloque;
import pi3.torre.ProblemaTorre;


public class TorrePLI {
	
	static String createMax(){
		String res = "";
		res = "max: ";
		int numVar = 0;
		for(Bloque b: ProblemaTorre.listaBloques){
			if(b.getCodigo()==ProblemaTorre.listaBloques.size()-1){
				String var = "x" + numVar;
				res = res + "+";
				res = res + b.getBeneficio();
				res = res + " " + var;
				numVar++;
			} else {
				String var = "x" + numVar;
				res = res + "+";
				res = res + b.getBeneficio();
				res = res + " " + var + " ";
				numVar++;
			}
		}
		return res + ";\n\n";
	}
	
	static String createMaxAltura(){
		String res = "";
		int numVar = 0;
		for(Bloque b: ProblemaTorre.listaBloques){
			res = res + b.getAltura() + " ";
			res = res + "x" + numVar + " ";
			numVar++;
		}
		return res + "= " + ProblemaTorre.h + ";" + "\n\n";
	}
	
	static String createMinUnidades(){
		String res = "";
		int numVar = 0;
		for(Bloque b: ProblemaTorre.listaBloques){
			String var = "x" + numVar;
			res = res + var;
			res = res + ">=";
			res = res + b.getNumMinDeUnidades();
			res = res + ";\n";
			numVar++;
		}
		return res + "\n";
	}
	
	static String createMaxUnidades(){
		String res = "";
		int numVar = 0;
		for(Bloque b: ProblemaTorre.listaBloques){
			String var = "x" + numVar;
			res = res + var;
			res = res + "<=";
			res = res + b.getNumMaxDeUnidades();
			res = res + ";\n";
			numVar++;
		}
		return res + "\n";
	}
	
	static String createDobleMinMax(){
		String res = "";
		int last = ProblemaTorre.listaBloques.size()-1; 
		res = res + "x0>=";
		res = res + "2 ";
		res = res + "x";
		res = res + last;
		res = res + ";\n\n";
		return res;
	}
	
	static String createVars(){
		String res = "int ";
		for(int i=0; i<ProblemaTorre.listaBloques.size();i++){
			if(i == ProblemaTorre.listaBloques.size()-1){
				res = res + " x" + i;
			} else {
				res = res + " x" + i + ",";
			}
		}
		return res + ";";
	}

	public static String getConstraints(){
		String ret = "";
		ret = ret + createMax();
		ret = ret + createMaxAltura();
		ret = ret + createMinUnidades();
		ret = ret + createMaxUnidades();
		ret = ret + createDobleMinMax();
		ret = ret + createVars();
		return ret;
		
	}	
}
