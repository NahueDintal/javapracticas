// ============================
// ESTRUCTURA BÁSICA DE UN PROGRAMA JAVA
// ============================

// Nombre del archivo DEBE coincidir con el nombre de la clase pública
// Convención: PascalCase para clases
public class SintaxisJava {

  // Método principal - punto de entrada del programa
  public static void main(String[] args) {
    System.out.println("¡Hola Mundo!");

    // Llamar a diferentes secciones de demostración
    demostrarVariables();
    demostrarOperadores();
    demostrarCondicionales();
    demostrarCiclos();
    demostrarArreglos();
    demostrarMatrices();
    demostrarMetodos();
    demostrarExcepciones();
    demostrarClasesWrapper();
    demostrarStrings();
    demostrarColecciones();
  }

  // ============================
  // 1. VARIABLES Y TIPOS DE DATOS
  // ============================

  static void demostrarVariables() {
    System.out.println("\n=== VARIABLES Y TIPOS DE DATOS ===");

    // Tipos primitivos
    byte byteVar = 127; // 8 bits (-128 a 127)
    short shortVar = 32767; // 16 bits (-32,768 a 32,767)
    int intVar = 2147483647; // 32 bits (-2^31 a 2^31-1)
    long longVar = 9223372036854775807L; // 64 bits (sufijo L)

    float floatVar = 3.1416f; // 32 bits (sufijo f)
    double doubleVar = 3.141592653589793; // 64 bits

    char charVar = 'A'; // 16 bits Unicode
    char charUnicode = '\u0041'; // 'A' en Unicode

    boolean booleanVar = true; // true o false

    // Variables de referencia (objetos)
    String texto = "Hola Java";
    Integer numeroWrapper = 100; // Clase wrapper para int

    // Constantes (final)
    final double PI = 3.141592653589793;
    final int DIAS_SEMANA = 7;

    // Inferencia de tipos (Java 10+)
    var numero = 10; // Infiere que es int
    var mensaje = "Hola"; // Infiere que es String

    // Mostrar valores
    System.out.println("byte: " + byteVar);
    System.out.println("int: " + intVar);
    System.out.println("double: " + doubleVar);
    System.out.println("char: " + charVar + " (Unicode: " + charUnicode + ")");
    System.out.println("String: " + texto);
    System.out.println("PI constante: " + PI);
    System.out.println("var numero: " + numero);
  }

  // ============================
  // 2. OPERADORES
  // ============================

  static void demostrarOperadores() {
    System.out.println("\n=== OPERADORES ===");

    int a = 10, b = 3;

    // Operadores aritméticos
    System.out.println("a + b = " + (a + b)); // 13
    System.out.println("a - b = " + (a - b)); // 7
    System.out.println("a * b = " + (a * b)); // 30
    System.out.println("a / b = " + (a / b)); // 3 (división entera)
    System.out.println("a % b = " + (a % b)); // 1 (módulo)

    double x = 10.0, y = 3.0;
    System.out.println("x / y = " + (x / y)); // 3.333...

    // Operadores de incremento/decremento
    int contador = 5;
    System.out.println("contador++ = " + contador++); // 5 (post-incremento)
    System.out.println("Ahora contador = " + contador); // 6
    System.out.println("++contador = " + ++contador); // 7 (pre-incremento)

    // Operadores de asignación compuesta
    int num = 10;
    num += 5; // num = num + 5 → 15
    num -= 3; // num = num - 3 → 12
    num *= 2; // num = num * 2 → 24
    num /= 4; // num = num / 4 → 6
    num %= 4; // num = num % 4 → 2

    // Operadores de comparación
    System.out.println("10 > 5: " + (10 > 5)); // true
    System.out.println("10 < 5: " + (10 < 5)); // false
    System.out.println("10 == 10: " + (10 == 10)); // true
    System.out.println("10 != 5: " + (10 != 5)); // true
    System.out.println("10 >= 10: " + (10 >= 10)); // true

    // Operadores lógicos
    boolean esVerdadero = true;
    boolean esFalso = false;

    System.out.println("true && false: " + (esVerdadero && esFalso)); // AND → false
    System.out.println("true || false: " + (esVerdadero || esFalso)); // OR → true
    System.out.println("!true: " + (!esVerdadero)); // NOT → false

    // Operador ternario
    int edad = 18;
    String puedeVotar = (edad >= 18) ? "Sí puede votar" : "No puede votar";
    System.out.println("¿Puede votar?: " + puedeVotar);

    // Operador de instancia (instanceof)
    String texto = "Java";
    System.out.println("¿texto es String?: " + (texto instanceof String)); // true
  }

  // ============================
  // 3. ESTRUCTURAS CONDICIONALES
  // ============================

  static void demostrarCondicionales() {
    System.out.println("\n=== ESTRUCTURAS CONDICIONALES ===");

    int nota = 85;

    // IF-ELSE básico
    if (nota >= 60) {
      System.out.println("Aprobado");
    } else {
      System.out.println("Reprobado");
    }

    // IF-ELSE IF-ELSE
    if (nota >= 90) {
      System.out.println("Excelente (A)");
    } else if (nota >= 80) {
      System.out.println("Muy bien (B)");
    } else if (nota >= 70) {
      System.out.println("Bien (C)");
    } else if (nota >= 60) {
      System.out.println("Suficiente (D)");
    } else {
      System.out.println("Insuficiente (F)");
    }

    // SWITCH (Java 7+ soporta Strings)
    String diaSemana = "Lunes";

    switch (diaSemana.toLowerCase()) {
      case "lunes":
        System.out.println("Inicio de semana");
        break;
      case "martes":
      case "miércoles":
      case "jueves":
        System.out.println("Días laborables");
        break;
      case "viernes":
        System.out.println("¡Viernes!");
        break;
      case "sábado":
      case "domingo":
        System.out.println("Fin de semana");
        break;
      default:
        System.out.println("Día no válido");
    }

    // SWITCH con expresión (Java 12+)
    int mes = 3;
    String estacion = switch (mes) {
      case 12, 1, 2 -> "Invierno";
      case 3, 4, 5 -> "Primavera";
      case 6, 7, 8 -> "Verano";
      case 9, 10, 11 -> "Otoño";
      default -> "Mes no válido";
    };
    System.out.println("Estación (mes " + mes + "): " + estacion);

    // Operador ternario anidado
    int temperatura = 25;
    String clima = (temperatura > 30) ? "Caluroso"
        : (temperatura > 20) ? "Templado" : (temperatura > 10) ? "Fresco" : "Frío";
    System.out.println("Clima: " + clima);
  }

  // ============================
  // 4. CICLOS (LOOPS)
  // ============================

  static void demostrarCiclos() {
    System.out.println("\n=== CICLOS (LOOPS) ===");

    System.out.println("--- FOR tradicional ---");
    // for (inicialización; condición; incremento)
    for (int i = 1; i <= 5; i++) {
      System.out.println("Iteración " + i);
    }

    System.out.println("\n--- FOR decreciente ---");
    for (int i = 5; i >= 1; i--) {
      System.out.println("Cuenta regresiva: " + i);
    }

    System.out.println("\n--- FOR con múltiples variables ---");
    for (int i = 1, j = 10; i <= 5; i++, j -= 2) {
      System.out.println("i = " + i + ", j = " + j);
    }

    System.out.println("\n--- FOR-EACH (enhanced for) ---");
    String[] frutas = { "Manzana", "Banana", "Naranja", "Uva" };
    for (String fruta : frutas) {
      System.out.println("Fruta: " + fruta);
    }

    System.out.println("\n--- WHILE ---");
    // Se ejecuta mientras la condición sea verdadera
    int contador = 1;
    while (contador <= 3) {
      System.out.println("Contador (while): " + contador);
      contador++;
    }

    System.out.println("\n--- DO-WHILE ---");
    // Se ejecuta al menos una vez
    int numero = 1;
    do {
      System.out.println("Número (do-while): " + numero);
      numero++;
    } while (numero <= 3);

    System.out.println("\n--- CICLOS ANIDADOS ---");
    // Tabla de multiplicar
    for (int i = 1; i <= 3; i++) {
      for (int j = 1; j <= 3; j++) {
        System.out.print(i + "x" + j + "=" + (i * j) + "\t");
      }
      System.out.println();
    }

    System.out.println("\n--- BREAK y CONTINUE ---");
    // BREAK: sale del ciclo
    // CONTINUE: salta a la siguiente iteración

    System.out.println("Ejemplo BREAK:");
    for (int i = 1; i <= 10; i++) {
      if (i == 6) {
        System.out.println("Break en i = 6");
        break; // Sale del ciclo
      }
      System.out.println("i = " + i);
    }

    System.out.println("\nEjemplo CONTINUE:");
    for (int i = 1; i <= 5; i++) {
      if (i == 3) {
        System.out.println("Continue en i = 3, saltando...");
        continue; // Salta esta iteración
      }
      System.out.println("i = " + i);
    }

    System.out.println("\n--- ETIQUETAS (labels) ---");
    // Permiten controlar ciclos anidados
    externo: for (int i = 1; i <= 3; i++) {
      interno: for (int j = 1; j <= 3; j++) {
        if (i == 2 && j == 2) {
          System.out.println("Break al ciclo externo");
          break externo; // Sale del ciclo externo
        }
        System.out.println("i = " + i + ", j = " + j);
      }
    }

    System.out.println("\n--- WHILE infinito con break ---");
    int intentos = 0;
    while (true) { // Ciclo infinito
      intentos++;
      System.out.println("Intento " + intentos);

      if (intentos >= 3) {
        System.out.println("Límite alcanzado, saliendo...");
        break; // Rompe el ciclo infinito
      }
    }
  }

  // ============================
  // 5. ARREGLOS (ARRAYS)
  // ============================

  static void demostrarArreglos() {
    System.out.println("\n=== ARREGLOS (ARRAYS) ===");

    // Declaración e inicialización
    int[] numeros = new int[5]; // Arreglo de 5 enteros
    numeros[0] = 10;
    numeros[1] = 20;
    numeros[2] = 30;
    numeros[3] = 40;
    numeros[4] = 50;

    // Inicialización directa
    int[] edades = { 25, 30, 18, 42, 35 };

    // Arreglo de Strings
    String[] nombres = { "Ana", "Juan", "María", "Carlos" };

    // Longitud del arreglo
    System.out.println("Longitud de 'nombres': " + nombres.length);

    // Recorrer arreglo con for tradicional
    System.out.println("\n--- Recorrer con FOR ---");
    for (int i = 0; i < nombres.length; i++) {
      System.out.println("Índice " + i + ": " + nombres[i]);
    }

    // Recorrer arreglo con for-each
    System.out.println("\n--- Recorrer con FOR-EACH ---");
    for (String nombre : nombres) {
      System.out.println("Nombre: " + nombre);
    }

    // Copiar arreglos
    int[] original = { 1, 2, 3, 4, 5 };
    int[] copia = new int[original.length];

    // Método 1: System.arraycopy()
    System.arraycopy(original, 0, copia, 0, original.length);

    // Método 2: Arrays.copyOf() (necesita import java.util.Arrays)
    // int[] copia2 = Arrays.copyOf(original, original.length);

    // Arreglo de objetos
    Persona[] personas = new Persona[3];
    personas[0] = new Persona("Ana", 25);
    personas[1] = new Persona("Juan", 30);
    personas[2] = new Persona("María", 28);

    for (Persona p : personas) {
      System.out.println(p);
    }
  }

  // ============================
  // 6. MATRICES (ARRAYS MULTIDIMENSIONALES)
  // ============================

  static void demostrarMatrices() {
    System.out.println("\n=== MATRICES (2D ARRAYS) ===");

    // Matriz 2x3 (2 filas, 3 columnas)
    int[][] matriz = new int[2][3];

    // Inicialización
    matriz[0][0] = 1;
    matriz[0][1] = 2;
    matriz[0][2] = 3;
    matriz[1][0] = 4;
    matriz[1][1] = 5;
    matriz[1][2] = 6;

    // Inicialización directa
    int[][] tabla = {
        { 1, 2, 3 },
        { 4, 5, 6 },
        { 7, 8, 9 }
    };

    // Recorrer matriz
    System.out.println("Matriz 3x3:");
    for (int i = 0; i < tabla.length; i++) { // Filas
      for (int j = 0; j < tabla[i].length; j++) { // Columnas
        System.out.print(tabla[i][j] + "\t");
      }
      System.out.println();
    }

    // Matriz irregular (jagged array)
    int[][] irregular = new int[3][];
    irregular[0] = new int[2]; // Primera fila con 2 columnas
    irregular[1] = new int[3]; // Segunda fila con 3 columnas
    irregular[2] = new int[1]; // Tercera fila con 1 columna

    // Inicializar
    irregular[0][0] = 1;
    irregular[0][1] = 2;
    irregular[1][0] = 3;
    irregular[1][1] = 4;
    irregular[1][2] = 5;
    irregular[2][0] = 6;

    // Matriz 3D
    int[][][] cubo = new int[2][2][2];
    cubo[0][0][0] = 1;
    cubo[0][0][1] = 2;
    cubo[0][1][0] = 3;
    // ... etc
  }

  // ============================
  // 7. MÉTODOS (FUNCIONES)
  // ============================

  static void demostrarMetodos() {
    System.out.println("\n=== MÉTODOS (FUNCIONES) ===");

    // Llamar métodos
    saludar();
    saludarPersonalizado("Juan");

    int suma = sumar(5, 3);
    System.out.println("5 + 3 = " + suma);

    System.out.println("¿15 es par? " + esPar(15));
    System.out.println("¿20 es par? " + esPar(20));

    // Sobrecarga de métodos
    System.out.println("Suma enteros: " + sumar(10, 20));
    System.out.println("Suma doubles: " + sumar(10.5, 20.3));
    System.out.println("Suma tres números: " + sumar(10, 20, 30));

    // Método con parámetros variables (varargs)
    System.out.println("Promedio: " + calcularPromedio(10, 20, 30, 40, 50));

    // Método recursivo
    int factorial = calcularFactorial(5);
    System.out.println("5! = " + factorial);
  }

  // Método sin parámetros ni retorno
  static void saludar() {
    System.out.println("¡Hola desde el método saludar!");
  }

  // Método con parámetro
  static void saludarPersonalizado(String nombre) {
    System.out.println("¡Hola " + nombre + "!");
  }

  // Método con retorno
  static int sumar(int a, int b) {
    return a + b;
  }

  // Sobrecarga de métodos (mismo nombre, diferentes parámetros)
  static double sumar(double a, double b) {
    return a + b;
  }

  static int sumar(int a, int b, int c) {
    return a + b + c;
  }

  // Método con varargs (parámetros variables)
  static double calcularPromedio(int... numeros) {
    if (numeros.length == 0)
      return 0;

    int suma = 0;
    for (int num : numeros) {
      suma += num;
    }
    return (double) suma / numeros.length;
  }

  // Método con retorno booleano
  static boolean esPar(int numero) {
    return numero % 2 == 0;
  }

  // Método recursivo
  static int calcularFactorial(int n) {
    if (n <= 1)
      return 1;
    return n * calcularFactorial(n - 1);
  }

  // ============================
  // 8. MANEJO DE EXCEPCIONES
  // ============================

  static void demostrarExcepciones() {
    System.out.println("\n=== MANEJO DE EXCEPCIONES ===");

    // Try-Catch básico
    try {
      int resultado = 10 / 0; // Esto lanzará ArithmeticException
      System.out.println("Resultado: " + resultado);
    } catch (ArithmeticException e) {
      System.out.println("Error: División por cero");
      System.out.println("Mensaje: " + e.getMessage());
    }

    // Múltiples catch
    try {
      String texto = null;
      System.out.println(texto.length()); // NullPointerException
    } catch (NullPointerException e) {
      System.out.println("Error: Variable nula");
    } catch (Exception e) {
      System.out.println("Error general: " + e.getClass().getName());
    }

    // Try-Catch-Finally
    try {
      int[] numeros = { 1, 2, 3 };
      System.out.println(numeros[5]); // ArrayIndexOutOfBoundsException
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Error: Índice fuera de rango");
    } finally {
      System.out.println("Este bloque SIEMPRE se ejecuta");
    }

    // Try con recursos (Java 7+)
    // try (RecursoAutoCloseable recurso = new RecursoAutoCloseable()) {
    // // Usar recurso
    // } catch (Exception e) {
    // // Manejar excepción
    // }

    // Lanzar excepción manualmente
    try {
      validarEdad(15);
    } catch (IllegalArgumentException e) {
      System.out.println("Excepción capturada: " + e.getMessage());
    }

    // Try multicatch (Java 7+)
    try {
      // Código que puede lanzar múltiples excepciones
    } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
      System.out.println("Error: " + e.getClass().getSimpleName());
    }
  }

  static void validarEdad(int edad) {
    if (edad < 18) {
      throw new IllegalArgumentException("Edad mínima: 18 años");
    }
    System.out.println("Edad válida: " + edad);
  }

  // ============================
  // 9. CLASES WRAPPER Y AUTOBOXING
  // ============================

  static void demostrarClasesWrapper() {
    System.out.println("\n=== CLASES WRAPPER ===");

    // Clases wrapper para tipos primitivos
    Integer enteroObj = Integer.valueOf(100); // Boxing explícito
    Integer enteroObj2 = 200; // Autoboxing (Java 5+)

    int primitivo = enteroObj.intValue(); // Unboxing explícito
    int primitivo2 = enteroObj2; // Auto-unboxing

    // Conversiones
    String numeroTexto = "123";
    int numero = Integer.parseInt(numeroTexto);
    System.out.println("String a int: " + numero);

    Integer numeroObj = Integer.valueOf(numeroTexto);
    System.out.println("String a Integer: " + numeroObj);

    String texto = Integer.toString(456);
    System.out.println("int a String: " + texto);

    // Valores límite
    System.out.println("Máximo int: " + Integer.MAX_VALUE);
    System.out.println("Mínimo int: " + Integer.MIN_VALUE);

    // Comparación de objetos wrapper
    Integer a = 127;
    Integer b = 127;
    System.out.println("a == b (127): " + (a == b)); // true (cache de -128 a 127)

    Integer c = 200;
    Integer d = 200;
    System.out.println("c == d (200): " + (c == d)); // false (usar equals)
    System.out.println("c.equals(d): " + c.equals(d)); // true
  }

  // ============================
  // 10. MANEJO DE STRINGS
  // ============================

  static void demostrarStrings() {
    System.out.println("\n=== MANEJO DE STRINGS ===");

    // Creación de Strings
    String str1 = "Hola"; // Pool de Strings
    String str2 = new String("Hola"); // Nuevo objeto
    String str3 = "Hola";

    System.out.println("str1 == str2: " + (str1 == str2)); // false
    System.out.println("str1 == str3: " + (str1 == str3)); // true (misma referencia)
    System.out.println("str1.equals(str2): " + str1.equals(str2)); // true

    // Métodos comunes
    String texto = " Java Programming ";

    System.out.println("Original: '" + texto + "'");
    System.out.println("Longitud: " + texto.length());
    System.out.println("Trim: '" + texto.trim() + "'");
    System.out.println("Mayúsculas: " + texto.toUpperCase());
    System.out.println("Minúsculas: " + texto.toLowerCase());
    System.out.println("Carácter en índice 2: " + texto.charAt(2));
    System.out.println("Substring(2, 6): " + texto.substring(2, 6));
    System.out.println("¿Contiene 'Java'?: " + texto.contains("Java"));
    System.out.println("¿Termina con 'ing '?: " + texto.endsWith("ing "));
    System.out.println("¿Empieza con ' Java'?: " + texto.startsWith(" Java"));
    System.out.println("Reemplazar: " + texto.replace("Java", "Python"));
    System.out.println("Índice de 'Prog': " + texto.indexOf("Prog"));

    // Split
    String csv = "Ana,25,Programadora";
    String[] datos = csv.split(",");
    System.out.println("\nSplit CSV:");
    for (String dato : datos) {
      System.out.println("Dato: " + dato.trim());
    }

    // Concatenación
    String nombre = "Juan";
    String apellido = "Pérez";
    String nombreCompleto = nombre + " " + apellido;
    System.out.println("Concatenación: " + nombreCompleto);

    // StringBuilder (mutable, más eficiente para muchas concatenaciones)
    StringBuilder sb = new StringBuilder();
    sb.append("Hola");
    sb.append(" ");
    sb.append("Mundo");
    System.out.println("StringBuilder: " + sb.toString());

    // StringBuffer (thread-safe)
    StringBuffer sbf = new StringBuffer();
    sbf.append("Texto");
    sbf.append(" seguro");
    System.out.println("StringBuffer: " + sbf.toString());

    // Formateo de Strings
    String formato = String.format("Nombre: %s, Edad: %d, Salario: %.2f",
        "Ana", 30, 2500.50);
    System.out.println("Formateado: " + formato);
  }

  // ============================
  // 11. COLECCIONES BÁSICAS
  // ============================

  static void demostrarColecciones() {
    System.out.println("\n=== COLECCIONES BÁSICAS ===");

    // Necesita: import java.util.ArrayList;
    // import java.util.HashMap;
    // import java.util.HashSet;

    // ArrayList (Lista dinámica)
    System.out.println("--- ArrayList ---");
    ArrayList<String> lista = new ArrayList<>();
    lista.add("Manzana");
    lista.add("Banana");
    lista.add("Naranja");
    lista.add(1, "Uva"); // Inserta en posición específica

    System.out.println("Tamaño: " + lista.size());
    System.out.println("Elemento en índice 2: " + lista.get(2));
    System.out.println("¿Contiene 'Banana'?: " + lista.contains("Banana"));

    // Recorrer ArrayList
    System.out.println("Elementos:");
    for (int i = 0; i < lista.size(); i++) {
      System.out.println("  " + i + ": " + lista.get(i));
    }

    // HashSet (Conjunto sin duplicados)
    System.out.println("\n--- HashSet ---");
    HashSet<Integer> conjunto = new HashSet<>();
    conjunto.add(10);
    conjunto.add(20);
    conjunto.add(10); // Duplicado, no se añade
    conjunto.add(30);

    System.out.println("Tamaño: " + conjunto.size());
    System.out.println("¿Contiene 20?: " + conjunto.contains(20));

    // HashMap (Diccionario clave-valor)
    System.out.println("\n--- HashMap ---");
    HashMap<String, Integer> mapa = new HashMap<>();
    mapa.put("Juan", 25);
    mapa.put("Ana", 30);
    mapa.put("Carlos", 28);

    System.out.println("Edad de Ana: " + mapa.get("Ana"));
    System.out.println("¿Contiene clave 'Juan'?: " + mapa.containsKey("Juan"));

    // Recorrer HashMap
    System.out.println("Elementos del mapa:");
    for (String clave : mapa.keySet()) {
      System.out.println("  " + clave + ": " + mapa.get(clave));
    }
  }
}

// ============================
// CLASE AUXILIAR PARA EJEMPLOS
// ============================

class Persona {
  private String nombre;
  private int edad;

  public Persona(String nombre, int edad) {
    this.nombre = nombre;
    this.edad = edad;
  }

  @Override
  public String toString() {
    return nombre + " (" + edad + " años)";
  }
}
