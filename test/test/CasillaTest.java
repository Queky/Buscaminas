package test;


import org.junit.Before;
import model.Casilla;

public class CasillaTest {
	Casilla S,D;
	
	@Before
	public void setUp() throws Exception {
		S = new Casilla();
		D = new Casilla();
	}
	/*@test
	public void testCasillaBoolean() {
		
	}*/

	/*@test
	public void testCalcularMinasCerca() {
		fail("Not yet implemented");
	}*/

	/*@test
	public void testCasilla() {
		fail("Not yet implemented");
	}*/

	
	/** Hay que arreglarlo, metodos nuevos
	@test
	public void testIsVisible() {
		
		assertFalse(S.isVisible());
	}

	@test
	public void testSetVisible() {
		S.setVisible(false);
		
	}

	@test
	public void testIsInterrogacion() {
		assertFalse(S.isInterrogacion());
	}

	@test
	public void testSetInterrogacion() {
		S.setInterrogacion(false);
	}

	@test
	public void testEsMina() {
		
		assertFalse(S.esMina());
	}

	/*@test
	public void testSetTieneMina() {
		S.setTieneMina(true);
		D.setTieneMina(true);
		
	}*/
	

	/*@test
	public void testGetMinasCerca() {
		fail("Not yet implemented");
	}*/

	/*@test
	public void testSetMinasCerca() {
		fail("Not yet implemented");
	}*/

}
