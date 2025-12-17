public class Busqueda {
  public static int binaria(int[] array, int elementoBuscado) {
    int izquierda = 0; // Inicio del array
    int derecha = array.length - 1; // Final del array

    while (izquierda <= derecha) {
      int medio = izquierda + (derecha - izquierda) / 2;

      if (array[medio] == elementoBuscado) {
        return medio; // ¡Encontrado! Devolvemos posición
      }

      if (array[medio] < elementoBuscado) {
        izquierda = medio + 1; // Buscamos en la mitad DERECHA
      } else {
        derecha = medio - 1; // Buscamos en la mitad IZQUIERDA
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
