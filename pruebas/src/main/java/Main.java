/**
 * Proyecto: pruebas
 * Generado automáticamente con jc
 */
public class Main {
  public static void main(String[] args) {
    System.out.println("¡Hola wachin desde pruebas con Java 25!");
    System.out.println("Directorio: " + System.getProperty("user.dir"));

    // Demo de características Java 25
    demoJavaFeatures();
  }

  private static void demoJavaFeatures() {
    var message = "Java 25 funcionando correctamente!";
    System.out.println(message);

    // Pattern matching instanceOf
    Object obj = "Texto de ejemplo";
    if (obj instanceof String s) {
      System.out.println("Longitud del string: " + s.length());
    }

    // Switch expressions (Java 14+)
    int day = 3;
    String dayType = switch (day) {
      case 1, 2, 3, 4, 5 -> "Día laboral";
      case 6, 7 -> "Fin de semana";
      default -> "Día inválido";
    };
    System.out.println("Tipo de día: " + dayType);
  }
}
