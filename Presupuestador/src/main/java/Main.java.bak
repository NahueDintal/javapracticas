import java.util.Scanner;

public class Main {

  private static final int HORASXSEMANA = 40;

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int opcion = 0;
    boolean ok = false;

    while (!ok) {
      System.out.println("::Calculadora de presupuesto!");
      System.out.println("    1: Condiciones. ");
      System.out.println("    2: Salir!");
      System.out.print(":: Opcion: ");
      String linea = scanner.nextLine();
      try {
        opcion = Integer.parseInt(linea);
        switch (opcion) {
          case 1:
            configurarAjustes(scanner);
            break;
          case 2:
            System.out.println("Saliendo...");
            ok = true;
            break;
          default:
            System.out.println("Opcion no válida!");
        }
      } catch (NumberFormatException e) {
        System.out.println("Ingrese solo una de la opciones...");
      }
    }
    scanner.close();
  }

  public static int leerInt(Scanner scanner, String mensaje) {
    while (true) {
      System.out.print(mensaje);
      try {
        int valor = Integer.parseInt(scanner.nextLine());
        if (valor <= 0) {
          System.out.println("Error, debe ingresar un mayor a cero.");
        } else {
          return valor;
        }
      } catch (NumberFormatException e) {
        System.out.println("Error, debe ingresar un numero entero.");
      }
    }
  }

  public static double leerDouble(Scanner scanner, String mensaje) {
    while (true) {
      System.out.print(mensaje);
      try {
        double valor = Double.parseDouble(scanner.nextLine());
        if (valor <= 0) {
          System.out.println("Error, debe ingresar un mayor a cero.");
        } else {
          return valor;
        }
      } catch (NumberFormatException e) {
        System.out.println("Error, debe ingresar un numero double.");
      }
    }
  }

  public static void configurarAjustes(Scanner scanner) {
    double costoMateriales = leerDouble(scanner, ":: Costo de materiales: ");
    double horas = leerInt(scanner, ":: Horas estimadas de trabajo: ");
    double canastaBasicaFamiliar = leerDouble(scanner, ":: Canasta basica: ");

    System.out.println(":: Nivel de herramientas utilizadas. ");
    System.out.println("    1: Herramientas manuales. ");
    System.out.println("    2: Herramientas electricas. ");
    System.out.println("    3: Equipo pesado, roto y escalera. ");

    int nivelHerramientas = leerInt(scanner, ":: Opcion: ");
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

    double tarifaBase = canastaBasicaFamiliar / HORASXSEMANA;
    double CostoManoDeObra = horas * (tarifaBase * multiplicador);
    System.out.println(":: Costo de mano de obra: $" + CostoManoDeObra);
    System.out.println(":: Costo de materiales: $" + costoMateriales);
    double total = costoMateriales + CostoManoDeObra;
    System.out.println(":: Costo total del trabajo: $" + total);
  }
}
