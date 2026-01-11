public class Pasador extends Producto {
  private String color;
  private boolean conLlave;

  public Pasador(int id, String codigo, String marca, String modelo, int stock, double precio, String color,
      boolean conLlave) {
    super(id, codigo, marca, modelo, stock, precio);
    this.color = color;
    this.conLlave = conLlave;
  }

  public String getColor() {
    return color;
  }

  public boolean getConLlave() {
    return conLlave;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public void setConLlave(boolean conLlave) {
    this.conLlave = conLlave;
  }

  @Override
  public void mostrarInformacion() {
    super.mostrarInformacion();
    System.out.println("Color: " + color);
    System.out.println("Con llave: " + (conLlave ? "Si" : "No"));
  }
}
