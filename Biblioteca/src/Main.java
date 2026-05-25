public class Main {
  public static void main(String[] args) {
    Biblioteca biblioteca = new Biblioteca();

    biblioteca.agregarLibro(new Libro("111", "Java para todos", "Maddona", 2000, true));

    Usuario user = new Usuario(123, "Jampa", "Del Valle");

    biblioteca.prestarLibro("111", 123);

  }

}
