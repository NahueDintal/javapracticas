
public class Cerradura extends Producto {
  private int cantidadCombinaciones;

  public Cerradura(int id, String codigo, String marca, String modelo, int stock, double precio,
      int cantidadCombinaciones) {
    super(id, codigo, marca, modelo, stock, precio);

    this.cantidadCombinaciones = cantidadCombinaciones;
  }

  public int getCantidadCombinaciones() {
    return cantidadCombinaciones;
  }

  public void setCantidadCombinaciones(int cantidadCombinaciones) {
    this.cantidadCombinaciones = cantidadCombinaciones;
  }

  @Override
  public void mostrarInformacion() {
    super.mostrarInformacion();
    System.out.println("Cantidad de Combinaciones: " + cantidadCombinaciones);
  }
}
