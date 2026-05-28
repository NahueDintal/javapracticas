public class Funcion {
  private Pelicula pelicula;
  private Sala sala;
  private String horario;
  private String fecha;

  public Funcion(Pelicula pelicula, Sala sala, String horario, String fecha) {
    this.pelicula = pelicula;
    this.sala = sala;
    this.horario = horario;
    this.fecha = fecha;
  }

  public Pelicula getPelicula() {
    return pelicula;
  }

  public String getTitulo() {
    return pelicula.getTitulo();
  }

  public String getHorario() {
    return horario;
  }

  public String getFecha() {
    return fecha;
  }

  public boolean reservarButacas(int cantidad) {
    if (sala.getButacasLibres() > cantidad) {
      sala.ocuparButacas(cantidad);
      return true;
    }
    return false;
  }

  public boolean cancelarReserva(int cantidad) {
    if (sala.getButacasOcupadas() > cantidad) {
      sala.liberarButacas(cantidad);
      return true;
    }
    return false;
  }

  public void mostrarDetalle() {
    System.out.println("Pelicula: " + pelicula.getTitulo());
    System.out.println("Sala: " + sala.getNumeroSala());
    System.out.println("Butacas libres: " + sala.getButacasLibres());
  }

}
