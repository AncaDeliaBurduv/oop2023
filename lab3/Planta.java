public class Planta{
	
	public int rezervaApa;
	public boolean inflorita;
	
	private String specie;
	private int varsta;
	
	public Planta(String specie){
		this.specie=specie;
	}
	
	public Planta(int varsta, boolean inflorita){
		this.varsta=varsta;
		this.inflorita=inflorita;
	}
	
	public String getSpecie(){
		return specie;
	}
	public void setSpecie(String specie){
		this.specie=specie;
	}
	
	public int getVarsta(){
		return varsta;
	}
	public void setVarsta(int varsta){
		this.varsta=varsta;
	}
	
	public void consumaApa(int apaConsumata){
		rezervaApa-=apaConsumata;
	}
	
	public void infloreste(){
		inflorita=true;
	}
	
}