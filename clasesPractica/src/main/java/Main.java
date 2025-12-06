import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  static ArrayList<Mascotas> listaMascotas = new ArrayList<>();
  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {

    int opcion = 0;

    System.out.println("Abm de mascotas");
    System.out.println("1. Agregar mascota.");
    System.out.println("2. Modificar mascota.");
    System.out.println("3. Ver mascota.");
    System.out.println("4. Salir");
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
        infoMascota();
        break;
      case 4:
        System.out.println("Saliendo...");
        return;
    }
    while (opcion != 0)
      ;
    sc.close();
  }

  public static void agreagarMascota() {
    System.out.print("Ingresar nombre mascota: ");
    String nombre = (sc.nextLine());
    System.out.print("Ingresar animal mascota: ");
    String animal = (sc.nextLine());
    System.out.print("Ingresar dueñx mascota: ");
    String dueñx = (sc.nextLine());
    Mascotas mascota1 = new Mascotas(nombre, animal, dueñx);
    misMascotas.add(mascota1);

  }

  public static void modificarMascota() {
    System.out.println("");
    System.out.println("Modificacion de nombre: ");
    System.out.print("nombre: ");

  }

  public void infoMascota() {

  }
}
