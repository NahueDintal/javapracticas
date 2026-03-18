public class Rectangulo extends Figura {
  private double base;
  private double altura;

  public Rectangulo(String color, double base, double altura) {
    super(color);
    this.base = base;
    this.altura = altura;
  }

  @Override
  public double calculoArea() {
    return base * altura;
  }
}
