package BusinessLogic;

public class StudentTree {
	SubjectNode root;

    public StudentTree() {
        root = null;
    }

    //CHECK IF THE STUDENT TREE IS EMPTY
    public boolean isEmpty() {
    	if(root!=null)
    		return false;
    	else
    		return true;
    }
    
    
    // INSERT NODE
    public int insertNode(int idStudent, String[] subjects, int numGrades) {
    	root = insertRec(root, idStudent, subjects, numGrades);
    	return idStudent;
    }

    private SubjectNode insertRec(SubjectNode actual, int newIdStudent, String[] subjects, int numGrades) {

        if (actual == null) {
            return new SubjectNode(newIdStudent, subjects, numGrades);
        }

        if (newIdStudent < actual.idStudent) {
            actual.left = insertRec(actual.left, newIdStudent, subjects, numGrades);
        } else if (newIdStudent > actual.idStudent) {
            actual.right = insertRec(actual.right, newIdStudent, subjects, numGrades);
        }

        return actual;
    }

    
    // SEARCH
    public boolean findNode(int idStudent) {
        return searchRec(root, idStudent);
    }

    private boolean searchRec(SubjectNode actual, int wantedIdStudent) {

        if (actual == null) {
            return false;
        }

        if (actual.idStudent == wantedIdStudent) {
            return true;
        }

        if (wantedIdStudent < actual.idStudent) {
            return searchRec(actual.left, wantedIdStudent);
        } else {
            return searchRec(actual.right, wantedIdStudent);
        }
    }

    
    // DELETE
    public int deleteNode(int idStudent) {
        root = deleteRec(root, idStudent);
        return idStudent;
    }

    private SubjectNode deleteRec(SubjectNode actual, int idStudentToDlt) {
        if (actual == null) {
            return null;
        }

        if (idStudentToDlt < actual.idStudent) {
            actual.left = deleteRec(actual.left, idStudentToDlt);
        } else {
        	if (idStudentToDlt > actual.idStudent) {
        		actual.right = deleteRec(actual.right, idStudentToDlt);
        	} else {

        			// CASO 1: Nodo hoja
        			if (actual.left == null && actual.right == null) {
        				return null;
        			}

        			// CASO 2: Un solo hijo derecho
        			if (actual.left == null) {
        				return actual.right;
        			}

        			// CASO 2: Un solo hijo izquierdo
        			if (actual.left == null) {
        				return actual.right;
        			}

        			// CASO 3: Dos hijos
        			int lowerId = getLowerId(actual.right);
        			actual.idStudent = lowerId;

        			actual.right = deleteRec(actual.right, lowerId);
        	}
        }

        return actual;
    }

    // GET THE LOWER ID STUDENT FROM THE RIGHT SUBTREE
    private int getLowerId(SubjectNode rightSubTree) {

        int lower = rightSubTree.idStudent;

        while (rightSubTree.left != null) {
            lower = rightSubTree.left.idStudent;
            rightSubTree = rightSubTree.left;
        }

        return lower;
    }
    
    //SHOW GRADES
    public boolean getSubjectGrades(int idStudent) {
    	boolean found = findNode(idStudent);
    	if (found == true) {
    		//for(Subject subject : ) {
    			
    		//}
    		return false;
    	} else {
    		return found;
    	}
    }
}
