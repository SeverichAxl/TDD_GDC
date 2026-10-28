package com.ucb.tdd;

import static org.junit.Assert.assertEquals;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CalculadoraTest {
	
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void siCadenaVaciaRetornarCero() throws Exception{

		//REQ: Cuando se ingrese una cadena vacia, se debe retornar cero

		//1. Preparacion de la prueba
		Calculadora c = new Calculadora();
		
		//2. Logica de la prueba
		String resultadoActual = c.suma("");
		
		//3. Verificacion o Assert
		assertEquals("0",resultadoActual);
	}

	@Test
	public void cuando2numerosRetornarSuma() throws Exception{

		//REQ: Para 2 números delimitados por coma, se debe retornar la suma

		//1. Preparacion de la prueba
		Calculadora c = new Calculadora();
		
		//2. Logica de la prueba
		String resultadoActual = c.suma("2,10");
		
		//3. Verificacion o Assert
		assertEquals("12",resultadoActual);

		//Mas Pruebas
		assertEquals("25",c.suma("25,0"));
		assertEquals("4",c.suma("2,2"));
		assertEquals("0",c.suma("0,0"));
	}

@Test
	public void cuando3numerosRetornarSuma() throws Exception{

		//REQ: Para 3 números delimitados por coma, se debe retornar la suma

		//1. Preparacion de la prueba
		Calculadora c = new Calculadora();
		
		//2. Logica de la prueba
		String resultadoActual = c.suma("2,10,15");
		
		//3. Verificacion o Assert
		assertEquals("27",resultadoActual);

		//Mas Pruebas
		assertEquals("125",c.suma("25,0,100"));

		exception.expect(Exception.class);
		assertEquals("3",c.suma("2,2,-1"));
		
		assertEquals("1000",c.suma("0,0,1000"));
	}

	@Test
	public void cuandoNumerosMayor1000Ignorar() throws Exception{

		//REQ: Para números mayores a 1000, se deben ignorar

		//1. Preparacion de la prueba
		Calculadora c = new Calculadora();
		
		//2. Logica de la prueba
		String resultadoActual = c.suma("2,1001,15");
		
		//3. Verificacion o Assert
		assertEquals("17",resultadoActual);

		//Mas Pruebas
		assertEquals("125",c.suma("25,10000,100"));
		//assertEquals("-6",c.suma("2,2,-10"));
		assertEquals("1000",c.suma("0,0,1000"));
	}

	@Test
	public void paraNumerosNegativosLanzarException() throws Exception{

		//REQ: Para números negativos, se debe lanzar una excepción

		
		//1. Preparacion de la prueba
		Calculadora c = new Calculadora();
		
		exception.expect(Exception.class);
		//2. Logica de la prueba
		String resultadoActual = c.suma("2,2,-10");
				
		//3. Verificacion o Assert

		assertEquals("10",resultadoActual);
		
	}


	/* 
	

	
	
	
	
	
	*/










	
	
	
	/*
	@Test
	public void siCadenaVaciaRetornarCero() throws Exception{
		//1. Preparacion de la prueba
		Calculadora c = new Calculadora();
		
		//2. Logica de la prueba
		String resultado = c.suma("");
		
		//3. Verificacion o Assert
		assertEquals("0",resultado);
	}
	
	
	 
	 
	 
	@Test
	public void para2numerosRetornarSuma() throws Exception{
		//1. Preparacion de la prueba
		Calculadora c = new Calculadora();
				
		//2. Logica de la prueba
		
				
		//3. Verificacion o Assert
		assertEquals("5",c.suma("2,3"));
		assertEquals("3",c.suma("0,3"));
		assertEquals("55",c.suma("44,11"));
		assertEquals("20",c.suma("10,10"));
	}
	
	@Test
	public void para3numerosRetornarSuma() throws Exception{
		//1. Preparacion de la prueba
		Calculadora c = new Calculadora();
				
		//2. Logica de la prueba
		
				
		//3. Verificacion o Assert
		assertEquals("10",c.suma("2,3,5"));
		assertEquals("3",c.suma("1,2,0"));
		assertEquals("55",c.suma("20,20,15"));
		assertEquals("20",c.suma("10,5,5"));
	}
	
	@Test
	public void paraNumerosMayores1000Ignorar() throws Exception{
		//1. Preparacion de la prueba
		Calculadora c = new Calculadora();
				
		//2. Logica de la prueba
		
				
		//3. Verificacion o Assert
		assertEquals("10",c.suma("1001,10"));
		
	}
	
	
	
	*/

}
