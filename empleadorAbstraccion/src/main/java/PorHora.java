public class PorHora extends Empleado {
  private double horasTrabajadas;
  private double tarifaPorHora;

  public PorHora(String nombre, int id, double horasTrabajadas, double tarifaPorHora) {
    super(nombre, id);
    this.horasTrabajadas = horasTrabajadas;
    this.tarifaPorHora = tarifaPorHora;
  }

  @Override
  public double calcularSalario() {
    return horasTrabajadas * tarifaPorHora;
  }
}
