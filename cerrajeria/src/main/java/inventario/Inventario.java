import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

public class Inventario {
  private Map<String, Producto> productosPorCodigo;
  private Map<String, Producto> productosPorClaveUnica;

  public Inventario() {
    productosPorCodigo = new HashMap<>();
    productosPorClaveUnica = new HashMap<>();
  }

  public Producto agregarOActualizarProducto(Producto nuevoProducto) {
    String codigo = nuevoProducto.getCodigo();

    if (productosPorCodigo.containsKey(codigo)) {
      Producto existente = productosPorCodigo.get(codigo);
      existente.setMarca(nuevoProducto.getMarca());
      existente.setModelo(nuevoProducto.getModelo());
      existente.setStock(nuevoProducto.getStock());
      existente.setPrecio(nuevoProducto.getPrecio());
      return existente;
    } else {
      productosPorCodigo.put(codigo, nuevoProducto);

      String claveUnica = nuevoProducto.getMarca() + "|" + nuevoProducto.getModelo();
      productosPorClaveUnica.put(claveUnica, nuevoProducto);

      return nuevoProducto;
    }
  }

  public Producto buscarPorCodigo(String codigo) {
    return productosPorCodigo.get(codigo);
  }

  public Producto buscarPorMarcaModelo(String marca, String modelo) {
    return productosPorClaveUnica.get(marca + "|" + modelo);
  }

  public void mostrarTodos() {
    for (Producto p : productosPorCodigo.values()) {
      p.mostrarInformacion();
      System.out.println("-------------------");
    }
  }

  public Collection<Producto> getTodosLosProductos() {
    return productosPorCodigo.values();
  }
}
