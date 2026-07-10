public class Habitacion {
  private int id;
  private double precioBase;

  public Habitacion(int id, double precioBase) {
    this.id = id;
    this.precioBase = precioBase;
  }

  public int getId() {
    return id;
  }

  public double getPrecioBase() {
    return precioBase;
  }

  public double calcularPrecio(long noches) {
    return precioBase * noches;
  }
}
