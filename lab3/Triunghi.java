public class Triunghi extends Forma{
	private int latura1;
	private int latura2;
	private int latura3;
	public double calculArie(){
		double sp=calculPerimetru()/2;
		return Math.sqrt(sp*(sp-latura1)*(sp-latura1)*(sp-latura1));
	}
	public double calculPerimetru(){
		return latura1+latura2+latura3;
	}
}