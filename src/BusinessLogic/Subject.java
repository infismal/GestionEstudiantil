package BusinessLogic;

public class Subject {

	String name;
	float[] grades;
	
	public Subject(String name, int numGrades) {
		this.name = name;
		this.grades = new float[numGrades];
	}
}
