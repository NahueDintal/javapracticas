import java.util.ArrayList;
import java.util.List;

public class Hotel {
  private List<Habitacion> habitaciones;
  private List<Reserva> reservas;

  public Hotel() {
    this.habitaciones = new ArrayList<Habitacion>();
    this.reservas = new ArrayList<Reserva>();
  }

  public void agregarHabitacion(Habitacion h) {
    habitaciones.add(h);
  }

  public void agregarReserva(Reserva r) {
    reservas.add(r);
  }

  public void removerReserva(Reserva r) {
    reservas.remove(r);

  }

  public Habitacion buscarHabitacionDisponible(int capacidad) {
    int buscarCapacidad = capacidad;
    for (Habitacion habitacion : habitaciones) {
      if (habitacion.getCapacidad() == buscarCapacidad) {
        return habitacion;
      }
    }
    return null;
  }

  public Reserva buscarReserva(int numeroHabitacion) {
    for (Reserva reserva : reservas) {
      if (reserva.getHabitacion().getNumero() == numeroHabitacion) {
        return reserva;
      }
    }
    return null;
  }

  public void cancelarReserva(int numeroHabitacion) {
    Habitacion habitacion = buscarHabitacionDisponible(numeroHabitacion);
    Reserva reserva = buscarReserva(numeroHabitacion);

    habitacion.liberar();
    removerReserva(reserva);
  }

  public boolean hacerReserva(Cliente cliente, int capacidad, String fechaInicio, String fechaFin) {
    Habitacion habitacion = buscarHabitacionDisponible(capacidad);
    Reserva reserva = new Reserva(cliente, habitacion, fechaInicio, fechaFin);

    habitacion.reservar();
    agregarReserva(reserva);
    return true;
  }

  public void mostrarReservas() {
    for (Reserva reserva : reservas) {
      System.out.println(reserva);
    }
  }
}
