public class Main {
  public static void main(String[] args) {
    Circulo fig1 = new Circulo("rojo", 45);
    Rectangulo fig2 = new Rectangulo("violeta", 15, 155);

    System.out.println("Calculo de area figura 1: " + fig1.calculoArea());
    System.out.println("Calculo de area figura 2: " + fig2.calculoArea());
  }
}
