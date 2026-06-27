package DataAccess;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements IDAO<StudentDTO> {
	
	// Método auxiliar para obtener la fecha y hora actual
    private String getNow() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public boolean create(StudentDTO st) {
        // Incluimos campos de auditoría: State = 'A' y CreationDate
        String sql = "INSERT INTO Student (Name, LastName, IdCard, State, CreationDate) VALUES (?, ?, ?, 'A', ?)";
        try (Connection conn = ConnectionDB.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, st.getName());
            stmt.setString(2, st.getLastName());
            stmt.setString(3, st.getIdCard());
            stmt.setString(4, getNow()); // Inyectamos fecha de creación
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al insertar: " + e.getMessage());
            return false;
        }
    }

    public List<StudentDTO> readAll() {
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
                st.setIdCard(rs.getString("IdCard"));
                st.setState(rs.getString("State"));
                st.setCreationDate(rs.getString("CreationDate"));
                st.setModifiedDate(rs.getString("ModifiedDate"));
                lista.add(st);
            }
        } catch (SQLException e) {
            System.err.println("Error al leer: " + e.getMessage());
        }
        return lista;
    }

    public boolean update(StudentDTO st) {
        // Actualizamos datos y la fecha de modificación
        String sql = "UPDATE Student SET Name = ?, LastName = ?, IdCard = ?, ModifiedDate = ? WHERE IdStudent = ?";
        try (Connection conn = ConnectionDB.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, st.getName());
            stmt.setString(2, st.getLastName());
            stmt.setString(3, st.getIdCard());
            stmt.setString(4, getNow()); // Inyectamos fecha de modificación
            stmt.setInt(5, st.getIdStudent());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar: " + e.getMessage());
            return false;
        }
    }

    public boolean delete(int idStudent) {
        // Eliminación lógica y actualizamos fecha de modificación
        String sql = "UPDATE Student SET State = 'X', ModifiedDate = ? WHERE IdStudent = ?";
        try (Connection conn = ConnectionDB.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, getNow());
            stmt.setInt(2, idStudent);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar: " + e.getMessage());
            return false;
        }
    }
	

}
