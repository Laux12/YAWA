import java.util.ArrayList;

public class Student {
	private String name;
	private String program;
	private String year;
	private int id;
	private ArrayList<enrolledSubject> subjects = new ArrayList<>();
	private ArrayList<Float> grades = new ArrayList<>();
	private boolean enrolled = false;
	Student(int id,String name, String year, String program){
		this.id = id;
		this.name = name;
		this.program = program;
		this.year = year;
	}
	public int getID() {
		return id;
	}
	public String getName() {
		return name;
		
	}
	public String getProgram() {
		return program;
		
	}
	public String getYear() {
		return year;
		
	}
	
	public void setNewInfo(String name,String year,String program) {
		this.name = name;
		this.year = year;
		this.program = program;
	}
	
	
	
	public void addSubject(enrolledSubject subject) {
		subjects.add(subject);
	}
	public ArrayList<enrolledSubject> getSubject() {
		return subjects;
		
	}
	public void addGrade(float grade) {
		grades.add((float) grade);
	}
	public void setGrade(int index,float grade) {
		grades.set(index, grade);
	}
	public ArrayList<Float> getGrades(){
		return grades;
	}
	public void setEnrolled(boolean enroll) {
		this.enrolled = enroll;
	}
	public boolean getEnrolled() {
		return enrolled;
	}
}
