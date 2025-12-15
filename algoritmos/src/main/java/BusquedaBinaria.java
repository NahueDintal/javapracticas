import java.util.Arrays; // Necesario para ordenar

public class BusquedaBinaria {
  // IMPORTANTE: El array DEBE estar ORDENADO
  public static int busquedaBinaria(int[] array, int elementoBuscado) {
    // 1. Definimos los límites de búsqueda
    int izquierda = 0; // Inicio del array
    int derecha = array.length - 1; // Final del array

    // 2. Mientras haya elementos por revisar
    while (izquierda <= derecha) {
      // 3. Calculamos el punto medio (evitando overflow)
      int medio = izquierda + (derecha - izquierda) / 2;

      // 4. Verificamos si encontramos el elemento
      if (array[medio] == elementoBuscado) {
        return medio; // ¡Encontrado! Devolvemos posición
      }

      // 5. Si el elemento del medio es MENOR que el buscado
      if (array[medio] < elementoBuscado) {
        izquierda = medio + 1; // Buscamos en la mitad DERECHA
      }
      // 6. Si el elemento del medio es MAYOR que el buscado
      else {
        derecha = medio - 1; // Buscamos en la mitad IZQUIERDA
      }
    }

    // 7. Si salimos del while, no encontramos el elemento
    return -1;
  }

  public static void main(String[] args) {
    int[] numeros = { 10, 23, 45, 70, 11, 15 };

    // ¡ORDENAMOS antes de usar búsqueda binaria!
    Arrays.sort(numeros); // Ordena: {10, 11, 15, 23, 45, 70}

    int buscar = 23;
    int resultado = busquedaBinaria(numeros, buscar);

    System.out.println("Array ordenado: " + Arrays.toString(numeros));
    System.out.println("Elemento " + buscar + " en posición: " + resultado);
  }
}
