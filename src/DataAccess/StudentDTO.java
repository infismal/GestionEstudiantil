package DataAccess;

public class StudentDTO {
	
	// Datos básicos del estudiante
    private Integer IdStudent	  ;
    private String 	Name		  ;
    private String 	LastName	  ;
    private Integer IdCard		  ;
    private String 	Program		  ;
    private String 	Faculty		  ;
    private String  State         ; 
    private String  CreationDate  ; 
    private String  ModifiedDate  ;
   

	// Constructor vacío
    public StudentDTO() {}

    // Constructor completo
    public StudentDTO(Integer idStudent, String name, String lastName, Integer idCard, String program, String faculty, String state,
			String creationDate, String modifiedDate) {
		IdStudent = idStudent;
		Name = name;
		LastName = lastName;
		IdCard = idCard;
		Program = program;
		Faculty = faculty;
		State = state;
		CreationDate = creationDate;
		ModifiedDate = modifiedDate;
	}
    
    public StudentDTO(Integer idStudent, String name, String lastName, Integer idCard, String program, String faculty) {
        this.IdStudent = idStudent;
        this.Name = name;
        this.LastName = lastName;
        this.IdCard = idCard;
        this.Program = program;
        this.Faculty = faculty;
    }

	public Integer getIdStudent() {
		return IdStudent;
	}

	public void setIdStudent(Integer idStudent) {
		IdStudent = idStudent;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public Integer getIdCard() {
		return IdCard;
	}

	public void setIdCard(Integer idCard) {
		IdCard = idCard;
	}
	
	public String getProgram() {
		return Program;
	}

	public void setProgram(String program) {
		Program = program;
	}

	public String getFaculty() {
		return Faculty;
	}

	public void setFaculty(String faculty) {
		Faculty = faculty;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getCreationDate() {
		return CreationDate;
	}

	public void setCreationDate(String creationDate) {
		CreationDate = creationDate;
	}

	public String getModifiedDate() {
		return ModifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		ModifiedDate = modifiedDate;
	}

	public double[] getMathGrades() {
		return mathGrades;
	}

	public void setMathGrades(double[] mathGrades) {
		this.mathGrades = mathGrades;
	}

	public double[] getLanguageGrades() {
		return languageGrades;
	}

	public void setLanguageGrades(double[] languageGrades) {
		this.languageGrades = languageGrades;
	}

	public double[] getPhysicGrades() {
		return physicGrades;
	}

	public void setPhysicGrades(double[] physicGrades) {
		this.physicGrades = physicGrades;
	}

	@Override
    public String toString() {
        return getClass().getName()
        + "\n IdStudent		: "+ getIdStudent        () 
        + "\n Name        : "+ getName          ()
        + "\n LastName      : "+ getLastName        ()
        + "\n IdCard        : "+ getIdCard          ()
        + "\n Program        : "+ getProgram()
        + "\n Faculty        : "+ getFaculty()
        + "\n State        : "+ getState          ()
        + "\n CreationDate : "+ getCreationDate   ()
        + "\n ModifiedDate : "+ getModifiedDate   ();
    }

}
