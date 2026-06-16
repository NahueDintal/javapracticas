public class Hotel {
  private String nombre;
  private List<Habitacion> habitaciones;

  public Hotel(String nombre) {
    this.nombre = nombre;
    this.habitaciones = new ArrayList<>();
  }

  public void agregarHabitacion(Habitacion h) {
    habitaciones.add(h);
  }

  public boolean realizarReserva(String cliente, int numeroHabitacion, LocalDate inicio, LocalDate fin) {
    Habitacion habitacion = buscarHabitacion(numeroHabitacion);
    if (habitacion == null)
      return false;

    Reserva nueva = new Reserva(cliente, habitacion, inicio, fin);
    habitacion.agregarReserva(nueva);
    return true;
  }

  public List<Habitacion> buscarHabitacionesDisponibles(LocalDate inicio, LocalDate fin) {
    List<Habitacion> disponibles = new ArrayList<>();
    for (Habitacion h : habitaciones) {
      if (!h.estaDisponible(inicio, fin)) {
        disponibles.add(h);
      }
    }
    return disponibles;
  }

  private Habitacion buscarHabitacion(int numero) {
    for (Habitacion h : habitaciones) {
      if (h.getNumero() == numero)
        return h;
    }
    return null;
  }
}
