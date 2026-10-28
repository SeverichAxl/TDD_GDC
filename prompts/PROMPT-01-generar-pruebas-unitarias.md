# PROMPT 01 — Generación de pruebas unitarias con IA (Kata: Tres en Raya)

> Uso: pegar tal cual en ChatGPT (o similar) antes de escribir la clase de pruebas.
> Salida esperada: un único archivo Java listo para compilar con Maven/JUnit 4.

---

## Prompt (copiar y pegar)

```
Actúa como un desarrollador senior experto en TDD y en pruebas unitarias con Java y JUnit 4.
Vas a escribir SOLAMENTE pruebas unitarias (no la implementación) para la kata "Tres en Raya".

## Contexto del proyecto
- Proyecto Maven, Java 8, JUnit 4.13 (ya incluido en el pom.xml).
- Package: com.ucb.tdd
- Clase a probar: public class TresEnRaya
- API pública:
    String jugar(int x, int y) throws Exception   // x = fila (1..3), y = columna (1..3)
    char siguienteTurno()                          // devuelve el jugador que debe mover ahora
- Jugadores: 'X' y '+'. El primer turno siempre es 'X'.
- Contrato de comportamiento:
    * Si x o y está fuera del rango 1..3 -> lanza Exception con mensaje
      "La coordenada <valor> esta fuera de lugar".
    * Si la celda ya está ocupada -> lanza Exception con mensaje
      "La posicion ya esta ocupada".
    * Si el movimiento no produce tres en raya -> devuelve "No hay ganador".
    * Si el movimiento completa una fila, columna o diagonal del jugador que acaba de
      mover -> devuelve "<jugador> es el ganador" (ej. "X es el ganador").

## Especificación de la kata (única fuente de verdad; NO inventes requisitos extra)
Requerimiento 1: una pieza puede colocarse en un espacio de un tablero 3x3.
  - Cuando una pieza está fuera del eje X -> excepción.
  - Cuando una pieza está fuera del eje Y -> excepción.
  - Cuando la pieza está en un lugar ya ocupado -> excepción.
Requerimiento 2: debe existir una forma de determinar qué jugador juega después.
  - El primer turno siempre lo juega 'X'.
  - Si el último turno fue 'X', el siguiente es '+'.
  - Si el último turno fue '+', el siguiente es 'X'.
Requerimiento 3: gana quien conecta una línea completa (horizontal, vertical o diagonal).
  - Si no se cumple la condición de victoria -> no hay ganador.
  - Gana con una línea horizontal completa.
  - Gana con una línea vertical completa.
  - Gana con una línea diagonal completa.

## Cobertura mínima exigida (debes generar una prueba para cada punto)
1. Coordenadas inválidas en X (0, 4 y negativa) y en Y (0, 4 y negativa), verificando
   también el mensaje exacto de la excepción.
2. Coordenadas válidas en los extremos (1,1) y (3,3) -> no lanzan excepción.
3. Posición ocupada -> excepción, con su mensaje exacto.
4. Orden de turnos: primer turno 'X', alternancia X -> + -> X durante una secuencia.
5. Sin ganador -> "No hay ganador".
6. Las 8 líneas ganadoras (3 filas + 3 columnas + 2 diagonales), probando que gana 'X'
   y que gana '+' (es decir, el resultado debe nombrar al jugador correcto en ambos casos).
7. Un caso de tablero lleno sin tres en raya -> "No hay ganador".

## Restricciones técnicas y de estilo
- Un único archivo: TresEnRayaIATest.java, en package com.ucb.tdd, clase pública.
- JUnit 4: usa @Test, @Before y org.junit.Assert. NO uses JUnit 5, Mockito ni librerías externas.
- Prepara el tablero en un método @Before (no repitas "new TresEnRaya()" dentro de cada prueba).
- Para excepciones usa assertThrows(...) y valida e.getMessage() con assertEquals.
- Nombres de métodos en español, estilo "cuando<condicion>Entonces<resultado>" o
  "<escenario>EntoncesGana".
- Cada jugada lleva un comentario corto con el jugador (// X, // +).
- Sin System.out.println, sin dependencias de estado entre pruebas, sin orden entre pruebas.
- No pruebes la clase Calculadora ni otras clases.
- NO agregues requisitos que no estén en la especificación (p. ej. prohibir jugar después
  de que haya ganador, detectar empate con una regla propia, etc.). Si la especificación no
  lo define, no lo pruebes.

## Criterios de aceptación de tu respuesta
- El código compila con "mvn -B clean test" y TODAS las pruebas pasan.
- Cobertura: mínimo 18 pruebas (la salida real fue de 27).
- Devuelve SOLO el contenido del archivo .java (sin explicaciones ni markdown).
```

---

## Notas de uso

| Iteración | Qué se pide | Resultado esperado |
|---|---|---|
| 1 | Prompt 01 completo | Archivo `TresEnRayaIATest.java` con 27 pruebas |
| 2 | Prompt 02 (refinamiento de cobertura) | Se agregan casos límite y se detectan requisitos "inventados" por la IA |
| 3 | Ejecutar `mvn -B clean test` | 0 fallos; si falla, se pega el error en la conversación y se corrige |

La salida de este prompt es exactamente el archivo
`TDD/src/test/java/com/ucb/tdd/TresEnRayaIATest.java` (27 pruebas, todas verdes),
que es el conjunto "IA" comparado en la presentación.
