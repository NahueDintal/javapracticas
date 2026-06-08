public class Cliente {
  private String id;
  private String nombre;
  private String email;

  public Cliente(String id, String nombre, String email) {
    if (id != null) {
      this.id = id;
    }

    if (nombre != null) {
      this.nombre = nombre;
    }

    if (email != null) {
      this.email = email;
    }
  }

  public String getNombre() {
    return nombre;
  }

  public String getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  public void mostrarInfo() {
    System.out.println("Cliente: " + getNombre() + " (" + getId() + ") - " + getEmail());
  }
}
