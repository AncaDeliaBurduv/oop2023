import java.util.Scanner;

public class Lab9Ex2 {
    public static String s = "qwertyuiopasdfghjklzxcvbnm";
    public  static int startIndex=0;
    public  static int endIndex=s.length()-1;

    public static void main(String[] args) {
        Thread t1=new Thread(()->{
            //int startIndex=0;
            while(startIndex<endIndex){
                System.out.println("Thread 1: "+s.charAt(startIndex));
                ++startIndex;
            }
        });
        Thread t2=new Thread(()->{
            //int endIndex=s.length()-1;
            while(endIndex>startIndex){
                System.out.println("Thread 2: "+s.charAt(endIndex));
                --endIndex;
            }
        });
        t1.start();
        t2.start();
    }
}
