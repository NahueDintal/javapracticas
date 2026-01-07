public class Main {
  public static void main(String[] args) {
    int[] numeros = { 10, 19, 18, 9, 15, 7, 25, 30, 35 };
    int buscar = 18;

    // Ordenamiento.bubbleSort(numeros);
    // System.out.println("Array ordenado por bubble sort");

    // Ordenamiento.selectionSort(numeros);
    // System.out.println("Array ordenado por selection sort");

    // Ordenamiento.insertionSort(numeros);
    // System.out.println("Array ordenando por insercisión");

    // Ordenamiento.insertionSort(numeros);
    // System.out.println("Array ordenado por insersión");

    int resultadoBinario = Busqueda.binaria(numeros, buscar);

    System.out.println(
        resultadoBinario == -1
            ? "Elemento no encontrado"
            : "Elemento econtrado en posicion: " + resultadoBinario);

    int resultadoLineal = Busqueda.lineal(numeros, buscar);

    System.out.println(
        resultadoLineal == -1
            ? "Elemento no encontrado"
            : "Elemento contrado en la posicion: " + resultadoLineal);
  }

}
