
public class Cerradura {
  // Atributos campos
  private int Codigo;
  private String Marca;
  private String Modelo;
  private int Combinaciones;
  private int Stock;
  private double Precio;

  // Constructor con parametros
  public Cerradura(int Codigo, String Marca, String Modelo, int Stock, double Precio) {
    this.Codigo = Codigo;
    this.Marca = Marca;
    this.Modelo = Modelo;
    this.Stock = Stock;
    this.Precio = Precio;
  }

  // Métodos geter y seter
  public int getCodigo() {
    return Codigo;
  }

  public void setCodigo(int Codigo) {
    this.Codigo = Codigo;
  }

  public String getMarca() {
    return Marca;
  }

  public void setNombre(String Marca) {
    this.Marca = Marca;
  }

  public String getModelo() {
    return Modelo;
  }

  public void setModelo(String Modelo) {
    this.Modelo = Modelo;
  }

  public int getStock() {
    return Stock;
  }

  public void setStock(int Stock) {
    this.Stock = Stock;
  }

  public double getPrecio() {
    return Precio;
  }

  public void setPrecio(double Precio) {
    this.Precio = Precio;
  }

  // Método personalizado
  public void MostrarInformacion() {
    System.out.println("Código: " + Codigo);
    System.out.println("Marca: " + Marca);
    System.out.println("Modelo: " + Modelo);
    System.out.println("Stock: " + Stock);
    System.out.println("Precio: " + Precio);
  }
}
