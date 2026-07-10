public class HabitacionSimple extends Habitacion {
  private boolean tieneBalcon;

  public HabitacionSimple(boolean tieneBalcon) {
    this.tieneBalcon = tieneBalcon;
  }

  public boolean getTieneBalcon() {
    return tieneBalcon;
  }

  public double calcularPrecio(int noches) {
    return (double) (getPrecioBase() * noches) + 50;
  }
}
