package Test;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Model.Casilla;
import Pruebas.CampoDeCasillas;

public class CampoDeCasillaTest {
	CampoDeCasillas S,B,C;	
	CampoDeCasillas M = new CampoDeCasillas("facil");
	
	private Casilla[][] testCasillasFacil = new Casilla[5][5];
	//private Casilla[][] testCasillasMedio = new Casilla[10][10];
	//private Casilla[][] testCasillasDificil = new Casilla[20][20];
	@Before
	public void setUp() throws Exception {
		S = new CampoDeCasillas(5,5);
		
		for (int i = 0; i < testCasillasFacil.length; i++) {
		for (int j = 0; j < testCasillasFacil[i].length; j++) {
				//Casilla Casilla01 = new Casilla(false);
				//testCasillasFacil[i][j]=Casilla01;
			}
		}
		
		
		
	}
	@Test
	public void testCampoDeCasillasString() {
		assertNotNull(new CampoDeCasillas("facil"));
	}

	@Test
	public void testRellenarTablero() {
		S.rellenarTablero();
		assertNotNull(S);
		//assertEquals(M, S);
		
		
		
		
	}

	@Test
	public void testCampoDeCasillasIntInt() {
		assertNotNull(new CampoDeCasillas(5,5));
		
	}

	@Test
	public void testIntroducirBombas() {
		fail("Not yet implemented");
	}


	@Test
	public void testCalcularMinasCerca() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCampoCasillas() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetCampoCasillas() {
		fail("Not yet implemented");
	}

}
