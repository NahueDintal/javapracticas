class ArticuloCerrajeria {
  private int cod;
  private String marca;
  private String modelo;
  private double precio;
  private int stock;

  public ArticuloCerrajeria(int cod, String marca, String modelo, double precio, int stock) {
    this.cod = cod;
    this.marca = marca;
    this.modelo = modelo;
    this.precio = precio;
    this.stock = stock;
  }

  public int getCod() {
    return cod;
  }

  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public String getModelo() {
    return modelo;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public double getPrecio() {
    return precio;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }

  public int getStock() {
    return stock;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }

  // Métodos vender, reponer, info.
  public void vender(int cantidad) {
    if (cantidad <= stock) {
      stock -= cantidad;
      System.out.println("Vendido '" + cantidad + "' unidades de '" + cod);
    } else {
      System.out.println("No hay stock suficiente.");
    }
  }

  public void reponer(int cantidad) {
    stock += cantidad;
    System.out.println("Agregado de '" + cod + "' la cantidad: " + cantidad);
  }

  public void info() {
    System.out.println("Código: " + cod);
    System.out.println("Marca: " + marca);
    System.out.println("Modelo: " + modelo);
    System.out.println("Precio: " + precio);
    System.out.println("Stock: " + stock);
  }
}
