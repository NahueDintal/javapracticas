public class Habitacion {
  private int id;
  private double precioBase;

  public Habitacion(int id, double precioBase) {
    this.id = id;
    this.precioBase = precioBase;
  }

  // metodo para calcular la estancia en noches y devuelva un int

  public double calcularPrecio(estanciaNoches {
    return estanciaNoches * precioBase;
  }

  public int getId() {
    return id;
  }

  public double getPrecioBase() {
    return precioBase;
  }
}
