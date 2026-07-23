import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class HabitacionDAO {

  public Habitacion obtenerPorId(int id) throws SQLException {
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

    try (Connection conn = ConexionDB.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql)) {
      while (rs.next()) {
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
    if (habitacion instanceof HabitacionSimple) {
      sql = "UPDATE habitacion SET precio_base = ?, tiene_balcon = ?, tiene_jacuzzi = ?, WHERE id = ?";
    } else if (habitacion instanceof HabitacionSuite) {
      sql = "UPDATE habitacion SET precio_base = ?, tiene_balcon = ?, tiene_jacuzzi = ?, WHERE id = ?";
    } else {
      throw new IllegalArgumentException("Tipo de habitacion no dispobible.");
    }
    try (Connection conn = ConexionDB.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
      pstmt.setDouble(1, habitacion.getPrecioBase());
      if (habitacion instanceof HabitacionSimple) {
        pstmt.setBoolean(2, ((HabitacionSimple) habitacion).getTieneBalcon());
      } else {
        pstmt.setBoolean(2, ((HabitacionSuite) habitacion).getTieneJacuzzi());
      }
      pstmt.setInt(3, habitacion.getId());
      pstmt.executeUpdate();
    }
  }

  public void eliminar(int id) throws SQLException {
    String sql = "DELETE FROM habitacion WHERE id = ?";
    try (Connection conn = ConexionDB.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
      pstmt.setInt(1, id);
      pstmt.executeUpdate();
    }
  }

  private Habitacion mapearHabitacion(ResultSet rs) throws SQLException {
    int id = rs.getInt("id");
    double precioBase = rs.getDouble("precio_base");
    String tipo = rs.getString("tipo");

    if ("simple".equalsIgnoreCase(tipo)) {
      boolean tieneBalcon = rs.getBoolean("tiene_balcon");
      return new HabitacionSimple(id, precioBase, tieneBalcon);
    } else if ("suite".equalsIgnoreCase(tipo)) {
      boolean tieneJacuzzi = rs.getBoolean("tiene_jacuzzi");
      return new HabitacionSuite(id, precioBase, tieneJacuzzi);
    } else {
      throw new SQLException("Tipo de habitacion desconocido: " + tipo);
    }
  }
} // fin de clase
