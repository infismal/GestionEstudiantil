package DataAccess;

import java.util.List;

public class GradesDTO{
	
	//datos de las notas dentro de la DB
	private float[] gradesOfMate;
	private float[] gradesOfPhysic;
	private float[] gradesOfAlgebra;
	private float[] gradesOfQuimic;
	
	private int idStudent;
	public int getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}

	public float[] getGradesOfMate() {
		return gradesOfMate;
	}

	public void setGradesOfMate(float[] gradesOfMate) {
		this.gradesOfMate = gradesOfMate;
	}

	public float[] getGradesOfPhysic() {
		return gradesOfPhysic;
	}

	public void setGradesOfPhysic(float[] gradesOfPhysic) {
		this.gradesOfPhysic = gradesOfPhysic;
	}

	public float[] getGradesOfAlgebra() {
		return gradesOfAlgebra;
	}

	public void setGradesOfAlgebra(float[] gradesOfAlgebra) {
		this.gradesOfAlgebra = gradesOfAlgebra;
	}

	public float[] getGradesOfQuimic() {
		return gradesOfQuimic;
	}

	public void setGradesOfQuimic(float[] gradesOfQuimic) {
		this.gradesOfQuimic = gradesOfQuimic;
	}

	
	public GradesDTO(int idStudent,String nameOfSubject, float[] grades) {
		this.idStudent = idStudent;
		switch(nameOfSubject) {
		case "Matemática" -> this.gradesOfMate = grades;
		case "Física" -> this.gradesOfPhysic = grades;
		case "Algebra" -> this.gradesOfAlgebra = grades;
		case "Química" -> this.gradesOfQuimic = grades;
		default -> throw new IllegalArgumentException("Materia no Válida: " + nameOfSubject);
		}
	}

}
