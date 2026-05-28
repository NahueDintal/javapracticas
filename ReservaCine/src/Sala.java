public class Sala {
  private int numeroSala;
  private int capacidad;
  private int butacasOcupadas = 0;

  public Sala(int numeroSala, int capacidad) {
    this.numeroSala = numeroSala;
    this.capacidad = capacidad;
  }

  public int getNumeroSala() {
    return numeroSala;
  }

  public int getCapacidad() {
    return capacidad;
  }

  public int getButacasOcupadas() {
    return butacasOcupadas;
  }

  public int getButacasLibres() {
    return capacidad - getButacasOcupadas();
  }

  public void setButacasOcupadas(int butacasOcupadas) {
    this.butacasOcupadas += butacasOcupadas;

  }

  public boolean hayButacasDisponibles() {
    return butacasOcupadas < capacidad;
  }

  public void ocuparButacas(int cantidad) {
    if (getButacasLibres() >= cantidad) {
      setButacasOcupadas(cantidad);
    }
  }

  public void liberarButacas(int cantidad) {
    butacasOcupadas -= cantidad;
  }
}
