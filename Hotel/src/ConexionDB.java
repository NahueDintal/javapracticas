import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.InputStream;

public class ConexionDB {
  private static final Properties properties = new Properties();

  static {
    try (InputStream input = new FileInputStream("config.properties")) {
      properties.load(input);
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException("Error cargando configuración", e);
    }
  }

  public static Connection getConnection() throws SQLException {
    String url = properties.getProperty("db.url");
    String user = properties.getProperty("db.user");
    String password = properties.getProperty("db.password");
    return DriverManager.getConnection(url, user, password);
  }
}
