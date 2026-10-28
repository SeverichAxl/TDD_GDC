# PROMPT 02 — Iteración: auditoría de cobertura y limpieza de requisitos inventados

> Uso: segunda ronda de la conversación con la IA, después de tener las pruebas generadas
> con el PROMPT 01 y de haberlas ejecutado con `mvn -B clean test`.

---

## Prompt (copiar y pegar)

```
Ahora actúa como un revisor de cobertura de pruebas unitarias (code reviewer de QA).

Te entrego:
(a) la especificación de la kata "Tres en Raya" (mismo texto que te di antes), y
(b) el archivo de pruebas TresEnRayaIATest.java que generaste.

Haz tres cosas, en este orden:

1) MATRIZ DE COBertura
   Devuelve una tabla markdown: | Caso de la especificación | Cubierto por prueba (nombre) | Sí/No |
   Recorre los 3 requerimientos y sus casos de prueba uno por uno. Marca "No" los que falten.

2) HUECOS Y RIESGOS
   Lista los casos que NO están cubiertos y que sí están respaldados por la especificación
   (p. ej. coordenadas negativas, límites 1 y 3, mensaje exacto de cada excepción,
   que gane 'X' y que gane '+' en cada una de las 8 líneas, tablero lleno sin ganador).
   Para cada hueco, escribe el código Java de la prueba que lo cierra, lista para pegar
   en el archivo (mismo estilo y mismas restricciones que te di antes).

3) REQUISITOS INVENTADOS
   Señala cualquier comportamiento que la IA haya asumido pero que NO está en la
   especificación (ej.: que el juego termine y lance excepción después de un ganador,
   reglas propias de empate, mensajes nuevos, límites de turnos, etc.).
   Para cada uno: explica por qué no corresponde agregarlo y qué pasaría si lo
   probáramos (¿fallaría contra la implementación actual?).
   NO agregues pruebas de requisitos inventados.

Reglas: no modiques las pruebas que ya pasan; solo agrega las que cierren huecos
respaldados por la especificación. Devuelve el código completo actualizado de
TresEnRayaIATest.java al final, y termina con el resultado esperado de
"mvn -B clean test" (número de pruebas y 0 fallos).
```

---

## Resultado de esta iteración

- Matriz de cobertura: 3 requerimientos / 10 casos de la presentación del curso → todos cubiertos.
- Pruebas agregadas: casos límite de coordenadas, mensajes exactos de excepción,
  verificación de ganador para **ambos** jugadores en las **8** líneas, tablero lleno sin ganador.
- Requisitos detectados como "inventados" y descartados (no se agregaron al archivo):
  - *Jugar después de que hay un ganador debe lanzar excepción*: la especificación no lo pide
    y la implementación actual lo permite → la prueba habría fallado.
  - *Regla propia de empate / contador de turnos*: fuera del alcance del requerimiento 3,
    que solo habla de "no hay ganador".
- Total final: **27 pruebas IA, 0 fallos** (`TresEnRayaIATest.java`).
