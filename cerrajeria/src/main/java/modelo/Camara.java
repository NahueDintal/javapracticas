public class Camara extends Producto {
  private String tipoConexion;

  // Constructor con id para cargar desde la base de datos
  public Camara(int id, String codigo, String marca, String modelo, int stock, double precio, String tipoConexion) {
    super(id, codigo, marca, modelo, stock, precio);

    this.tipoConexion = tipoConexion;
  }

  // Constructor sin id para productos nuevos
  public Camara(String codigo, String marca, String modelo, int stock, double precio, String tipoConexion) {
    super(codigo, marca, modelo, stock, precio);

    this.tipoConexion = tipoConexion;
  }

  public String getTipoConexion() {
    return tipoConexion;
  }

  public void setTipoConexion(String tipoConexion) {
    this.tipoConexion = tipoConexion;
  }

  @Override
  public void mostrarInformacion() {
    super.mostrarInformacion();
    System.out.println("Tipo de conexión: " + tipoConexion);
  }
}
