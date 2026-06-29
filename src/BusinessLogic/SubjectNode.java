package BusinessLogic;

public class SubjectNode {

	int idStudent;
	Subject [] subjects;
	SubjectNode left;
	SubjectNode right;
	
	public SubjectNode (int idStudent, String[] subjectsNames, int numGrades) {
		this.left = null;
		this.right = null;
		this.idStudent = idStudent;
		this.subjects = new Subject[subjectsNames.length];
		for (int i = 0; i <= subjectsNames.length; i++) {
			this.subjects[i] = new Subject(subjectsNames[i], numGrades);
		}
	}
}
