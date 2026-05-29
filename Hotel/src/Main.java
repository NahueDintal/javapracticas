public class Main {
  public static void main(String[] args) {
    Habitacion habitacion = new Habitacion(001, 4, 120000);

    habitacion.mostrarInfo();

    Cliente cliente = new Cliente(001, "Paco del Valle", "paquito123@gmail.com");

    cliente.mostrarInfo();

    Reserva reserva = new Reserva(cliente, habitacion, "2026-05-10", "2026-05-15");

    System.out.println("El costo de la reserva es de: $ " + reserva.calcularCostoTotal(5));

  }
}

