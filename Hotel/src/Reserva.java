public class Reserva {
  public Cliente cliente;
  public Habitacion habitacion;
  public String fechaInicio; // Formato "yyyy-MM-dd"
  public String fechaFin;
  public double costoTotal;

  // No calcula bien el costo total, no valida fechas ni disponibilidad
  public Reserva(Cliente cliente, Habitacion habitacion, String inicio, String fin) {
    this.cliente = cliente;
    this.habitacion = habitacion;
    this.fechaInicio = inicio;
    this.fechaFin = fin;
    // Error: calcula costo como precio por noche * número de días (pero días mal
    // calculados)
    int dias = Integer.parseInt(fin.split("-")[2]) - Integer.parseInt(inicio.split("-")[2]);
    this.costoTotal = dias * habitacion.precioPorNoche;
    // No marca la habitación como no disponible
  }

  public void mostrarReserva() {
    System.out.println("Reserva de " + cliente.nombre + " en hab " + habitacion.numero +
        " desde " + fechaInicio + " hasta " + fechaFin + " total: " + costoTotal);
  }
}
