package com.ucb.tdd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TresEnRayaIATest {

    private TresEnRaya juego;

    @Before
    public void prepararTablero() {
        juego = new TresEnRaya();
    }

    // ---------------------------------------------------------------
    // Requerimiento 2: determinar que jugador juega despues
    // ---------------------------------------------------------------

    @Test
    public void elPrimerTurnoSiempreEsParaX() {
        assertEquals('X', juego.siguienteTurno());
    }

    @Test
    public void siElUltimoTurnoFueXEntoncesElSiguienteEsMas() throws Exception {
        juego.jugar(2, 1);
        assertEquals('+', juego.siguienteTurno());
    }

    @Test
    public void siElUltimoTurnoFueMasEntoncesElSiguienteEsX() throws Exception {
        juego.jugar(2, 1); // X
        juego.jugar(2, 2); // +
        assertEquals('X', juego.siguienteTurno());
    }

    @Test
    public void losTurnosSeAlternanDuranteTodaLaPartida() throws Exception {
        assertEquals('X', juego.siguienteTurno());
        juego.jugar(1, 1);
        assertEquals('+', juego.siguienteTurno());
        juego.jugar(2, 1);
        assertEquals('X', juego.siguienteTurno());
        juego.jugar(3, 1);
        assertEquals('+', juego.siguienteTurno());
    }

    // ---------------------------------------------------------------
    // Requerimiento 1: colocar una pieza en el tablero 3x3
    // ---------------------------------------------------------------

    @Test
    public void cuandoLaCoordenadaXEsMenorQueUnoSeLanzaExcepcion() {
        Exception e = assertThrows(Exception.class, () -> juego.jugar(0, 2));
        assertEquals("La coordenada 0 esta fuera de lugar", e.getMessage());
    }

    @Test
    public void cuandoLaCoordenadaXEsMayorQueTresSeLanzaExcepcion() {
        Exception e = assertThrows(Exception.class, () -> juego.jugar(4, 2));
        assertEquals("La coordenada 4 esta fuera de lugar", e.getMessage());
    }

    @Test
    public void cuandoLaCoordenadaYEsMenorQueUnoSeLanzaExcepcion() {
        Exception e = assertThrows(Exception.class, () -> juego.jugar(2, 0));
        assertEquals("La coordenada 0 esta fuera de lugar", e.getMessage());
    }

    @Test
    public void cuandoLaCoordenadaYEsMayorQueTresSeLanzaExcepcion() {
        Exception e = assertThrows(Exception.class, () -> juego.jugar(2, 5));
        assertEquals("La coordenada 5 esta fuera de lugar", e.getMessage());
    }

    @Test
    public void cuandoLaCoordenadaXEsCincoSeLanzaExcepcion() {
        Exception e = assertThrows(Exception.class, () -> juego.jugar(5, 2));
        assertEquals("La coordenada 5 esta fuera de lugar", e.getMessage());
    }

    @Test
    public void cuandoLaCoordenadaYEsCuatroSeLanzaExcepcion() {
        Exception e = assertThrows(Exception.class, () -> juego.jugar(2, 4));
        assertEquals("La coordenada 4 esta fuera de lugar", e.getMessage());
    }

    @Test
    public void cuandoLaCoordenadaXEsNegativaSeLanzaExcepcion() {
        Exception e = assertThrows(Exception.class, () -> juego.jugar(-1, 2));
        assertEquals("La coordenada -1 esta fuera de lugar", e.getMessage());
    }

    @Test
    public void cuandoLaCoordenadaYEsNegativaSeLanzaExcepcion() {
        Exception e = assertThrows(Exception.class, () -> juego.jugar(2, -1));
        assertEquals("La coordenada -1 esta fuera de lugar", e.getMessage());
    }

    @Test
    public void lasCoordenadasLimitesUnoUnoYTresTresSonValidas() throws Exception {
        assertEquals("No hay ganador", juego.jugar(1, 1));
        assertEquals("No hay ganador", juego.jugar(3, 3));
    }

    @Test
    public void cuandoLaPosicionYaEstaOcupadaSeLanzaExcepcion() throws Exception {
        juego.jugar(1, 3);
        Exception e = assertThrows(Exception.class, () -> juego.jugar(1, 3));
        assertEquals("La posicion ya esta ocupada", e.getMessage());
    }

    @Test
    public void unaPosicionOcupadaNoPermiteQueOtroJugadorLaReemplace() throws Exception {
        juego.jugar(2, 2); // X ocupa el centro
        assertThrows(Exception.class, () -> juego.jugar(2, 2)); // + intenta volver a jugarla
    }

    // ---------------------------------------------------------------
    // Requerimiento 3: deteccion del ganador
    // ---------------------------------------------------------------

    @Test
    public void siNoSeCumpleLaCondicionDeVictoriaEntoncesNoHayGanador() throws Exception {
        assertEquals("No hay ganador", juego.jugar(2, 1));
    }

    @Test
    public void xGanaCuandoOcupaTodaUnaLineaHorizontal() throws Exception {
        juego.jugar(2, 1); // X
        juego.jugar(1, 1); // +
        juego.jugar(2, 2); // X
        juego.jugar(1, 2); // +
        String resultado = juego.jugar(2, 3); // X completa la fila 2
        assertEquals("X es el ganador", resultado);
    }

    @Test
    public void xGanaCuandoOcupaTodaUnaLineaVertical() throws Exception {
        juego.jugar(1, 1); // X
        juego.jugar(1, 2); // +
        juego.jugar(2, 1); // X
        juego.jugar(1, 3); // +
        String resultado = juego.jugar(3, 1); // X completa la columna 1
        assertEquals("X es el ganador", resultado);
    }

    @Test
    public void xGanaCuandoOcupaLaTerceraLineaHorizontal() throws Exception {
        juego.jugar(3, 1); // X
        juego.jugar(1, 1); // +
        juego.jugar(3, 2); // X
        juego.jugar(1, 2); // +
        String resultado = juego.jugar(3, 3); // X completa la fila 3
        assertEquals("X es el ganador", resultado);
    }

    @Test
    public void xGanaCuandoOcupaLaDiagonalPrincipal() throws Exception {
        juego.jugar(1, 1); // X
        juego.jugar(1, 2); // +
        juego.jugar(2, 2); // X
        juego.jugar(1, 3); // +
        String resultado = juego.jugar(3, 3); // X completa la diagonal
        assertEquals("X es el ganador", resultado);
    }

    @Test
    public void xGanaCuandoOcupaLaDiagonalOpuesta() throws Exception {
        juego.jugar(1, 3); // X
        juego.jugar(3, 2); // +
        juego.jugar(2, 2); // X
        juego.jugar(3, 3); // +
        String resultado = juego.jugar(3, 1); // X completa la anti-diagonal
        assertEquals("X es el ganador", resultado);
    }

    @Test
    public void masGanaCuandoOcupaTodaUnaLineaHorizontal() throws Exception {
        juego.jugar(2, 1); // X
        juego.jugar(1, 1); // +
        juego.jugar(2, 2); // X
        juego.jugar(1, 2); // +
        juego.jugar(3, 1); // X
        String resultado = juego.jugar(1, 3); // + completa la fila 1
        assertEquals("+ es el ganador", resultado);
    }

    @Test
    public void masGanaCuandoOcupaLaSegundaLineaVertical() throws Exception {
        juego.jugar(1, 1); // X
        juego.jugar(1, 2); // +
        juego.jugar(1, 3); // X
        juego.jugar(2, 2); // +
        juego.jugar(2, 1); // X
        String resultado = juego.jugar(3, 2); // + completa la columna 2
        assertEquals("+ es el ganador", resultado);
    }

    @Test
    public void masGanaCuandoOcupaTodaUnaLineaVertical() throws Exception {
        juego.jugar(1, 1); // X
        juego.jugar(1, 3); // +
        juego.jugar(2, 2); // X
        juego.jugar(2, 3); // +
        juego.jugar(1, 2); // X
        String resultado = juego.jugar(3, 3); // + completa la columna 3
        assertEquals("+ es el ganador", resultado);
    }

    @Test
    public void masGanaCuandoOcupaLaDiagonalPrincipal() throws Exception {
        juego.jugar(2, 1); // X
        juego.jugar(1, 1); // +
        juego.jugar(2, 3); // X
        juego.jugar(2, 2); // +
        juego.jugar(3, 1); // X
        String resultado = juego.jugar(3, 3); // + completa la diagonal
        assertEquals("+ es el ganador", resultado);
    }

    @Test
    public void masGanaCuandoOcupaLaDiagonalOpuesta() throws Exception {
        juego.jugar(1, 1); // X
        juego.jugar(1, 3); // +
        juego.jugar(1, 2); // X
        juego.jugar(2, 2); // +
        juego.jugar(2, 1); // X
        String resultado = juego.jugar(3, 1); // + completa la anti-diagonal
        assertEquals("+ es el ganador", resultado);
    }

    @Test
    public void tableroLlenoSinTresEnRayaEntoncesNoHayGanador() throws Exception {
        juego.jugar(1, 1); // X
        juego.jugar(1, 2); // +
        juego.jugar(1, 3); // X
        juego.jugar(2, 3); // +
        juego.jugar(2, 1); // X
        juego.jugar(3, 1); // +
        juego.jugar(2, 2); // X
        juego.jugar(3, 3); // +
        String resultado = juego.jugar(3, 2); // X cierra el tablero sin linea
        assertEquals("No hay ganador", resultado);
        assertTrue(resultado.equals("No hay ganador"));
    }
}
