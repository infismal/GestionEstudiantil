package DataAccess;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements IDAO<StudentDTO> {
	
    // Fecha y hora actual!!
    private String getNow() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    @Override
    public boolean create(StudentDTO st) throws Exception {
        String sql = "INSERT INTO Student (Name, LastName, IdCard, Carreer, Faculty, State, CreationDate) VALUES (?, ?, ?, ?, ?, 'A', ?)";
        try (Connection conn = ConnectionDB.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, st.getName());
            stmt.setString(2, st.getLastName());
            stmt.setInt(3, st.getIdCard());       
            stmt.setString(4, st.getProgram());
            stmt.setString(5, st.getFaculty()); 
            stmt.setString(6, getNow()); 
            return stmt.executeUpdate() > 0;
        } 
    }

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
                st.setProgram(rs.getString("Program"));
                st.setFaculty(rs.getString("Faculty"));
                st.setState(rs.getString("State"));
                st.setCreationDate(rs.getString("CreationDate"));
                st.setModifiedDate(rs.getString("ModifiedDate"));
                lista.add(st);
            }
        } 
        return lista;
    }

    @Override
    public boolean update(StudentDTO st) throws Exception {
        // Se añade 'Carreer' al UPDATE
        String sql = "UPDATE Student SET Name = ?, LastName = ?, IdCard = ?, Carreer = ?, Faculty = ?, ModifiedDate = ? WHERE IdStudent = ?";
        try (Connection conn = ConnectionDB.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, st.getName());
            stmt.setString(2, st.getLastName());
            stmt.setInt(3, st.getIdCard());       
            stmt.setString(4, st.getProgram());   
            stmt.setString(5, st.getFaculty()); 
            stmt.setString(6, getNow()); 
            stmt.setInt(6, st.getIdStudent());
            return stmt.executeUpdate() > 0;
        } 
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String sql = "UPDATE Student SET State = 'X', ModifiedDate = ? WHERE IdStudent = ?";
        try (Connection conn = ConnectionDB.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, getNow());
            stmt.setInt(2, id);
            return stmt.executeUpdate() > 0;
        } 
    }

    @Override
    public StudentDTO readBy(Integer id) throws Exception {
        StudentDTO st = null;
        String sql = "SELECT * FROM Student WHERE IdStudent = ? AND State = 'A'";
        try (Connection conn = ConnectionDB.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    st = new StudentDTO();
                    st.setIdStudent(rs.getInt("IdStudent"));
                    st.setName(rs.getString("Name"));
                    st.setLastName(rs.getString("LastName"));
                    st.setIdCard(rs.getInt("IdCard"));         
                    st.setProgram(rs.getString("Program"));
                    st.setFaculty(rs.getString("Faculty"));
                    st.setState(rs.getString("State"));
                    st.setCreationDate(rs.getString("CreationDate"));
                    st.setModifiedDate(rs.getString("ModifiedDate"));
                }
            }
        }
        return st;
    }

}