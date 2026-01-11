public class Fabrica {

  public static Producto nuevaCamara(int id, String codigo, String marca,
      String modelo, int stock, double precio, String tipoConexion) {
    validaciones(marca, modelo, precio, stock);
    return new Camara(id, codigo, marca, modelo, stock, precio, tipoConexion);
  }

  public static Producto nuevaAlarma(int id, String codigo, String marca,
      String modelo, int stock, double precio, boolean inalambrico) {
    validaciones(marca, modelo, precio, stock);
    return new Alarma(id, codigo, marca, modelo, stock, precio, inalambrico);
  }

  public static Producto nuevoCandado(int id, String codigo, String marca,
      String modelo, int stock, double precio, int cantidadLlaves) {
    validaciones(marca, modelo, precio, stock);
    return new Candado(id, codigo, marca, modelo, stock, precio, cantidadLlaves);
  }

  public static Producto nuevaCerradura(int id, String codigo, String marca,
      String modelo, int stock, double precio, int cantidadCombinaciones) {
    validaciones(marca, modelo, precio, stock);
    return new Cerradura(id, codigo, marca, modelo, stock, precio, cantidadCombinaciones);
  }

  public static Producto nuevoPasador(int id, String codigo, String marca,
      String modelo, int stock, double precio, String color, boolean conLlave) {
    validaciones(marca, modelo, precio, stock);
    return new Pasador(id, codigo, marca, modelo, stock, precio, color, conLlave);
  }

  public static Producto nuevaManija(int id, String codigo, String marca,
      String modelo, int stock, double precio, String color) {
    validaciones(marca, modelo, precio, stock);
    return new Camara(id, codigo, marca, modelo, stock, precio, color);
  }

  public static void validaciones(String marca, String modelo, double precio, int stock) {

    if (marca == null || marca.trim().isEmpty()) {
      throw new IllegalArgumentException("No puede estar vacío el nombre de la marca");
    }
    if (modelo == null || marca.trim().isEmpty()) {
      throw new IllegalArgumentException("No puede estar vacío el nombre del modelo");
    }
    if (precio <= 0) {
      throw new IllegalArgumentException("El precio debe ser mayor a 0");
    }
    if (stock < 0) {
      throw new IllegalArgumentException("El stock no puede ser negativo");
    }
  }
}
