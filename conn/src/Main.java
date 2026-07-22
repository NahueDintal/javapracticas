import java.sql.*;

public class Main {
  public static void main(String[] args) {
    String url = "jdbc:mariadb://localhost:3306/Hotel";
    String user = "root";
    String password = "canela";

    try (Connection conn = DriverManager.getConnection(url, user, password)) {
      System.out.println("✅ Conectading...");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
