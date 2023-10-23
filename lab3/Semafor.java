public class Semafor{
	boolean stareCuloare;
	String culoare;
	int durata;

	public Semafor(boolean stareCuloare, int durata){
		this.stareCuloare=stareCuloare;
		this.durata=durata;
		if(stareCuloare){
			culoare="verde";
		}
		else{
			culoare="rosu";
		}
		
	}
	
	public void schimbaCuloarea(){
		this.stareCuloare=(!this.stareCuloare);	
		if(stareCuloare){
			culoare="verde";
		}
		else{
			culoare="rosu";
		}
	}
	
	/*
	poate verificare inseamna o metoda boolean cu parametru String care compara
	verifica daca atributul este la fel ca parametrul?? depinde de cerinta
	*/
	public String getCuloare(){
		return this.culoare;
	}
}
