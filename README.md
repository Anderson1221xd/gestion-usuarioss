Gestión de Usuarios – CI/CD con GitHub Actionss

Este proyecto implementa un sistema básico de gestión de usuarios en Java, junto con un pipeline de Integración Continua (CI) que incluye:

Linter obligatorio

Compilación

Pruebas unitarias automatizadas

Reporte de cobertura

Validación de umbral mínimo

Ejecución local con nektos/act

El objetivo es demostrar buenas prácticas de calidad de software mediante un flujo de CI reproducible tanto en GitHub como de manera local.

1. Estrategia del proyecto
1.1 Diferencia entre CI y CD

CI (Continuous Integration)
Proceso automático que ejecuta linters, pruebas, compilación y reporta errores cada vez que se hace un push o pull request.
Su objetivo es encontrar fallos pronto y mantener el proyecto siempre funcional.

CD (Continuous Delivery/Deployment)
Proceso posterior a la CI donde el sistema se despliega automáticamente (o semi-automáticamente) a un entorno productivo o de pruebas.
En este proyecto solo se usa CI, no CD.

1.2 Lenguaje, linter y cobertura seleccionados
🔹 Lenguaje: Java (Maven)

Justificación:

Soporta pruebas con JUnit.

Tiene plugins integrados para cobertura.

Es ampliamente compatible con GitHub Actions y act.

🔹 Linter utilizado: Google Java Format

Justificación:

Es el estándar más usado en proyectos Java.

Garantiza estilo consistente entre todos los archivos.

Se integra fácilmente con CI y plugins de Maven.

🔹 Cobertura: JaCoCo

Justificación:

Es el estándar en proyectos Java.

Genera reportes XML y HTML.

Permite validar cobertura mínima en el pipeline.

1.3 Umbral mínimo de cobertura

Se define una cobertura mínima del 80% por las siguientes razones:

Es un estándar recomendado en proyectos académicos y empresariales.

Asegura cobertura suficiente sin impedir el desarrollo ágil.

Obliga a cubrir lógica importante sin ser excesivamente estricto.

El pipeline falla si la cobertura es < 80%.

2. Pipeline de CI — GitHub Actions

El workflow principal está en:

.github/workflows/ci-quality.yml


Incluye:

checkout

Instalación de dependencias (Maven)

Ejecución del linter (Google Java Format)

Compilación del proyecto

Pruebas unitarias

Generación de reporte de cobertura (JaCoCo)

Validación del umbral mínimo

Fallo automático si cualquiera de los pasos falla

El pipeline se activa en:

push

pull_request

3. Ejecución local con nektos/act
3.1 ¿Qué es act?

act es una herramienta que permite ejecutar workflows de GitHub Actions localmente usando Docker, sin necesidad de subir cambios al repositorio.

Permite:

Probar el pipeline antes de hacer push

Depurar errores de linter, pruebas y cobertura

Simular runners de GitHub Actions

3.2 Requisitos

✔ Tener Docker instalado
✔ Tener act instalado:

choco install act


o

brew install act

3.3 Ejecutar el pipeline localmente

Dentro del proyecto:

act -j ci


Si el workflow no tiene nombre de job, usar:

act

4. Validación y análisis de logs

En el archivo RESPUESTAS.md se explica:

🔹 Cómo identificar fallos en:

Linter

Se muestran mensajes de formato incorrecto

El exit code del linter será 1

Pruebas unitarias

JUnit mostrará pruebas fallidas

Cobertura

El plugin de JaCoCo mostrará que el umbral no se cumple

🔹 Ejecución fallida

Debe incluir una captura donde:

El linter falle

o

La cobertura esté por debajo del 80%

o

Una prueba falle

🔹 Ejecución exitosa

Debe incluir una captura donde:

Linter pase

Pruebas pasen

Cobertura ≥ 80%

Job finalice con estado verde ("success")

5. IA y Ética

En el archivo RESPUESTAS.md se explica:

🔹 Métodos para detectar código generado por IA:

Análisis de patrones mediante detectores (GPTZero, CodeWhisperer Detector, etc.)

Análisis estadístico de estilo (consistencia, patrones repetitivos, uniformidad anómala)

🔹 Por qué NO se puede garantizar autoría al 100%

Los modelos de IA se entrenan en código real

Humanos y IA pueden escribir código similar

Es imposible tener certeza total solo con patrones estilísticos

🔹 Políticas razonables de uso de IA

Uso permitido para documentación y explicación

Prohibido para generación de código en parciales

Transparencia si se usa IA en proyectos reales

Promover aprendizaje autónomo antes que dependencia

6. Cómo ejecutar el proyecto

Compilar:

mvn clean install


Ejecutar pruebas:

mvn test


Generar reporte de cobertura:

mvn jacoco:report


Reportes en:

target/site/jacoco/index.html

7. Estructura del proyecto
|-- src
|   |-- main/java/... (código fuente)
|   |-- test/java/... (pruebas unitarias)
|-- pom.xml
|-- README.md
|-- RESPUESTAS.md
|-- .github/workflows/ci.yml

8. Estudiante:

Anderson Castilla

