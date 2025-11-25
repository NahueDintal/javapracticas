#!/bin/bash
CURRENT_DIR=$(pwd)
PROJECT_NAME=$(basename "$CURRENT_DIR")


mkdir -p src/main/java
mkdir -p src/main/resources

cat > pom.xml << EOF
<?xml version="1.0" encoding="UTF-8"?>
<project>
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.example</groupId>
    <artifactId>$PROJECT_NAME</artifactId>
    <version>1.0</version>
    <properties>
        <maven.compiler.release>25</maven.compiler.release>
    </properties>
</project>
EOF

cat > src/main/java/Main.java << EOF
public class Main {
    public static void main(String[] args) {
        System.out.println("¡Hola wachin desde $PROJECT_NAME!");
    }
}
EOF


echo "Proyecto '$PROJECT_NAME' creado en: $CURRENT_DIR"
