public class HabitacionSuite extends Habitacion {
  private boolean tieneJacuzzi;

  public HabitacionSuite(boolean tieneJacuzzi) {
    this.tieneJacuzzi = tieneJacuzzi;
  }

  public boolean getTieneBalcon() {
    return tieneJacuzzi;
  }

  public double calcularPrecio(int noches) {
    return (double) (getPrecioBase() * noches) + 80;
  }
}
