public class Student{
	private int student_id;
	private String student_name;
	private int note[]= new int[100];
	private int nrNote=0;
	
	public int getStudent_id(){
		return student_id;
	}
	public void setStudent_id(int id){
		student_id=id;
	}
	
	public String student_name(){
		return student_name;
	}
	public void setStudent_name(String nume){
		student_name=nume;
	}
	
	public void addGrade(int nota){
		if(nota<1 || nota>10){
			System.out.prinln("Nota invalida");
		}
		else if(note.length==nrNote){
			System.out.prinln("Nu mai este loc de note");
		}
		else{
			note[nrNote]=nota;
			++nrNote;
		}
	}
}