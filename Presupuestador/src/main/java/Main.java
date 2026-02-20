import com.sun.net.httpserver.BasicAuthenticator;

public class Presupuesto {
  private final double costoMateriales;
  private final double horas;
  private final double canastaBasicaFamiliar;
  private final int nivelHerramientas;

  public Presupuesto(double costoMateriales, double horas, double canastaBasicaFamiliar, int nivelHerramientas) {
    this.costoMateriales = costoMateriales;
    this.horas = horas;
    this.canastaBasicaFamiliar = canastaBasicaFamiliar;
    this.nivelHerramientas = nivelHerramientas;
  }

  public double calcularCostoManoDeObra() {
    double multiplicador = switch (nivelHerramientas) {
      case 1 -> 1.0;
      case 2 -> 1.3;
      case 3 -> 1.6;
      default -> 1.0;
    };
    double tarifaBase = canastaBasicaFamiliar / 40;
    return horas * (tarifaBase * multiplicador);
  }

  public double calcularTotal() {
    return costoMateriales + calcularCostoManoDeObra();
  }
}
