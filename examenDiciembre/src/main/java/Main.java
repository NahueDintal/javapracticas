public class Main {
  public static void main(String[] args) {
    // Calcular las horas trabajadas y su porcentaje de los empleados
    int[] horasTrabajadas = { 35, 40, 42, 38 };
    String[] empleados = { "Juan", "Panchio", "Jorjitou", "Jesucristo" };

    // Primero suma de horas, requisito para porcentaje.
    int totalHoras = 0;
    for (int i = 0; i < horasTrabajadas.length; i++) {
      int horas = horasTrabajadas[i];
      totalHoras += horas;
    }

    // Porcentaje de cada empleado
    for (int i = 0; i < empleados.length; i++) {
      double porcentaje = (horasTrabajadas[i] * 100) / totalHoras;
      System.out.println("Porcentaje: " + porcentaje + "%");
      System.out.println("Empleado: " + empleados[i]);
    }
  }
}
