import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int opcion = 0;
    boolean ok = false;

    while (!ok) {
      System.out.println("::Calculadora de presupuesto!");
      System.out.println("    1: Configurar condiciones. ");
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

  public static void configurarAjustes(Scanner scanner) {
    double costoMateriales = 0;
    boolean okCostoMateriales = false;

    while (!okCostoMateriales) {
      System.out.print(":: Costo de materiales: ");
      String linea = scanner.nextLine();
      try {
        costoMateriales = Double.parseDouble(linea);
        okCostoMateriales = true;
      } catch (NumberFormatException e) {
        System.out.println("Por favor ingresa solo numeros y punto para decimal...");
      }
    }

    double horas = 0;
    boolean okHoras = false;
    while (!okHoras) {
      System.out.print(":: Horas estimadas de trabajo: ");
      String linea = scanner.nextLine();
      try {
        horas = Double.parseDouble(linea);
        okHoras = true;
      } catch (NumberFormatException e) {
        System.out.println("Por favor, solo ingresa horas...");
      }
    }

    double canastaBasicaFamiliar = 0;
    boolean okCanastaBasicaFamiliar = false;
    while (!okCanastaBasicaFamiliar) {
      System.out.print(":: Canasta basica familiar: $");
      String linea = scanner.nextLine();
      try {
        canastaBasicaFamiliar = Double.parseDouble(linea);
        okCanastaBasicaFamiliar = true;
      } catch (NumberFormatException e) {
        System.out.println("Por favor solo, ingresa el monto en pesos...");
      }
    }

    int nivelHerramientas = 0;
    boolean okNivelHerramientas = false;
    double multiplicador = 0;
    while (!okNivelHerramientas) {
      System.out.println(":: Nivel de herramientas utilizadas. ");
      System.out.println("    1: Herramientas manuales. ");
      System.out.println("    2: Herramientas electricas. ");
      System.out.println("    3: Equipo pesado, roto y escalera. ");
      System.out.print(":: Opcion: ");
      String linea = scanner.nextLine();

      try {
        nivelHerramientas = Integer.parseInt(linea);
        okNivelHerramientas = true;
        multiplicador = 0;
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
      } catch (NumberFormatException e) {
        System.out.println("Por favor, elija solo una de las opciones...");
      }
    }

    // Procesos
    double tarifaBase = canastaBasicaFamiliar / 40;
    double CostoManoDeObra = horas * (tarifaBase * multiplicador);
    System.out.println(":: Costo de mano de obra: $" + CostoManoDeObra);
    System.out.println(":: Costo de materiales: $" + costoMateriales);
    double total = costoMateriales + CostoManoDeObra;
    System.out.println(":: Costo total del trabajo: $" + total);
  }
}
