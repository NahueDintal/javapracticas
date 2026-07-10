public class Cliente {
  private int id;
  private String nombre;
  private boolean esFrecuente;

  public Cliente(int id, String nombre, boolean esFrecuente) {
    this.id = id;
    this.nombre = nombre;
    this.esFrecuente = esFrecuente;
  }

  public int getId() {
    return id;
  }

  public String getNombre() {
    return nombre;
  }

  public boolean getEsFrecuente() {
    return esFrecuente;
  }

  public void aplicarDescuento(boolean esFrecuente) {
    if (esFrecuente != true) {
      // return precio * 0.10;
    }
  }
}
