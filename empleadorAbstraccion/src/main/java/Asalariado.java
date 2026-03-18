public class Asalariado extends Empleado {
  private double salarioMensual;

  public Asalariado(String nombre, int id, double salarioMensual) {
    super(nombre, id);
    this.salarioMensual = salarioMensual;
  }

  @Override
  public double calcularSalario() {
    return salarioMensual;

  }
}
