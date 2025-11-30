public class Llave extends ArticuloCerrajeria {
  private String tipoCopia;
  private String perfil;

  // Constructor
  public Llave(int cod, String marca, String modelo, double precio, int stock, String tipoCopia, String perfil) {
    super(cod, marca, modelo, precio, stock);
    this.tipoCopia = tipoCopia;
    this.perfil = perfil;
  }

  // Get y set

  public String getTipoCopia() {
    return tipoCopia;
  }

  public void setTipoCopia(String tipoCopia) {
    this.tipoCopia = tipoCopia;
  }

  public String getPerfil() {
    return perfil;
  }

  public void setPerfil(String perfil) {
    this.perfil = perfil;
  }

  @Override
  public void info() {
    super.info();
    System.out.println("Tipo de copia: " + tipoCopia);
    System.out.println("Perfil de la llave: " + perfil);
  }
}
