public class HabitacionSimple extends Habitacion {
  private boolean tieneBalcon;

  public HabitacionSimple(int id, double precioBase, boolean tieneBalcon) {
    super(id, precioBase);
    this.tieneBalcon = tieneBalcon;
  }

  public boolean getTieneBalcon() {
    return tieneBalcon;
  }

  public double calcularPrecio(long noches) {
    return (double) (getPrecioBase() * noches) + 50;
  }
}
