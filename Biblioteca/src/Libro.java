public class Libro {
  private String isbn;
  private String titulo;
  private String autor;
  private int anioPublicacion;
  private boolean disponible;

  public Libro(String isbn, String titulo, String autor, int anioPublicacion, boolean disponible) {
    this.isbn = isbn;
    this.titulo = titulo;
    this.autor = autor;
    this.anioPublicacion = anioPublicacion;
    this.disponible = disponible;
  }

  public String getIsbn() {
    return isbn;
  }

  public String getTitulo() {
    return titulo;
  }

  public String getAutor() {
    return autor;
  }

  public boolean getDispobible() {
    return disponible;
  }

  public void prestar() {
    this.disponible = false;
  }

  public void devolver() {
    this.disponible = true;
  }
}
