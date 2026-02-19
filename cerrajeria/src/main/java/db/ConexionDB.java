import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
  private static final String URL = "jdbc:mysql://localhost:3306/seguridad_db";
  private static final String USUARIO = "root";
  private static final String PASSWORD = "tu_contraseña";
  private static Connection connection = null;

  private ConexionDB() {
  }

  public static Connection getConnection() throws SQLException {
    if (connection == null || connection.isClosed()) {
      try {
        connection = DriverManager.getConnection(URL, USUARIO, PASSWORD);
        System.out.println("Conexión exitosa!");
      } catch (SQLException e) {
        System.out.println("Error de conexión: " + e.getMessage());
        throw e;
      }
    }
    return connection;
  }

  public static void closeConnection() {
    if (connection != null) {
      try {
        connection.close();
        System.out.println("Conexión cerrada.");
      } catch (SQLException e) {
        System.out.println("Error al cerrar la conexión: " + e.getMessage());
      }
    }
  }
}
