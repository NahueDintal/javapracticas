
public class Producto {
  // Atributos campos
  private int id;
  private String codigo;
  private String marca;
  private String modelo;
  private int stock;
  private double precio;

  // Constructor con parametros
  public Producto(int id, String Codigo, String Marca, String Modelo, int Stock, double Precio) {
    this.id = id;
    this.codigo = Codigo;
    this.marca = Marca;
    this.modelo = Modelo;
    this.stock = Stock;
    this.precio = Precio;
  }

  // Métodos geter y seter
  public int getId() {
    return id;
  }

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String Codigo) {
    this.codigo = Codigo;
  }

  public String getMarca() {
    return marca;
  }

  public void setMarca(String Marca) {
    this.marca = Marca;
  }

  public String getModelo() {
    return modelo;
  }

  public void setModelo(String Modelo) {
    this.modelo = Modelo;
  }

  public int getStock() {
    return stock;
  }

  public void setStock(int Stock) {
    this.stock = Stock;
  }

  public double getPrecio() {
    return precio;
  }

  public void setPrecio(double Precio) {
    this.precio = Precio;
  }

  // Método personalizado
  public void mostrarInformacion() {
    System.out.println("Id: " + id);
    System.out.println("Código: " + codigo);
    System.out.println("Marca: " + marca);
    System.out.println("Modelo: " + modelo);
    System.out.println("Stock: " + stock);
    System.out.println("Precio: " + precio);
  }
}
