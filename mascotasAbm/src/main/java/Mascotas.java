class Mascotas {
  int cod;
  String nombre;
  String animal;
  String dueñx;

  // Constructor
  public Mascotas(int cod, String nombre, String animal, String dueñx) {
    this.cod = cod;
    this.nombre = nombre;
    this.animal = animal;
    this.dueñx = dueñx;
  }

  public int getCod() {
    return cod;
  }

  public String getNombre() {
    return nombre;
  }

  public String getAnimal() {
    return animal;
  }

  public String getDueñx() {
    return dueñx;
  }

  public void setCod(int cod) {
    this.cod = cod;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setAnimal(String animal) {
    this.animal = animal;
  }

  public void setDueñx(String dueñx) {
    this.dueñx = dueñx;
  }

}
