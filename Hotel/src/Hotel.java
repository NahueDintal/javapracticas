import java.util.ArrayList;
import java.time.LocalDate;

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
      if (h.getTipo().equals(tipo) && h.getDisponible()) {
        return h;
      }
    }
    return null;
  }

  public Habitacion buscarHabitacionDisponible(String tipo, LocalDate inicio, LocalDate fin) {
    for (Habitacion h : habitaciones) {
      if (h.getTipo().equals(tipo) && h.getDisponible()) {
        boolean disponible = false;
        for (Reserva r : reservas) {
          if (inicio.isBefore(r.getFechaFin()) && fin.isAfter(r.getFechaInicio())) {
            disponible = true;
            break;
          }
        }
        if (!disponible) {
          return h;
        }
      }
    }
    return null;
  }

  public void hacerReserva(Cliente cliente, String tipoHabitacion, LocalDate inicio, LocalDate fin) {
    Habitacion hab = buscarHabitacionDisponible(tipoHabitacion, inicio, fin);
    if (hab != null) {
      Reserva r = new Reserva(cliente, hab, inicio, fin);
      reservas.add(r);
      hab.getDisponible();
      System.out.println("Reserva creada exitosamente.");
    } else {
      System.out.println("No hay habitaciones disponibles.");
    }
  }

  // Cancelar reserva: no busca bien, no libera habitación
  public void cancelarReserva(int indice) {
    if (indice >= 0 && indice < reservas.size()) {
      Reserva r = reservas.get(indice);
      reservas.remove(r);
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
