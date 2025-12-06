import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  static ArrayList<Mascotas> listaMascotas = new ArrayList<>();
  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {

    listaMascotas.add(new Mascotas(1, "Firulais", "Perro", "Juan"));
    listaMascotas.add(new Mascotas(2, "Michi", "Gato", "María"));

    int opcion = 0;
    do {

      System.out.println("Abm de mascotas");
      System.out.println("1. Agregar mascota.");
      System.out.println("2. Modificar mascota.");
      System.out.println("3. Ver mascota.");
      System.out.println("4. Buscar mascota.");
      System.out.println("5. Salir");
      System.out.print("Seleccione opcion: ");

      opcion = sc.nextInt();
      sc.nextLine();

      switch (opcion) {

        case 1:
          agreagarMascota();
          break;
        case 2:
          modificarMascota();
          break;
        case 3:
          mostrarMascota();
          break;
        case 4:
          busquedaCodigo();
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

  public static void agreagarMascota() {
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

  public static void modificarMascota() {
    busquedaCodigo();
    agreagarMascota();
  }

  public static void mostrarMascota() {
    if (listaMascotas.isEmpty()) {
      System.out.println("No hay mascotas registradas.");
      return;
    }

    for (Mascotas m : listaMascotas) {
      System.out.println("Código: " + m.getCod());
      System.out.println("Nombre: " + m.getNombre());
      System.out.println("Animal: " + m.getAnimal());
      System.out.println("Dueñx: " + m.getDueñx());
    }
  }

  public static void busquedaCodigo() {
    System.out.print("Ingrese código para buscar: ");
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

  }
}
