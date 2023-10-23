import java.util.*;

public class Lab1Ex3{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.println("n=");
		int n=sc.nextInt();
		if(n<1000 || n>9999){
			System.out.println("Numarul nu are 4 cifre");
		}
		else{
			System.out.println("1. Afisare paritate ultima cifra");
			System.out.println("2. Afisare paritate prima cifra");
			System.out.println("3. Afisare suma cifrelor");
			int op=sc.nextInt();
			if(op==1){
				if(n%2==0){
					System.out.println("Ultima cifra e para");
				}
				else{
					System.out.println("Ultima cifra e impara");
				}
			}
			else if(op==2){
				if((n/1000)%2==0){
					System.out.println("Prima cifra e para");
				}
				else{
					System.out.println("Prima cifra e impara");
				}
			}
			else if(op==3){
				int tmp=n;
				int sum=0;
				for(int i=0;i<4;++i){
					sum+=(tmp%10);
					tmp/=10;
				}
				System.out.println("Suma cifrelor este "+sum);
			}
		}
	}
}