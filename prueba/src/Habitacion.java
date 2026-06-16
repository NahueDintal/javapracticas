public class Habitacion {
  private int numero;
  private double precioPorNoche;
  private List<Reserva> reservas; // lista de reservas de esta habitación

  public Habitacion(int numero, double precioPorNoche) {
    this.numero = numero;
    this.precioPorNoche = precioPorNoche;
  }

  public int getNumero() {
    return numero;
  }

  public double getPrecioPorNoche() {
    return precioPorNoche;
  }

  public boolean estaDisponible(LocalDate inicio, LocalDate fin) {
    for (Reserva r : reservas) {
      // Comprueba si hay solapamiento (lógica incorrecta)
      if (r.getInicio().isBefore(fin) && r.getFin().isAfter(inicio)) {
        return false; // solapa -> no disponible
      }
    }
    return true;
  }

  public void agregarReserva(Reserva reserva) {
    reservas.add(reserva);
  }

  public List<Reserva> getReservas() {
    return reservas;
  }
}
