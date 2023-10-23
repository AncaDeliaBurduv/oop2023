import java.util.*;
import java.time.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		ArrayList<Persoana> listaPersoane = new ArrayList<Persoana>();
		
		//System.out.println("Numar presoane: ");
		System.out.print("n = ");
		int n=sc.nextInt();
		/*sc.nextLine();
		for(int i=0;i<n;++i){
			System.out.println("Introduceti datele persoanei "+(i+1)+" :");
			System.out.println("Nume: ");
			String nume = sc.nextLine();
			System.out.println("Prenume: ");
			String prenume = sc.nextLine();
			System.out.println("CNP: ");
			String cnp = sc.nextLine();
			try{
				listaPersoane.add(new Persoana(nume, prenume, cnp));
			}catch (Exception e) {
				System.out.println("Date invalide");
			}
			System.out.println("");
		}
		int sumaVarste=0;
		for(Persoana p: listaPersoane){
			sumaVarste+=(Year.now().getValue()-p.getAnulNasterii());
		}
		double medieVarste=sumaVarste/n;
		System.out.println("Media varstelor este: "+medieVarste);
		*/
		/*
		ArrayList<Integer> listaInt = new ArrayList<Integer>();
		for(int i=0;i<n;++i){
			System.out.print("numar "+(i+1)+": ");
			listaInt.add(sc.nextInt());
		}
		*/
		ArrayList<String> listaInt = new ArrayList<String>();
		sc.nextLine();
		for(int i=0;i<n;++i){
			System.out.print("string "+(i+1)+": ");
			listaInt.add(sc.nextLine());
		}
	}
}