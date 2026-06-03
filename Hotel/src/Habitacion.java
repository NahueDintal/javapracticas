public class Habitacion {
  private int numero;
  private String tipo;
  private double precioPorNoche;
  private boolean disponible;

  public Habitacion(int numero, String tipo, double precioPorNoche, boolean disponible) {
    this.numero = numero;
    this.tipo = tipo;
    this.precioPorNoche = precioPorNoche;
    this.disponible = disponible;
  }

  public int getNumero() {
    return numero;
  }

  public String getTipo() {
    return tipo;
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
}
