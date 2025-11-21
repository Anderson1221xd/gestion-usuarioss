1. Identificación de fallos en los logs

Durante la ejecución del pipeline de CI, los logs permiten identificar claramente en qué etapa ocurrió un fallo. Estas son las señales para cada caso:

🔹 1.1 Fallos del Linter (Google Java Format)

Los errores del linter aparecen usualmente con mensajes como:

"Code style violation"

"Formatting error"

"Google Java Format found files that need formatting"

Además:

El job del linter termina con exit code 1.

El pipeline se detiene inmediatamente.

Cómo detectarlo en los logs:

Buscar palabras clave: format, style, google-java-format, error.

Ver que el workflow no avanza a la etapa de build.

🔹 1.2 Fallos en Pruebas Unitarias (JUnit)

Cuando falla una prueba, JUnit muestra:

Nombre de la prueba fallida

El error lanzado (AssertionError, NullPointerException, etc.)

Número de pruebas exitosas y fallidas

Ejemplo típico en logs:

Tests run: 4, Failures: 1, Errors: 0, Skipped: 0


El pipeline falla automáticamente.

🔹 1.3 Fallos por Cobertura (JaCoCo)

El plugin de JaCoCo valida un mínimo definido (en este caso, 80%).

Si está por debajo, verás mensajes como:

"Rule violated for class X: coverage is below threshold"

"Coverage check failed"

Los logs muestran:

[ERROR] Coverage percentage (75%) is below the minimum required (80%)


El job termina con exit code 1.

2. Ejecución fallida vs exitosa
🔹 2.1 Ejecución Fallida (obligatoria para el parcial)

Para generar un run fallido se puede:

Romper el linter (añadir espacios indebidos o desordenar llaves)

Romper las pruebas (assert incorrecto)

Bajar cobertura (comentar una prueba)

En el log de un run fallido se observa:

El job se pinta en rojo

Mensajes de error visibles (JUnit, JaCoCo o linter)

El pipeline se detiene en ese punto

🔹 2.2 Ejecución Exitosa

Para generar un run exitoso:

Código formateado correctamente

Todas las pruebas pasan

Cobertura ≥ 80%

En los logs se observará:

Todos los pasos en verde

Salida final: "Job succeeded"

JaCoCo muestra cobertura aprobada

Maven indica: "BUILD SUCCESS"

3. Métodos para detectar código generado por IA
3.1 Detector basado en patrones lingüísticos

Herramientas como GPTZero, CodeWhisperer Detector, Copyleaks AI Detector analizan:

Fluidez excesivamente uniforme

Complejidad sintáctica repetitiva

Ausencia de errores humanos típicos

Estructura de código altamente simétrica

Funcionan midiendo la perplejidad: qué tan “predecible” es el texto.

3.2 Análisis estadístico del estilo de programación

Métodos utilizados:

Comparación del estilo entre archivos del mismo autor

Frecuencias de patrones (indentación, nombres repetitivos, comentarios uniformes)

Métricas de complejidad ciclomática extrañamente homogénea

Muchos detectores combinan este análisis con machine learning.

4. Por qué no es posible asegurar la autoría al 100%

IA y humanos pueden producir código indistinguible

Un estudiante puede mejorar su estilo y parecer IA

Un programador puede pedir ayuda a IA parcialmente

Detectores de IA generan falsos positivos y falsos negativos

No existe una firma digital que pruebe la autoría humana

Por eso ningún método puede garantizar autoría total.

5. Políticas razonables para el uso de IA en educación y calidad

Permitir IA para documentación, explicaciones y debugging, pero no para generar código en evaluaciones.

Declarar cuando se utiliza IA, igual que una referencia bibliográfica.

Uso libre en proyectos reales, siempre que exista revisión del desarrollador.

Prohibir IA en exámenes y parciales, salvo autorización explícita.

Enseñar pensamiento crítico antes que dependencia en IA, para fortalecer competencias reales.
