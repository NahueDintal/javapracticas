import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;

public class DatabaseConnection {
  private static final String URL = "jdbc:mysql://localhost:3306/seguridad_db";
  private static final String USER = "root";
  private static final String PASSWORD = "tu_contraseña";
  private static Connection connection = null;

  private DatabaseConnection() {
  }

  public static Connecion getConnection() {
    if(connection == null) {
      try {

      }
    }
  }

}
