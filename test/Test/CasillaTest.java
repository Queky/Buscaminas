package test;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Casilla;

public class CasillaTest {
	Casilla S,D;
	
	@Before
	public void setUp() throws Exception {
		S = new Casilla();
		D = new Casilla();
	}
	/*@Test
	public void testCasillaBoolean() {
		
	}*/

	/*@Test
	public void testCalcularMinasCerca() {
		fail("Not yet implemented");
	}*/

	/*@Test
	public void testCasilla() {
		fail("Not yet implemented");
	}*/

	
	/** Hay que arreglarlo, metodos nuevos
	@Test
	public void testIsVisible() {
		
		assertFalse(S.isVisible());
	}

	@Test
	public void testSetVisible() {
		S.setVisible(false);
		
	}

	@Test
	public void testIsInterrogacion() {
		assertFalse(S.isInterrogacion());
	}

	@Test
	public void testSetInterrogacion() {
		S.setInterrogacion(false);
	}

	@Test
	public void testEsMina() {
		
		assertFalse(S.esMina());
	}

	/*@Test
	public void testSetTieneMina() {
		S.setTieneMina(true);
		D.setTieneMina(true);
		
	}*/
	

	/*@Test
	public void testGetMinasCerca() {
		fail("Not yet implemented");
	}*/

	/*@Test
	public void testSetMinasCerca() {
		fail("Not yet implemented");
	}*/

}
