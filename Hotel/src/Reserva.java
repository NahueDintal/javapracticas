public class Reserva {
  private Cliente cliente;
  private Habitacion habitacion;
  private String fechaInicio;
  private String fechaFin;

  public Reserva(Cliente cliente, Habitacion habitacion, String fechaInicio, String fechaFin) {
    this.fechaInicio = fechaInicio;
    this.fechaFin = fechaFin;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public Habitacion getHabitacion() {
    return habitacion;
  }

  public String getFechaInicio() {
    return fechaInicio;
  }

  public String getFechaFin() {
    return fechaFin;
  }
}
