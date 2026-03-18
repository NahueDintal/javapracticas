public class Circulo extends Figura {
  private double radio;

  public Circulo(String color, double radio) {
    super(color);
    this.radio = radio;
  }

  @Override
  public double calculoArea() {
    return Math.PI * radio * radio;
  }
}
