// Calcular las horas trabajadas y su porcentaje de los empleados
// Primero suma de horas, requisito para porcentaje.
// Porcentaje de cada empleado
public class Main {
  public static void main(String[] args) {

  }
}

class calculoHorasTrabajo {
  public int horas;
  public String nombre;
  public String apellido;
  public int dni;
  public String cargo;
  public int horasExtras;
  public double precioHoraTrabajada;

  public calculoHorasTrabajo(int horas, String nombre, String apellido, int dni, String cargo, int horasExtras,
      double precioHoraTrabajada) {
    if (horas <= 0) {
      throw new IllegalArgumentException("Las horas no pueden ser 0...");
    }

    if (nombre == null || apellido == null || cargo == null) {
      throw new IllegalArgumentException("No puede estar vacío...");
    }

    if (dni <= 0) {
      throw new IllegalArgumentException("El dni no puede estar vacío");
    }

    if (horasExtras <= 0) {
      throw new IllegalArgumentException("Por favor ingrese un valor de horas extras");
    }

    if (precioHoraTrabajada <= 0) {
      throw new IllegalArgumentException("Por favor ingrese el valor de precio de hora trabajada");
    }

    this.horas = horas;
    this.nombre = nombre;
    this.apellido = apellido;
    this.dni = dni;
    this.cargo = cargo;
    this.horasExtras = horasExtras;
    this.precioHoraTrabajada = precioHoraTrabajada;
  }

  public double calculoHorasExtras() {
    return horasExtras * (precioHoraTrabajada * 2);
  }

  public double calculoHorasTrabajadas() {
    return calculoHorasExtras() + (horas * precioHoraTrabajada);
  }
}
