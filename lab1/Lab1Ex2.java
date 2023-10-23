import java.util.*;

public class Lab1Ex2{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.println("n1=");
		int n1=sc.nextInt();
		System.out.println("n2=");
		int n2=sc.nextInt();
		System.out.println("suma: "+(n1+n2));
		System.out.println("produsul: "+(n1*n2));
		System.out.println("catul: "+(n1/n2));
		System.out.println("restul: "+(n1%n2));
		Random rand=new Random();
		int r1=rand.nextInt(100);
		int r2=rand.nextInt(100);
		System.out.println("n1 * "+r1+" = "+(n1*r1));
		System.out.println("n2 * "+r2+" = "+(n2*r2));
	}
}