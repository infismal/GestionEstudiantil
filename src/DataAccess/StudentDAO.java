package DataAccess;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements IDAO<StudentDTO> {
	



	// método revisado funcional create
    @Override
    public boolean create(StudentDTO st) throws Exception {
        String sql = "INSERT INTO Student (IdStudent,Name, LastName, IdCard, Career, Faculty) VALUES (?, ?, ?, ?, ?,?)";
        try (Connection conn = ConnectionDB.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
        	stmt.setInt(1, st.getIdStudent());
            stmt.setString(2, st.getName());
            stmt.setString(3, st.getLastName());
            stmt.setInt(4, st.getIdCard());       
            stmt.setString(5, st.getCareer());
            stmt.setString(6, st.getFaculty());  
            return stmt.executeUpdate() > 0;
        } 
    }

    // método revisado funcional readAll
    @Override
    public List<StudentDTO> readAll() throws Exception {
        List<StudentDTO> lista = new ArrayList<>();
        String sql = "SELECT * FROM Student WHERE State = 'A'";
        try (Connection conn = ConnectionDB.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                StudentDTO st = new StudentDTO();
                st.setIdStudent(rs.getInt("IdStudent"));
                st.setName(rs.getString("Name"));
                st.setLastName(rs.getString("LastName"));
                st.setIdCard(rs.getInt("IdCard"));         
                st.setCareer(rs.getString("Career"));
                st.setFaculty(rs.getString("Faculty"));
                st.setState(rs.getString("State"));
                st.setCreationDate(rs.getString("CreationDate"));
                st.setModifiedDate(rs.getString("ModifiedDate"));
                lista.add(st);
            }
        } 
        return lista;
    }
// funciona update
    @Override
    public boolean update(StudentDTO st) throws Exception {
        String sql = "UPDATE Student SET Name = ?, LastName = ?, IdCard = ?, Career = ?, Faculty = ?, ModifiedDate = datetime('now','localtime') WHERE IdStudent = ?";
        try (Connection conn = ConnectionDB.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, st.getName());
            stmt.setString(2, st.getLastName());
            stmt.setInt(3, st.getIdCard());       
            stmt.setString(4, st.getCareer());   
            stmt.setString(5, st.getFaculty());  
            stmt.setInt(6, st.getIdStudent());
            return stmt.executeUpdate() > 0;
        } 
    }
// método delete funcional
    @Override
    public boolean delete(Integer id) throws Exception {
        String sql = "UPDATE Student SET State = 'X', ModifiedDate = datetime('now','localtime') WHERE IdStudent = ?";
        try (Connection conn = ConnectionDB.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } 
    }
    //método readBy borrado

}