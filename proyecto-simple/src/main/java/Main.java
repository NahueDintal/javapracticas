public class Main {
  public static void main(String[] args) {

    Libro libro1 = new Libro("Cien años de soledad", "Gabriel García Márquez", 1967);
    Libro libro2 = new Libro("1984", "George Orwell", 1949);
    Libro libro3 = new Libro("El Quijote", "Miguel de Cervantes", 1605);

    libro1.mostrarInfo();
    libro2.mostrarInfo();
    libro3.mostrarInfo();
  }
}
