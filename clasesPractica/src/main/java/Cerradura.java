// clase
public class Cerradura extends ArticuloCerrajeria {
  private String tipoInstalacion;
  private int cantidadLlaves;

  public Cerradura(int cod, String marca, String modelo, double precio, int stock, String tipoInstalacion,
      int cantidadLlaves) {
    super(cod, marca, modelo, precio, stock);
    this.tipoInstalacion = tipoInstalacion;
    this.cantidadLlaves = cantidadLlaves;
  }

  // Geters y Seters
  public String getTipoInstalacion() {
    return tipoInstalacion;
  }

  public void setTipoInstalacion(String tipoInstalacion) {
    this.tipoInstalacion = tipoInstalacion;
  }

  public int getCantidadLlaves() {
    return cantidadLlaves;
  }

  public void setCantidadLlaves(int cantidadLlaves) {
    this.cantidadLlaves = cantidadLlaves;
  }

  @Override

  public void info() {
    super.info();
    System.out.println("Tipo de instalación: " + tipoInstalacion);
    System.out.println("Cantidad de llaves: " + cantidadLlaves);
  }
}
// metodos
