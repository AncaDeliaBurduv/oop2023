import java.util.*;

public class Lab1Ex1{
	public static void main(String args[]){
		System.out.println("suma: "+(Integer.parseInt(args[0])+Integer.parseInt(args[1])));
		System.out.println("produsul: "+(Integer.parseInt(args[0])*Integer.parseInt(args[1])));
		System.out.println("catul: "+(Integer.parseInt(args[0])/Integer.parseInt(args[1])));
		System.out.println("restul: "+(Integer.parseInt(args[0])%Integer.parseInt(args[1])));
		Random rand=new Random();
		int r1=rand.nextInt(100);
		int r2=rand.nextInt(100);
		System.out.println("n1 * "+r1+" = "+(Integer.parseInt(args[0])*r1));
		System.out.println("n2 * "+r2+" = "+(Integer.parseInt(args[1])*r2));
	}
}