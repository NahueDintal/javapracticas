import java.util.ArrayList;
import java.util.List;

public class Cine {
  private List<Funcion> funciones;

  public Cine() {
    this.funciones = new ArrayList<>();
  }

  public void agregarFuncion(Pelicula pelicula, Sala sala, String horario, String fecha) {
    Funcion funcion = new Funcion(pelicula, sala, horario, fecha);
    funciones.add(funcion);
  }

  public Funcion buscarFuncion(String tituloPelicula, String horario) {
    for (Funcion funcion : funciones) {
      String tituloDeEstaFuncion = funcion.getPelicula().getTitulo();
      String horarioDeEstaFuncion = funcion.getHorario();
      if (tituloDeEstaFuncion.equalsIgnoreCase(tituloPelicula) && horarioDeEstaFuncion.equals(horario)) {
        return funcion;
      }
    }
    return null;
  }

  public void reservarButaca(String tituloPelicula, String horario, int cantidad, String nombreCliente) {
    Funcion funcion = buscarFuncion(tituloPelicula, horario);

    if (funcion == null) {
      System.out.println("No se encontró ninguna función con ese titulo y horario.");
      return;
    }
    if (funcion.reservarButacas(cantidad)) {
      System.out.println("Reserva confirmada para " + nombreCliente);
    } else {
      System.out.println("No hay suficientes butacas libres.");
    }

  }

  public void mostrarCartelera() {
    if (funciones.isEmpty()) {
      System.out.println("No hay funciones programadas.");
      return;
    }
    for (Funcion f : funciones) {
      f.mostrarDetalle();
      System.out.println("--------------------");
    }

  }
}
