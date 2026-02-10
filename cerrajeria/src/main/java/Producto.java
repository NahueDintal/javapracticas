public class Producto {
  // Atributos campos
  private static int contadorId = 1;
  private int id;
  private String codigo;
  private String marca;
  private String modelo;
  private int stock;
  private double precio;

  // Constructor con parametros
  public Producto(String Codigo, String Marca, String Modelo, int Stock, double Precio) {
    this.id = contadorId++;
    this.codigo = Codigo;
    this.marca = Marca;
    this.modelo = Modelo;
    this.stock = Stock;
    this.precio = Precio;
  }

  public Producto(int id, String codigo, String marca, String modelo, int stock, double precio) {
    this.id = id;
    this.codigo = codigo;
    this.marca = marca;
    this.modelo = modelo;
    this.stock = stock;
    this.precio = precio;
    if (id >= contadorId) {
      contadorId = id + 1;
    }
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
