public class TestLogger{
	public static void main (String[] args){
		LoggerSingleton.getInstance().writeLog("asdfghj");
		LoggerSingleton.getInstance().writeLog("qwertyuio");
		LoggerSingleton.getInstance().writeLog("xcvbnm");
	}
}