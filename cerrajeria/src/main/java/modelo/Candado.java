
public class Candado extends Producto {
  private int cantidadLlaves;

  public Candado(int id, String codigo, String marca, String modelo, int stock, double precio, int cantidadLlaves) {
    super(id, codigo, marca, modelo, stock, precio);

    this.cantidadLlaves = cantidadLlaves;
  }

  public Candado(String codigo, String marca, String modelo, int stock, double precio, int cantidadLlaves) {
    super(codigo, marca, modelo, stock, precio);

    this.cantidadLlaves = cantidadLlaves;
  }

  public int getCantidadLlaves() {
    return cantidadLlaves;
  }

  public void setCantidadLlaves(int cantidadLlaves) {
    this.cantidadLlaves = cantidadLlaves;
  }

  @Override
  public void mostrarInformacion() {
    super.mostrarInformacion();
    System.out.println("Cantidad de llaves: " + cantidadLlaves);
  }
}
