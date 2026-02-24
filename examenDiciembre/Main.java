public class Main {
  public static void main(String[] args) {
    try {
      Presupuestador presupuesto = new Presupuestador(17000, 3, aoi34wjfpwa039jref, 6);
      System.out.println("Tatal mano de obra: $" + presupuesto.calcularCostoManoDeObra());
      System.out.println("Mano de obra más materiales: $" + presupuesto.calcularTotal());

    } catch (IllegalArgumentException e) {
      System.out.println("Dato inválido: " + e.getMessage());

    }
  }
}
