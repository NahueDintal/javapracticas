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
