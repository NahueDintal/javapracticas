import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Crear objetos de diferentes tipos
    Candado candado1 = new Candado(001, "Master Lock", "Acero", 25.50, 10, "combinacion", 1, true);

    Llave llave1 = new Llave(002, "Yale", "Bronce", 5.75, 50, "original", "EURO", 60);

    Cerradura cerradura1 = new Cerradura(004, "ABUS", "Zinc", 45.80, 5, "embutir", "Plateado", true);

    int opcion;

    do {
      System.out.println("\n=== 🔐 SISTEMA DE CERRAJERÍA ===");
      System.out.println("1. Mostrar información de todos los artículos");
      System.out.println("2. Vender artículos");
      System.out.println("3. Reponer stock");
      System.out.println("4. Funciones específicas");
      System.out.println("5. Salir");
      System.out.print("Elige una opción: ");

      opcion = scanner.nextInt();

      switch (opcion) {
        case 1:
          System.out.println("\n--- INFORMACIÓN DE ARTÍCULOS ---");
          candado1.info();
          llave1.info();
          cerradura1.info();
          break;

        case 2:
          System.out.println("\n--- VENTA DE ARTÍCULOS ---");
          System.out.print("¿Cuántos candados vender? ");
          int ventaCandados = scanner.nextInt();
          candado1.vender(ventaCandados);

          System.out.print("¿Cuántas llaves vender? ");
          int ventaLlaves = scanner.nextInt();
          llave1.vender(ventaLlaves);
          break;

        case 3:
          System.out.println("\n--- REPOSICIÓN DE STOCK ---");
          System.out.print("¿Cuántos candados reponer? ");
          int repoCandados = scanner.nextInt();
          candado1.reponer(repoCandados);

          System.out.print("¿Cuántas llaves reponer? ");
          int repoLlaves = scanner.nextInt();
          llave1.reponer(repoLlaves);
          break;

        case 4:
          System.out.println("\n--- FUNCIONES ESPECÍFICAS ---");
          // candado1.probarResistencia();
          // llave1.hacerCopia();
          // cerradura1.calcularPrecioInstalacion();
          break;

        case 5:
          System.out.println("¡Hasta luego! 🔑");
          break;

        default:
          System.out.println("❌ Opción no válida");
      }

    } while (opcion != 5);

    scanner.close();
  }
}
