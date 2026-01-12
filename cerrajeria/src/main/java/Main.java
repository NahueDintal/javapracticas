public class EntradaConsola {
  private static final Scanner SCANNER = new Scanner(System.in);

  public static String texto(String mensaje) {
    System.out.print(mensaje + ": ");
    return SCANNER.nextLine().trim();
  }

  public static int entero(String mensaje) {
    while (true) {
      try {
        System.out.print(mensaje + ": ");
        return Integer.parseInt(SCANNER.nextLine().trim());
      } catch (NumberFormatException e) {
        System.out.println("❌ Debe ser un número entero");
      }
    }
  }

  public static double decimal(String mensaje) {
    while (true) {
      try {
        System.out.print(mensaje + ": ");
        return Double.parseDouble(SCANNER.nextLine().trim());
      } catch (NumberFormatException e) {
        System.out.println("❌ Debe ser un número válido");
      }
    }
  }
}

// 2. Uso en tu menú principal
public class Main {
  public static void main(String[] args) {
    boolean continuar = true;

    while (continuar) {
      System.out.println("\n=== SISTEMA DE STOCK ===");
      System.out.println("1. Agregar Alarma");
      System.out.println("2. Listar Productos");
      System.out.println("3. Salir");
      System.out.print("Opción: ");

      int opcion = EntradaConsola.entero("Seleccione opción");

      switch (opcion) {
        case 1:
          agregarAlarma();
          break;
        case 2:
          listarProductos();
          break;
        case 3:
          continuar = false;
          break;
      }
    }
  }

  private static void agregarAlarma() {
    System.out.println("\n--- NUEVA ALARMA ---");

    Alarma alarma = Alarma.crear()
        .conId(EntradaConsola.entero("ID"))
        .conCodigo(EntradaConsola.texto("Código"))
        .deMarca(EntradaConsola.texto("Marca"))
        .modelo(EntradaConsola.texto("Modelo"))
        .stock(EntradaConsola.entero("Stock"))
        .precio(EntradaConsola.decimal("Precio"))
        .conexionWifi() // O pedirlo: .conTipoConexion(pedirTipoConexion())
        .build();

    // Guardar en tu sistema
    System.out.println("✅ Alarma creada exitosamente!");
  }

  private static String pedirTipoConexion() {
    System.out.println("\nTipo de conexión:");
    System.out.println("1. WiFi");
    System.out.println("2. Cableada");
    System.out.println("3. Híbrida");

    int opcion = EntradaConsola.entero("Seleccione (1-3)");

    switch (opcion) {
      case 1:
        return "WiFi";
      case 2:
        return "Cableada";
      case 3:
        return "Híbrida";
      default:
        return "Cableada";
    }
  }
}
