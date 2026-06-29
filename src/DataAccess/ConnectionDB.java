package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static final String URL = "jdbc:sqlite:dataBase/estudiante.sqlite";
    private static Connection conn = null;

    // revisa si el método ya tiene una conexión abierta
    public static Connection connect() {
        try {
        	if(conn == null) {
        		conn = DriverManager.getConnection(URL);
        		System.out.println("Conexión exitosa a la base de datos.");
        	}
        	return conn;
        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }
        return conn;
    }

}
