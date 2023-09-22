import java.util.*;

public class Laborator2
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		//ex1
		ContBancar cont1 = new ContBancar(0.0);
		System.out.print("Introduceti suma depusa:");
		cont1.depozitareSuma(sc.nextDouble());
		System.out.print("Introduceti suma depusa:");
		cont1.depozitareSuma(sc.nextDouble());
		
		//ex2
		ContBancar cont2 = new ContBancar(500);
		cont2.depozitareSuma(300);
		System.out.println("Sold curent: "+cont2.getSold());
		Random rnd = new Random();
		int nrOperatii = rnd.nextInt(1000);
		for(int i=0;i<nrOperatii;++i)
		{
			if(rnd.nextBoolean())
			{
				cont2.depozitareSuma(rnd.nextDouble()*100);
			}
			else
			{
				cont2.retragereSuma(rnd.nextDouble()*100);
			}
		}
		
		//ex3
		Masina m = new Masina();
		System.out.println("Tip masina: ");
		sc.nextLine();
		m.setTip(sc.nextLine());
		System.out.println("Culoare masina: ");
		m.setCuloare(sc.nextLine());
		System.out.println("Viteza masina: ");
		m.setViteza(sc.nextDouble());
		System.out.println("Tip: "+m.getTip());
		System.out.println("Culoare: "+m.getCuloare());
		System.out.println("Viteza: "+m.getViteza());
		System.out.println("masina m: "+m.toString());
		
		System.out.print("Numar de masini: ");
		int nrMasini = sc.nextInt();
		Masina masini[] = new Masina[nrMasini];
		for(int i=0;i<nrMasini;++i)
		{
			masini[i] = new Masina();
		}
	}
}
