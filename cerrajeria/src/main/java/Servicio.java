import java.util.*;

public class ProductoService {
  private Map<Integer, Producto> productos = new HashMap<>();
  private int contadorId = 1;

  // CREATE - Usando la fábrica
  public Producto agregarProducto(String nombre, String descripcion,
      double precio, int stock, String categoria) {

    Producto nuevo = ProductoFactory.crearProductoConValidacion(
        contadorId++, nombre, descripcion, precio, stock, categoria);

    productos.put(nuevo.getId(), nuevo);
    return nuevo;
  }

  // READ ALL
  public List<Producto> obtenerTodos() {
    return new ArrayList<>(productos.values());
  }

  // READ BY ID
  public Producto obtenerPorId(int id) {
    return productos.get(id);
  }

  // UPDATE
  public boolean actualizarProducto(int id, String nombre, String descripcion,
      double precio, int stock, String categoria) {
    if (productos.containsKey(id)) {
      Producto actualizado = ProductoFactory.crearProductoConValidacion(
          id, nombre, descripcion, precio, stock, categoria);
      productos.put(id, actualizado);
      return true;
    }
    return false;
  }

  // DELETE
  public boolean eliminarProducto(int id) {
    return productos.remove(id) != null;
  }

  // Búsqueda por nombre
  public List<Producto> buscarPorNombre(String nombre) {
    return productos.values().stream()
        .filter(p -> p.getNombre().toLowerCase().contains(nombre.toLowerCase()))
        .toList();
  }
}
