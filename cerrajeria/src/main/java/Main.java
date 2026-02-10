public class Main {
  public static void main(String[] args) {
    Inventario inventario = new Inventario();

    // Crear productos usando la fábrica (sin ID)
    Producto alarma = Fabrica.nuevaAlarma("AL001", "Ezviz", "C9C", 4, 95000, true);
    Producto candado = Fabrica.nuevoCandado("Can001", "Olaen", "Art.30", 5, 30000, 2);

    // Agregar al inventario
    inventario.agregarOActualizarProducto(alarma);
    inventario.agregarOActualizarProducto(candado);

    // Mostrar información
    System.out.println("=== Productos en Inventario ===");
    inventario.mostrarTodos();

    // Probar el servicio
    Servicio servicio = new Servicio(inventario);

    try {
      System.out.println("\n=== Buscar por ID ===");
      Producto encontrado = servicio.buscarProductoPorId(1);
      encontrado.mostrarInformacion();
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
