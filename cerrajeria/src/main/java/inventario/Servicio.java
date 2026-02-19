import java.util.Collection;

public class Servicio {
  private Inventario inventario;

  public Servicio(Inventario inventario) {
    this.inventario = inventario;
  }

  public Producto buscarProductoPorId(int id) {
    Collection<Producto> productos = inventario.getTodosLosProductos();
    for (Producto producto : productos) {
      if (producto.getId() == id) {
        return producto;
      }
    }
    throw new IllegalArgumentException("No se encuentra el producto con ID: " + id);
  }

  public Producto buscarProductoPorMarca(String marca) {
    Collection<Producto> productos = inventario.getTodosLosProductos();
    for (Producto producto : productos) {
      if (producto.getMarca().equalsIgnoreCase(marca)) {
        return producto;
      }
    }
    throw new IllegalArgumentException("No se encuentra el producto con la Marca: " + marca);
  }
}
