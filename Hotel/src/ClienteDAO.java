import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
  public Cliente obtenerPorId(int id) throws SQLException {
    String sql = "SELECT id, nombre, es_frecuente FROM cliente WHERE id = ?";
    try (Connection conn = ConexionDB.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
      pstmt.setInt(1, id);
      try (ResultSet rs = pstmt.executeQuery()) {
        if (rs.next()) {
          return mapearCliente(rs);
        }

      }
    }
    return null;
  }

  public List<Cliente> listarTodos() throws SQLException {
    List<Clientes> clientes = new ArrayList<>();
    String sql = "SELECT id, nombre, es_frecuente FROM cliente";
    try (Connection conn = ConexionDB.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql)) {
      while (rs.next()) {
        clientes.add(mapearCliente(rs));
      }
    }
    return clientes;
  }

  public void insertar(Cliente cliente) throws SQLException {
    String sql = "INSERT INTO cliente (nombre, es_frecuente) VALUES (?, ?)";
    try (Connection conn = ConexionDB.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
      pstmt.setString(1, cliente.getNombre());
      pstmt.setBoolean(2, cliente.getEsFrecuente());
      int afectadas = pstmt.executeUpdate();
      if (afectadas == 0) {
        throw new SQLException("No se pudo insertad cliente.");
      }
      try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
        if (generatedKeys.next()) {
          cliente.setId(generatedKeys.getInt(1));
        }
      }
    }
  }

  public void actualizar(Cliente cliente) throws SQLException {
    String sql = "UPDATE cliente SET nombre = ?, es_frecuente = ? WHERE id = ?";
    try (Connection conn = ConexionDB.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
      pstmt.setString(1, cliente.getNombre());
      pstmt.setBoolean(2, cliente.getEsFrecuente());
      pstmt.setInt(3, cliente.getId());
      pstmt.executeUpdate();
    }
  }

  public void eliminar(int id) throws SQLException {
    String sql = "DETELE FROM cliente WHERE id = ?";
    try (Connection conn = ConexionDB.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
      pstmt.setInt(1, id);
      pstmt.executeUpdate();
    }
  }

  private Cliente mapearCliente(ResultSet rs) throws SQLException {
    int id = rs.getInt("id");
    String nombre = rs.getString("nombre");
    boolean esFrecuente = rs.getBoolean("es_frecuente");
    return new Cliente(id, nombre, esFrecuente);
  }

} // fin de clase;
