import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    try {
      System.out.println("Ingrese dividendo");
      int dividendo = scanner.nextInt();

      System.out.println("Ingrese divisor");
      int divisor = scanner.nextInt();

      int resultado = dividendo / divisor;
      System.out.println("Resultado: " + resultado);

    } catch (ArithmeticException e) {
      System.out.println("Error: No se puede dividir por cero!");

    } catch (InputMismatchException e) {
      System.out.println("Error: Debe ingresar números enteros!");

    } finally {
      System.out.println("Operacion finalizada!");
      scanner.close();

    }
  }
}
