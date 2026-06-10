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
    if (cliente != null) {
      this.cliente = cliente;
    }
    this.habitacion = habitacion;
    this.fechaInicio = inicio;
    this.fechaFin = fin;
    if (inicio.isAfter(fin) || inicio.isEqual(fin)) {
      throw new IllegalArgumentException("La fecha de inicio debe ser anterior a la fecha de fin.");
    }
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
