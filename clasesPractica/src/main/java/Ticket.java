import java.text.SimpleDateFormat;
import java.util.Date;

public class Ticket {
  public static void generarTicket(String cliente, String[] items, double total) {
    System.out.println("\n" + "=".repeat(40));
    System.out.println("            TICKET DE VENTA");
    System.out.println("=".repeat(40));
    System.out.println("Fecha: " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));
    System.out.println("Cliente: " + cliente);
    System.out.println("-".repeat(40));

    for (int i = 0; i < items.length; i++) {
      System.out.printf("%-25s $%8.2f%n", items[i], 10.0 * (i + 1)); // Ejemplo
    }

    System.out.println("-".repeat(40));
    System.out.printf("TOTAL: $%.2f%n", total);
    System.out.println("=".repeat(40));
    System.out.println("¡Gracias por su compra!");
  }
}
