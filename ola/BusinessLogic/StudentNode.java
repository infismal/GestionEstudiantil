package BusinessLogic;
import DataAccess.StudentDTO;


public class StudentNode {

	private StudentDTO Student;
	protected StudentNode Next;
	
	public StudentNode(StudentDTO Student) {
		
		Next = null;
		this.Student = Student;
	}
	
	public StudentDTO getStudentDTO() {return Student;}
	
	public void setStudentDTO(StudentDTO Student) {this.Student = Student;}
	
	
}
