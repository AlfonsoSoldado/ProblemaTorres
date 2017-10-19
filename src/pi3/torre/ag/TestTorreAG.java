package pi3.torre.ag;

import pi3.torre.ProblemaTorre;
import us.lsi.ag.*;
import us.lsi.ag.agchromosomes.ChromosomeFactory;
import us.lsi.ag.agchromosomes.ChromosomeFactory.ChromosomeType;
import us.lsi.ag.agchromosomes.IndexChromosome;
import us.lsi.ag.agstopping.StoppingConditionFactory;
import us.lsi.ag.agstopping.StoppingConditionFactory.StoppingConditionType;
import us.lsi.algoritmos.Algoritmos;

public class TestTorreAG {

	public static void main(String[] args){
		
		AlgoritmoAG.ELITISM_RATE  = 0.30;
		AlgoritmoAG.CROSSOVER_RATE = 0.8;
		AlgoritmoAG.MUTATION_RATE = 0.7;
		AlgoritmoAG.POPULATION_SIZE = 200;
		StoppingConditionFactory.NUM_GENERATIONS = 500;
		StoppingConditionFactory.SOLUTIONS_NUMBER_MIN = 10;
		StoppingConditionFactory.FITNESS_MIN = 100.0;
		StoppingConditionFactory.stoppingConditionType = StoppingConditionType.GenerationCount;

		ProblemaTorre.create("bloques.txt");
		ProblemaTorre.h = 41;
		System.out.println("------");
		System.out.println("Altura total: " + ProblemaTorre.h);
		System.out.println("------");
		System.out.println("Bloques:\n" + ProblemaTorre.listaBloques);
		System.out.println("------");
		System.out.println("Solución :");
		ProblemaTorreAG p = new ProblemaTorreAG();
		
		AlgoritmoAG ap = Algoritmos.createAG(ChromosomeType.IndexRange, p);
		
		ap.ejecuta();
		
		IndexChromosome cr = ChromosomeFactory.asIndex(ap.getBestFinal());
		System.out.println("Mejor solución: " + p.getSolucion(cr));
		System.out.println("Fitness de la mejor solución: " + p.fitnessFunction(cr));
		System.out.println("------");
			
	}	

}
