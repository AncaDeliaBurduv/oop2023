import java.io.*;

public class LoggerSingleton{
	
	private static LoggerSingleton instance;
	
	private FileWriter log;
	private BufferedWriter out;
	
	private LoggerSingleton(){
		try {
			log = new FileWriter("log.txt");
			out = new BufferedWriter(log);
		}
		catch (IOException e) {
			System.err.println("Eroare creeare logger.");
			e.printStackTrace();
		}
	}
	
	public static LoggerSingleton getInstance(){
		if(null == instance){
			instance = new LoggerSingleton();
		}
		return instance;
	}
	
	public boolean writeLog(String s){
		try{
			out.write(s);
			out.newLine();
			return true;
		}
		catch (IOException e){
			System.err.println("Eroare scriere in logger.");
			e.printStackTrace();
			return false;
		}
	}
	
}