import java.util.ArrayList;

public class Hotel {
  public ArrayList<Habitacion> habitaciones;
  public ArrayList<Reserva> reservas;

  public Hotel() {
    habitaciones = new ArrayList<>();
    reservas = new ArrayList<>();
  }

  public void agregarHabitacion(Habitacion h) {
    habitaciones.add(h);
  }

  // Método que busca habitación disponible pero no comprueba superposición de
  // fechas
  public Habitacion buscarHabitacionDisponible(String tipo) {
    for (Habitacion h : habitaciones) {
      if (h.tipo.equals(tipo) && h.disponible) {
        return h;
      }
    }
    return null;
  }

  // Hacer reserva sin validar fechas, sin verificar disponibilidad real
  public void hacerReserva(Cliente cliente, String tipoHabitacion, String inicio, String fin) {
    Habitacion hab = buscarHabitacionDisponible(tipoHabitacion);
    if (hab != null) {
      Reserva r = new Reserva(cliente, hab, inicio, fin);
      reservas.add(r);
      hab.disponible = false;
      System.out.println("Reserva creada exitosamente.");
    } else {
      System.out.println("No hay habitaciones disponibles.");
    }
  }

  // Cancelar reserva: no busca bien, no libera habitación
  public void cancelarReserva(int indice) {
    if (indice >= 0 && indice < reservas.size()) {
      Reserva r = reservas.get(indice);
      // No libera la habitación
      reservas.remove(indice);
      System.out.println("Reserva cancelada.");
    } else {
      System.out.println("Índice inválido.");
    }
  }

  public void mostrarTodasReservas() {
    for (Reserva r : reservas) {
      r.mostrarReserva();
    }
  }
}
