public class ContBancar
{
	private double _sold=0.0;
	public double getSold()
	{
		return _sold;
	}
	public ContBancar(double sold)
	{
		_sold = sold;
	}
	public void depozitareSuma(double suma)
	{
		if(suma>=0)
		{
			_sold+=suma;
		}
		else
		{
			System.err.println("Eroare: depozitare suma negativa");
		}
	}
	public boolean retragereSuma(double suma)
	{
		if(suma>=0)
		{
			_sold-=suma;
			return true;
			
		}
		else
		{
			System.err.println("Eroare: retragere suma negativa");
			return false;
		}
	}
	
	@Override
	public String toString()
	{
		String str = "{_sold: "+_sold+"}";
		return str;
	}
}
