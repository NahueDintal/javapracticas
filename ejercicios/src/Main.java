import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int altura = 0;
    System.out.print("Ingrese la altura con un numero entero: ");

    altura = sc.nextInt();

    for (int i = 1; i <= altura; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print(i + " ");
      }
      System.out.println();
    }

    sc.close();
  }
}
