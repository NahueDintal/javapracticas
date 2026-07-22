import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class HabitacionDAO {

  public Habitacion obtenerPorID(int id) throws SQLException {
    String sql = "SELECT id, precio_base, tipo, tiene_balcon, tiene_jacuzzi FROM habitacion WHERE id = ?";
    try (Connection conn = ConexionDB.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
      pstmt.setInt(1, id);
      try (ResultSet rs = pstmt.executeQuery()) {
        if (rs.next()) {
          return mapearHabitacion(rs);
        }
      }
    }
    return null;
  }

  public List<Habitacion> listarTodos() throws SQLException {
    List<Habitacion> habitaciones = new ArrayList<>();
    String sql = "SELECT id, precio_base, tipo, tiene_balcon, tiene_jacuzzi FROM habitacion";

    try (Connection conn = ConexionDB.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql) {
      while ( rs.next()) {
        habitaciones.add(mapearHabitacion(rs));
      }
    }
    return habitaciones;
  }

  public void insertar(Habitacion habitacion) throws SQLException {
    String sql;

    if (habitacion instanceof HabitacionSimple) {
      sql = "INSERT INTO habitacion (precio_base, tipo, tiene_balcon, tiene_jacuzzi) VALUES (?, 'simple', ?, null)";
    } else if (habitacion instanceof HabitacionSuite) {
      sql = "INSERT INTO habitacion (precio_base, tipo, tiene_balcon, tiene_jacuzzi) VALUES (?, 'suite', null, ?)";
    } else {
      throw new IllegalArgumentException("Tipo de habitacion no soportada");
    }

    try (Connection conn = ConexionDB.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
      pstmt.setDouble(1, habitacion.getPrecioBase());
      if (habitacion instanceof HabitacionSimple) {
        pstmt.setBoolean(2, ((HabitacionSimple) habitacion).getTieneBalcon());
      } else {
        pstmt.setBoolean(2, ((HabitacionSuite) habitacion).getTieneJacuzzi());
      }
      int afectadas = pstmt.executeUpdate();
      if (afectadas == 0) {
        throw new SQLException("No se pudo insertar habitacion.");
      }
      try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
        if (generatedKeys.next()) {
          habitacion.setId(generatedKeys.getInt(1));
        }
      }
    }
  }

  public void actualizar(Habitacion habitacion) throws SQLException {
    String sql;
    try (Connection conn = ConexionDB.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

    }
  }

} // fin de clase
