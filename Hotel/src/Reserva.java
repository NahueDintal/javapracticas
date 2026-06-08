import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Reserva {
  private Cliente cliente;
  private Habitacion habitacion;
  private LocalDate fechaInicio;
  private LocalDate fechaFin;
  private double costoTotal;

  // No calcula bien el costo total, no valida fechas ni disponibilidad
  public Reserva(Cliente cliente, Habitacion habitacion, LocalDate inicio, LocalDate fin) {
    this.cliente = cliente;
    this.habitacion = habitacion;
    this.fechaInicio = fechaInicio;
    this.fechaFin = fechaFin;
    if (fechaInicio.isAfter(fechaFin) || fechaInicio.isEqual(fechaFin)) {
      throw new IllegalArgumentException("La fecha de inicio debe ser anterior a la fecha de fin.");
    }
    // Error: calcula costo como precio por noche * número de días (pero días mal
    // calculados)
    long dias = ChronoUnit.DAYS.between(fechaInicio, fechaFin);
    double precioPorNoche = habitacion.getPrecioPorNoche();
    this.costoTotal = dias * precioPorNoche;
  }

  public LocalDate getFechaInicio() {
    return fechaInicio;
  }

  public LocalDate getFechaFin() {
    return fechaFin;
  }

  public double getCostoTotal() {
    return costoTotal;
  }

  public void mostrarReserva() {
    System.out.println("Reserva de " + cliente.getNombre() + " en hab " + habitacion.getNumero() +
        " desde " + fechaInicio + " hasta " + fechaFin + " total: " + getCostoTotal());
  }
}
