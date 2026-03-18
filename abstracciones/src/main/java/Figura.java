public abstract class Figura {
  private String color;

  // constructoro
  public Figura(String color) {
    this.color = color;
  }

  // getter
  public String getColor() {
    return color;
  }

  // setter
  public void setColor(String color) {
    this.color = color;
  }

  // calculo de area
  public abstract double calculoArea();
}
