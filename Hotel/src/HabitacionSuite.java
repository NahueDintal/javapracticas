public class HabitacionSuite extends Habitacion {
  private boolean tieneJacuzzi;

  public HabitacionSuite(int id, double precioBase, boolean tieneJacuzzi) {
    super(id, precioBase);
    this.tieneJacuzzi = tieneJacuzzi;
  }

  public boolean getTieneJacuzzi() {
    return tieneJacuzzi;
  }

  public double calcularPrecio(long noches) {
    return (double) (getPrecioBase() * noches) + 80;
  }
}
