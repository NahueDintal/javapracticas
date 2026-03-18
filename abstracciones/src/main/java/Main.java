public class Main {
  public static void main(String[] args) {
    Circulo figura1 = new Circulo("Azul", 15);
    Rectangulo figura2 = new Rectangulo("Rojo", 4, 5);

    System.out.println("Calculo de area figura 1: " + figura1.calcularArea());
    System.out.println("Calculo de area figura 2: " + figura2.calcularArea());
  }
}
