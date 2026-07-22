import java.time.LocalDate;

public class Main {
  public static void main(String[] args) {
    try {
      // 1. Crear DAOs
      ClienteDAO clienteDAO = new ClienteDAO();
      HabitacionDAO habitacionDAO = new HabitacionDAO();
      ReservaDAO reservaDAO = new ReservaDAO();

      // 2. Crear un cliente
      Cliente cliente = new Cliente(0, "María Pérez", true);
      clienteDAO.insertar(cliente); // Se asigna el ID automático
      System.out.println("Cliente insertado con ID: " + cliente.getId());

      // 3. Crear una habitación simple
      HabitacionSimple hab = new HabitacionSimple(0, 120.0, true);
      habitacionDAO.insertar(hab);
      System.out.println("Habitación insertada con ID: " + hab.getId());

      // 4. Crear una reserva
      Reserva reserva = new Reserva(0,
          LocalDate.now(),
          LocalDate.now().plusDays(3),
          cliente,
          hab);
      reservaDAO.insertar(reserva);
      System.out.println("Reserva insertada con ID: " + reserva.getId());

      // 5. Recuperar y mostrar la reserva
      Reserva reservaRecuperada = reservaDAO.obtenerPorId(reserva.getId());
      System.out.println("Total de la reserva: " + reservaRecuperada.calcularTotal());

      // 6. Listar todas las reservas
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
