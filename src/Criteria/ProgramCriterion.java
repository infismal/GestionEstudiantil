package Criteria;

import DataAccess.StudentDTO;

public class ProgramCriterion implements Criterion {

	
	private String program;
	
	public ProgramCriterion(String program) {
		
		this.program = program;
	}
	
	
	@Override
	public boolean conditionIsSatisfied(StudentDTO myStudent) {
		
		return  myStudent.getCareer().equals(program);
	}
}
