public class Masina{
	private String tip;
	private String culoare;
	private double viteza;
	
	public String getTip()
	{
		return tip;
	}
	public boolean setTip(String tip)
	{
		this.tip=tip;
		return true;
	}
	
	public String getCuloare()
	{
		return culoare;
	}
	public boolean setCuloare(String culoare)
	{
		this.culoare=culoare;
		return true;
	}
	
	public double getViteza()
	{
		return viteza;
	}
	public boolean setViteza(double viteza)
	{
		if(viteza<0)
		{
			System.err.println("Eroare: viteza negativa");
			return false;
		}
		this.viteza=viteza;
		return true;
	}
	
	@Override
	public String toString()
	{
		String str = "{tip: "+tip+"; culoare: "+culoare+"; viteza: "+viteza+"}";
		return str;
	}
}