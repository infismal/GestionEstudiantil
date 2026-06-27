package DataAccess;

public class StudentDTO {
	
	// Datos básicos del estudiante
    private Integer IdStudent	  ;
    private String 	Name		  ;
    private String 	LastName	  ;
    private String 	IdCard		  ;
    private String  State         ; 
    private String  CreationDate  ; 
    private String  ModifiedDate  ;
    
    // Las materias (como mencionaste que son 3, las incluimos aquí)
    private double[] mathGrades = new double[5]; // Ejemplo de 5 notas
    private double[] languageGrades = new double[5];
    private double[] physicGrades = new double[5];

    // Constructor vacío (necesario para el Helper o para instanciar manualmente)
    public StudentDTO() {}

    // Constructor completo
    public StudentDTO(Integer idStudent, String name, String lastName, String idCard) {
        this.IdStudent = idStudent;
        this.Name = name;
        this.LastName = lastName;
        this.IdCard = idCard;
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

	public String getIdCard() {
		return IdCard;
	}

	public void setIdCard(String idCard) {
		IdCard = idCard;
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
        + "\n State        : "+ getState          ()
        + "\n CreationDate : "+ getCreationDate   ()
        + "\n ModifiedDate : "+ getModifiedDate   ();
    }

}
