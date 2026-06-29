package Criteria;

import DataAccess.StudentDTO;

public class AndCriteria implements Criterion {

	private Criterion[] criteria;
	
	public AndCriteria(Criterion... criteria) {
		
		this.criteria = criteria;
	}
	
	@Override
	public boolean conditionIsSatisfied(StudentDTO myStudent) {
		
		for(Criterion c : criteria) {
		
			if(!c.conditionIsSatisfied(myStudent))
				return false;
		}
		
		return true;
	}

}
