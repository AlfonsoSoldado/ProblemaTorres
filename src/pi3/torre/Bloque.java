package pi3.torre;

public class Bloque{

	private Integer codigo;
	private Integer altura;
	private Integer beneficio;
	private Integer numMinDeUnidades;
	private Integer numMaxDeUnidades;
	
	private Bloque(Integer codigo, Integer altura, Integer beneficio, Integer numMin, Integer numMax) {
		super();
		this.codigo = codigo;
		this.altura = altura;
		this.beneficio = beneficio;
		this.numMinDeUnidades = numMin;
		this.numMaxDeUnidades = numMax;
	}
	
	private Bloque(int codigo, String[] fm) {
		super();
		this.codigo = codigo;
		this.altura = new Integer(fm[0]);
		this.beneficio = new Integer(fm[1]);
		this.numMinDeUnidades = new Integer(fm[2]);
		this.numMaxDeUnidades = new Integer(fm[3]);
	}
	
	public static Bloque create(Integer codigo, Integer altura, Integer beneficio, Integer numMin, Integer numMax)  {
		return new Bloque(codigo, altura, beneficio, numMin, numMax);
	}
	
	public static Bloque create(int codigo, String[] fm) {
		return new Bloque(codigo, fm);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Bloque other = (Bloque) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bloque " + codigo;
	}

	public Integer getCodigo() {
		return codigo;
	}
	
	public Integer getAltura() {
		return altura;
	}

	public Integer getBeneficio() {
		return beneficio;
	}
	
	public Integer getNumMinDeUnidades() {
		return numMinDeUnidades;
	}
	
	public Integer getNumMaxDeUnidades() {
		return numMaxDeUnidades;
	}

}

