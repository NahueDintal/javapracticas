// ============================
// CLASE PADRE (SUPERCLASE)
// ============================

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase base que representa a una Persona
 * Usamos 'abstract' para indicar que no se puede instanciar directamente
 */
public abstract class Persona {
  // Atributos privados (encapsulamiento)
  private String nombre;
  private String apellido;
  private LocalDate fechaNacimiento;
  private String dni;

  // Constante estática
  protected static final String PAIS = "España";

  // Lista protegida para uso en herencia
  protected List<String> contactos = new ArrayList<>();

  // ============================
  // CONSTRUCTORES
  // ============================

  // Constructor por defecto
  public Persona() {
    this.nombre = "Sin nombre";
    this.apellido = "Sin apellido";
    this.fechaNacimiento = LocalDate.now();
    this.dni = "00000000A";
  }

  // Constructor con parámetros
  public Persona(String nombre, String apellido, LocalDate fechaNacimiento, String dni) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.fechaNacimiento = fechaNacimiento;
    this.dni = dni;
  }

  // Constructor de copia
  public Persona(Persona otraPersona) {
    this.nombre = otraPersona.nombre;
    this.apellido = otraPersona.apellido;
    this.fechaNacimiento = otraPersona.fechaNacimiento;
    this.dni = otraPersona.dni;
    this.contactos = new ArrayList<>(otraPersona.contactos);
  }

  // ============================
  // GETTERS Y SETTERS
  // ============================

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    if (nombre != null && !nombre.trim().isEmpty()) {
      this.nombre = nombre;
    } else {
      throw new IllegalArgumentException("El nombre no puede estar vacío");
    }
  }

  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public LocalDate getFechaNacimiento() {
    return fechaNacimiento;
  }

  public void setFechaNacimiento(LocalDate fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }

  public String getDni() {
    return dni;
  }

  public void setDni(String dni) {
    this.dni = dni;
  }

  // ============================
  // MÉTODOS PÚBLICOS
  // ============================

  /**
   * Método concreto que pueden usar todas las subclases
   */
  public String getNombreCompleto() {
    return nombre + " " + apellido;
  }

  /**
   * Método abstracto que deben implementar las subclases
   */
  public abstract String obtenerInformacion();

  /**
   * Método que puede ser sobrescrito por las subclases
   */
  public String getTipoPersona() {
    return "Persona";
  }

  // ============================
  // MÉTODOS DE LA CLASE OBJECT
  // ============================

  @Override
  public String toString() {
    return getNombreCompleto() + " - DNI: " + dni;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null || getClass() != obj.getClass())
      return false;
    Persona persona = (Persona) obj;
    return dni.equals(persona.dni);
  }

  @Override
  public int hashCode() {
    return dni.hashCode();
  }
}

// ============================
// INTERFAZ
// ============================

/**
 * Interfaz que define comportamientos para trabajadores
 */
public interface Trabajador {
  // Constante en interfaz (implícitamente public static final)
  int HORAS_JORNADA = 40;

  // Métodos abstractos (sin implementación)
  double calcularSalario();

  String getPuesto();

  // Método default (Java 8+)
  default String getInfoTrabajador() {
    return "Trabajador con jornada de " + HORAS_JORNADA + " horas";
  }

  // Método static (Java 8+)
  static boolean esJornadaCompleta(int horas) {
    return horas >= HORAS_JORNADA;
  }
}

// ============================
// CLASE HIJA (SUBCLASE)
// ============================

/**
 * Clase Empleado que hereda de Persona e implementa Trabajador
 */
public class Empleado extends Persona implements Trabajador {
  // Atributos específicos de Empleado
  private String puesto;
  private double salario;
  private String departamento;
  private LocalDate fechaContratacion;

  // Constante específica
  private static final double BONO_ANTIGUEDAD = 0.05;

  // ============================
  // CONSTRUCTORES
  // ============================

  public Empleado() {
    super(); // Llama al constructor de la clase padre
    this.puesto = "Sin puesto";
    this.salario = 0.0;
    this.departamento = "Sin departamento";
    this.fechaContratacion = LocalDate.now();
  }

  // Constructor con parámetros usando super()
  public Empleado(String nombre, String apellido, LocalDate fechaNacimiento,
      String dni, String puesto, double salario, String departamento) {
    super(nombre, apellido, fechaNacimiento, dni);
    this.puesto = puesto;
    this.salario = salario;
    this.departamento = departamento;
    this.fechaContratacion = LocalDate.now();
  }

  // ============================
  // GETTERS Y SETTERS
  // ============================

  public String getPuesto() {
    return puesto;
  }

  public void setPuesto(String puesto) {
    this.puesto = puesto;
  }

  public double getSalario() {
    return salario;
  }

  public void setSalario(double salario) {
    if (salario >= 0) {
      this.salario = salario;
    } else {
      throw new IllegalArgumentException("El salario no puede ser negativo");
    }
  }

  public String getDepartamento() {
    return departamento;
  }

  public void setDepartamento(String departamento) {
    this.departamento = departamento;
  }

  public LocalDate getFechaContratacion() {
    return fechaContratacion;
  }

  public void setFechaContratacion(LocalDate fechaContratacion) {
    this.fechaContratacion = fechaContratacion;
  }

  // ============================
  // IMPLEMENTACIÓN DE MÉTODOS ABSTRACTOS
  // ============================

  @Override
  public String obtenerInformacion() {
    return String.format("Empleado: %s, Puesto: %s, Departamento: %s, Salario: %.2f€",
        getNombreCompleto(), puesto, departamento, salario);
  }

  @Override
  public double calcularSalario() {
    // Cálculo con bono por antigüedad
    int añosAntiguedad = LocalDate.now().getYear() - fechaContratacion.getYear();
    return salario + (salario * BONO_ANTIGUEDAD * añosAntiguedad);
  }

  // ============================
  // SOBREESCRITURA DE MÉTODOS
  // ============================

  @Override
  public String getTipoPersona() {
    return "Empleado";
  }

  @Override
  public String toString() {
    return super.toString() + String.format(" - Puesto: %s - Departamento: %s",
        puesto, departamento);
  }

  // ============================
  // MÉTODOS ESPECÍFICOS DE EMPLEADO
  // ============================

  public void aumentarSalario(double porcentaje) {
    if (porcentaje > 0) {
      this.salario += this.salario * (porcentaje / 100);
    }
  }

  public int getAntiguedad() {
    return LocalDate.now().getYear() - fechaContratacion.getYear();
  }
}

// ============================
// CLASE HIJA DE EMPLEADO
// ============================

/**
 * Clase Gerente que hereda de Empleado
 * Ejemplo de herencia multinivel
 */
public class Gerente extends Empleado {
  // Atributos específicos de Gerente
  private double bonoGerencia;
  private List<Empleado> equipo;

  // ============================
  // CONSTRUCTORES
  // ============================

  public Gerente() {
    super();
    this.bonoGerencia = 0.0;
    this.equipo = new ArrayList<>();
  }

  public Gerente(String nombre, String apellido, LocalDate fechaNacimiento,
      String dni, String puesto, double salario, String departamento,
      double bonoGerencia) {
    super(nombre, apellido, fechaNacimiento, dni, puesto, salario, departamento);
    this.bonoGerencia = bonoGerencia;
    this.equipo = new ArrayList<>();
  }

  // ============================
  // GETTERS Y SETTERS
  // ============================

  public double getBonoGerencia() {
    return bonoGerencia;
  }

  public void setBonoGerencia(double bonoGerencia) {
    this.bonoGerencia = bonoGerencia;
  }

  public List<Empleado> getEquipo() {
    return new ArrayList<>(equipo); // Devuelve copia para proteger encapsulamiento
  }

  // ============================
  // SOBREESCRITURA DE MÉTODOS
  // ============================

  @Override
  public double calcularSalario() {
    // Llama al método de la clase padre y añade el bono de gerencia
    return super.calcularSalario() + bonoGerencia;
  }

  @Override
  public String obtenerInformacion() {
    return super.obtenerInformacion() +
        String.format(" - Bono Gerencia: %.2f€ - Equipo: %d personas",
            bonoGerencia, equipo.size());
  }

  @Override
  public String getTipoPersona() {
    return "Gerente";
  }

  // ============================
  // MÉTODOS ESPECÍFICOS DE GERENTE
  // ============================

  public void agregarEmpleadoAlEquipo(Empleado empleado) {
    if (empleado != null && !equipo.contains(empleado)) {
      equipo.add(empleado);
    }
  }

  public void eliminarEmpleadoDelEquipo(Empleado empleado) {
    equipo.remove(empleado);
  }
}

// ============================
// CLASE PARA DEMOSTRAR USO
// ============================

public class Main {
  public static void main(String[] args) {
    // ======================
    // USO DE LAS CLASES
    // ======================

    // No se puede instanciar una clase abstracta
    // Persona persona = new Persona(); // ERROR

    // Crear un Empleado
    Empleado empleado1 = new Empleado(
        "Juan",
        "Pérez",
        LocalDate.of(1990, 5, 15),
        "12345678A",
        "Desarrollador",
        30000.0,
        "TI");

    // Usar setters
    empleado1.setSalario(32000.0);

    // Usar getters
    System.out.println("Nombre completo: " + empleado1.getNombreCompleto());
    System.out.println("DNI: " + empleado1.getDni());
    System.out.println("Puesto: " + empleado1.getPuesto());

    // Usar método sobrescrito
    System.out.println(empleado1.obtenerInformacion());

    // Usar método de la interfaz
    System.out.println("Salario calculado: " + empleado1.calcularSalario());
    System.out.println(empleado1.getInfoTrabajador());

    // Crear un Gerente
    Gerente gerente1 = new Gerente(
        "María",
        "Gómez",
        LocalDate.of(1985, 3, 22),
        "87654321B",
        "Gerente de Proyecto",
        50000.0,
        "TI",
        5000.0);

    // Añadir empleado al equipo del gerente
    gerente1.agregarEmpleadoAlEquipo(empleado1);

    // Polimorfismo
    Persona personaPolimorfica = gerente1;
    System.out.println("\n--- Polimorfismo ---");
    System.out.println("Tipo de persona: " + personaPolimorfica.getTipoPersona());
    System.out.println("Información: " + personaPolimorfica.obtenerInformacion());

    Trabajador trabajadorPolimorfico = gerente1;
    System.out.println("Salario gerente: " + trabajadorPolimorfico.calcularSalario());

    // ======================
    // COLECCIONES Y ARRAYS
    // ======================

    List<Persona> personas = new ArrayList<>();
    personas.add(empleado1);
    personas.add(gerente1);

    System.out.println("\n--- Lista de Personas ---");
    for (Persona p : personas) {
      System.out.println(p.getTipoPersona() + ": " + p.getNombreCompleto());
    }

    // ======================
    // COMPARACIONES
    // ======================

    Empleado empleado2 = new Empleado(empleado1); // Usando constructor de copia
    empleado2.setDni("12345678A");

    System.out.println("\n--- Comparaciones ---");
    System.out.println("¿Son iguales? " + empleado1.equals(empleado2));
    System.out.println("HashCode empleado1: " + empleado1.hashCode());
    System.out.println("HashCode empleado2: " + empleado2.hashCode());

    // ======================
    // USO DE MÉTODOS STATIC
    // ======================

    System.out.println("\n--- Métodos Static ---");
    System.out.println("¿Es jornada completa 45 horas? " + Trabajador.esJornadaCompleta(45));
    System.out.println("País desde constante: " + Persona.PAIS);
  }
}
