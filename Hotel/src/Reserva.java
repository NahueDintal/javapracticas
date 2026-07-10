import java.time.temporal.ChronoUnit;
import java.time.LocalDate;

public class Reserva {
  public int id;
  public LocalDate fechaEntrada;
  public LocalDate fechaSalida;
  Cliente cliente;
  Habitacion habitacion;

  public Reserva(int id, LocalDate fechaEntrada, LocalDate fechaSalida, Cliente cliente, Habitacion habitacion) {
    this.id = id;
    this.fechaEntrada = fechaEntrada;
    this.fechaSalida = fechaSalida;
    this.cliente = cliente;
    this.habitacion = habitacion;
  }

  public int getId() {
    return id;
  }

  public LocalDate getFechaEntrada() {
    return fechaEntrada;
  }

  public LocalDate getFechaSalida() {
    return fechaSalida;
  }

  public double calcularTotal() {
    long noches = ChronoUnit.DAYS.between(this.fechaEntrada, this.fechaSalida);
    double precioBaseTotal = this.habitacion.calcularPrecio(noches);
    double precioFinal = this.cliente.aplicarDescuento(precioBaseTotal);
    return precioFinal;
  }
}
