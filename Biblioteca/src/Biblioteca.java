import java.util.List;
import java.util.ArrayList;

public class Biblioteca {
  private List<Libro> catalogo;

  public Biblioteca() {
    this.catalogo = new ArrayList<>();
  }

  public void agregarLibro(Libro l) {
    catalogo.add(l);
  }

  public void removerLibro(Libro l) {
    catalogo.remove(l);
  }

  public Libro buscarLibroIsbn(String isbn) {
    String isbnBuscado = isbn;
    for (Libro libro : catalogo) {
      if (libro.getIsbn().equals(isbnBuscado)) {
        return libro;
      }
    }
    return null;
  }

  public void prestarLibro(String isbn, Usuario usuario) {
    Libro libro = buscarLibroIsbn(isbn);

    if (isbn != null && libro.getDisponible()) {
      libro.prestar();
      usuario.agregarPrestamo(libro);
      System.out.println("Libro Prestado al usuario " + usuario.getNombre() + ", " + usuario.getApellido());
    } else {
      System.out.println("No se puede encontrar el libro para prestar.");
    }

  }

  public void devolverLibro(String isbn) {
    Libro libro = buscarLibroIsbn(isbn);
    libro.devolver();
    System.out.println("Libro devuelto");
  }

  public void mostrarCatalogo() {
    if (catalogo.isEmpty()) {
      System.out.println("No hay libros que mostrar!");
    }
    for (Libro libro : catalogo) {
      System.out.println("Titulo: " + libro.getTitulo() + " | Autor: " + libro.getAutor() + " | " + "Disponible: "
          + libro.getDisponible());
    }
  }
}
