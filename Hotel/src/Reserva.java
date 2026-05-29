public class Reserva {
  private Cliente cliente;
  private Habitacion habitacion;
  private String fechaInicio;
  private String fechaFin;
  private int noches;

  public Reserva(Cliente cliente, Habitacion habitacion, String fechaInicio, String fechaFin) {
    this.cliente = cliente;
    this.habitacion = habitacion;
    this.fechaInicio = fechaInicio;
    this.fechaFin = fechaFin;
  }

  public double calcularCostoTotal(int noches) {
    double precio = habitacion.getPrecioPorNoche();
    return precio * noches;
  }

  public Habitacion getHabitacion() {
    return habitacion;
  }

  public void mostrarinfoReserva() {
  }
}
