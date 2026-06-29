package Criteria;

import DataAccess.StudentDTO;

public class FacultyCriterion implements Criterion{

	private String faculty;
	
	public FacultyCriterion(String faculty) {
		
		this.faculty = faculty;
	}
	
	
	@Override
	public boolean conditionIsSatisfied(StudentDTO myStudent) {
		
		return myStudent.getFaculty().equals(faculty);
	}
}
