public class Reserva {
  private String cliente;
  private Habitacion habitacion;
  private LocalDate inicio;
  private LocalDate fin;

  public Reserva(String cliente, Habitacion habitacion, LocalDate inicio, LocalDate fin) {
    this.cliente = cliente;
    this.habitacion = habitacion;
    this.inicio = inicio;
    this.fin = fin;
  }

  public LocalDate getInicio() {
    return inicio;
  }

  public LocalDate getFin() {
    return fin;
  }

  public Habitacion getHabitacion() {
    return habitacion;
  }

  public double calcularCosto() {
    long noches = ChronoUnit.DAYS.between(inicio, fin);
    return habitacion.getPrecioPorNoche() * noches;
  }
}
