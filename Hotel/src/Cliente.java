public class Cliente {
  private String idCliente;
  private String nombre;
  private String apellido;
  private String email;
  private int telefono;

  public Cliente(String idCliente, String nombre, String apellido, String email, int telefono) {
    this.idCliente = idCliente;
    this.nombre = nombre;
    this.apellido = apellido;
    this.email = email;
    this.telefono = telefono;
  }

  public String getIdCliente() {
    return idCliente;
  }

  public String getNombre() {
    return nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public String getEmail() {
    return email;
  }

  public int getTeleno() {
    return telefono;
  }

}
