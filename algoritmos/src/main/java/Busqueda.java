public class Busqueda {
  public static int binaria(int[] array, int elementoBuscado) {
    int izquierda = 0;
    int derecha = array.length - 1;

    while (izquierda <= derecha) {
      int medio = izquierda + (derecha - izquierda) / 2;

      if (array[medio] == elementoBuscado) {
        return medio;
      }

      if (array[medio] < elementoBuscado) {
        izquierda = medio + 1;
      } else {
        derecha = medio - 1;
      }
    }
    return -1;
  }

  public static int lineal(int[] array, int elementoBuscado) {
    for (int i = 0; i < array.length; i++) {
      if (array[i] == elementoBuscado)
        return i;
    }
    return -1;
  }
}
