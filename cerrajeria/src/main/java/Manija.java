public class Manija extends Producto {
  private String color;

  public Manija(int id, String codigo, String marca, String modelo, int stock, double precio, String color) {
    super(id, codigo, marca, modelo, stock, precio);
    this.color = color;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  @Override
  public void mostrarInformacion() {
    super.mostrarInformacion();
    System.out.println("Color: " + color);
  }
}
