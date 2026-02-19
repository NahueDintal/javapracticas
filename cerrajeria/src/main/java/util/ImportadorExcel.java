import java.util.List;

public class ImportadorExcel {
  private Inventario inventario;

  public ImportadorExcel(Inventario inventario) {
    this.inventario = inventario;
  }

  // public void importarLista(List<ProductoExcelDTO> productosExcel) {
  // // Comenta temporalmente si no tienes la clase ProductoExcelDTO
  // System.out.println("ImportadorExcel: Función no implementada aún");
  // /*
  // * for (ProductoExcelDTO dto : productosExcel) {
  // * Producto producto = crearProductoDesdeDTO(dto);
  // * Producto resultado = inventario.agregarOActualizarProducto(producto);
  // *
  // * if (resultado.getId() != producto.getId()) {
  // * System.out.println("Actualizado: " + dto.getCodigo());
  // * } else {
  // * System.out.println("Nuevo: " + dto.getCodigo());
  // * }
  // * }
  // */
  // }

  // private Producto crearProductoDesdeDTO(ProductoExcelDTO dto) {
  // // Comenta temporalmente
  // return null;
  // /*
  // * switch (dto.getTipo()) {
  // * case "CAMARA":
  // * return Fabrica.nuevaCamara(dto.getCodigo(), dto.getMarca(),
  // * dto.getModelo(), dto.getStock(),
  // * dto.getPrecio(), dto.getTipoConexion());
  // * case "ALARMA":
  // * return Fabrica.nuevaAlarma(dto.getCodigo(), dto.getMarca(),
  // * dto.getModelo(), dto.getStock(),
  // * dto.getPrecio(), dto.isInalambrico());
  // * // ... otros tipos
  // * }
  // */
  // }
}
