import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // int altura = 0;
    // System.out.print("Ingrese la altura con un numero entero: ");
    //
    // altura = sc.nextInt();

    // for (int i = 1; i <= altura; i++) {
    // for (int j = 1; j <= i; j++) {
    // System.out.print(i + " ");
    // }
    // System.out.println();
    // }

    // int i = 1;
    // while (i <= altura) {
    // int j = 1;
    // while (j <= i) {
    // System.out.print(i);
    // j++;
    // }
    // i++;
    // System.out.println();
    //
    // }

    // int numeroEntero = 0;
    // boolean valido = false;
    // do {
    // try {
    // System.out.println("Ingrese un numero entero entre 1 y 10: ");
    // numeroEntero = sc.nextInt();
    // if (numeroEntero > 0 && numeroEntero <= 10) {
    // System.out.println("Muchas gracias! Ingresaste " + numeroEntero);
    // valido = true;
    // }
    //
    // } catch (InputMismatchException e) {
    // System.out.println("Por favor ingrese un numero entero entre 1 y 10");
    // sc.nextLine();
    // }
    // } while (!valido);

    // int suma = 0;
    // int numeroEntero = 0;
    // boolean valido = false;
    //
    // do {
    // try {
    // System.out.println("Para salir ingrese un numero negativo");
    // numeroEntero = sc.nextInt();
    // if (numeroEntero > 0) {
    // suma += numeroEntero;
    // System.out.println("Suma: " + suma);
    // } else {
    // System.out.println("Ingresaste un numero negativo, fin de la suma.");
    // System.out.println("Suma: " + suma);
    // valido = true;
    // }
    // } catch (InputMismatchException e) {
    // System.out.println("Por favor ingrese un numero entero");
    // sc.nextLine();
    // }
    // } while (!valido);
    //

    int numeroSegundus = 0;
    int numeroPrimaris = 0;
    int resultado = 0;
    boolean valido = false;

    do {
      try {
        System.out.print("Ingrese un numero para divirlo: ");
        numeroPrimaris = sc.nextInt();
        System.out.print("Ingrese un numero para dividir: ");
        numeroSegundus = sc.nextInt();
        resultado = numeroPrimaris / numeroSegundus;
        valido = true;
        System.out.println("El resultado es: " + resultado);

      } catch (ArithmeticException e) {
        System.out.println("Por favor ingrese un numero entero");
        sc.nextLine();
      } catch (NullPointerException e) {
        System.out.println("Por favor ingrese un numero entero");
        sc.nextLine();
      } catch (InputMismatchException e) {
        System.out.println("Por favor ingrese un valor adecuado, un numero");
        sc.nextLine();
      }
    } while (!valido);
    sc.close();
  }
}
