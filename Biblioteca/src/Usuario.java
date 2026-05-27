import java.util.List;
import java.util.ArrayList;

public class Usuario {
  private int idUsuario;
  private String nombre;
  private String apellido;
  private List<Libro> prestamos;

  public Usuario(int idUsuario, String nombre, String apellido) {
    this.idUsuario = idUsuario;
    this.nombre = nombre;
    this.apellido = apellido;
    this.prestamos = new ArrayList<>();
  }

  public int getIdUsuario() {
    return idUsuario;
  }

  public String getNombre() {
    return nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public void agregarPrestamo(Libro libro) {
    prestamos.add(libro);
  }

  public boolean devolverLibro(Libro libro) {
    return prestamos.remove(libro);
  }

  public void mostrarPrestamos() {
    if (prestamos.isEmpty()) {
      System.out.println("No hay libros que mostrar!");
    }
    for (Libro libro : prestamos) {
      System.out.println("Titulo: " + libro.getTitulo() + " | Autor: " + libro.getAutor());
    }
  }

}
