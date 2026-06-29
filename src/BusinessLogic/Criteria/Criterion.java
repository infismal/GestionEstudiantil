package Criteria;
import DataAccess.StudentDTO;

public  interface Criterion {

	boolean conditionIsSatisfied(StudentDTO myStudent);
	
}
