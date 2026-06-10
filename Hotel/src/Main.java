import java.time.LocalDate;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Hotel hotel = new Hotel();

    // Crear habitaciones de ejemplo (sin usar método)
    Habitacion h1 = new Habitacion(101, "individual", 50.0);
    Habitacion h2 = new Habitacion(102, "doble", 80.0);
    Habitacion h3 = new Habitacion(201, "suite", 150.0);
    hotel.habitaciones.add(h1);
    hotel.habitaciones.add(h2);
    hotel.habitaciones.add(h3);

    Scanner sc = new Scanner(System.in);
    int opcion;
    do {
      System.out.println("\n--- Menú Hotel ---");
      System.out.println("1. Ver habitaciones");
      System.out.println("2. Hacer reserva");
      System.out.println("3. Cancelar reserva");
      System.out.println("4. Mostrar reservas");
      System.out.println("5. Salir");
      System.out.print("Opción: ");
      opcion = sc.nextInt();
      sc.nextLine(); // limpiar buffer

      switch (opcion) {
        case 1:
          for (Habitacion h : hotel.habitaciones) {
            h.mostrarInfo();
          }
          break;
        case 2:
          System.out.print("ID Cliente: ");
          String id = sc.nextLine();
          System.out.print("Nombre: ");
          String nombre = sc.nextLine();
          System.out.print("Email: ");
          String email = sc.nextLine();
          Cliente c = new Cliente(id, nombre, email);
          System.out.print("Tipo habitación (individual/doble/suite): ");
          String tipo = sc.nextLine();

          LocalDate inicio = null;
          LocalDate fin = null;

          System.out.print("Fecha inicio (YYYY-MM-DD): ");
          String inicioStr = sc.nextLine();
          try {
            inicio = LocalDate.parse(inicioStr);
          } catch (Exception e) {
            System.out.println("Formato de fecha no válido: YYYY-MM-DD.");
          }
          System.out.print("Fecha fin (YYYY-MM-DD): ");
          String finStr = sc.nextLine();
          try {
            fin = LocalDate.parse(finStr);
          } catch (Exception e) {
            System.out.println("Formato de fecha no válido: YYYY-MM-DD.");
          }

          hotel.hacerReserva(c, tipo, inicio, fin);
          break;
        case 3:
          System.out.print("Índice de reserva a cancelar (0 basado): ");
          int idx = sc.nextInt();
          hotel.cancelarReserva(idx);
          break;
        case 4:
          hotel.mostrarTodasReservas();
          break;
        case 5:
          System.out.println("Saliendo...");
          break;
        default:
          System.out.println("Opción no válida");
      }
    } while (opcion != 5);
    sc.close();
  }
}
