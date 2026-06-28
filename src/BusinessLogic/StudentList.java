package BusinessLogic;
import DataAccess.StudentDTO;


public class StudentList {
	
	private StudentNode Top, Bottom; 
	private int count;
	
	public StudentList()
	{
		Top = Bottom = null;
		count = 0;
	}
	
	public int getCount() {return count;}
	
	public boolean isEmpty() {return Top == null;}
	
	public void insert(StudentDTO myDto) {
		
		if(isEmpty())
		{
			Top = Bottom = new StudentNode(myDto);
			count++;
			return;
		}
			
		Bottom = Bottom.Next = new StudentNode(myDto);
		count++;
		
	}
	public void updateStudent(Integer idCard, StudentDTO student) {   
		
	// Is necessary to replace strings types with enum ones in order not to mess up things when modifying ._.
		
		if (idCard == null || student == null) {
	        throw new IllegalArgumentException("Datos inválidos");
	    }
		
		StudentNode aux = Top;
		
		while(aux != null)
		{
			if(idCard.equals(aux.getStudentDTO().getIdCard()))
			{
				aux.setStudentDTO(student);
				return;
			}
			
			aux = aux.Next;
		}
		
		throw new IllegalArgumentException("Estudiante no encontrado");
	}
	
	public StudentDTO search(Integer idCard) throws Exception {  // just some linear search
		
		if (idCard == null)
			throw new IllegalArgumentException("La cédula no puede ser nula.");
		   
		StudentNode aux = Top;
		
		while(aux != null)
		{
			if(idCard.equals(aux.getStudentDTO().getIdCard()))
				return aux.getStudentDTO();
			
			aux = aux.Next;
		}
		
		throw new Exception("El estudiante buscado no se encuentra registrado");
	}
	
	public void search() {   //  need to use strategy ??
		
		
	}
	public void delete(Integer idCard) throws Exception {
		
		if (idCard == null)
			throw new IllegalArgumentException("La cédula no puede ser nula.");
		
		if(isEmpty())
			throw new Exception("No se encuentra registrado ningún estudiante");
		
		if(Top.getStudentDTO().getIdCard().equals(idCard))
		{
			if(Top == Bottom)
			{
				Top = Bottom = null;
				count = 0;
				return;
			}
			
			Top = Top.Next;
			count--;
			return;
		}
		
		StudentNode prev = Top, aux = Top.Next;
		
		while(aux != null)
		{
			if(aux.getStudentDTO().getIdCard().equals(idCard))
			{
				prev.Next = aux.Next;
				count--;
				if(aux == Bottom)
					Bottom = prev;
				
				return;
			}
			prev = aux;
			aux = aux.Next;
		}
		
		throw new Exception("El estudiante requerido no se encuentra registrado");
		
	}
	
	@Override
	public String toString() {
		
		if(isEmpty())
			return "Actualmente no hay estudiantes registrados";
		
		StringBuilder sb = new StringBuilder();

		StudentNode aux = Top;

		while (aux != null) {
		    StudentDTO student = aux.getStudentDTO();

		    sb.append("---------------\n")
		      .append("Estudiante:\t")
		      .append(student.getName())
		      .append(" ")
		      .append(student.getLastName())
		      .append("\n")
		      .append("Facultad:\t")
		      .append(student.getFaculty())
		      .append("\n")
		      .append("Carrera:\t")
		      .append(student.getProgram())
		      .append("\n")
		      .append("Código Único del Estudiante:\t")
		      .append(student.getIdStudent())
		      .append("\n")
		      .append("Num de Cédula del Estudiante:\t")
		      .append(student.getIdCard())
		      .append("\n");

		    aux = aux.Next;
		}
		
		return sb.toString();
		
	}
	
}
