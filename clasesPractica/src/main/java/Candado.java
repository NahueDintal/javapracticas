public class Candado extends ArticuloCerrajeria {
  private int mm;
  private int cantidadLlaves;
  private boolean esResistenteAgua;

  public Candado(int cod, String marca, String modelo, double precio, int stock, int mm, int cantidadLlaves,
      boolean esResistenteAgua) {
    super(cod, marca, modelo, precio, stock);
    this.mm = mm;
    this.cantidadLlaves = cantidadLlaves;
    this.esResistenteAgua = esResistenteAgua;
  }

  // Geters y Seters
  public int getMm() {
    return mm;
  }

  public void setMm(int mm) {
    this.mm = mm;
  }

  public int getCantidadLlaves() {
    return cantidadLlaves;
  }

  public void setCantidadLlaves(int cantidadLlaves) {
    this.cantidadLlaves = cantidadLlaves;
  }

  public boolean getEsResistenteAgua() {
    return esResistenteAgua;
  }

  public void setEsResistenteAgua(boolean esResistenteAgua) {
    this.esResistenteAgua = esResistenteAgua;
  }

  @Override
  public void info() {
    super.info();
    System.out.println("Tamaño candado en mm: " + mm);
    System.out.println("Cantidad de llaves: " + cantidadLlaves);
    System.out.println("Es resistente al agua: " + esResistenteAgua);
  }
}
