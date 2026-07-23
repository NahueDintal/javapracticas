import java.time.LocalDate;

public class Main {
  public static void main(String[] args) {
    try {
      ClienteDAO clienteDAO = new ClienteDAO();
      HabitacionDAO habitacionDAO = new HabitacionDAO();
      ReservaDAO reservaDAO = new ReservaDAO();

      Cliente cliente = new Cliente(0, "María Pérez", true);
      clienteDAO.insertar(cliente); // Se asigna el ID automático
      System.out.println("Cliente insertado con ID: " + cliente.getId());

      HabitacionSimple hab = new HabitacionSimple(0, 120.0, true);
      habitacionDAO.insertar(hab);
      System.out.println("Habitación insertada con ID: " + hab.getId());

      Reserva reserva = new Reserva(0,
          LocalDate.now(),
          LocalDate.now().plusDays(3),
          cliente,
          hab);
      reservaDAO.insertar(reserva);
      System.out.println("Reserva insertada con ID: " + reserva.getId());

      Reserva reservaRecuperada = reservaDAO.obtenerPorId(reserva.getId());
      System.out.println("Total de la reserva: " + reservaRecuperada.calcularTotal());

      System.out.println("Lista de reservas:");
      for (Reserva r : reservaDAO.listarTodos()) {
        System.out.println("Reserva ID: " + r.getId() +
            ", Cliente: " + r.getCliente().getNombre() +
            ", Total: " + r.calcularTotal());
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
