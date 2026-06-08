public class Habitacion {
  private int numero;
  private String tipo; // "individual", "doble", "suite"
  private double precioPorNoche;
  private boolean disponible;

  // Constructor sin validaciones
  public Habitacion(int numero, String tipo, double precio) {
    this.numero = numero;
    this.tipo = tipo;
    this.precioPorNoche = precio;
    this.disponible = true;
  }

  public void mostrarInfo() {
    System.out.println("Habitación " + getNumero() + " tipo " + getTipo() + " precio " + getPrecioPorNoche());
  }

  // Getter y setter inconsistentes
  public int getNumero() {
    return numero;
  }

  public String getTipo() {
    return tipo;
  }

  public double getPrecioPorNoche() {
    return precioPorNoche;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public boolean getDisponible() {
    return disponible;
  }
}
