import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int nrThreads;
        Scanner sc= new Scanner(System.in);
        System.out.println("nr:");
        nrThreads=sc.nextInt();
        Thread[] threads=new Thread[nrThreads];
        for(int i=0;i<nrThreads;++i){
            final int threadNumber=i;
            threads[i]=new Thread(()->{
                System.out.println("Thread "+threadNumber+" has started.");
                try {
                    threads[threadNumber].sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread "+threadNumber+" has finished Running.");
            });
        }
        for(int i=0;i<nrThreads;++i){
            threads[i].start();
        }
    }
}