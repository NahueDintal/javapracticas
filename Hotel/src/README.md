# Sistema de Reservas de Hotel - Código con errores para refactorizar

## Problemas detectados (y otros que deberás encontrar)

### 1. Encapsulamiento
- Todos los atributos son `public` (deberían ser `private`).
- Se accede directamente a campos desde otras clases (ej: `habitacion.numero`, `cliente.nombre`).

### 2. Manejo de fechas
- Se usan `String` para fechas, con cálculo de días incorrecto (solo resta el día del mes).
- No se valida que `fechaInicio` sea anterior a `fechaFin`.
- No se usa `LocalDate` ni `java.time`.

### 3. Lógica de disponibilidad
- `Habitacion.disponible` se marca manualmente, pero no se verifica superposición de reservas.
- `buscarHabitacionDisponible` ignora las fechas.
- Cancelar reserva no libera la habitación.

### 4. Malas prácticas
- Método `mostrarInfo` imprime directamente en consola (mezcla vista con modelo).
- `cambiarId` en `Cliente` permite modificar identificador (debería ser inmutable).
- Constructor de `Reserva` no valida que la habitación esté realmente libre en esas fechas.
- Clase `Hotel` expone directamente `habitaciones` y `reservas` como públicos.
- `Main` agrega habitaciones accediendo a la lista pública.

### 5. Posibles bugs
- Cálculo de `costoTotal` falla si las fechas cruzan de mes o año.
- `cancelarReserva` por índice es frágil (debería ser por ID de reserva).
- No se manejan excepciones (entrada de usuario, fechas inválidas).
- No se verifica que el email tenga formato válido.

### 6. Refactorizaciones sugeridas
- Aplicar encapsulamiento completo.
- Usar `LocalDate` y calcular días con `ChronoUnit.DAYS.between`.
- Implementar verificación de superposición de fechas para disponibilidad real.
- Crear un método `estaDisponible(LocalDate inicio, LocalDate fin)` en `Habitacion`.
- Extraer lógica de menú a métodos separados.
- Agregar excepciones personalizadas (ej: `ReservaException`).
- Usar `ArrayList` con tipos genéricos correctos (ya lo están, pero faltan validaciones).

## Tareas a realizar
1. Corregir todos los errores mencionados.
2. Asegurar que el sistema funcione correctamente.
3. Mejorar el diseño (aplicar principios SOLID si es posible).
4. Escribir pruebas básicas (opcional).

¡Buena suerte con la refactorización!
