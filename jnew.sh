#!/bin/bash

CURRENT_DIR=$(pwd)
PROJECT_NAME=$(basename "$CURRENT_DIR")

echo "🚀 Creando proyecto Java 25: $PROJECT_NAME"

# Limpiar si ya existe (como hace .NET)
if [ -d "src" ] || [ -d "bin" ]; then
    echo "⚠️  Limpiando estructura existente..."
    rm -rf src bin lib *.sh README.md
fi

# Crear estructura ORGANIZADA (como .NET)
mkdir -p src/main/java
mkdir -p src/test/java
mkdir -p bin/main
mkdir -p bin/test
mkdir -p lib

# Crear Main.java en paquete (más organizado)
cat > src/main/java/Main.java << EOF
/**
 * Proyecto: $PROJECT_NAME
 * Generado automáticamente
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("¡Hola desde $PROJECT_NAME con Java 25!");
        System.out.println("Directorio: $CURRENT_DIR");
        
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
EOF

# Crear un test básico
cat > src/test/java/MainTest.java << EOF
public class MainTest {
    public static void main(String[] args) {
        System.out.println("Ejecutando tests...");
        // Aquí irían tus tests
        System.out.println("✅ Todos los tests pasaron!");
    }
}
EOF

# Crear scripts robustos
cat > build.sh << 'EOF'
#!/bin/bash
echo "🔨 Building $PROJECT_NAME..."
echo "📦 Compilando código principal..."
javac --release 25 -d bin/main src/main/java/*.java

if [ $? -eq 0 ]; then
    echo "📦 Compilando tests..."
    javac --release 25 -d bin/test -cp bin/main src/test/java/*.java
    echo "✅ Build completado!"
else
    echo "❌ Error en build"
    exit 1
fi
EOF

cat > run.sh << 'EOF'
#!/bin/bash
echo "🚀 Running $PROJECT_NAME..."
java -cp bin/main Main
EOF

cat > test.sh << 'EOF'
#!/bin/bash
echo "🧪 Testing $PROJECT_NAME..."
java -cp "bin/main:bin/test" MainTest
EOF

chmod +x build.sh run.sh test.sh

# Crear archivo de configuración del proyecto
cat > .java-project << EOF
PROJECT_NAME=$PROJECT_NAME
JAVA_VERSION=25
CREATED=$(date)
EOF

echo "✅ Proyecto Java 25 '$PROJECT_NAME' creado exitosamente!"
echo ""
echo "📋 Comandos disponibles:"
echo "   ./build.sh    # Compilar proyecto"
echo "   ./run.sh      # Ejecutar proyecto" 
echo "   ./test.sh     # Ejecutar tests"
echo "   jrun25        # Compilar y ejecutar automáticamente"
echo ""
echo "📁 Estructura creada:"
find src -type f
