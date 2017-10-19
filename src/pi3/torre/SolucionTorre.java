package pi3.torre;

import java.util.*;

public class SolucionTorre {

	private Map<Bloque, Integer> bloques;
	private Integer altura;	
	private Integer beneficio;

	public static SolucionTorre create(Map<Bloque, Integer> bloques) {
		return new SolucionTorre(bloques);
	}

	private SolucionTorre(Map<Bloque, Integer> bloques){
		this.bloques = new HashMap<Bloque, Integer>();
		this.bloques.putAll(bloques);
		calculaPropiedadesDerivadas();		
	}
	
	private void calculaPropiedadesDerivadas(){
		this.altura = 0;
		this.beneficio = 0;
		for (Bloque b: bloques.keySet()){
			this.altura = this.altura + b.getAltura()*bloques.get(b);
			this.beneficio = this.beneficio + b.getBeneficio()*bloques.get(b);
		}
	}
	
	public Map<Bloque, Integer> getBloques() {
		return bloques;
	}

	public Integer getAltura() {
		return altura;
	}
	
	public Integer getBeneficio() {
		return beneficio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bloques == null) ? 0 : bloques.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SolucionTorre other = (SolucionTorre) obj;
		if (bloques == null) {
			if (other.bloques != null)
				return false;
		} else if (!bloques.equals(other.bloques))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SolucionBloques [bloques=" + bloques + ", altura=" + altura
				+ ", beneficio=" + beneficio + "]";
	}
		
}
