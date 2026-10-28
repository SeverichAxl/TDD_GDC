# Kata Tres en Raya — TDD con JUnit 4 y CI

Pruebas unitarias y código de la kata **Tres en Raya** descrita en la presentación del
curso *TDD - CI/CD* (Requerimientos 1, 2 y 3).

> Repositorio: https://github.com/SeverichAxl/TDD_GDC.git

## Requisitos

- JDK 8 o superior (el pipeline de CI usa JDK 17)
- Maven 3.x

## Ejecutar las pruebas

```bash
mvn -B clean test
```

Resultado: **42 pruebas, 0 fallos** (10 + 27 + 5).

## Estructura

| Archivo | Descripción |
|---|---|
| `src/main/java/com/ucb/tdd/TresEnRaya.java` | Implementación del juego (tablero 3x3, turnos y detección de ganador) |
| `src/main/java/com/ucb/tdd/Calculadora.java` | Kata previa (suma con delimitadores) |
| `src/test/java/com/ucb/tdd/TresEnRayaTest.java` | **Suite humana**: 10 pruebas escritas con el ciclo rojo-verde-refactor |
| `src/test/java/com/ucb/tdd/TresEnRayaIATest.java` | **Suite IA**: 27 pruebas generadas con un prompt de IA y auditadas |
| `src/test/java/com/ucb/tdd/CalculadoraTest.java` | 5 pruebas de la kata de la calculadora |
| `.github/workflows/maven.yml` | CI: `mvn -B clean compile test` en push/PR a `main` |

## Nota sobre las pruebas generadas con IA

`TresEnRayaIATest.java` es la salida del prompt descrito fuera de este repositorio
(`prompts/PROMPT-01-generar-pruebas-unitarias.md` y `prompts/PROMPT-02-auditoria-cobertura.md`),
que exige como restricción **no inventar requisitos que la especificación no define**.
La comparación detallada entre ambas suites está en la presentación en PDF de la actividad.
