class Presupuestador {
  private final double costoMateriales;
  private final double horas;
  private final double canastaBasicaFamiliar;
  private final int nivelHerramientas;

  public Presupuestador(double costoMateriales, double horas, double canastaBasicaFamiliar, int nivelHerramientas) {

    if (costoMateriales <= 0) {
      throw new IllegalArgumentException("El valor de costo materiales debe ser positivo.");
    }

    if (horas <= 0) {
      throw new IllegalArgumentException("El valor de horas deber ser positivo.");
    }

    if (canastaBasicaFamiliar <= 0) {
      throw new IllegalArgumentException("El valor de la canasta basica familiar deber ser positivo.");
    }

    if (nivelHerramientas < 1 || nivelHerramientas > 3) {
      throw new IllegalArgumentException("Nivel de herramientas debe ser 1, 2 o 3.");
    }

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
