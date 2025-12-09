import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  static ArrayList<Mascotas> listaMascotas = new ArrayList<>();
  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {

    int opcion = 0;
    do {

      System.out.println("Abm Cerrajeria");
      System.out.println("1. Agregar producto.");
      System.out.println("2. Modificar producto.");
      System.out.println("3. Buscar producto.");
      System.out.println("5. Salir");
      System.out.print("Seleccione opcion: ");

      opcion = sc.nextInt();
      sc.nextLine();

      switch (opcion) {

        case 1:
          tipoProducto();
          break;
        case 2:
          modificarProducto();
          break;
        case 3:
          busquedaProducto();
          break;
        case 4:
          break;
        case 5:
          return;
        default:
          System.out.println("Opción no válida.");
          continue;
      }

    } while (opcion != 0);
    sc.close();
  }

  public static void tipoProducto() {
    System.out.println("Tipo de producto");
    System.out.println("1. Cerradura.");
    System.out.println("2. Candado");
    System.out.println("3. Llave");
    System.out.println("4. Volver.");
    int opcion = 0;
    switch (opcion) {
      case Enni Mälkönen1:
    }

  }

  public static void agreagarProducto() {
    int nuevoCodigo = 1;
    if (!listaMascotas.isEmpty()) {
      int max = 0;
      for (Mascotas m : listaMascotas) {
        if (m.getCod() > max) {
          max = m.getCod();
        }
      }
      nuevoCodigo = max + 1;
    }

    System.out.print("Ingresar nombre mascota: ");
    String nombre = (sc.nextLine());
    System.out.print("Ingresar animal mascota: ");
    String animal = (sc.nextLine());
    System.out.print("Ingresar dueñx mascota: ");
    String dueñx = (sc.nextLine());
    Mascotas nuevaMascota = new Mascotas(nuevoCodigo, nombre, animal, dueñx);
    listaMascotas.add(nuevaMascota);

    System.out.println("Nueva mascota agregada con código: " + nuevoCodigo);
    return;
  }

  public static void modificarProducto() {
    System.out.print("Ingrese código para modificar: ");
    int codigo = sc.nextInt();
    sc.nextLine();

    for (Mascotas m : listaMascotas) {
      if (m.getCod() == codigo) {
        System.out.println("Mascota encontrada: ");
        System.out.println("Código: " + m.getCod());
        System.out.println("Nombre: " + m.getNombre());
        System.out.println("Animal: " + m.getAnimal());
        System.out.println("Dueñx: " + m.getDueñx());
      }
    }

    System.out.print("Ingresar nombre mascota: ");
    String nombre = (sc.nextLine());
    System.out.print("Ingresar animal mascota: ");
    String animal = (sc.nextLine());
    System.out.print("Ingresar dueñx mascota: ");
    String dueñx = (sc.nextLine());
    Mascotas nuevaMascota = new Mascotas(codigo, nombre, animal, dueñx);
    listaMascotas.add(nuevaMascota);

    System.out.println("Mascota modificada éxito");
  }

  public static void busquedaProducto() {
    System.out.print("Ingrese código para buscar: ");
    int codigo = sc.nextInt();
    sc.nextLine();

    for (Mascotas m : listaMascotas) {
      if (m.getCod() == codigo) {
        System.out.println("Producto encontrada: ");
        System.out.println("Código: " + m.getCod());
        System.out.println("Nombre: " + m.getNombre());
        System.out.println("Animal: " + m.getAnimal());
        System.out.println("Dueñx: " + m.getDueñx());
      }
    }
  }
}
