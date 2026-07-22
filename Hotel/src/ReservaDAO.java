import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO {

  private ClienteDAO clienteDAO = new ClienteDAO();
  private HabitacionDAO habitacionDAO = new HabitacionDAO();

  public Reserva obtenerPorId(int id) throws SQLException {
    String sql = "SELECT r.id, r.fecha_entrada, r.fecha_salida, " +
        "r.cliente_id, r.habitacion_id " +
        "FROM reserva r WHERE r.id = ?";
    try (Connection conn = ConexionDB.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
      pstmt.setInt(1, id);
      try (ResultSet rs = pstmt.executeQuery()) {
        if (rs.next()) {
          return mapearReserva(rs);
        }
      }
    }
    return null;
  }

  public List<Reserva> listarTodos() throws SQLException {
    List<Reserva> reservas = new ArrayList<>();
    String sql = "SELECT r.id, r.fecha_entrada, r.fecha_salida, " +
        "r.cliente_id, r.habitacion_id " +
        "FROM reserva r";
    try (Connection conn = ConexionDB.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql)) {
      while (rs.next()) {
        reservas.add(mapearReserva(rs));
      }
    }
    return reservas;
  }

  // Insertar una nueva reserva (asume que cliente y habitación ya están guardados
  // con sus IDs)
  public void insertar(Reserva reserva) throws SQLException {
    String sql = "INSERT INTO reserva (fecha_entrada, fecha_salida, cliente_id, habitacion_id) VALUES (?, ?, ?, ?)";
    try (Connection conn = ConexionDB.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
      pstmt.setDate(1, Date.valueOf(reserva.getFechaEntrada()));
      pstmt.setDate(2, Date.valueOf(reserva.getFechaSalida()));
      pstmt.setInt(3, reserva.getCliente().getId());
      pstmt.setInt(4, reserva.getHabitacion().getId());
      int afectadas = pstmt.executeUpdate();
      if (afectadas == 0) {
        throw new SQLException("No se pudo insertar la reserva");
      }
      try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
        if (generatedKeys.next()) {
          // Asignar ID a la reserva (necesitarás setter en Reserva)
          reserva.setId(generatedKeys.getInt(1));
        }
      }
    }
  }

  // Actualizar una reserva (cambiar fechas, cliente o habitación)
  public void actualizar(Reserva reserva) throws SQLException {
    String sql = "UPDATE reserva SET fecha_entrada = ?, fecha_salida = ?, cliente_id = ?, habitacion_id = ? WHERE id = ?";
    try (Connection conn = ConexionDB.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
      pstmt.setDate(1, Date.valueOf(reserva.getFechaEntrada()));
      pstmt.setDate(2, Date.valueOf(reserva.getFechaSalida()));
      pstmt.setInt(3, reserva.getCliente().getId());
      pstmt.setInt(4, reserva.getHabitacion().getId());
      pstmt.setInt(5, reserva.getId());
      pstmt.executeUpdate();
    }
  }

  public void eliminar(int id) throws SQLException {
    String sql = "DELETE FROM reserva WHERE id = ?";
    try (Connection conn = ConexionDB.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
      pstmt.setInt(1, id);
      pstmt.executeUpdate();
    }
  }

  // Mapeo: construye la Reserva y carga los objetos Cliente y Habitacion usando
  // los DAOs
  private Reserva mapearReserva(ResultSet rs) throws SQLException {
    int id = rs.getInt("id");
    LocalDate fechaEntrada = rs.getDate("fecha_entrada").toLocalDate();
    LocalDate fechaSalida = rs.getDate("fecha_salida").toLocalDate();
    int clienteId = rs.getInt("cliente_id");
    int habitacionId = rs.getInt("habitacion_id");

    // Cargar el cliente y la habitación completos
    Cliente cliente = clienteDAO.obtenerPorId(clienteId);
    Habitacion habitacion = habitacionDAO.obtenerPorId(habitacionId);

    return new Reserva(id, fechaEntrada, fechaSalida, cliente, habitacion);
  }
}
