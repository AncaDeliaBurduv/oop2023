package calculgrade;

public class Grade{

	public static float convertCtoF (float gradeC){
		return (gradeC * 9.0 / 5.0)+32;
	}

	public static float convertFtoC (float gradeF){
		return (gradeF - 32) * 5.0 / 9.0;
	}
}