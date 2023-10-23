import java.util.*;
import java.time.*;

public class Persoana{
	private String nume;
	private String prenume;
	private String cnp;
	private int anulNasterii;
	private int lunaNasterii;
	private int ziuaNasterii;
	private String adresa;
	
	public Persoana(String nume, String prenume, String cnp){
		if(cnpValid(cnp)){
			this.cnp=cnp;
		}
		else{
			throw new IllegalArgumentException("CNP invalid");
		}
		
		if(cnp.charAt(0)=='1' || cnp.charAt(0)=='2'){
			anulNasterii=1900+Integer.parseInt(cnp.substring(1,3));
		}
		else if(cnp.charAt(0)=='3' || cnp.charAt(0)=='4'){
			anulNasterii=1800+Integer.parseInt(cnp.substring(1,3));
		}
		else if(cnp.charAt(0)=='5' || cnp.charAt(0)=='6'){
			anulNasterii=2000+Integer.parseInt(cnp.substring(1,3));
		}
		
		lunaNasterii = Integer.parseInt(cnp.substring(3,5));
		ziuaNasterii = Integer.parseInt(cnp.substring(5,7));
		
		this.nume=nume;
		this.prenume=prenume;
	}
	
	public Persoana(String nume, String prenume){
		this.nume=nume;
		this.prenume=prenume;
	}
	
	private static boolean anBisect(int an){
		if(an%4==0&&(an%100!=0||an%400==0))
			return true;
		else
			return false;
	}
	
	private static boolean ziValida(int zi, int luna, int an){
		Integer luni31Zile[]={1,3,5,7,8,10,12};
		Integer luni30Zile[]={4,6,9,11};
		if( Arrays.asList(luni31Zile).contains(luna)&&zi>31)
		{
			return false;
		}
		if( Arrays.asList(luni30Zile).contains(luna) && zi>30)
		{
			return false;
		}
		if(luna==2 && ((anBisect(an)&&zi>29) || zi>28))
		{
			return false;
		}
		return true;
	}
	
	private static boolean cnpValid(String cnp){
		
		//validare format
		if(!cnp.matches("\\d{13}")){
			System.err.println("Format CNP invalid");
			return false;
		}
		
		//validare prima cifra
		if(cnp.charAt(0)=='0' || cnp.charAt(0)=='9'){
			System.err.println("Prima cifra CNP invalida");
			return false;
		}
		
		//gasire an din CNP pentru validare zi
		int anCNP=0;
		if(cnp.charAt(0)=='1' || cnp.charAt(0)=='2'){
			anCNP=1900+Integer.parseInt(cnp.substring(1,3));
		}
		else if(cnp.charAt(0)=='3' || cnp.charAt(0)=='4'){
			anCNP=1800+Integer.parseInt(cnp.substring(1,3));
		}
		else if(cnp.charAt(0)=='5' || cnp.charAt(0)=='6'){
			anCNP=2000+Integer.parseInt(cnp.substring(1,3));
		}
		
		//validare luna
		int lunaCNP=Integer.parseInt(cnp.substring(3,5));
		if(lunaCNP>12 || lunaCNP==0){
			System.err.println("Luna CNP invalida");
			return false;
		}
		
		//validare zi
		int ziCNP=Integer.parseInt(cnp.substring(5,7));
		if(!ziValida(ziCNP, lunaCNP, anCNP))
		{
			System.err.println("Zi CNP invalida");
			return false;
		}
		
		//validare judet
		int judet=Integer.parseInt(cnp.substring(7,9));
		if(judet>52 || judet==49 || judet==50 || judet==0){
			System.err.println("Judet CNP invalid");
			return false;
		}
		
		//validare numar secvential
		if(Integer.parseInt(cnp.substring(9,12))==0){
			System.err.println("Numar secvential CNP invalid");
			return false;
		}
		//TO-DO: validare cifra de control
		return true;
	}
	
	public String getNume(){
		return nume;
	}
	public void setNume(String nume){
		this.nume=nume;
	}
	
	public String getPrenume(){
		return prenume;
	}
	public void setPrenume(String prenume){
		this.prenume=prenume;
	}
	
	public String getCNP(){
		return cnp;
	}
	public void setCNP(String cnp){
		if(cnpValid(cnp)){
			this.cnp=cnp;
		}
		else{
			throw new IllegalArgumentException("CNP invalid");
		}
	}
	
	public int getAnulNasterii(){
		return anulNasterii;
	}
	public void setAnulNasterii(int anulNasterii){
		if(anulNasterii>=1800 && anulNasterii<=Year.now().getValue()){
			this.anulNasterii=anulNasterii;
		}
		else{
			throw new IllegalArgumentException("An invalid");
		}
	}
	
	public int getLunaNasterii(){
		return lunaNasterii;
	}
	public void setLunaNasterii(int lunaNasterii){
		if(lunaNasterii<=12 && lunaNasterii>0){
			this.lunaNasterii=lunaNasterii;
		}
		else{
			throw new IllegalArgumentException("An invalid");
		}
	}
	
	public int getZiuaNasterii(){
		return ziuaNasterii;
	}
	public void setZiuaNasterii(int ziuaNasterii){
		if(ziValida(ziuaNasterii, lunaNasterii, anulNasterii)){
			this.ziuaNasterii=ziuaNasterii;
		}
		else{
			throw new IllegalArgumentException("An invalid");
		}
	}
	
	public String getAdresa(){
		return adresa;
	}
	public void setAdresa(String adresa){
		this.adresa=adresa;
	}
	
}