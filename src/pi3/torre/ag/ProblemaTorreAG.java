package pi3.torre.ag;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import com.google.common.collect.Maps;

import pi3.torre.Bloque;
import pi3.torre.ProblemaTorre;
import us.lsi.ag.ProblemaAGIndex;
import us.lsi.ag.agchromosomes.IndexChromosome;

//TODO
public class ProblemaTorreAG implements ProblemaAGIndex<Map<Bloque, Integer>>{

	@Override
	public Integer getObjectsNumber() {
		return ProblemaTorre.listaBloques.size();
	}

	@Override
	public Double fitnessFunction(IndexChromosome cr) {
		List<Integer> ld = cr.decode();
		double altura = 0.;
		double fitness = 0.;
		double numMin = 0.;
		double numMax = 0.;
		int tamanioLista = ld.size();
		
		int primerElemento = ld.get(0);
		int ultimoElemento = ld.get(tamanioLista-1);
		
		for(int i = 0; i < ld.size(); i++){
			altura = altura + ld.get(i) * ProblemaTorre.listaBloques.get(i).getAltura();
			fitness = fitness + ld.get(i) * ProblemaTorre.listaBloques.get(i).getBeneficio();
		}
		
		double diff = ProblemaTorre.h - altura;
		
		if(diff < 0.){
			fitness = fitness - 10*(diff*diff*diff*diff*diff*diff);
		} 
		
		if(primerElemento<2*ultimoElemento){
			fitness = fitness * -100*fitness;
		}
		
		for(int i = 0; i < ld.size(); i++){
			numMin = ProblemaTorre.listaBloques.get(i).getNumMinDeUnidades();
			if(ld.get(i)<numMin){
				fitness = fitness * -100*fitness;
			}
			numMax = ProblemaTorre.listaBloques.get(i).getNumMaxDeUnidades();
			if(ld.get(i)>numMax){
				fitness = fitness * -100*fitness;
			}
		}
		
		return fitness;
	}

	@Override
	public Map<Bloque, Integer> getSolucion(IndexChromosome cr) {
		List<Integer> ld = cr.decode();
		
		Map<Bloque, Integer> res = Maps.newHashMap();
		
		IntStream.range(0, ld.size()).boxed().forEach(i->res.put(ProblemaTorre.listaBloques.get(i), ld.get(i)));
		
		return res;
	}
	
	public Integer getMax(int index){
		return ProblemaTorre.listaBloques.get(index).getNumMaxDeUnidades();
	}
}
