class Mascotas {
  String nombre;
  String animal;
  String dueñx;

  // Constructor
  public Mascotas(String nombre, String animal, String dueñx) {
    this.nombre = nombre;
    this.animal = animal;
    this.dueñx = dueñx;
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
