public class Pelicula {
  private String titulo;
  private int duracion;
  private String genero;
  private String clasificacion;

  public Pelicula(String titulo, int duracion, String genero, String clasificacion) {
    this.titulo = titulo;
    this.duracion = duracion;
    this.genero = genero;
    this.clasificacion = clasificacion;
  }

  public String getTitulo() {
    return titulo;
  }

  public int getDuracion() {
    return duracion;
  }

  public String getGenero() {
    return genero;
  }

  public String getClasificacion() {
    return clasificacion;
  }

  public void mostrarInfo() {
    System.out
        .println(getTitulo() + " | Duración " + getDuracion() + " min | " + getGenero() + " | Clasif: "
            + getClasificacion());
  }
}
