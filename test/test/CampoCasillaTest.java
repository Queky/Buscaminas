package test;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.CampoCasilla;
import model.Casilla;

public class CampoCasillaTest {
	CampoCasilla S,B,C;	
	private Casilla[][] testCasillas = new Casilla[5][5];
	
	
	
	
	
	@Before
	public void setUp() throws Exception {
		S = new CampoCasilla();
		B = new CampoCasilla();
	/*	for (int i = 0; i < testCasillas.length; i++) {
			for (int j = 0; j < testCasillas[i].length; j++) {
				Casilla Casilla01 = new Casilla(false);
				testCasillas[i][j]=Casilla01;
			}
		}
		
		*/
		
	}
	
	

	@Test
	public void testGetcampoCasillas() {
		fail("Not yet implemented");
	}

	@Test
	public void testInicializar() {
		//S.inicializar(5,5);
		
		//assertArrayEquals(testCasillas, S.getCampoCasillas());
		//assertArrayEquals(testCasillas, S.inicializar(5,5));
		
	}
	//
	@Test
	public void testRellenarTablero() {
		fail("Not yet implemented");
	}
	//
	@Test
	public void testIntroducirBombas() {
		fail("Not yet implemented");
	}


	@Test
	public void testCalcularMinasCerca() {
		//B.inicializar(5, 5);
		B.rellenarTablero();
		
		
	}

	@Test
	public void testDescubrirCasilla() {
		fail("Not yet implemented");
	}

	@Test
	public void testDescubrirCasillaExpansion() {
		fail("Not yet implemented");
	}

	@Test
	public void testComprobarjuego() {
		fail("Not yet implemented");
	}

	@Test
	public void testCalcularMinasCercaIntInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCampoCasillas() {
		S.getCampoCasillas();
		assertNotNull(S);
	}

	@Test
	public void testSetCampoCasillas() {
		S.setCampoCasillas(testCasillas);
		B.setCampoCasillas(testCasillas);
		//assertEquals(B, S);
		assertNotNull(S);
		
	}

	@Test
	public void testGetBombasTotales() {
		//S.inicializar(5, 5);
		assertEquals(5, S.getBombasTotales());
	}

	@Test
	public void testSetBombasTotales() {
		//S.inicializar(5, 5);
		S.setBombasTotales(10);
		assertEquals(10, S.getBombasTotales());
	}

	@Test
	//Mirar en el codigo, El numero de interrogaciones debe ser el mismo que le numero de bombas en la partida no?
	public void testGetInterrrogacionesTotales() {
		//S.inicializar(5, 5);
		
		//assertEquals(0,S.getInterrrogacionesTotales() );
	}

	@Test
	public void testSetInterrrogacionesTotales() {
		//S.inicializar(5,5);
		//S.setInterrrogacionesTotales(5);
		//assertEquals(5, S.getInterrrogacionesTotales());
	}

}
