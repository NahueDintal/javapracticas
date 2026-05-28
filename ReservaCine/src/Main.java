public class Main {
  public static void main(String[] args) {
    Cine cine = new Cine();

    Pelicula peli1 = new Pelicula("Dune 2", 166, "Ciencia ficción", "+13");

    Sala sala1 = new Sala(1, 100);

    cine.agregarFuncion(peli1, sala1, "19:00", "2025-06-10");

    cine.mostrarCartelera();

    cine.reservarButaca("Dune 2", "19:00", 2, "Carlos");
    cine.reservarButaca("Dune 2", "19:00", 99, "Lucía"); // debería fallar

    cine.mostrarCartelera();
  }
}
