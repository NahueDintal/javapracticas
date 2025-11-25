/**
 * Proyecto: compiladorJava
 * Generado automáticamente
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("¡Hola desde compiladorJava con Java 25!");
        System.out.println("Directorio: /home/nahue/Estudio/javapracticas/compiladorJava");
        
        // Demo de características Java 25
        demoJavaFeatures();
    }
    
    private static void demoJavaFeatures() {
        var message = "Java 25 funcionando correctamente!";
        System.out.println(message);
        
        // Pattern matching instanceOf
        Object obj = "Texto de ejemplo";
        if (obj instanceof String s) {
            System.out.println("Longitud del string: " + s.length());
        }
    }
}
