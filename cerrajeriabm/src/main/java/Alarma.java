public class Alarma extends Producto {
  private boolean inalambrico;

  public Alarma(int id, String codigo, String marca, String modelo, int stock, double precio, boolean inalambrico) {
    super(id, codigo, marca, modelo, stock, precio);

    this.inalambrico = inalambrico;
  }
}
