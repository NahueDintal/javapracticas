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
        System.out.println(libro.getTitulo() + libro.getAutor() + libro.getDispobible());
        return libro;
      }
    }
    System.out.println("No se hay conincidencias.");
    return null;
  }

  public void prestarLibro(String isbn, int idUsuario) {
    Libro libro = buscarLibroIsbn(isbn);
    libro.prestar();
    Usuario.agregarPrestamo(isbn);
    System.out.println("Libro Prestado");
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
          + libro.getDispobible());
    }
  }
}
