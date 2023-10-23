public class Restaurant{

	private class elemMeniu{
		private String articol;
		private float pret;
		
		public String getArticol(){
			return this.articol;
		}
		public void setArticol(String articol){
			this.articol=articol;
		}
		
		public float getPret(){
			return this.pret;
		}
		public void setPret(float pret){
			this.pret=pret;
		}
	}

	private int maxElemMeniu;
	private int nrElemMeniu;
	private elemMeniu[] meniu;
	
	private int maxEvaluari;
	private int nrEvaluari;
	private int[] evaluari;
	
	public void adaugareArticol(String articol, float pret){
		elemMeniu tmp = new elemMeniu();
		tmp.setArticol(articol);
		tmp.setPret(pret);
		meniu[nrElemMeniu-1]=tmp;
		nrElemMeniu++;
	}
	
	public boolean eliminareArticol(String articol){
		boolean articolGasit=false;
		for(int i=0;i<nrElemMeniu&&!articolGasit;++i){
			if(meniu[i].getArticol().equals(articol)){
				for(int j=i;j<nrElemMeniu-2;j++)
					meniu[j]=meniu[j+1];
				nrElemMeniu--;
				articolGasit=true;
			}
		}
		return articolGasit;
	}
	
	public void adaugareEvaluare(int evaluare){
		evaluari[nrEvaluari-1]=evaluare;
		nrEvaluari++;
	}
	
	public double medieEvaluari(){
		int sum=0;
		for(int i=0;i<nrEvaluari;++i){
			sum+=evaluari[i];
		}
		return (sum/nrEvaluari);
	}
}