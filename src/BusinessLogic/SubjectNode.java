package BusinessLogic;

public class SubjectNode {

	private int idStudent;
	public int getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}

	public String[] getSubjectNames() {
		return subjectNames;
	}

	public void setSubjectNames(String[] subjectNames) {
		this.subjectNames = subjectNames;
	}

	public int[][] getGrades() {
		return grades;
	}

	public void setGrades(int[][] grades) {
		this.grades = grades;
	}

	public SubjectNode getLeft() {
		return left;
	}

	public void setLeft(SubjectNode left) {
		this.left = left;
	}

	public SubjectNode getRight() {
		return right;
	}

	public void setRight(SubjectNode right) {
		this.right = right;
	}

	private String[] subjectNames;
	private int[][] grades;
	private SubjectNode left;
	private SubjectNode right;
	
	public SubjectNode (int idStudent, String[] subjectsNames, int[] Grades) {
		this.left = null;
		this.right = null;
		this.idStudent = idStudent;
		this.grades = new int[subjectsNames.length][5];
		for (int i = 0; i < subjectsNames.length; i++) {
			for (int j = 0; j < Grades.length; j++) {
				grades[i][j] = Grades[j];
			}
		}
	}
}
