public class Main {
  public static void main(String[] args) {
    int[] numeros = { 10, 15, 20, 25, 30, 35 };
    int buscar = 20;

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
