
public class Camara extends Producto {
  private String tipoConexion;

  public Camara(int id, String codigo, String marca, String modelo, int stock, double precio, String tipoConexion) {
    super(id, codigo, marca, modelo, stock, precio);

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
