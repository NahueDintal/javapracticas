public class Habitacion {
  public int numero;
  public String tipo; // "individual", "doble", "suite"
  public double precioPorNoche;
  public boolean disponible;

  // Constructor sin validaciones
  public Habitacion(int numero, String tipo, double precio) {
    this.numero = numero;
    this.tipo = tipo;
    this.precioPorNoche = precio;
    this.disponible = true;
  }

  // Método que mezcla presentación con lógica (mala práctica)
  public void mostrarInfo() {
    System.out.println("Habitación " + numero + " tipo " + tipo + " precio " + precioPorNoche);
  }

  // Getter y setter inconsistentes
  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }
  // faltan getters/setters para tipo, precio, disponible
}
