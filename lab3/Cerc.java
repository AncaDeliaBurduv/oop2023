public class Cerc extends Forma{
	private int raza;
	public double calculArie(){
		return Math.PI*raza*raza;
	}
	public double calculPerimetru(){
		return 2*Math.PI*raza;
	}
}