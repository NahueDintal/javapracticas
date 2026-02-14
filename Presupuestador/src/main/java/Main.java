import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int opcion = 0;

    while (opcion != 2) {
      System.out.println("::Calculadora de presupuesto!");
      System.out.println("    1: Configurar condiciones. ");
      System.out.println("    2: Salir!");
      System.out.print(":: Opcion: ");
      opcion = scanner.nextInt();

      switch (opcion) {
        case 1:
          ConfigurarAjustes(scanner);
          break;
        case 2:
          System.out.println("Saliendo...");
          break;
        default:
          System.out.println("Opcion no válida!");
      }
    }
    scanner.close();

  }

  public static void ConfigurarAjustes(Scanner scanner) {
    System.out.print(":: Costo de materiales: ");
    double costoMateriales = scanner.nextDouble();

    System.out.print(":: Horas estimadas de trabajo: ");
    double horas = scanner.nextDouble();

    System.out.print(":: Canasta basica familiar: $");
    double canastabasicafamiliar = scanner.nextDouble();
    double tarifaBase = canastabasicafamiliar / 40;

    System.out.println(":: Nivel de herramientas utilizadas. ");
    System.out.println("    1: Herramientas manuales. ");
    System.out.println("    2: Herramientas electricas. ");
    System.out.println("    3: Equipo pesado, roto y escalera. ");
    System.out.print(":: Opcion: ");
    int nivelHerramientas = scanner.nextInt();

    double multiplicador;
    switch (nivelHerramientas) {
      case 1:
        multiplicador = 1.0;
        break;
      case 2:
        multiplicador = 1.3;
        break;
      case 3:
        multiplicador = 1.6;
        break;
      default:
        multiplicador = 1.0;
    }

    double CostoManoDeObra = horas * (tarifaBase * multiplicador);
    System.out.println(":: Costo de mano de obra: $" + CostoManoDeObra);
    System.out.println(":: Costo de materiales: $" + costoMateriales);
    double total = costoMateriales + CostoManoDeObra;
    System.out.println(":: Costo total del trabajo: $" + total);

  }

  public static void calcularPresupuesto(Scanner scanner) {

    return;
  }
}
