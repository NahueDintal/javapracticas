public class Cliente {
  public String id;
  public String nombre;
  public String email;

  // Constructor público sin validación
  public Cliente(String id, String nombre, String email) {
    this.id = id;
    this.nombre = nombre;
    this.email = email;
  }

  // Mala práctica: cambiar el ID después de creado
  public void cambiarId(String nuevoId) {
    this.id = nuevoId;
  }

  public void mostrarInfo() {
    System.out.println("Cliente: " + nombre + " (" + id + ") - " + email);
  }
}
