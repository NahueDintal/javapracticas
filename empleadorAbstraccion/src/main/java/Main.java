public class Main {
  public static void main(String[] args) {
    Empleado emp1 = new PorHora("Juan Perez", 03, 45, 50000);
    System.out.println(emp1.calcularSalario());
    Empleado emp2 = new Asalariado("Virginia Días", 35, 2500000);
    System.out.println(emp2.calcularSalario());
  }
}
