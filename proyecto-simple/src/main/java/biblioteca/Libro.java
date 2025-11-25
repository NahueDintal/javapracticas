public class Libro {
  private String titulo;
  private String autor;
  private int fechapublicacion;
  private boolean disponibilidad;

  public Libro(String titulo, String autor, int fechapublicacion) {
    this.titulo = titulo;
    this.autor = autor;
    this.fechapublicacion = fechapublicacion;
    this.disponibilidad = true;
  }

  public String getTitulo() {
    return titulo;
  }

  public String getAutor() {
    return autor;
  }

  public int getfechapublicacion() {
    return fechapublicacion;
  }

  public boolean isDisponible() {
    return disponibilidad;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public void prestar() {
    if (disponibilidad) {
      disponibilidad = false;
      System.out.println("Libro '" + titulo + "' prestado.");
    } else {
      System.out.println("Libro '" + titulo + "' no está disponible.");
    }
  }

  public void devolver() {
    disponibilidad = true;
    System.out.println("Libro '" + titulo + "'devuelto exitosamente.");
  }

  public void mostrarInfo() {
    String estado = disponibilidad ? "Disponible" : "Prestado";
    System.out.println("Título: " + titulo);
    System.out.println("Autor: " + autor);
    System.out.println("Año: " + fechapublicacion);
    System.out.println("Estado: " + estado);
    System.out.println("----------------------");
  }
}
