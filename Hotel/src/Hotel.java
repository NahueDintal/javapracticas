import java.util.ArrayList;

public class Hotel {
  private ArrayList<Habitacion> habitaciones;
  private ArrayList<Reserva> reservas;

  public Hotel() {
    this.habitaciones = new ArrayList<Habitacion>();
    this.reservas = new ArrayList<Reserva>();
  }

  public void agregarHabitacion(Habitacion h) {
    habitaciones.add(h);
  }

  // buscar habitacion
  public Habitacion buscarHabitacionPorNumero(String tipo) {
    String busqueda = tipo;
    for (Habitacion hab : habitaciones) {
      if (hab.getTipo().equals(busqueda)) {
        return hab;
      }
    }
    return null;
  }

  public void cancelarReserva() {

  }

  public Reserva hacerReserva(Cliente cliente, String tipoHabitacion, String fechaInicio, String fechaFin) {
    Habitacion hab = buscarHabitacionPorNumero(tipoHabitacion);
    Reserva reservas = reservas;

    if (hab != null && Habitacion.getDisponible()) {
      Habitacion.reservar();
    }
    reservas.add(Reserva);
  }

  public Reserva mostrarReservas() {
    for (Reserva reserva : reservas) {
      if (reserva != null) {
        System.out.print(reserva);
        return reserva;
      }
    }
    return null;
  }

  public Habitaciones mostrarHabitaciones() {
    for ()

  }
}
