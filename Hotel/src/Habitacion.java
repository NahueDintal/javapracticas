public class Habitacion {
  private int numero;
  private int capacidad;
  private double precioPorNoche;
  private boolean disponible = true;

  public Habitacion(int numero, int capacidad, double precioPorNoche) {
    this.numero = numero;
    this.capacidad = capacidad;
    this.precioPorNoche = precioPorNoche;
  }

  public int getNumero() {
    return numero;
  }

  public int getCapacidad() {
    return capacidad;
  }

  public double getPrecioPorNoche() {
    return precioPorNoche;
  }

  public boolean getDisponible() {
    return disponible;
  }

  public void reservar() {
    this.disponible = false;
  }

  public void liberar() {
    this.disponible = true;
  }

  public void mostrarInfo() {
    System.out.println("Numero habitación: " + getNumero() + " | Capacidad: " + getCapacidad() + " | Precio por noche: "
        + getPrecioPorNoche());
  }
}
