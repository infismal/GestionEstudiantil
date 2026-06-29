import BusinessLogic.StudentList;
import DataAccess.StudentDAO;
import DataAccess.StudentDTO;
import java.util.List;
public class app {

	void main() {
		StudentList sl = new StudentList();
		StudentDAO sd = new StudentDAO();
		try {
			StudentDTO sdt = new StudentDTO(202321742,"Adrian", "Muñoz",1750712950,"Ing.Compu","Sistemas");
			sd.delete(202321742);
		}catch(Exception e){
			e.printStackTrace();
		}
		IO.println(sl.toString());
	}
}
